package ¿¹¿Ü_13;
class Ball extends Exception {}
public class NUMBER_35 {
   private static Ball ball = new Ball();
   static void playBall() {
      int i = 0;
      while(true) {
          try {
             if(i % 4 == 3) throw ball;
             i++;
          } catch (Ball b) {
             i = 0;
             System.out.println("Reset");
          }
      }
   }
   public static void main(String[] args) {
      NUMBER_35.playBall();
   }
}