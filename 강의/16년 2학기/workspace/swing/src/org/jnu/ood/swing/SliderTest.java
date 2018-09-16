package org.jnu.ood.swing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderTest
{
   public static void main(String[] args)
   {  
      SliderTestFrame frame = new SliderTestFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

/**
   A frame with many sliders and a text field to show slider
   values.
*/
class SliderTestFrame extends JFrame
{  
   public SliderTestFrame()
   {  
      setTitle("SliderTest");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      sliderPanel = new JPanel();
      sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

      // common listener for all sliders
      listener = new 
         ChangeListener()
         {  
            public void stateChanged(ChangeEvent event)
            {  
               // update text field when the slider value changes
               JSlider source = (JSlider)event.getSource();
               textField.setText("" + source.getValue());
            }
         };

      // add a plain slider

      JSlider slider = new JSlider();
      addSlider(slider, "Plain");

      // add a slider with major and minor ticks

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      addSlider(slider, "Ticks");

      // add a slider that snaps to ticks

      slider = new JSlider();
      slider.setPaintTicks(true);//슬라이더 하단에 틱 생성
      slider.setSnapToTicks(true);//슬라이더 틱이 있는곳에만 바가 멈춤
      slider.setMajorTickSpacing(20);//슬라이더 틱(대)가 20틱마다 있음
      slider.setMinorTickSpacing(5);//슬라이더 틱(소)가 5틱마다 있음
      addSlider(slider, "Snap to ticks");

      // add a filled slider

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      slider.putClientProperty("JSlider.isFilled", 
         Boolean.FALSE);
      addSlider(slider, "Filled");

      // add a filled and inverted slider

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      slider.putClientProperty("JSlider.isFilled", 
         Boolean.TRUE);//슬라이더의 바가 찬것을 시각적으로 보여줌
      slider.setInverted(true);//슬라이더 바를 뒤에서 부터 채움
      addSlider(slider, "Inverted");

      // add a slider with numeric labels

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      addSlider(slider, "Labels");

      // add a slider with alphabetic labels 

      slider = new JSlider();
      slider.setPaintLabels(true);
      slider.setPaintTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);

      Hashtable labelTable = new Hashtable();
      labelTable.put(new Integer(0), new JLabel("A"));
      labelTable.put(new Integer(20), new JLabel("B"));
      labelTable.put(new Integer(40), new JLabel("C"));
      labelTable.put(new Integer(60), new JLabel("D"));
      labelTable.put(new Integer(80), new JLabel("E"));
      labelTable.put(new Integer(100), new JLabel("F"));

      slider.setLabelTable(labelTable);
      addSlider(slider, "Custom labels");

      // add a slider with icon labels

      slider = new JSlider();
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      slider.setSnapToTicks(true);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(20);

      labelTable = new Hashtable();

      // add card images

      labelTable.put(new Integer(0),
         new JLabel(new ImageIcon("org/jnu/ood/swing/nine.gif")));
      labelTable.put(new Integer(20),
         new JLabel(new ImageIcon("org/jnu/ood/swing/ten.gif")));
      labelTable.put(new Integer(40),
         new JLabel(new ImageIcon("org/jnu/ood/swing/jack.gif")));
      labelTable.put(new Integer(60),
         new JLabel(new ImageIcon("org/jnu/ood/swing/queen.gif")));
      labelTable.put(new Integer(80),
         new JLabel(new ImageIcon("org/jnu/ood/swing/king.gif")));
      labelTable.put(new Integer(100),
         new JLabel(new ImageIcon("org/jnu/ood/swing/ace.gif")));

      slider.setLabelTable(labelTable);
      addSlider(slider, "Icon labels");

      // add the text field that displays the slider value

      textField = new JTextField();
      Container contentPane = getContentPane();
      contentPane.add(sliderPanel, BorderLayout.CENTER);
      contentPane.add(textField, BorderLayout.SOUTH);
   }

   /**
      Adds a slider to the slider panel and hooks up the listener
      @param s the slider
      @param description the slider description
   */
   public void addSlider(JSlider s, String description)
   {        
      s.addChangeListener(listener);
      JPanel panel = new JPanel();
      panel.add(s);
      panel.add(new JLabel(description));
      sliderPanel.add(panel);
   }

   public static final int DEFAULT_WIDTH = 350;
   public static final int DEFAULT_HEIGHT = 450;  

   private JPanel sliderPanel;
   private JTextField textField;
   private ChangeListener listener;
}
