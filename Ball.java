/**
*Class that represents the balls on the GameArena
*Brick Breaker Game
*
*@author Boris Boychev
*/
public class Ball{
	
	private double xPosition;
	private double yPosition;
	private static double size;// static??
	private static String colour;//static??
	
	private double xSpeed; //used for moving the ball on the X cordinate 
	private double ySpeed; //used for moving the ball on the y cordinate 

	private boolean deleteAble = false; // if thi is set to true, the ball shoud be deleted by GameArena

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
	 * 
	 * write a description
	 */
	public void setxSpeed(double speed)
	{
		xSpeed = speed;
	}

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

	public boolean getDeleteAble(){
		return deleteAble;
	}

/* ------------------------------------------------ */

	public Ball(double x, double y){
		xPosition = x;
		yPosition = y;
		xSpeed = 0;
		ySpeed = 0;
		
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
	
	public void bounce(double maxX, double maxY){
		move();

		if (xPosition > maxX || xPosition < 0){
			xSpeed = -xSpeed;
			xPosition += xSpeed;
		}

		/*if (yPosition > maxY || yPosition < 0){
			    ySpeed = -ySpeed;
			    yPosition += ySpeed;
		 
		}*/
		if (yPosition < 0){
			ySpeed = -ySpeed;
			yPosition += ySpeed;
		 
		}

		if(yPosition > maxY){
			//System.out.println(yPosition +" "+maxY);	
			deleteAble = true;
			//System.out.println("Disappear");
			
		}
		
	}

		/*public void mouseClicked(MouseEvent e) {
				System.out.println("bbla");		
		}*/


}
