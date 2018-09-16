import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Preview extends JFrame {
	int[][][] arr2;
	int[][] LM; // int[index]¿¡ L°ª°ú M°ªÀ» ÀúÀåÇÏ´Â ¹è¿­
	int T;
	int index = 0;
	MyPanel p;
	JLabel lb_number;

	public Preview(int T) {
		this.T = T;
		this.arr2 = new int[T][][];
		setTitle("Preview");
		setBounds(100, 100, 800, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LM = new int[T][2];
	}
	
	public void make(int[][] arr2, int L, int M){
		int i;
		for(i = 0; i < T; i++){
			if(this.arr2[i] == null){
				this.arr2[i] = arr2;
				break;
			}
		}
		LM[i][0] = L;
		LM[i][1] = M;
		
		if(p == null){
			MyPanel p = new MyPanel();
			this.setContentPane(p);
		}
	}
	
	class MyPanel extends JPanel{
		protected void paintComponent(final Graphics g){
			super.paintComponent(g);
			draw(g);
			
			JButton btn_next = new JButton("Next");
			btn_next.setForeground(Color.BLACK);
			btn_next.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
			btn_next.setBackground(Color.WHITE);
			btn_next.setBounds(435, 10, 80, 40);
			btn_next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(index < arr2.length && arr2[index] != null){
						getContentPane().removeAll();
						getContentPane().repaint();
						draw(g);
						lb_number.setText("#" + (index));
					}
				}
			});
			this.add(btn_next);
			
			lb_number = new JLabel("#" + (index));
			lb_number.setForeground(Color.WHITE);
			lb_number.setFont(new Font("±¼¸²", Font.BOLD, 22));
			lb_number.setHorizontalAlignment(SwingConstants.CENTER);
			lb_number.setBounds(360, 10, 80, 40);
			this.add(lb_number);
			
			JButton btn_previous = new JButton("Prev");
			btn_previous.setForeground(Color.BLACK);
			btn_previous.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
			btn_previous.setBackground(Color.WHITE);
			btn_previous.setBounds(285, 10, 80, 40);
			btn_previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(index-2 >= 0 && arr2[index-1] != null){
						index--;
						getContentPane().removeAll();
						getContentPane().repaint();
						draw(g);
						lb_number.setText("#" + (index));
						index--;
					}
				}
			});
			this.add(btn_previous);
			index++;
		}

		private void draw(Graphics g){
			int zoom;
			for(zoom = 12; zoom*LM[index][0] > 600 || zoom*LM[index][1] > 800; zoom--);
			
			int x = 400 - zoom*LM[index][0]/2;
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 1000);
			g.setColor(Color.white);
			g.fillRect(x, 100, zoom*LM[index][0], zoom*LM[index][1]);
			for(int i = 0; i < arr2[index].length; i++){
				int red = (int) (Math.random() * 220 + 10);
				int green = (int) (Math.random() * 220 + 10);
				int blue = (int) (Math.random() * 220 + 10);
				Color c = new Color(red, green, blue);
				
				g.setColor(new Color(0, 0, 0));
				g.drawRect(x+zoom*arr2[index][i][0], 100+zoom*arr2[index][i][1], zoom*(arr2[index][i][2]-arr2[index][i][0]), zoom*(arr2[index][i][3]-arr2[index][i][1]));
				g.setColor(c);
				g.fillRect(x+zoom*arr2[index][i][0], 100+zoom*arr2[index][i][1], zoom*(arr2[index][i][2]-arr2[index][i][0]), zoom*(arr2[index][i][3]-arr2[index][i][1]));
			}
		}
	}
}