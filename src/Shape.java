import java.awt.*;

/**
 * Shape: represents a shape
 */
public abstract class Shape implements Comparable<Shape> {
	
	private SortingTechnique canvas;
	private int WIDTH, HEIGHT; // dimensions of shape
	private Color color; // color of shape
	
	public Shape(SortingTechnique canvas, int width, int height, Color color) {
		this.canvas = canvas;;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.color = color;
	}
	
	// area(surface) of a shape (to be implemented)
	public abstract double getSurface(); 
	
	// puts the shape in drawing queue (to be implemented)
	public abstract void draw();
	
	// getter for shape width
	public int getWidth() {
		return WIDTH;
	}
	
	// getter for shape height
	public int getHeight() {
		return HEIGHT;
	}
	
	// getter for shape color
	public Color getColor() {
		return color;
	}
	
	// getter for canvas reference
	public SortingTechnique getCanvas() {
		return canvas;
	}
	
	@Override
	public int compareTo(Shape o) {
		return (int)(this.getSurface() - o.getSurface());
	}
}
