/**
*This class represents the Triangles in the Brick Breaker Game
*
*/
public class HalfBrick{
	private double xPosition;
	private double yPosition;
	private double height;// static
	private double width;// static
	private byte score;//inside the brick score + add a method that score--
	private String colour ;// static??


	/**
	 * Returns current X position of this HalfBrick.
	 * @return X coordinate of this HalfBrick within the GameArena
	 */
	public double getxPosition(){
		return xPosition;
	}

	/**
	 * Returns current Y position of this HalfBrick.
	 * @return y coordinate of this HalfBrick within the GameArena
	 */
	public double getyPosition(){
		return yPosition;
	}

	/**
	 * Returns current height of this HalfBrick.
	 * @return height coordinate of this HalfBrick within the GameArena
	 */
	public double getHeight(){
		return height;
	}

	/**
	 * Returns current height of this HalfBrick.
	 * @return height of this HalfBrick within the GameArena
	 */
	public double getWidth(){
		return width;
	}

	/**
	 * Returns current score of this HalfBrick.
	 * @return score of this HalfBrick within the GameArena
	 */
	public byte getScore(){
		return score;
	}

	/**
	 * Sets the score inside the HalfBrick
	 * @param s the new score
	 */
	public void setScore(byte s)
	{
		this.score = s;
	}
/* ------------------------------------------------ */

	public HalfBrick(double x, double y, byte s){
		xPosition = x;
		yPosition = y;
		score = s;

	}

	/**
	*This method decreases the score of the HalfBrick by 1.
	*Used when the HalfBrick is hit by a ball.
	*/
	public void scoreDecrease(){
		score -= 1;
	};

}
