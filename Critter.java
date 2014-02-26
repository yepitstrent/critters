/**************************************************************************
* Name: Trent Russell
* Login: cs8bafk
* Date: 3-8-12
* File: CrittersController.java
* Sources of Help: Bob, Michael, Meera, Rick Ord...
* This program is the driver to create Critter objects
**************************************************************************/
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*************************************************************************
* Name: class Critter
* Purpose: abstract class to direct the Critter
**************************************************************************/
public abstract class Critter
{

  private Location locLocation;
  private DrawingCanvas aCanvas;
  private Critter aOther;

  /************************************************************************
  * Name: ()
  * Purpose: Constructor 
  * Parameters: Location loc, DrawingCanvas canvas
  ************************************************************************/
  public Critter(Location loc, DrawingCanvas canvas)
  {
    locLocation = loc;
    aCanvas = canvas;	

  }//end Critter constructor

  /************************************************************************
  * Name: reactTo()
  * Purpose: abstract method to be defined later
  * Parameters: Critter other
  * Return: void.
  ************************************************************************/
  public abstract void reactTo(Critter other);

  /************************************************************************
  * Name: kill()
  * Purpose: abstract method to be defined later
  * Parameters: none
  * Return: void.
  ************************************************************************/
  public abstract void kill();

  /************************************************************************
  * Name: getLocation()
  * Purpose: gets the location
  * Parameters: none
  * Return: Location.
  ************************************************************************/
  public Location getLocation()
  {
    //returns the location
    return locLocation;
  }

  /************************************************************************
  * Name: setLocation()
  * Purpose: sets the location
  * Parameters: double x, double y
  * Return: void.
  ************************************************************************/
  public void setLocation(double x, double y)
  {
    locLocation = new Location(x, y);
  }

}//end class Critter
