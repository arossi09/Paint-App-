
package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * MainHomework creates a frame and adds three panels to it.
 * This version adds MouseListener to the DrawPanel.
 *
 * @author javiergs
 * @author Blake
 * @author Noa
 * @author Steven
 * @author Anthony
 * @version 2.0
 */
public class MainHomework extends JFrame {
	
	public static void main(String[] args) {
		MainHomework app = new MainHomework();
		app.setSize(800, 600);
		app.setTitle("Second Attempt for a Drawing Application");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setResizable(false);
		app.setVisible(true);
	}
	
	public MainHomework() {

		JPanel drawPanel = new DrawPanel();
		MouseNanny mouseNanny = new MouseNanny();
		drawPanel.addMouseListener(mouseNanny);
		drawPanel.addMouseMotionListener(mouseNanny);
		Officer.setDrawPanel(drawPanel); // new line compared to version 2.
		setLayout(new BorderLayout());
		add(drawPanel, BorderLayout.CENTER);
		Officer.CreateMenu(this);
		//TODO: Create TextAreaPanel and pass as listener
		TextArea textPanel = new TextArea();
		Officer.getInstance().addObserver(textPanel);


	}

}