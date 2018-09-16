import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FocusPracticeFrame extends JFrame {
	JTextField tf = new JTextField(10);

	public FocusPracticeFrame() {
		super("Focus Practice Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		add(new JLabel("�Է��� �� �ٸ� â�� ���콺 Ŭ���ϸ� �빮�ڷ� ���մϴ�."));
		add(tf);
	
		tf.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				JTextField t = (JTextField)e.getSource();
				t.setText(t.getText().toUpperCase());
			}
		});

		setSize(400,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FocusPracticeFrame();
	}
}
