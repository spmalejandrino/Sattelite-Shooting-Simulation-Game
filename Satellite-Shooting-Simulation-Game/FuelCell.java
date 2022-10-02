
public class FuelCell
{
  private Circle fuelCell;
  private SpaceStation spaceStation;    // local reference for the space station
  private Canvas canvas;                // local reference for the canvas
  private String cellStatus;            // "moving", "missed", "refueled"
  

  public FuelCell(Canvas theCanvas, SpaceStation theSpaceStation)
  {
      canvas = theCanvas;
      spaceStation = theSpaceStation;
      fuelCell = new Circle(canvas);
      fuelCell.moveTo(canvas.getHeight()/2,canvas.getWidth()/2);
      fuelCell.makeInvisible();
      cellStatus = "moving";
  }
  

 public void launch(int xPosition, int yPosition)
 {
        fuelCell.moveTo(xPosition,yPosition); //move the fuel cell to launch position
        fuelCell.makeVisible(); // and make it visible
 }


 public void moveSmallDistance()
 {
         // Check to see if the cell is "close enough" to the space station
         if ( (Math.abs(spaceStation.getXPosition()-fuelCell.getXPosition())<=fuelCell.getDiameter()/2) &&
              (Math.abs(spaceStation.getYPosition()-fuelCell.getYPosition())<=fuelCell.getDiameter()/2))
         {
            fuelCell.moveTo(spaceStation.getXPosition(),spaceStation.getYPosition()); // Now dock the fuel cell
            canvas.wait(3000);
            fuelCell.makeInvisible();
            spaceStation.reFuel();
            cellStatus = "refueled";
         }
       else if ( fuelCell.getXPosition()<canvas.getWidth()) // Move the fuel cell a little more to the rignt.
       {
          fuelCell.moveDirection(10,0);
       }
       else  // The fuel cell missed
       {
           cellStatus = "missed";
           fuelCell.makeInvisible();
       }
}

public String status()
{
    return cellStatus;
}
}
