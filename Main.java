import java.util.concurrent.TimeUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main{
	public static void main(String args[])  throws InterruptedException {
		GameArena g = new GameArena(500,500);
		Ball[] balls = new Ball[15];
		Arrow arr = new Arrow(250,500, 250, 450, 5,"#00FF00",g);
		g.addMouseListener(this);
		double a = 2;
		double b = 3;
		for(int i = 0; i<balls.length;i++){

			balls[i] = new Ball(250,495);
			balls[i].setxSpeed(a);
			balls[i].setySpeed(b);
			g.addBall(balls[i]);
			//a = a - 0.1;
			//b = b - 0.1;

		}
		g.update();
		/*
		Ball balls = new Ball(250,500);
		g.addBall(balls);*/

		//Ball b = new Ball(0,250);
		//g.addBall(b);

		while(true)
		{
			
            		for(int i = 0; i<balls.length;i++){

				balls[i].bounce(500,500);
				//Thread.sleep(3);
				//g.update();
				if(balls[i].getDeleteAble() == true ){
					g.removeBall(balls[i]);
				}
			}
			g.update();
			

		}

	}
}
