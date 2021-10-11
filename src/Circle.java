import java.awt.Graphics2D;
import java.awt.*;

/**
 * Circle: represents a circle 
 */
public class Circle extends Shape {
	
	public Circle(SortingTechnique canvas, int WIDTH, int HEIGHT, Color color) {
		super(canvas, WIDTH, HEIGHT, color);
	}
	
	@Override
	public double getSurface() {
		
		double radius = this.getWidth() / 2;
		double surface = Math.PI * (radius * radius); // area of circle
		return surface;
	}

	@Override
	public void draw() {
		this.getCanvas().updateDrawingQueue(this);
	}

}
