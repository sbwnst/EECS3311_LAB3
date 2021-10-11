import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Canvas: represents a canvas on which shapes are drawn 
 */
public class SortingTechnique extends JComponent {
	
	private final int INITIAL_X = 10, INITIAL_Y = 10; // initial drawing coordinates
	private ArrayList<Shape> drawing_queue = new ArrayList<>(); // drawing queue
	
	/**
	 * draw all shapes of the drawing queue
	 */
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);
		
		int x = INITIAL_X;
		int y = INITIAL_Y;
		
		for(int i=0; i<drawing_queue.size(); i++) {
			
			Shape shape = drawing_queue.get(i); // get shape
			
			// extract shape attributes
			int width = shape.getWidth();
			int height = shape.getHeight();
			Color color = shape.getColor();
			
			graphics.setColor(color); // set color
			
			// calculate next coordinate based on previous shape's dimensions
			if(i > 0) {
				x += drawing_queue.get(i-1).getWidth() + INITIAL_X;
				y += drawing_queue.get(i-1).getHeight() + INITIAL_Y;
			}
			
			// draw circle
			if(shape instanceof Circle) {
				graphics.fillOval(x, y, width, height);
			}
			
			// draw Rectangle
			if(shape instanceof Rectangle) {
				graphics.fillRect(x, y, width, height);
			}
		}
	}
	
	/**
	 * updates the drawing queue on screen
	 */
	public void updateDrawingQueue(Shape shape) {
		this.drawing_queue.add(shape);
		this.repaint(); // redraw
	}
	
	/**
	 * sorts shapes in drawing queue by surface and redraws on screen
	 */
	public void sortDrawingQueue() {
		
		// copy to another array
		Shape[] tempList = new Shape[drawing_queue.size()];
		
		for(int i=0; i<drawing_queue.size(); i++) {
			tempList[i] = drawing_queue.get(i);
		}
		
		// selection sort
		for(int i=0; i<tempList.length; i++) {
			for(int j=i+1; j<tempList.length; j++) {
				if(tempList[i].compareTo(tempList[j]) > 0) {
					Shape temp = tempList[i];
					tempList[i] = tempList[j];
					tempList[j] = temp;
				}
			}
		}
		
		// add to original list and redisplay
		drawing_queue.clear();
		for(Shape shape : tempList) {
			this.updateDrawingQueue(shape);
		}
		
		this.repaint(); // redraw sorted shapes
	}
	
	/**
	 * clears the drawing queue
	 */
	public void clearDrawingQueue() {
		this.drawing_queue.clear();
		this.repaint();
	}
}
