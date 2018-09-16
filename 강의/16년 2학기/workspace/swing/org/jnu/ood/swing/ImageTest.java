package org.jnu.ood.swing;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageTest
{  
   public static void main(String[] args)
   {  
      ImageFrame frame = new ImageFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/** 
    A frame with an image panel
*/
class ImageFrame extends JFrame
{
   public ImageFrame()
   {
      setTitle("ImageTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // add panel to frame

      ImagePanel panel = new ImagePanel();
      Container contentPane = getContentPane();
      contentPane.add(panel);
   }

   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 200;  
}

/**
   A panel that displays a tiled image
*/
class ImagePanel extends JPanel
{  
   public ImagePanel()
   {  
      // acquire the image      
      image = Toolkit.getDefaultToolkit().getImage
         ("org/jnu/ood/swing/blue-ball.gif");
      MediaTracker tracker = new MediaTracker(this);
      tracker.addImage(image, 0);
      try { tracker.waitForID(0); } 
      catch (InterruptedException exception) {}
      
	   /*
      try
      {
         image = ImageIO.read(new File("v1/v1ch7/ImageTest/blue-ball.gif"));
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
      */
   }
   
   public void paintComponent(Graphics g)
   {  
      super.paintComponent(g);
      if (image == null) return;
   
      int imageWidth = image.getWidth(this);
      int imageHeight = image.getHeight(this);

      // draw the image in the upper-left corner
      
      g.drawImage(image, 0, 0, null);

      // tile the image across the panel

      for (int i = 0; i * imageWidth <= getWidth(); i++)
        for (int j = 0; j * imageHeight <= getHeight(); j++)
            if (i + j > 0) 
               g.copyArea(0, 0, imageWidth, imageHeight,
                  i * imageWidth, j * imageHeight);
   }
   
   private Image image;
}

