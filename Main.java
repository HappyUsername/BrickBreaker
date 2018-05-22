import java.util.concurrent.TimeUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.MouseListener;
public class Main{
	public static void main(String args[])  {
		GameArena g = new GameArena(500,500);
		Ball[] balls = new Ball[15];
		Arrow arr = new Arrow(250,500, 250, 450, 5,"#00FF00",g);
	    int cycle = 1;
	    boolean ballsInitialized = false;

		Rectangle[] Bricks = new Rectangle[3];
		Bricks[0] = new Rectangle(245, 321, 80, 50, 151);
		Bricks[1] = new Rectangle(80, 100, 80, 50, 20);
		Bricks[2] = new Rectangle(270, -50, 80, 50, 151);

		Point pointBegin = new Point();
		Point pointDeath = new Point();
		
		Text[] textScore = new Text[3];
		textScore[0] = new Text(Integer.toString(Bricks[0].getScore()), 235, 326, 15,  "#FF0000");
		textScore[1] = new Text(Integer.toString(Bricks[1].getScore()), 80, 90, 15,  "#FF0000");
		textScore[2] = new Text(Integer.toString(Bricks[2].getScore()), 255, -45, 15,  "#FF0000");
		
		g.addRectangle(Bricks[0]);
		g.addRectangle(Bricks[1]);
		g.addRectangle(Bricks[2]);
		g.addText(textScore[0]);
		g.addText(textScore[1]);
		g.addText(textScore[2]);
		g.initBalls(balls,250,495);
		g.update();
		
		boolean condition = true; // if it is set to FALSE the level/game ends.
		boolean play = false; // set to true when space is pressed. Set to false when the level is over.
		
		while(condition){
			if(g.leftPressed() == true  ) { //&& (arr.getEndX() < g.getArenaHeight())
				arr.setEnd(arr.getEndX()-1, arr.getEndY());
				//Point point = MouseInfo.getPointerInfo().getLocation();
				//arr.setEnd(point.getX(), point.getY());
			}
			if(g.rightPressed() == true){
				arr.setEnd(arr.getEndX()+1, arr.getEndY());
			}
			if(g.upPressed() == true){
				arr.setEnd(arr.getEndX(), arr.getEndY() -1);
			}
			if(g.upPressed() == true){
				arr.setEnd(arr.getEndX(), arr.getEndY() -1);
			}
			if(g.spacePressed() == true){
				pointBegin.setLocation(arr.getEndX(), arr.getEndY());
				play = true;
			//	arr.removeArrow(g);
			}

				if(play == true)
            		for(int i = 0; i<balls.length;i++){
						if(!ballsInitialized){
							while(cycle < balls.length+1 ){
								for(int m = 0; m < cycle; m++)
									for(int z=0; z < 3; z++)
										//balls[cycle-1].headTowards(point.getX(), point.getY());
										balls[cycle-1].bounce(500,500, pointBegin.getX(), pointBegin.getY());
										Bricks[0].bounceRect(balls[cycle-1]);
										g.update();
										cycle++;
							}
							ballsInitialized = true;
						}
						else{
						 //System.out.println("point.getX() = " + point.getX());
							//balls[i].headTowards(point.getX(), point.getY());

								balls[i].bounce(500, 500, pointBegin.getX(), pointBegin.getY());//, point.getX(), point.getY()

								if (Bricks[0].getForDelete() == true) g.removeRectangle(Bricks[0]);
								else Bricks[0].bounceRect(balls[i]);

						
							
						} // end of else
						if(g.isOut(balls, 15)  == true ){
							for(int j=0;j<balls.length;j++) {
								pointDeath.setLocation(balls[0].getXPosition(), balls[0].getYPosition());

								//arr.setStart(pointDeath.getX(),pointDeath.getY());

								g.removeBall(balls[j]);
							}
								if(i == balls.length-1){

									//condition = false;
									play = false;
									cycle = 1;
									g.initBalls( balls, pointDeath.getX(), pointDeath.getY());
									arr.setStart(pointDeath.getX(),pointDeath.getY());
									arr.setEnd(pointDeath.getX(),pointDeath.getY() - 100);
									ballsInitialized = false;
									//Arrow arr = new Arrow(pointDeath.getX(),pointDeath.getX(), pointDeath.getY()-20,pointDeath.getY() , 5,"#00FF00",g);
									
									for(int h = 0; h<Bricks.length ; h++){
										g.removeText(textScore[h]);
										Bricks[h].pushDown(textScore[h]);

										textScore[h].setText(Integer.toString(Bricks[h].getScore()));
										System.out.println("score = "+textScore[h].getText());

										g.removeText(textScore[h]);
										g.addText(textScore[h]);
										
									}
									
									System.out.println("End of level.");
									if(g.isGameWon(Bricks) == true ) {condition = false; break;}
									if(g.isGameOver(Bricks) == true) {condition = false; break;}

									g.update();
									break;
								}
						}
					  }
				g.update();
			

		  }//while ends here 
	//	arr.setStart(123, 55);



	}
	

}
