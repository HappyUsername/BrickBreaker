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
	    int cycle = 1;
	    boolean ballsInitialized = false;
		double a = 2;
		double b = 1;
		double yCord = 0;
		Rectangle rect = new Rectangle(265, 321, 85, 55, 2);
		g.addRectangle(rect);

		for(int i = 0; i<balls.length;i++){
			
			balls[i] = new Ball(250,495);
			balls[i].setxSpeed(a);
			balls[i].setySpeed(b);
			g.addBall(balls[i]);
			//a = a - 0.1;
			//b = b - 0.1;
			//yCord--;
		}
		g.update();
		System.out.println("rect x cordinate" + rect.getXPosition());
		
		boolean condition = true; // if it is set to FALSE the level/game ends.
		
		
		while(condition){	
			Point point = MouseInfo.getPointerInfo().getLocation();
			arr.setEnd(point.getX(), point.getY());
			
				if(g.MousePressedd == true)
            		for(int i = 0; i<balls.length;i++){
						if(!ballsInitialized){
							while(cycle < balls.length+1 ){
								for(int m = 0; m < cycle; m++)
									for(int z=0; z < 6; z++)
										//balls[cycle-1].headTowards(point.getX(), point.getY());
										balls[cycle-1].bounce(500,500, point.getX(), point.getY());
										g.update();
										cycle++;
							}
							ballsInitialized=true;
						}
						else
						{ //System.out.println("point.getX() = " + point.getX());
							//balls[i].headTowards(point.getX(), point.getY());
							balls[i].bounce(500,500, point.getX(), point.getY());
							//System.out.println("Bounce before?");
							rect.bounceRect(balls[i]);
						//	System.out.println("Bounce here?");
							
						}
						if(balls[i].getDeleteAble() == true ){ 
							for(int j=0;j<balls.length;j++)
							g.removeBall(balls[j]);
							if(i==balls.length-1){
								condition = false;
								System.out.println("End of level.");
								break;
							}
						}
					  }
				g.update();
			

		  }//while ends here 




	}
	

}
