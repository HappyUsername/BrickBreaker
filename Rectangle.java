import java.awt.*;
/**
 * Models a simple, solid rectangle. 
 * This class represents a Rectangle object. When combined with the GameArena class,
 * instances of the Rectangle class can be displayed on the screen.
 */
public class Rectangle 
{
    // The following instance variables define the information needed to represent a Ball
    // Feel free to more instance variables if you think it will support your work... 
    
    private double xPosition;            // The X coordinate of this Rectangle
    private double yPosition;            // The Y coordinate of this Rectangle
    private double width;                // The width of this Rectangle
    private double height;               // The height of this Rectangle
    private static String colour;               // The colour of this Rectangle
    private boolean forDelete = false;  // rename to destroyed
    private int score; // the score of the brick


    /**
     * Obtains the current position of this Rectangle.
     * @return the X coordinate of this Rectangle within the GameArena.
     */
    public double getXPosition()
    {
        return xPosition;
    }

    /**
     * Obtains the current position of this Rectangle.
     * @return the Y coordinate of this Rectangle within the GameArena.
     */
    public double getYPosition()
    {
        return yPosition;
    }

    /**
     * Moves the current position of this Rectangle to the given X co-ordinate
     * @param x the new x co-ordinate of this Rectangle
     */
    public void setXPosition(double x)
    {
        this.xPosition = x;
    }

    /**
     * Moves the current position of this Rectangle to the given Y co-ordinate
     * @param y the new y co-ordinate of this Rectangle
     */
    public void setYPosition(double y)
    {
        this.yPosition = y;
    }

    /**
     * Obtains the width of this Rectangle.
     * @return the width of this Rectangle,in pixels.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Obtains the current score of this Rectangle.
     * @return the score of this Rectangle within the GameArena.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Changes the width of this Rectangle to the given value
     * @param w the new width of this rectangle, in pixels.
     */
    public void setWidth(double w)
    {
        width = w;
    }

    /**
     * Obtains the height of this Rectangle.
     * @return the height of this Rectangle,in pixels.
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Changes the height of this Rectangle to the given value
     * @param h the new height of this rectangle, in pixels.
     */
    public void setHeight(double h)
    {
        height = h;
    }

    /**
     * Obtains the colour of this Rectangle.
     * @return a textual description of the colour of this Rectangle.
     */
    public String getColour()
    {
        return colour;
    }

    /**
     * Changes the score of this Rectangle to the given value
     * @param s the new score of this rectangle.
     */
    public void setScore(int s)
    {
        score = s;
    }

    /**
     * Changes the colour of this Rectangle to the given value.
     * 
     * @param c The new colour of this Rectangle. 
     * <BR><BR>
     * Permissable values are 8 bit hexadecimal RGB values in the format #RRGGBB. e.g.  
     * Pure red is "#FF0000"   <BR>
     * Pure green is "#00FF00" <BR>
     * Pure blue is "#0000FF"  <BR>
     * <BR>
     * Alternativley, named colours are also allowed for the following list. e.g. "AQUA" :
     * <BR><BR>
     * ALICEBLUE ANTIQUEWHITE AQUA AQUAMARINE AZURE BEIGE BISQUE BLACK BLANCHEDALMOND BLUE BLUEVIOLET BROWN BURLYWOOD CADETBLUE CHARTREUSE CHOCOLATE CORAL
     * CORNFLOWERBLUE CORNSILK CRIMSON CYAN DARKBLUE DARKCYAN DARKGOLDENROD DARKGRAY DARKGREEN DARKGREY DARKKHAKI DARKMAGENTA DARKOLIVEGREEN DARKORANGE DARKORCHID
     * DARKRED DARKSALMON DARKSEAGREEN DARKSLATEBLUE DARKSLATEGRAY DARKSLATEGREY DARKTURQUOISE DARKVIOLET DEEPPINK DEEPSKYBLUE DIMGRAY DIMGREY DODGERBLUE FIREBRICK
     * FLORALWHITE FORESTGREEN FUCHSIA GAINSBORO GHOSTWHITE GOLD GOLDENROD GRAY GREEN GREENYELLOW GREY HONEYDEW HOTPINK INDIANRED INDIGO IVORY KHAKI LAVENDER LAVENDERBLUSH
     * LAWNGREEN LEMONCHIFFON LIGHTBLUE LIGHTCORAL LIGHTCYAN LIGHTGOLDENRODYELLOW LIGHTGRAY LIGHTGREEN LIGHTGREY LIGHTPINK LIGHTSALMON LIGHTSEAGREEN LIGHTSKYBLUE LIGHTSLATEGRAY
     * LIGHTSLATEGREY LIGHTSTEELBLUE LIGHTYELLOW LIME LIMEGREEN LINEN MAGENTA MAROON MEDIUMAQUAMARINE MEDIUMBLUE MEDIUMORCHID MEDIUMPURPLE MEDIUMSEAGREEN MEDIUMSLATEBLUE
     * MEDIUMSPRINGGREEN MEDIUMTURQUOISE MEDIUMVIOLETRED MIDNIGHTBLUE MINTCREAM MISTYROSE MOCCASIN NAVAJOWHITE NAVY OLDLACE OLIVE OLIVEDRAB ORANGE ORANGERED ORCHID
     * PALEGOLDENROD PALEGREEN PALETURQUOISE PALEVIOLETRED PAPAYAWHIP PEACHPUFF PERU PINK PLUM POWDERBLUE PURPLE RED ROSYBROWN ROYALBLUE SADDLEBROWN SALMON SANDYBROWN
     * SEAGREEN SEASHELL SIENNA SILVER SKYBLUE SLATEBLUE SLATEGRAY SLATEGREY SNOW SPRINGGREEN STEELBLUE TAN TEAL THISTLE TOMATO TURQUOISE VIOLET WHEAT WHITE
     * WHITESMOKE YELLOW YELLOWGREEN.
     */
    public void setColour(String c)
    {
        colour = c;
    }
    /**
    *Changes the value of the score of the current Rectangle by -1.
    * Used for when the ball hits the rectangle. 
    */
    public void scoreMinus(){
		score--;
		if (score == 0){
			forDelete = true;
		}
    }

    /**
    *If the score is less than 0 returns true, else false
    * Used flagging the current rectangle so it can be deleted by GameArena.
    */
    public boolean forDelete(){
	if(score == 0){
	return true;
	}
	else return false;
    }


    /**
     *
     * Constructor. Create a new instance of a Rectangle.
     *
     * @param x The X co-ordinate in the GameArena where this Rectangle will initially be located.
     * @param y The Y co-ordinate in the GameArena where this Rectangle will initially be located.
     * @param w The width of the Rectangle in pixels.
     * @param h The height of the Rectangle in pixels.
     * @param col. The colour of the Ball. @see setColour for a description of permissable colours.
     *
     */
    public Rectangle(double x, double y, double w, double h, int s)
    {
        xPosition = x;
        yPosition = y;
        width = w;
        height = h;
		score = s;
        colour = "#C0C0C0";
    }    
    
    public void bounceRect(Ball bl){
	/*	
		if(this.intersects(bl) == true){
			System.out.println("Hitting");
		}
		*/
		double bx = bl.getXPosition();
		double by = bl.getYPosition();
		double br = (bl.getSize())/2; 
		
		if(by + br > yPosition + (height/2) &&
		by - br < yPosition + (height/2) &&
		bx - br < xPosition + (width/2) &&
		bx + br > xPosition - (width/2)
		){
			
			//	 System.out.println("Hitting bottom");
		}
		if ( by + br > yPosition - (height/2) &&
		by - br < yPosition - (height/2) &&
		bx - br > xPosition - (width/2) &&
		bx + br < xPosition + (width/2)
		
		){		
			 System.out.println("Hitting top");
		}
		if (bx + br > xPosition + (width/2) &&
		bx - br < xPosition + (width/2) &&
		by - br > yPosition - (height/2) &&
		by + br < yPosition + (height/2)
		){
			 System.out.println("Hitting RIGHT");
		}
		if (bx + br > xPosition - (width/2) && // doesnt work
		bx - br < xPosition - (width/2) &&
		by - br < yPosition + (height/2) &&
		by + br > yPosition - (height/2)
		){
			 System.out.println("Hitting Left");
		}
		
		
		
		
		
		
		if( (bl.getXPosition() >= xPosition) && //+height
			(bl.getYPosition() == yPosition + height) &&
			(bl.getXPosition() <= xPosition + width + 1) &&
			 (forDelete == false)
			){ // - width
				System.out.println("Hitting bottom");
	// 			xPosition += xSpeed;	
		//bl.setyPosition(bl.getYspeed());	 
		}
		/*else if (  // hit the top (bl.getXPosition() >= xPosition + (height/2)) && 
			(bl.getXPosition() <= xPosition ) 
			){ //(bl.getXPosition() > xPosition- (width/2))
				 System.out.println("Hitting top \n");
				 	bl.setxSpeed(-bl.getXspeed());	 
			 }
			 */
		else if((bl.getYPosition() >= yPosition) && // hit the left
			(bl.getYPosition() <= yPosition + height) &&
			(bl.getXPosition() == xPosition) &&
			 (forDelete == false)){
			System.out.println("Hitting left \n");
		}
		
		else if((bl.getYPosition() >= yPosition) && // hit the right
			(bl.getYPosition() >= yPosition + height) &&
			(bl.getXPosition() == xPosition + width) &&
			 (forDelete == false)){
			System.out.println("Hitting right \n");
		}
	}
}
