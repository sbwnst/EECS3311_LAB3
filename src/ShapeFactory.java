import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Screen: main application window
 */
public class ShapeFactory extends JFrame {
	
	// screen attributes
	private final String TITLE = "Display Shapes"; // screen title
	private final int WIDTH = 600; // width
	private final int HEIGHT = 600; // height
	
	// UI elements
	private JButton loadButton, sortButton; // buttons
	private SortingTechnique canvas; // drawing canvas
	
	// drawing data
	private final int X = 10, Y = 10; // initial drawing coordinates
	
	public ShapeFactory() {
		
		this.initUiComponents();  // create all UI components
		
		this.setTitle(TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null); // always initialize at center
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * create GUI components
	 */
	public void initUiComponents() {
		
		// create and add buttons
		loadButton = new JButton("Load Shapes");
		sortButton = new JButton("Sort Shapes");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(loadButton);
		buttonPanel.add(sortButton);
		
		this.add(buttonPanel, BorderLayout.NORTH);
		
		// create and add canvas
		canvas = new SortingTechnique();
		this.add(canvas, BorderLayout.CENTER);
		
		// add lister to load button
		loadButton.addActionListener(event -> {
			
			// clear old shapes
			canvas.clearDrawingQueue();
			this.createShapes();
		});
		
		// add lister to sort button
		sortButton.addActionListener(event -> {
			this.sortShapes();
		});
	}
	
	/**
	 * creates shapes and draws on canvas
	 */
	public void createShapes() {
		
		// top-left corder of next shape would be, previous corner + previous dimensions
		// make 6 shapes
		Shape shape1 = new Circle(canvas, 100, 100, Color.RED);
		Shape shape2 = new Rectangle(canvas, 30, 30, Color.GREEN);
		Shape shape3 = new Rectangle(canvas, 40, 30, Color.BLUE);
		Shape shape4 = new Circle(canvas, 60, 60, Color.GRAY);
		Shape shape5 = new Rectangle(canvas, 80, 95, Color.BLACK);
		Shape shape6 = new Circle(canvas, 99, 100, Color.CYAN);
		
		// draw all shapes
		shape1.draw();
		shape2.draw();
		shape3.draw();
		shape4.draw();
		shape5.draw();
		shape6.draw();
	}
	
	/**
	 * sorts shapes and draws on canvas
	 */
	public void sortShapes() {
		canvas.sortDrawingQueue();
	}
}
