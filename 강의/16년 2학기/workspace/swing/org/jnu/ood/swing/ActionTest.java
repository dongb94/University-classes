package org.jnu.ood.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTest
{  
   public static void main(String[] args)
   {  
      ActionFrame frame = new ActionFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a panel that demonstrates color change actions.
*/
class ActionFrame extends JFrame
{
   public ActionFrame()
   {
      setTitle("ActionTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      
      // add panel to frame

      ActionPanel panel = new ActionPanel();
      Container contentPane = getContentPane();
      contentPane.add(panel);
   }

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;  
}

/**
   A panel with buttons and keyboard shortcuts to change
   the background color.
*/
class ActionPanel extends JPanel
{  
   public ActionPanel()
   {  
      // define actions

      Action yellowAction = new ColorAction("Yellow",
         new ImageIcon("org/jnu/ood/swing/yellow-ball.gif"),
         Color.YELLOW);
      Action blueAction = new ColorAction("Blue",
         new ImageIcon("org/jnu/ood/swing/blue-ball.gif"),
         Color.BLUE);
      Action redAction = new ColorAction("Red",
         new ImageIcon("org/jnu/ood/swing/red-ball.gif"),
         Color.RED);

      // add buttons for these actions
      
      add(new JButton(yellowAction)); // since 1.3
      add(new JButton(blueAction));
      add(new JButton(redAction));

      // associate the Y, B, and R keys with names

      //InputMap imap = getInputMap( // since 1.3
      InputMap imap = getInputMap(
         JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT); 
         
      
      imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
      imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
      imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

      // associate the names with actions

      //ActionMap amap = getActionMap();
      ActionMap amap = getActionMap();
      amap.put("panel.yellow", yellowAction);
      amap.put("panel.blue", blueAction);
      amap.put("panel.red", redAction);
            
   }

   public class ColorAction extends AbstractAction
   {  
      /**
         Constructs a color action.
         @param name the name to show on the button
         @param icon the icon to display on the button
         @param c the background color 
      */
      public ColorAction(String name, Icon icon, Color c)
      {  
         putValue(Action.NAME, name);
         putValue(Action.SMALL_ICON, icon);
         putValue(Action.SHORT_DESCRIPTION, 
            "Set panel color to " + name.toLowerCase());
         putValue("color", c);
      }

      public void actionPerformed(ActionEvent event)
      {  
         Color c = (Color)getValue("color");
         setBackground(c);
      }
   }
}


