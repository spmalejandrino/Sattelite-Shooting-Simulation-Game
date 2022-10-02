
import java.awt.event.*;

public class Controller
    implements KeyListener
{
    private SpaceStation spaceStation;
    private FuelCell fuelCell;
    private Shuttle shuttle;
    private Canvas canvas;
    private boolean sim;             // Used to determine whether (true) or 
                                     //      not (false)to continue the simulation 
    private boolean speedSet;        // Used to sequence the label at the top of the simulation window
    private boolean moveShuttle;     // true to move the shuttle up or down once
    private boolean launchFuelCell;  // true to launch a fuel cell
    private boolean fuelCellInMotion;
    private boolean inOrbit;         // true if the space station is orbiting
    private Label label;             // The label at the top of the simulation window
    
    public Controller()
    {
        canvas = new Canvas("Space Station Fueling Simulator",800,600);
        canvas.setListener(this);
        spaceStation = new SpaceStation(canvas);
        shuttle = new Shuttle(canvas,spaceStation);
    }

    /**
     * startSimulation creates the simulation environment and runs the simulation
     * using an indefinite while loop that looks at the state of the simulation
     * and acts accordingly each time through the loop.
     */
    public void simulate()
    {
        speedSet = false;           // speed not set yet
        label = new Label("Choose speed: B, I, or A", 350, 15,canvas);
        label.makeVisible();
        canvas.setVisible(true);

        moveShuttle = false;        // don't move the shuttle until the 'J' or 'K'  key is pressed
        launchFuelCell = false;     // don't move the fuel cell or make it visible until the spacebar is pressed
        fuelCellInMotion = false;   // don't move the fuel cell or make it visible until the spacebar is pressed

        sim = true;
        while (sim)// add comments here to show that only a little is accomplished each time in the loop
        { if (inOrbit)
          {
              spaceStation.moveSmallDistance(); //rename the orbit method to indicate partial movement
          }
          if (moveShuttle)
          {
              shuttle.moveSmallDistance();
              moveShuttle = false;
          }
          if (launchFuelCell && shuttle.getNumberFuelCells()>0)
          {
              fuelCell = shuttle.launchCell();
              launchFuelCell = false;
              fuelCellInMotion = true;
          }          
          if (fuelCellInMotion) // The cell has been launched
          {
              fuelCell.moveSmallDistance();
              if (fuelCell.status().equals("refueled")){
                  shuttle.dock();
                  canvas.wait(2000);
                  sim = false;
              }
              if (!fuelCell.status().equals("moving")){
                  fuelCellInMotion = false;
              }
          }
          if (spaceStation.getYPosition()>=canvas.getHeight()){
              canvas.wait(2000);
              sim = false;
          }
          canvas.wait(20);
        }
        canvas.setVisible(false);        
   }

    public void keyTyped(KeyEvent ke)
    {
       char myChar = Character.toUpperCase(ke.getKeyChar());
        if (myChar == 'J')
        {
            moveShuttle = true;
            shuttle.setDirection("down");
        } 
        else if (myChar == 'K')
        {
            moveShuttle = true;
            shuttle.setDirection("up");
        }
        /**
         * To Do: add logic here to move the shuttle "up"
         */
        
        
        else if (myChar == ' ' && !fuelCellInMotion)
        {
            launchFuelCell = true;
        }    
        else if (myChar == 'S' && speedSet)
        {
            label.setText("Up: K, Down: J, Launch: Space");
            inOrbit = true;
        }    
        else if (myChar == 'B' || myChar == 'I' || myChar == 'A')
        {
            spaceStation.setSpeed(myChar);
            speedSet = true;
            label.setText("To start: S, To Stop: X");
        }    
        else if (myChar == 'X')
        {
            sim = false;
        }    
    }
    public void keyReleased(KeyEvent ke)
    {
    }

    public void keyPressed(KeyEvent ke)
    {
    }
}
