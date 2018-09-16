package score;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import display.Game_stage;
/**게임화면에 점수와 스테이지를 출력하는 클래스
 * @author 변동건
 * @see Score
 * */
public class ScorePane extends Score implements Runnable {
	/**게임 스테이지*/
	private Game_stage game;
	/**이미지 URL*/
	private URL imageURL;
	/**점수의 이미지*/
	private BufferedImage numberImage;
	/**numberImage로 만들 점수의 아이콘*/
	private ImageIcon numberIcon;
	/**스테이지 표시를 위한 라벨 */
	private JLabel stage = new JLabel();
	/**점수 표시를 위한 라벨*/
	private JLabel score[] = new JLabel[4];
	/**스코어의 x좌표*/
	private int ScoreLocationX=1159;
	/**스코어의 y좌표*/
	private int ScoreLocationY=320;
	
	/**게임이 진행되는 화면에 점수판 초기화
	 * 
	 * @param game 게임이 진행되는 화면
	 */
	public ScorePane(Game_stage game) {
		this.game = game;
		for (int i = 0; i < 4; i++) {
			score[i]=new JLabel();
			score[i].setBounds(ScoreLocationX + 11 + 45 * i, ScoreLocationY +77, 40, 77);
			game.add(score[i]);
		}
		stage.setBounds(ScoreLocationX+20, ScoreLocationY-175, 165, 166);
		game.add(stage);
		ImageIcon stagepaneIcon=new ImageIcon(imageURL=getClass().getClassLoader().getResource("stagepane.png"));
		JLabel stagepane=new JLabel(stagepaneIcon);
		stagepane.setBounds(ScoreLocationX-55, ScoreLocationY-270, 323, 136);
		game.add(stagepane);
		ImageIcon scorepaneIcon=new ImageIcon(imageURL=getClass().getClassLoader().getResource("scorepane.png"));
		JLabel scorepane=new JLabel(scorepaneIcon);
		scorepane.setBounds(ScoreLocationX, ScoreLocationY, 200, 160);
		game.add(scorepane);
	}
	/**시간에 따라 점수와 스테이지를 변화시키는 스레드*/
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
				repaintImage(getScore()/1000);
				Thread.sleep(10);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**스테이지 이미지를 변화시키는 메소드
	 * 
	 * @param number 출력할 스테이지 번호
	 * @throws IOException
	 */
	private void repaintImage(int number) throws IOException {
		switch (number) {
		case 0:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("1.png"));
			numberIcon = new ImageIcon(numberImage);
			stage.setIcon(this.numberIcon);
			stage.validate();
			stage.repaint();
			break;
		case 1:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("2.png"));
			numberIcon = new ImageIcon(numberImage);
			stage.setIcon(this.numberIcon);
			stage.validate();
			stage.repaint();
			break;
		case 3:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("3.png"));
			numberIcon = new ImageIcon(numberImage);
			stage.setIcon(this.numberIcon);
			stage.validate();
			stage.repaint();
			break;
		}
	}
	/**점수 이미지를 변화시키는 메소드
	 * 
	 * @param locate 점수의 자릿수
	 * @param number 화면에 출력할 점수
	 * @throws IOException
	 */
	private void repaintImage(int locate, int number) throws IOException {
		switch (number) {
		case 0:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number0.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 1:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number1.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 2:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number2.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 3:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number3.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 4:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number4.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 5:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number5.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 6:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number6.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 7:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number7.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].repaint();
			break;
		case 8:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number8.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		case 9:
			numberImage = ImageIO.read(imageURL=getClass().getClassLoader().getResource("number9.png"));
			numberIcon = new ImageIcon(numberImage);
			score[locate].setIcon(this.numberIcon);
			score[locate].validate();
			score[locate].repaint();
			break;
		}
	}
}
