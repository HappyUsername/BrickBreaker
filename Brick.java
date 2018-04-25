/**
*This class represents the Bricks in the game.
*
*/
public class Brick{
	private double xPosition;
	private double yPosition;
	private double height;// static
	private double width;// static
	private byte score;//inside the brick score + add a method that score--
	private String colour ;// static??


	/**
	 * Returns current X position of this Brick.
	 * @return X coordinate of this Brick within the GameArena
	 */
	public double getxPosition(){
		return xPosition;
	}

	/**
	 * Returns current Y position of this Brick.
	 * @return y coordinate of this Brick within the GameArena
	 */
	public double getyPosition(){
		return yPosition;
	}

	/**
	 * Returns current height of this Brick.
	 * @return height coordinate of this Brick within the GameArena
	 */
	public double getHeight(){
		return height;
	}

	/**
	 * Returns current height of this Brick.
	 * @return height of this Brick within the GameArena
	 */
	public double getWidth(){
		return width;
	}

	/**
	 * Returns current score of this Brick.
	 * @return score of this Brick within the GameArena
	 */
	public byte getScore(){
		return score;
	}

	/**
	 * Sets the score inside the 
	 * @param s the new x co-ordinate of this Rectangle
	 */
	public void setScore(byte s)
	{
		this.score = s;
	}

/* ------------------------------------------------ */

	public Brick(double x, double y, byte s){
		xPosition = x;
		yPosition = y;
		score = s;

	}
	
	/**
	*This method decreases the score of the Brick by 1.
	*Used when the brick is hit by a ball.
	*/
	public void scoreDecrease(){
		score -= 1;
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
