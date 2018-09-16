import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class JSliderPractice2Frame extends JFrame {
	JSlider slider = new JSlider(1,100,50);
	JLabel label = new JLabel("   I Love Java   ");
	public JSliderPractice2Frame() {
		super("JSlider Practice Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		label.setFont(new Font("TimesRoman", Font.PLAIN, slider.getValue()));		
		add(slider, BorderLayout.NORTH);
		add(label, BorderLayout.CENTER);
	
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				label.setFont(new Font("TimesRoman", Font.PLAIN, s.getValue()));
			}
		});

		setSize(500,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JSliderPractice2Frame();
	}
}
