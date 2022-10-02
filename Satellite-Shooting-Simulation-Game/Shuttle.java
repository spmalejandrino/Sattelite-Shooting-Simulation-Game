public class Shuttle
{
  private Triangle shuttle; 
  private Canvas canvas;
  SpaceStation spaceStation;
  private String direction;    // Which way to move, "up" or "down"
  private int numberFuelCells; // Note: Up to 5 fuel cells can be created and launched

  
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

  
  public void moveSmallDistance()
  {
      if (direction.equals("up")){
          shuttle.moveDirection(0,-10);
      }
      else{
          shuttle.moveDirection(0,10);
        }
  }

  
  public FuelCell launchCell()
  {
      FuelCell cell = new FuelCell(canvas, spaceStation);
      
      if (numberFuelCells > 0){
            cell.launch(shuttle.getXPosition(), shuttle.getYPosition());
            numberFuelCells -= 1;
        }
      return cell;
  }    

  
  public void dock()
  {
     shuttle.moveTo(spaceStation.getXPosition(), spaceStation.getYPosition());
     canvas.wait(30);
     while(shuttle.getXPosition() > 0){
            shuttle.moveDirection(-2,0);
            canvas.wait(80);
     }
  }

  
  public int getNumberFuelCells()
  {
      return numberFuelCells;
  } 
        
}
