import java.awt.EventQueue;

/**
 * Main: launches the application 
 */
public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			
			new ShapeFactory();

			
		} );

	}

}
