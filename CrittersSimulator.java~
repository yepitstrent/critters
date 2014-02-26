/**************************************************************************
* Name: Trent Russell
* Login: cs8bafk
* Date: 3-8-12
* File: CrittersSimulator.java
* Sources of Help: Bob, Michael, Meera, Rick Ord...
* This program Creates a CrittersSimulator and does Run()
**************************************************************************/
import java.util.*;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

/*************************************************************************
* Name: class CrittersSimulator
* Purpose: Creates a CrittersSimulator and does Run()
**************************************************************************/
public class CrittersSimulator extends ActiveObject 
  implements ActionListener
{
  private ArrayList<Critter> critterArray;
  private DrawingCanvas aCanvas;
  private int delay = 40;
  private int minElement = 0;
  private double distance; 
  private double min = Double.MAX_VALUE;
  private double shortestDistance;
  private Location loc1, loc2;
  private boolean startButtonBool, stopButtonBool;
  private boolean runProgram = true;
  private boolean isClear = false;
  
  /************************************************************************
  * Name: CrittersSimulator()
  * Purpose: constructor
  * Parameters: ArrayList<Critter> critterList, DrawingCanvas canvas 
  ************************************************************************/
  public CrittersSimulator(ArrayList<Critter> critterList,
     DrawingCanvas canvas )
  {
    //new object
    critterArray = critterList;
    aCanvas = canvas;

    start();
  }
  /************************************************************************
  * Name: run()
  * Purpose: runs the program loop
  * Parameters: none
  * Return: void.
  ************************************************************************/
  public void run()
  {
    //infinate loop
    while(true)
    {
      pause(delay);

      //check to see if more than one critter on canvas
      //iterate through critter list
      if(runProgram == true && critterArray.size() >= 2)
      {
        for(int i = 0; i < critterArray.size(); i++ )
        {
          min = Double.MAX_VALUE;
          Critter tempCritter = null;
          for(int j = 0; j < critterArray.size(); j++ )
          {
            /*checks to see if array elements are equal and if 
            null and checks to see if the two critters are chasers*/
            if(i != j && critterArray.get(j) != null && 
              !(critterArray.get(i) instanceof Chaser && 
                  critterArray.get(j) instanceof Chaser))
            {
              //temp locations
              loc1 = critterArray.get(i).getLocation();
              loc2 = critterArray.get(j).getLocation();

              distance = loc1.distanceTo(loc2);
              //distance check to old distance
              if(distance < min)
              {
                //saves the info from the if conditions
                minElement = j;
                min = distance;
                tempCritter = critterArray.get(j);
              }//end if 

            }//end if

          }//end for

          critterArray.get(i).reactTo(tempCritter);

        }//end for

      }//end if(runProgram == true)

      if(isClear == true)
      {  
        isClear = false;

        for(int i = 0; i < critterArray.size(); i++)
        { 
          //clears the graphics
          critterArray.get(i).kill();
        }
          //trims array list and clears it
          critterArray.trimToSize();
          critterArray.clear();

        }//end if(isClear == true)

      }//end while

    }//end run

    /************************************************************************
  * Name: actionPerformed()
  * Purpose: handels the events for the buttons and 
  * Parameters: ActionEvent evt
  * Return: void.
  ************************************************************************/
    public void actionPerformed( ActionEvent evt )
    { 
      evt.getActionCommand();

      //handels the button events and sets flags
      if(((JButton)evt.getSource()).getText().equals("Stop"))
      {
        runProgram = false;
      }
      if(((JButton)evt.getSource()).getText().equals("Start"))
      {
        runProgram = true;
      }
      if(((JButton)evt.getSource()).getText().equals("Clear"))
      {
        isClear = true;
      }
    }//end actionPerformed()



}//end class
