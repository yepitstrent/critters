/**************************************************************************
* Name: Trent Russell
* Login: cs8bafk
* Date: 3-8-12
* File: Chaser.java
* Sources of Help: Bob, Michael, Meera, Rick Ord...
* This program Creates a Chaser Critter
**************************************************************************/
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*************************************************************************
* Name: class Chaser
* Purpose: Creates a Chaser Critter
**************************************************************************/
public class Chaser extends Critter
{     
  private FilledOval oval; 
  private int ovalDiameter = 15;    
  private double shortestDistance, otherX, 
    otherY, thisX, thisY, tempDistance; 
  private Location aLoc, otherArrayLoc, loc1, 
    loc2, otherLoc, thisLoc, tempLoc; 
  private int arraySize = 7;
  private double halfSize = 15/2;
  private int tranX, tranY; 
  private double min = Double.MAX_VALUE;

  /************************************************************************
  * Name: actionPerformed()
  * Purpose: handels the events for the buttons and 
  * Parameters: ActionEvent evt
  * Return: void.
  ************************************************************************/
  public Chaser(Location loc, DrawingCanvas canvas) 
  {
    super(loc, canvas);
    aLoc = loc;
    oval = new FilledOval(loc.getX()- halfSize, loc.getY()- halfSize, 
      ovalDiameter, ovalDiameter, canvas);
    oval.setColor(Color.RED);
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
    double distance = Double.MAX_VALUE;
    Location tempLoc = new Location(getLocation());
    Location newLoc = tempLoc;
    //for loops to determine behavior
    for(int x = -1; x < 2; x++)
    {

      for(int y = -1; y < 2; y++)
      {
        tempLoc.translate(x,y);
        tempDistance = other.getLocation().distanceTo(tempLoc);

        if(tempDistance < distance)
        {
          distance = tempDistance;
          newLoc = new Location(tempLoc);

        }
        tempLoc.translate(-x,-y);
      }

    }
    //move locations
    this.setLocation(newLoc.getX(), newLoc.getY());
    oval.moveTo(newLoc.getX()- halfSize, newLoc.getY()- halfSize);

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
    oval.removeFromCanvas();
  }


}//end class Chaser
