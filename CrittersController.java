/**************************************************************************
* Name: Trent Russell
* Login: cs8bafk
* Date: 3-8-12
* File: CrittersController.java
* Sources of Help: Bob, Michael, Meera, Rick Ord...
* This program is the driver to create Critter objects
**************************************************************************/

import java.util.*;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

/*************************************************************************
* Name: class CrittersController
* Purpose: declairs variables that will be used and contains methods
**************************************************************************/
public class CrittersController extends WindowController 
  implements ActionListener, MouseListener
{
  //names of the display objects
  private JLabel topLabel;
  private JLabel bottomLabel;

  private JPanel topButtonPanel;
  private JPanel bottomButtonPanel;

  private Container TopContentContainer;
  private Container BottomContentContainer;

  //the top buttons
  private JButton critterStart;
  private JButton critterStop;
  private JButton critterClear;

  //the bottom buttons
  private JButton critterChaser;
  private JButton critterRunner;
  private JButton critterRandom;
  //booleans
  private boolean startBool = true;
  private boolean stopBool = false;
  private boolean clearBool = false;
  private boolean chaserBool = false;
  private boolean runnerBool = false;
  private boolean randomBool = false;
  //Critter object names
  private Chaser currentChaser;
  private Runner currentRunner;
  private Random currentRandom;

  private CrittersSimulator crittersSimulator;

  //array list to hold the critters
  private ArrayList<Critter> critterArray = new ArrayList<Critter>();

  /************************************************************************
  * Name: begin()
  * Purpose: begins the program
  * Parameters: none
  * Return: void.
  ************************************************************************/
  public void begin()
  {

    crittersSimulator = new CrittersSimulator(critterArray, canvas );

    TopContentContainer = getContentPane();
    BottomContentContainer = getContentPane();
    //start stop clear buttons
    critterStart = new JButton("Start");
    critterStop = new JButton("Stop");
    critterClear = new JButton("Clear");
    //chaser runner random buttons
    critterChaser = new JButton("Chaser");
    critterRunner = new JButton("Runner");
    critterRandom = new JButton("Random");
    //start stop clear buttons added to listener
    critterStart.addActionListener(this);
    critterStop.addActionListener(this);
    critterClear.addActionListener(this);
    //chaser runner random buttons added to listener
    critterChaser.addActionListener(this);
    critterRunner.addActionListener(this);
    critterRandom.addActionListener(this);
    //adds buttons to the listener
    critterStart.addActionListener(crittersSimulator);
    critterStop.addActionListener(crittersSimulator);
    critterClear.addActionListener(crittersSimulator);

    canvas.addMouseListener(this);
    //top panel
    JPanel firstPanel = new JPanel(new GridLayout(1,2));
    //top button panel
    JPanel secondPanel = new JPanel(new GridLayout(1,3));
    //bottom panel, South panel
    JPanel thirdPanel = new JPanel(new GridLayout(2,1));
    //bottom button panel
    JPanel fourthPanel = new JPanel(new GridLayout(1,3));


    topLabel = new JLabel("Please add two or more Critters.");
    firstPanel.add(topLabel);
    //adds buttons to the panel
    secondPanel.add(critterStart);
    secondPanel.add(critterStop);
    secondPanel.add(critterClear);

    firstPanel.add(secondPanel);
    TopContentContainer.add(firstPanel, BorderLayout.NORTH);
    //stuff for the display of the layout

    bottomLabel = new JLabel("Select which Critter to place:", JLabel.CENTER);
    JPanel wordPanel = new JPanel(new GridLayout(1,2));
    wordPanel.add(bottomLabel);
    
    thirdPanel.add(wordPanel);
    //add buttons to the panel
    fourthPanel.add(critterChaser);
    fourthPanel.add(critterRunner);
    fourthPanel.add(critterRandom);
    
    thirdPanel.add(fourthPanel);

    BottomContentContainer.add(thirdPanel, BorderLayout.SOUTH);

  }//end begin()

  /************************************************************************
  * Name: actionPerformed()
  * Purpose: handels the events for the buttons and 
  * Parameters: ActionEvent evt
  * Return: void.
  ************************************************************************/
  public void actionPerformed( ActionEvent evt ) 
  {
    //checks to see if the start button is pressed
    if(((JButton)evt.getSource()).equals(critterStart))
    {
      //sets bool flags
      startBool = true;
      stopBool = false;
      
      if(startBool == true && critterArray.size() < 2)
      {
        topLabel.setText("Please add two or more Critters.");
      }
      else if(startBool == true && critterArray.size() >= 2)
      {
        topLabel.setText("Simulation is running.");
      }

    }
    //checks to see if the stop button is pressed
    if(((JButton)evt.getSource()).equals(critterStop))
    {
      //sets bool flags
      startBool = false;
      stopBool = true;
 
      if(stopBool == true)
      {
        topLabel.setText("Simulation is stopped.");
      }
  
  
    }
    //checks to see if the clear button is pressed
    if(((JButton)evt.getSource()).equals(critterClear))
    {
      
      if(startBool == true)
      {
        topLabel.setText("Please add two or more Critters.");
      }
      
    }
    //checks to see if the chaser button is pressed
    if(((JButton)evt.getSource()).equals(critterChaser))
    {
      //sets bool flags
      chaserBool = true;
      runnerBool = false;
      randomBool = false;
    }
    //checks to see if the runner button is pressed
    if(((JButton)evt.getSource()).equals(critterRunner))
    {

      //sets bool flags
      chaserBool = false;
      runnerBool = true;
      randomBool = false;
    }
    //checks to see if the random button is pressed
    if(((JButton)evt.getSource()).equals(critterRandom))
    {
      //sets bool flags
      chaserBool = false;
      runnerBool = false;
      randomBool = true;
    }

  }//end actionPerformed()

  /************************************************************************
  * Name: mouseClicked()
  * Purpose: handels the events for adding Critters on the canvas 
  * Parameters: MouseEvent event
  * Return: void.
  ************************************************************************/
  public void mouseClicked(MouseEvent event)
  {
    //gets a new location for the mouse click
    Location mouseLoc = new Location(event.getX(), event.getY());

    if(chaserBool == true)//checks for chaser
    {
      currentChaser = new Chaser(mouseLoc, canvas);

      critterArray.add(currentChaser);
    }
    if(runnerBool == true)//checks for runner
    {
      currentRunner = new Runner(mouseLoc, canvas);

      critterArray.add(currentRunner);

    }
    if(randomBool == true)//checks for random
    {
    currentRandom = new Random(mouseLoc, canvas);

    critterArray.add(currentRandom);
    }
    if(startBool == true && critterArray.size() < 2)
    {
      topLabel.setText("Please add two or more Critters.");
    }
    else if(startBool == true && critterArray.size() >= 2)
    {
      topLabel.setText("Simulation is running.");
    }

  }//end mouseClicked()

  /************************************************************************
  * Name: mouseEntered()
  * Purpose: handels the events for adding Critters on the canvas 
  * Parameters: MouseEvent event
  * Return: void.
  ************************************************************************/
  public void mouseEntered(MouseEvent event)
  {}

  /************************************************************************
  * Name: mouseExited()
  * Purpose: handels the events mouse exit the canvas
  * Parameters: MouseEvent event
  * Return: void.
  ************************************************************************/
  public void mouseExited(MouseEvent event)
  {}

  /************************************************************************
  * Name:  mousePressed()
  * Purpose: handels the events mouse press
  * Parameters: MouseEvent event
  * Return: void.
  ************************************************************************/
  public void mousePressed(MouseEvent event)
  {}

  /************************************************************************
  * Name: mouseReleased
  * Purpose: handels the events for mouse release
  * Parameters: MouseEvent event
  * Return: void.
  ************************************************************************/
  public void mouseReleased(MouseEvent event)
  {}


}//end class CrittersController
