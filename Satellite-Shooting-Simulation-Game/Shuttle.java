/**
 * The shuttle hovers on the left edge of the canvas. It can be moved up or down by pressing
 * the 'K' or 'J' key accordingly. The shuttle has 5 fuelcells, which can be launched one at
 * a time using the space bar. If after launching all 5 fuelcells a refueling cannot occur.
 * 
 * @author Carl Singer, Brian Howard, David Maharry
 * @version September 2004
 * @version September 2005, revised by Carl Singer
 * @version September 2006, revised by Carl Singer
 */
public class Shuttle
{
  private Triangle shuttle; 
  private Canvas canvas;
  SpaceStation spaceStation;
  private String direction;    // Which way to move, "up" or "down"
  private int numberFuelCells; // Note: Up to 5 fuel cells can be created and launched

  /**
   * Constructor create a Shuttle object:
   *    Uses canvas when creating the shuttle object
   *    The shuttle object needs a color, an initial position,
   *    an initial direction of motion, and 5 fuel cells
   *    
   * @param canvas the canvas on which to render the shuttle
   */
  public Shuttle(Canvas theCanvas, SpaceStation theSpaceStation)
  {
      canvas = theCanvas;
      spaceStation = theSpaceStation;
      shuttle = new Triangle(canvas);
      shuttle.moveTo(40, (canvas.getHeight() - shuttle.getHeight()));
      shuttle.changeColor("black");
      shuttle.makeVisible();
      numberFuelCells = 5;
  }

  public void setDirection(String theDirection)
  {
      direction = theDirection;
  }

  /**
   * moveShuttle move the shuttle 10 pixels up or down
   *    in the direction specified by the direction instance field
   */
  public void moveSmallDistance()
  {
      if (direction.equals("up")){
          shuttle.moveDirection(0,-10);
      }
      else{
          shuttle.moveDirection(0,10);
        }
  }

  /**
   * launchCell if there are more cells, create a new fuelCell and launch it
   * from the vertex of the shuttle. One is deducted from the number of available
   * cells.
   * 
   * @return cell a launched FuelCell object or null if the shuttle is out of cells
   */
  public FuelCell launchCell()
  {
      FuelCell cell = new FuelCell(canvas, spaceStation);
      
      if (numberFuelCells > 0){
            cell.launch(shuttle.getXPosition(), shuttle.getYPosition());
            numberFuelCells -= 1;
        }
      return cell;
  }    

  /**
   * dock 1) move the shuttle toward the space station and dock.
   *      2) Wait three seconds.
   *      3) move the shuttle horizontally
   *            back to the left side of the window.
   *      Pattern the docking operation after the similar operation
   *      in the FuelCell class.
   */
  public void dock()
  {
     shuttle.moveTo(spaceStation.getXPosition(), spaceStation.getYPosition());
     canvas.wait(30);
     while(shuttle.getXPosition() > 0){
            shuttle.moveDirection(-2,0);
            canvas.wait(80);
     }
  }

  /**
   * getNumberFuelCells a simple accessor
   * To do: rewrite the body of this method
   * @return the number of fuel cells remaining
   */
  public int getNumberFuelCells()
  {
      return numberFuelCells;
  } 
        
}
