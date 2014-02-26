/**************************************************************************
* Name: Trent Russell
* Login: cs8bafk
* Date: 3-8-12
* File: Random.java
* Sources of Help: Bob, Michael, Meera, Rick Ord...
* This program Creates a Random Critter
**************************************************************************/
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*************************************************************************
* Name: class Random
* Purpose: Creates a Random Critter
**************************************************************************/
public class Random extends Critter
{      
  private FilledOval oval; 
  private Line line1;
  private Line line2;
  private int lineLength = 15;  
  private double halfSize = 15.0/2.0; 
  private Location aLoc, aLoc1Start, aLoc1End, aLoc2Start, aLoc2End;
  private DrawingCanvas aCanvas; 
  private int randSize = 10;  

  /************************************************************************
  * Name: Random()
  * Purpose: constructor
  * Parameters: Location loc, DrawingCanvas canvas
  ************************************************************************/
  public Random(Location loc, DrawingCanvas canvas) 
  {
    super(loc, canvas);
    aLoc = loc;
    aCanvas = canvas;
    //locations for critter
    aLoc1Start = new Location(aLoc.getX(), aLoc.getY());
    aLoc1End = new Location(aLoc.getX(), aLoc.getY());
    aLoc1End.translate((double)lineLength, (double)lineLength);

    //locations for critter
    aLoc2Start = new Location(aLoc.getX(), aLoc.getY());
    aLoc2End = new Location(aLoc.getX(), aLoc.getY());
    aLoc2Start.translate((double)lineLength,0.0);
    aLoc2End.translate(0.0,(double)lineLength);

    line1 = new Line(aLoc1Start, aLoc1End, canvas);
    line2 = new Line(aLoc2Start, aLoc2End, canvas);

    line1.setColor(Color.BLUE);
    line2.setColor(Color.BLUE);


  }

  /************************************************************************
  * Name: reactTo()
  * Purpose: tells critter how to behave 
  * Parameters: Critter other
  * Return: void.
  ************************************************************************/
  public void reactTo(Critter other)
  { 
    if(other == null)
    {
      return;
    }
    RandomIntGenerator ran = new RandomIntGenerator(-randSize,randSize);
    int x = ran.nextValue();
    int y = ran.nextValue();

    while(x == 0 && y == 0)
    {
      x = ran.nextValue();
      y = ran.nextValue();
    }
    if((aLoc.getX() + x) >= 0 && (aLoc.getX() + x) + 15<=  aCanvas.getWidth()
      && (aLoc.getY() + y) >= 0 && 
      (aLoc.getY() + y) + 15 <= aCanvas.getHeight() )
    {
      line1.move(x,y);
      line2.move(x,y);

      aLoc.translate((double)x,(double)y);
      //move locations
      aLoc1Start.translate((double)x,(double)y);
      aLoc1End.translate((double)x,(double)y);
      //move locations
      aLoc2Start.translate((double)x,(double)y);
      aLoc2End.translate((double)x,(double)y);

      this.setLocation(aLoc.getX() + x, aLoc.getY() + y);
    }  
    else if((aLoc.getX() + x) < 0 )
    {
      line1.move(1,y);
      line2.move(1,y);

      aLoc.translate((double)1,(double)y);

      aLoc1Start.translate((double)1,(double)y);
      aLoc1End.translate((double)1,(double)y);

      aLoc2Start.translate((double)1,(double)y);
      aLoc2End.translate((double)1,(double)y);

      this.setLocation(aLoc.getX() + 1, aLoc.getY() + y);
    }
    else if((aLoc.getX() + x) + 15 > aCanvas.getWidth() )
    {
      line1.move(-1,y);
      line2.move(-1,y);

      aLoc.translate((double)-1,(double)y);
      //move locations
      aLoc1Start.translate((double)-1,(double)y);
      aLoc1End.translate((double)-1,(double)y);
      //move locations
      aLoc2Start.translate((double)-1,(double)y);
      aLoc2End.translate((double)-1,(double)y);

      this.setLocation(aLoc.getX() - 1, aLoc.getY() + y);
    }
    else if((aLoc.getY() + y) < 0 )
    {
      line1.move(x,1);
      line2.move(x,1);

      aLoc.translate((double)x,(double)1);
      //move locations
      aLoc1Start.translate((double)x,(double)1);
      aLoc1End.translate((double)x,(double)1);
      //move locations
      aLoc2Start.translate((double)x,(double)1);
      aLoc2End.translate((double)x,(double)1);

      this.setLocation(aLoc.getX() + x, aLoc.getY() + 1);
    }
    else if((aLoc.getY() + y) + 15 > aCanvas.getHeight() )
    {
      line1.move(x,-1);
      line2.move(x,-1);

      aLoc.translate((double)x,(double)-1);
      //move locations
      aLoc1Start.translate((double)x,(double)-1);
      aLoc1End.translate((double)x,(double)-1);
      //move locations
      aLoc2Start.translate((double)x,(double)-1);
      aLoc2End.translate((double)x,(double)-1);

      this.setLocation(aLoc.getX() + x, aLoc.getY() - 1);
    }

  }//end reactTo

  /************************************************************************
  * Name: kill()
  * Purpose: removes objects from the canvas
  * Parameters: none
  * Return: void.
  ************************************************************************/
  public void kill()
  {
    //remove object from canvas
    line1.removeFromCanvas();
    line2.removeFromCanvas();
  }


}//end class Random
