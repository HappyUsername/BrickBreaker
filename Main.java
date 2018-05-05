import java.util.concurrent.TimeUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class Main{
	public static void main(String args[])  throws InterruptedException {
		GameArena g = new GameArena(500,500);
		Ball[] balls = new Ball[15];
		Arrow arr = new Arrow(250,500, 250, 450, 5,"#00FF00",g);
		///g.addMouseListener(this);
		double a = 2;
		double b = 3;
		Rectangle rect = new Rectangle(245, 301, 15, 16, 10);
		g.addRectangle(rect);

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
		boolean condition = true;
		while(condition)
		{	Point point = MouseInfo.getPointerInfo().getLocation();
			arr.setEnd(point.getX(), point.getY());
            		for(int i = 0; i<balls.length;i++){
				
				balls[i].bounce(500,500);
				//Thread.sleep(20);
				//g.update();
				if(balls[i].getDeleteAble() == true ){
					g.removeBall(balls[i]);
					if(i==balls.length-1){
						condition = false;
						System.out.println("End of level.");
						break;
					}
				}
			}
			g.update();
			

		}

	}
}
