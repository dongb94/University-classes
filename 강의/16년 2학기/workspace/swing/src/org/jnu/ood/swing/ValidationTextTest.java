package org.jnu.ood.swing;
   
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class ValidationTextTest 
{
   public static void main(String[] args)
   {  
      ValidationTextTestFrame frame = new ValidationTextTestFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with two text fields to set a clock.
*/
class ValidationTextTestFrame extends JFrame
{  
   public ValidationTextTestFrame()
   {  
      setTitle("ValidationTextTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      Container contentPane = getContentPane();

      // add a panel with text fields

      JPanel panel = new JPanel();

      hourField = new IntTextField(12, 3);
      panel.add(hourField);
            
      minuteField = new IntTextField(0, 3);
      panel.add(minuteField);
      
      JButton setButton = new JButton("Set");
      panel.add(setButton);
      setButton.addActionListener(new
    		  	ActionListener(){
    	  			public void actionPerformed(ActionEvent event){
    	  				if( hourField.isValid() && minuteField.isValid() )
    	  					clock.setTime(hourField.getValue(), minuteField.getValue());
    	  			}
      			}
      );
      
      contentPane.add(panel, BorderLayout.SOUTH);

      // add the clock

      clock = new VClockPanel();
      contentPane.add(clock, BorderLayout.CENTER);
   }
   
   public static final int DEFAULT_WIDTH = 300;
   public static final int DEFAULT_HEIGHT = 300;  

   private IntTextField hourField;
   private IntTextField minuteField;
   private VClockPanel clock;
}
   
class IntTextField extends JTextField{
	public IntTextField(int defval, int size){
		   super("" + defval, size);
		   setInputVerifier(new IntTextFieldVerifier());
	}
	   
	protected Document createDefaultModel(){
	  return new IntTextDocument();
	}
	   
	public int getValue(){
	  try{
	   return Integer.parseInt(getText());
	  }
	  catch (NumberFormatException e){
	   return 0;
	  }
	}	   
}
   
class IntTextFieldVerifier extends InputVerifier{
  public boolean verify(JComponent component){
   String text = ((JTextComponent)component).getText();
   return IntTextDocument.isValid(text);
  }
}
   
class IntTextDocument extends PlainDocument{
	   public void insertString(int offs, String str, AttributeSet a)
	   		throws BadLocationException{
		   if(str == null) return;
		   String oldString = getText(0, getLength());
		   String newString = oldString.substring(0,offs) + str + oldString.substring(offs);
		   
		   if (canBecomeValid(newString))
			   super.insertString(offs,str,a);
	   }
	   
	   public static boolean isValid(String s){
		   try{
			   int tmp = Integer.parseInt(s);
			   if( tmp > 60 || tmp < -60 ) return false;			   
			   return true;
		   }
		   catch(NumberFormatException e){
			   return false;
		   }
	   }
	   
	   public static boolean canBecomeValid(String s){		   
		   return s.equals("") || s.equals("-") || isValid(s);
	   }
}

/**
   A panel that draws a clock.
*/
class VClockPanel extends JPanel
{

public void paintComponent(Graphics g)
   {
      // draw the circular boundary
      super.paintComponent(g); 
      Graphics2D g2 = (Graphics2D)g;
      Ellipse2D circle 
         = new Ellipse2D.Double(0, 0, 2 * RADIUS, 2 * RADIUS);
      g2.draw(circle);
      
      // draw the hour hand

      double hourAngle 
         = Math.toRadians(90 - 360 * minutes / (12 * 60));
      drawHand(g2, hourAngle, HOUR_HAND_LENGTH);

      // draw the minute hand

      double minuteAngle 
         = Math.toRadians(90 - 360 * minutes / 60);
      drawHand(g2, minuteAngle, MINUTE_HAND_LENGTH);
   }

   public void drawHand(Graphics2D g2, 
      double angle, double handLength)
   {
      Point2D end = new Point2D.Double(
         RADIUS + handLength * Math.cos(angle), 
         RADIUS - handLength * Math.sin(angle));
      Point2D center = new Point2D.Double(RADIUS, RADIUS);
      g2.draw(new Line2D.Double(center, end));
   }
   
   /**
      Set the time to be displayed on the clock
      @param h hours
      @param m minutes
   */
   public void setTime(int h, int m)
   {  
      minutes = h * 60 + m;
      repaint();
   }
   
   private double minutes = 0;
   private double RADIUS = 100;
   private double MINUTE_HAND_LENGTH = 0.8 * RADIUS;
   private double HOUR_HAND_LENGTH = 0.6 * RADIUS;
}
