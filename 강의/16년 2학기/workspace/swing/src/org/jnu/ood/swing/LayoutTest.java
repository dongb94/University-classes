package org.jnu.ood.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LayoutTest
{
   public static void main(String[] args)
   {  
	  FlowLayoutFrame frame1 = new FlowLayoutFrame();
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
      frame1.setVisible(true);
      
      BorderLayoutFrame frame2 = new BorderLayoutFrame();
      frame2.setVisible(true);
      
      CardLayoutFrame frame3 = new CardLayoutFrame();
      frame3.setVisible(true);
      
      ComboCardLayoutFrame frame4 = new ComboCardLayoutFrame();
      frame4.setVisible(true);
      
      GridLayoutFrame frame5 = new GridLayoutFrame();
      frame5.setVisible(true);
      
      AbsoluteLayoutFrame frame6 = new AbsoluteLayoutFrame();
      frame6.setVisible(true);
      
   }
}

class AbsoluteLayoutFrame extends JFrame
{
	public AbsoluteLayoutFrame(){
		setTitle("AbsoluteLayoutTest");
		setLocation(300,300);
		setSize(300,300);
		setResizable(false);
		Container contentPane = getContentPane();
		
		contentPane.setLayout(null);
		
		JButton b1 = new JButton("Button1");
		JButton b2 = new JButton("Button2");
		JButton b3 = new JButton("Button3");
		
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		
		Insets insets = contentPane.getInsets();
		Dimension size = null;
		size = b1.getPreferredSize();
		b1.setBounds(insets.left, insets.top, size.width, size.height);
		size = b2.getPreferredSize();
		b2.setBounds(insets.left+100, insets.top+100, size.width, size.height);
		size = b3.getPreferredSize();
		b3.setBounds(insets.left+200, insets.top+200, size.width, size.height);		
	}
}

class GridLayoutFrame extends JFrame
{
	public GridLayoutFrame(){
		setTitle("GridLayoutTest");
		setLocation(250,250);
		setSize(300,300);
		Container contentPane = getContentPane();		
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(2,1));
		
		MyBorderLayoutPanel p1 = new MyBorderLayoutPanel();
		p1.setLayout(new GridLayout(0,2));
		MyFlowLayoutPanel p2 = new MyFlowLayoutPanel();
		p2.setLayout(new GridLayout(2,0));
		
		gridPanel.add(p1);
		gridPanel.add(p2);
		
		contentPane.add(gridPanel);
	}
}

class ComboCardLayoutFrame extends JFrame implements ItemListener
{
	private JPanel cards;
	
	public ComboCardLayoutFrame(){
		setTitle("ComboCardLayoutTest");
		setLocation(200,200);
		setSize(300,300);
		Container contentPane = getContentPane();
		
		JPanel comboBoxPane = new JPanel();
		String comboBoxItems[] = {"Combo1","Combo2"};
		JComboBox<String> cb = new JComboBox<String>(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);
		
		cards = new JPanel(new CardLayout() );
		cards.add(new MyFlowLayoutPanel(),"Combo1");
		cards.add(new MyBorderLayoutPanel(),"Combo2");
				
		contentPane.add(comboBoxPane, BorderLayout.NORTH);
		contentPane.add(cards, BorderLayout.CENTER);	
	}
	
	public void itemStateChanged(ItemEvent evt){
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, (String)evt.getItem() );
	}
}

class CardLayoutFrame extends JFrame
{
	public CardLayoutFrame(){
		setTitle("CardLayoutTest");
		setLocation(150,150);
		setSize(300,300);
		Container contentPane = getContentPane();
				
		JTabbedPane tpane = new JTabbedPane();
		tpane.addTab("Card1", new MyFlowLayoutPanel() );
		tpane.addTab("Card2", new MyBorderLayoutPanel() );
		
		contentPane.add(tpane, BorderLayout.CENTER);		
	}
}

class BorderLayoutFrame extends JFrame
{
	public BorderLayoutFrame(){
		setTitle("BorderLayoutTest");
		setLocation(100,100);
		setSize(300,300);
	    Container contentPane = getContentPane();	    
	    contentPane.add(new JButton("Center"), BorderLayout.CENTER);
	    contentPane.add(new JButton("Top"), BorderLayout.NORTH);
	    contentPane.add(new JButton("East"), BorderLayout.EAST);
	    contentPane.add(new JButton("West"), BorderLayout.WEST);
	    contentPane.add(new MyBorderLayoutPanel(), BorderLayout.SOUTH);
	}
}

class MyBorderLayoutPanel extends JPanel
{
	public MyBorderLayoutPanel(){
		add(new JButton("Yellow"));
		add(new JButton("Blue"));
		add(new JButton("Green"));
	}
}

class FlowLayoutFrame extends JFrame
{
	public FlowLayoutFrame(){
		setTitle("FlowLayoutTest");
		setLocation(50,50);
		setSize(600,150);
		Container contentPane = getContentPane();
		
		MyFlowLayoutPanel leftPanel = new MyFlowLayoutPanel();
		leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		MyFlowLayoutPanel centerPanel = new MyFlowLayoutPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		MyFlowLayoutPanel rightPanel = new MyFlowLayoutPanel();
		rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
	    contentPane.add(leftPanel, BorderLayout.NORTH);
	    contentPane.add(centerPanel, BorderLayout.CENTER);
	    contentPane.add(rightPanel, BorderLayout.SOUTH);	    
	}
}

class MyFlowLayoutPanel extends JPanel
{
	public MyFlowLayoutPanel(){
		add(new JButton("Button1"));
		add(new JButton("Button2"));
		add(new JButton("Button3"));
		add(new JButton("Button4"));
		add(new JButton("Button5"));
	}
}
