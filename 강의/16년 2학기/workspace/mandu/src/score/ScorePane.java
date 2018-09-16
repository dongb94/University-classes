package score;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import display.Game_stage;

public class ScorePane extends Score implements Runnable {
	/**게임 프레임이 있는 객체*/
	private Game_stage game;
	/**스코어 페널에 출력될 숫자들의 이미지*/
	private BufferedImage numberImage;
	/**숫자 이미지의 이미지 아이콘*/
	private ImageIcon numberIcon;
	/**4자리수 점수의 각자리수 라벨*/
	private JLabel score[] = new JLabel[4];
	/**점수를 출력할 프레임을 받아 초기화*/
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
	/**점수의 출력*/
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
	/**점수 업데이트*/
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
