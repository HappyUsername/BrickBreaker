import java.lang.Math.*;
/**
*Class that represents the balls on the GameArena
*Brick Breaker Game
* //https://stackoverflow.com/questions/18704999/how-to-fix-circle-and-rectangle-overlap-in-collision-response/18790389#18790389
*@author Boris Boychev
*/
public class Ball{
	
	private double xPosition;
	private double yPosition;
	private static double size;// static??
	private static String colour;//static??
	
	private double xSpeed; //used for moving the ball on the X cordinate 
	private double ySpeed; //used for moving the ball on the y cordinate 
	private int itterations = 0;// dont forget me!
	private boolean deleteAble = false; // if thi is set to true, the ball shoud be deleted by GameArena
	private boolean started = false;  
	
	/**
	 * Returns current position of this Ball.
	 * @return X coordinate of this Ball within the GameArena
	 */
	public double getXPosition(){
		return xPosition;
	}

	/**
	 * Returns current position of this Ball.
	 * @return y coordinate of this Ball within the GameArena
	 */
	public double getYPosition(){
		return yPosition;
	}
	/**
	 * Returns current diameter of this Ball.
	 * @return diam coordinate of this Ball within the GameArena
	 */
	public double getSize(){
		return size;
	}

	/**
	 * Sets the x cordinates of the ball
	 * @return x the new and updated cordinates of the ball
	 */
	public void setxPosition(double x)
	{
		this.xPosition = x;
	} 

	/**
	 * Sets the y cordinates of the ball
	 * @return y the new and updated cordinates of the ball
	 */
	public void setyPosition(double y)
	{
		this.yPosition = y;
	}

	/**Returns current position of this Ball.
	 * Returns current position of this Ball.
	 * @return X coordinate of this Ball within the GameArena
	 */
	public String getColour()
	{
		return colour;
	}
	/**
	 * Sets the xSpeed which is used to  move the ball.
	 *@return the new xSpeed
	 */
	public void setxSpeed(double speed)
	{
		xSpeed = speed;
	}

    /**
     * Sets the ySpeed which is used to  move the ball.
     *@return the new ySpeed
     */
	public void setySpeed(double speed)
	{
		ySpeed = speed;
	}
	/**
	* When the ball goes out of the game
	* this method marks it as flaged
	* so it can be deleted by GameArena
	*/
	/*public boolean flagDelete(){//doesnt work
		if(yPosition > 500)
		return true;
		else return false;
	}*/
	
	/**
	 * Returns current x speed of this Ball.
	 * @return xspeed coordinate of this Ball within the GameArena
	 */
	public double getXspeed(){
		return xSpeed;
	}
	/**
	 * Returns current x speed of this Ball.
	 * @return xspeed coordinate of this Ball within the GameArena
	 */
	public double getYspeed(){
		return ySpeed;
	}

    /**
     * Returns the current state of the Ball.
     * Use for determining if the Ball should be deleted.
     * @return deleteAble
     */

	public boolean getDeleteAble(){
		return deleteAble;
	}

/* ------------------------------------------------ */

	public Ball(double x, double y){
		xPosition = x;
		yPosition = y;
		xSpeed = 0.5;
		ySpeed = 3 ;
		
		size = 5;
		colour = "#0000FF";

	}

	/**
	*This method is used for moving the Balls.
	*
	*/
	public void move(){

		xPosition += xSpeed;
		yPosition += ySpeed;
	}


	public void bounce(double maxX, double maxY, double xM, double yM){
		//, double xM, double yM)

			move();

		if (xPosition > maxX || xPosition < 0){
			xSpeed = -xSpeed;
			xPosition += xSpeed;
		}

		if (itterations == 0 ){
				//headTowards(xM, yM);
			 // ySpeed = -ySpeed;
			    yPosition += ySpeed;
				ySpeed = -ySpeed;
			
			move();

		}
		if (yPosition < 0){
			ySpeed = -ySpeed;
			yPosition += ySpeed;
		 
		}

		if(yPosition > maxY  && itterations>15){
			System.out.println(yPosition +" "+maxY);	
			deleteAble = true;
			
		}
		itterations++;


	}
	
	/*public void headTowards(double a, double b){
		int c = 0;
		double vx = a - xPosition;
		double vy = b - yPosition;
      double dist = Math.sqrt(vx*vx + vy*vy);
      if (dist > 0) {
         double speed = Math.sqrt(xSpeed*xSpeed + ySpeed*ySpeed);
         xSpeed = vx / dist * speed;
         ySpeed = vy / dist * speed;
         c++;
         if(c == 1)	return;
      }
		//bounce(500, 500);
	//if(c == 2)	return;
		
	}*/
	public void headTowards(double xM, double yM){

		if(started == false){
		double tang = Math.tan(yM/xM);
		double oldxSpeed = xSpeed;
		double oldySpeed = ySpeed;
	
		ySpeed = Math.cos(tang)*oldySpeed;
		System.out.println("yspeed = "+ySpeed);
		xSpeed = Math.sin(tang)*oldxSpeed ;
		}
		started = true ;
	}



}
