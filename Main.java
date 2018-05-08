import java.util.concurrent.TimeUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.MouseListener;
public class Main{
	public static void main(String args[])  throws InterruptedException {
		GameArena g = new GameArena(500,500);
		Ball[] balls = new Ball[15];
		Arrow arr = new Arrow(250,500, 250, 450, 5,"#00FF00",g);
		//g.addMouseListener(this);
   
		double a = 2;
		double b = 3;
	//	double mouseCordinateX = 0;
	//	double mouseCordinateY = 0;
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
		
		boolean condition = true; // if it is set to FALSE the level/game ends.
		while(condition)
		{	Point point = MouseInfo.getPointerInfo().getLocation();
			arr.setEnd(point.getX(), point.getY());
			
		  if(g.MousePressedd == true)
            		for(int i = 0; i<balls.length;i++){
				/*	
					while(true){
				if( g.mouseCordinateX == balls[i].getXPosition() &&
					g.mouseCordinateY == balls[i].getYPosition() )
					{break;}
					else {
						balls[i].bounce(500,500); g.update();
						System.out.println("HERE.");
					}
					}*/

						balls[i].bounce(500,500);
						//g.pause();
						//g.update();
						//TimeUnit.MILLISECONDS.sleep(23);
						//Thread.sleep(23);
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
