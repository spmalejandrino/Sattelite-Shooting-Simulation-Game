import java.util.Random;

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

  public void reFuel()
  {
    
  }
  

  public void setSpeed(char newSpeed)
  {
      
  }

 
  public int getXPosition()
  {
      return 1;
  }


  public int getYPosition()
  {
      return 1;
  }
}
