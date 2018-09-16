package score;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import display.Game_stage;

public class ScorePane extends Score implements Runnable {
	/**���� �������� �ִ� ��ü*/
	private Game_stage game;
	/**���ھ� ��ο� ��µ� ���ڵ��� �̹���*/
	private BufferedImage numberImage;
	/**���� �̹����� �̹��� ������*/
	private ImageIcon numberIcon;
	/**4�ڸ��� ������ ���ڸ��� ��*/
	private JLabel score[] = new JLabel[4];
	/**������ ����� �������� �޾� �ʱ�ȭ*/
	public ScorePane(Game_stage game) {
		this.game = game;
		for (int i = 0; i < 4; i++) {
			score[i]=new JLabel();
			score[i].setBounds(1170 + 45 * i, 300, 40, 77);
			game.add(score[i]);
		}
		ImageIcon scorepaneIcon=new ImageIcon("image/scorepane.png"
				+ "");
		JLabel scorepane=new JLabel(scorepaneIcon);
		scorepane.setBounds(1159, 223, 200, 160);
		game.add(scorepane);
	}
	/**������ ���*/
	public void run() {
		while (game.player.getLife() > 0) {
			try {
				setScore();
				if (getScore() % 1000 < 20)
					repaintImage(0, (getScore()/1000)%10);
				if (getScore() % 100 < 20)
					repaintImage(1, (getScore()/100)%10);
				repaintImage(2, (getScore()/10)%10);
				repaintImage(3, getScore()%10);
				Thread.sleep(10);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**���� ������Ʈ*/
	private void repaintImage(int locate, int number) throws IOException {
		switch (number) {
		case 0:
			numberImage = ImageIO.read(new File("image/number0.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 1:
			numberImage = ImageIO.read(new File("image/number1.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 2:
			numberImage = ImageIO.read(new File("image/number2.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 3:
			numberImage = ImageIO.read(new File("image/number3.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 4:
			numberImage = ImageIO.read(new File("image/number4.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 5:
			numberImage = ImageIO.read(new File("image/number5.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 6:
			numberImage = ImageIO.read(new File("image/number6.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 7:
			numberImage = ImageIO.read(new File("image/number7.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].repaint();
			break;
		case 8:
			numberImage = ImageIO.read(new File("image/number8.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 9:
			numberImage = ImageIO.read(new File("image/number9.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		}
	}
}
