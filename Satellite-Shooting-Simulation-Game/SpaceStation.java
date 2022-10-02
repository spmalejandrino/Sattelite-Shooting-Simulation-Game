import java.util.Random;
/**
 * The space station moves diagonally from upper-left to lower right. It is
 * green on the first orbit (the first time it moves on a diagonal), yellow
 * on the second orbit, and red thereafter until a new refueling operation
 * begins.
 * 
 * @author Carl Singer, Brian Howard, David Maharry
 * @version September 2004
 * @version September 2005, revised by Carl Singer
 * @version September 2006, revised by Carl Singer
 */
public class SpaceStation
{
  private Diamond spaceStation;
  private Canvas canvas;

  private int initXPosition; // where to start the shuttle (a random x-coordinate
                             // in the canvas boundary
  private int initYPosition; // the initial y-coordinate is always sero
  private int xDistance;     // the distance to move in the x direction
  private int yDistance;     // the distance to move in the y direction
  private int orbitCount;    // the number of orbits completed, used for color change control
  private Random r;          // a random number generator
  
/**
 * Creates a space shuttle as a Diamond object at a random position at the top of
 *    the simulation window. Once the space station is initialized it should begin
 *    to orbit.
 * 
 * @param canvas the canvas on which to render the space station
 */
  public SpaceStation(Canvas simCanvas)
  {
      canvas = simCanvas;
      spaceStation = new Diamond(simCanvas);
      spaceStation.changeSize(50,80);
      r = new Random();
      initXPosition = r.nextInt(canvas.getWidth() - 100);
      initYPosition = spaceStation.getHeight();
      spaceStation.moveTo(initXPosition, initYPosition);
      spaceStation.changeColor("green");
      spaceStation.makeVisible();
  }

 /**
  * To Do: moveSmallDistance handles orbiting details:
  *    (1) move the space station if it is within canvas boundaries
  *    (2) begin another orbit at a lower starting point if reaches the 
  *        right side of the canvas.Do this by computing new initXPosition, initYPosition and moving there
  *        (2a) update orbitCount
  *        (2b) if it completed 1 orbit change its color to "yellow"
  *        (2c) if it completed 2 orbits change its color to "red"
  */
  public void moveSmallDistance()
  {
      int orbitCount = 0;
      
      while(orbitCount < 3){
      if ((spaceStation.getXPosition() <= canvas.getWidth() || spaceStation.getYPosition() <= canvas.getHeight()) && orbitCount == 0){
            spaceStation.moveDirection(1,1);
      } orbitCount++;
      
      if (spaceStation.getXPosition() == canvas.getWidth() && orbitCount == 1){
            spaceStation.moveTo(initXPosition, 100);
            spaceStation.changeColor("yellow");
            
      }
      
      if (spaceStation.getXPosition() == canvas.getWidth() && orbitCount == 2){
            spaceStation.moveTo(initXPosition, 200);
            spaceStation.changeColor("red");
      } orbitCount++;
      
    }
}
/**
  * To Do: reFuel the refueling process. The fuel cell has docked, so:
  * (1) change color back to "green"
  * (2) wait 3 seconds
  */
  public void reFuel()
  {
    
  }
  
 /**
  * setSpeed set the orbiting speed according to 'B', 'I', or 'A'.
  *    You can experiment with xDistance and yDistance for this.
  *    To Do: Write the body of the method
  */
  public void setSpeed(char newSpeed)
  {
      
  }

 /**
  * getXposition a simple acccessor used for the docking proceses
  * 
  * @return xPosition the current x-coordinate of the space station
  * To Do: Write the body of this method
  */
  public int getXPosition()
  {
      return 1;
  }

 /**
  * getYposition a simple acccessor used for the docking proceses
  * 
  * @return yPosition the current y-coordinate of the space station
  *  * To Do: Write the body of this method
  */
  public int getYPosition()
  {
      return 1;
  }
}
