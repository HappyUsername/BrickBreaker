/**
*Class that represents the balls on the GameArena
*Brick Breaker Game
*
*@author Boris Boychev
*/
public class Ball{
	
	private double xPosition;
	private double yPosition;
	private double diam;// static??
	private String colour;//static??
	
	private double xSpeed; //used for moving the ball on the X cordinate 
	private double ySpeed; //used for moving the ball on the y cordinate 

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
	public double getDiam(){
		return diam;
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


/* ------------------------------------------------ */

	public Ball(double x, double y){
		xPosition = x;
		yPosition = y;
		xSpeed = 0;
		ySpeed = 0;
		//maybe diameter??

	}

	/**
	*This method is used for moving the Balls.
	*
	*/
	public void move()
	{
		xPosition += xSpeed;
		yPosition += ySpeed;
	}

}
