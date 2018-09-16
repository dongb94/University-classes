package org.jnu.ood.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlafTest
{  
   public static void main(String[] args)
   {  
      PlafFrame frame = new PlafFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with a button panel for changing look and feel
*/
class PlafFrame extends JFrame
{
   public PlafFrame()
   {
      setTitle("PlafTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // add panel to frame

      PlafPanel panel = new PlafPanel();
      Container contentPane = getContentPane();
      contentPane.add(panel);
   }

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;  
}

/**
   A panel with buttons to change the pluggable look and feel
*/
class PlafPanel extends JPanel
{  
   public PlafPanel()
   {  
      makeButton("Metal", 
         "javax.swing.plaf.metal.MetalLookAndFeel");
      makeButton("Motif",
         "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
      makeButton("Windows", 
         "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
   }

   /**
      Makes a button to change the pluggable look and feel.
      @param name the button name
      @param plafName the name of the look and feel class
    */
   void makeButton(String name, final String plafName)
   {  
      // add button to panel

      JButton button = new JButton(name);
      add(button);
      
      // set button action

      button.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {  
               // button action: switch to the new look and feel
               try
               {  
                  UIManager.setLookAndFeel(plafName);
                  SwingUtilities.updateComponentTreeUI
                     (PlafPanel.this);
               }
               catch(Exception e) { e.printStackTrace(); }
            }
         });
   }
}
