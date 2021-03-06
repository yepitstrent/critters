/**************************************************************************
* Name: Trent Russell
* Login: cs8bafk
* Date: 3-8-12
* File: Runner.java
* Sources of Help: Bob, Michael, Meera, Rick Ord...
* This program Creates a Runner Critter
**************************************************************************/
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*************************************************************************
* Name: class Runner
* Purpose: Creates a Runner Critter
**************************************************************************/
public class Runner extends Critter
{      
  private FilledRect rect; 
  private int rectLength = 15; 
  private int arraySize = 7; 
  private Location aLoc, loc1, loc2;
  private double tempDistance;
  private double min = 500.0;
  private int tranX, tranY;  
  private Location[] locArray;  
  private DrawingCanvas aCanvas;
  private double halfSize = 15.0/2.0;

  /************************************************************************
  * Name: Runner()
  * Purpose: creates a runner
  * Parameters: Location loc, DrawingCanvas canvas
  ************************************************************************/
  public Runner(Location loc, DrawingCanvas canvas)
  {
    super(loc, canvas);
    
    aLoc = loc;
    rect = new FilledRect(loc.getX()- halfSize, loc.getY()- halfSize,
       rectLength, rectLength, canvas);
    rect.setColor(Color.GREEN);
    aCanvas = canvas;

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
    double distance = 0.0;
    Location tempLoc = new Location(getLocation());
    Location newLoc = tempLoc;

    //for loops to determine furthest distance
    for(int x = -1; x < 2; x++)
    {

      for(int y = -1; y < 2; y++)
      {
        //move the location to test it
        tempLoc.translate(x,y);
        tempDistance = other.getLocation().distanceTo(tempLoc);

        if(tempDistance > distance)
        {
          // current best distance becomes the new
          distance = tempDistance; 
          newLoc = new Location(tempLoc);

        }
        //move location back to the starting point
        tempLoc.translate(-x,-y);
      }

    }
    //test for out of bounds
    if(newLoc.getX() > 0 && newLoc.getX()+rectLength < aCanvas.getWidth() 
        && newLoc.getY() > 0 
        && newLoc.getY()+rectLength < aCanvas.getHeight() )
    {
      this.setLocation(newLoc.getX(), newLoc.getY());
      rect.moveTo(newLoc.getX()- halfSize, newLoc.getY()- halfSize);
    }
    else
    {
      //generate random number
      RandomIntGenerator ran = new RandomIntGenerator(1,aCanvas.getWidth());
      int x = ran.nextValue();
      int y = ran.nextValue();
      //move locations by random number
      this.setLocation((double)x, (double)y);
      rect.moveTo((double)x, (double)y);

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
    rect.removeFromCanvas();

  }

}//end class Runner
