import java.awt.*;

public class Diamond
{
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private Canvas canvas;

    public Diamond(Canvas canvas)
    {
        height = 30;
        width = 40;
        xPosition = 50;
        yPosition = 50;
        color = "green";
        isVisible = false;
        this.canvas = canvas;
    }

  
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Make this diamond invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
   
    public void moveDirection(int xDistance, int yDistance)
    {
       erase();
       yPosition += yDistance;
       xPosition += xDistance;
       draw();
   }

  
    public void moveTo(int newXPosition, int newYPosition)
    {
       erase();
       yPosition = newYPosition;
       xPosition = newXPosition;
       draw();
   }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newHeight, int newWidth)
    {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /*
     * Draw the diamond with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Polygon myPoly = new Polygon();                     //Points in order drawn:
            myPoly.addPoint(xPosition,yPosition);                       //First
            myPoly.addPoint(xPosition -(width/2),yPosition - (height/2));  //Second
            myPoly.addPoint(xPosition,yPosition - height);  //Third
            myPoly.addPoint(xPosition + (width/2),yPosition - (height/2));  //Fourth
            canvas.draw(this, color, myPoly);
        }
    }

 
    public void erase()
    {
        if(isVisible) {
            canvas.erase(this);
        }
    }
    public int getXPosition()
    {
        return xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
