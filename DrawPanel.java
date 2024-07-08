package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;

/**
 * DrawPanel creates a panel where the drawing is done.
 * According to the data in Officer.
 *
 * @author javiergs
 * @version 3.0
 */
public class DrawPanel extends JPanel {
	
	public DrawPanel() {
		setBackground(new Color(176, 250, 192));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("Tell your boss to repaint. DOING!");

		super.paintComponents(g);
		g.setColor(new Color(176, 250, 192));
		g.fillRect(0, 0, getWidth(), getHeight());

		for (int x = 0; x < Officer.getStack().size(); x ++){
			Officer.getStack().get(x).draw(g);
		}
		Officer.getBox().draw(g);
		Officer.getOval().draw(g);
		Officer.getArc().draw(g);
		Officer.getLine().draw(g);
	}
	
}