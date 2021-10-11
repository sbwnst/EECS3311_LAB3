import java.awt.Graphics2D;
import java.awt.*;

/**
 * Circle: represents a circle 
 */
public class Rectangle extends Shape {
	
	public Rectangle(SortingTechnique canvas, int WIDTH, int HEIGHT, Color color) {
		super(canvas,WIDTH, HEIGHT, color);
	}
	
	@Override
	public double getSurface() {
		
		return getWidth() * getHeight(); // area of rectangle/square
	}

	@Override
	public void draw() {
		this.getCanvas().updateDrawingQueue(this);
	}

}
