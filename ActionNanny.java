package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * ActionNanny listens for action events.
 * Send information to Officer.
 *
 * @author javiergs
 * @version 2.0
 */
public class ActionNanny implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			String actionCommand = menuItem.getActionCommand();

			switch (actionCommand) {
				case "Black":
				case "Red":
				case "Blue":
				case "Green":
				case "Yellow":
				case "Orange":
				case "Pink":
					setColorForShape(actionCommand);
					break;
				case "undo":
					Officer.undo();
					break;
				case "erase":
					Officer.setErased(true);
					Officer.erase();
					break;
				case "redo":
					Officer.redo();
					break;
				case "copy":
					Officer.Copy();
					break;
				case "paste":
					Officer.Paste();
					Officer.tellYourBoss();
					break;
				case "save":
					try {
						Officer.saveShapesToFile();
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
					break;
				case "load":
					try {
						Officer.loadShapesFromFile();
						Officer.tellYourBoss();
					} catch (IOException | ClassNotFoundException ex) {
						throw new RuntimeException(ex);
					}
					break;
				case "new":
					Officer.erase();
					Officer.clearShapes();
					Officer.clearDeletedShapes();
					break;
				default:
					System.out.println(actionCommand);
					Officer.setShape(actionCommand);
					break;
			}
		}
	}

	private void setColorForShape(String colorCommand) {
		Color color;
		switch (colorCommand) {
			case "Black":
				color = Color.BLACK;
				break;
			case "Red":
				color = Color.RED;
				break;
			case "Blue":
				color = Color.BLUE;
				break;
			case "Green":
				color = Color.GREEN;
				break;
			case "Yellow":
				color = Color.YELLOW;
				break;
			case "Orange":
				color = Color.ORANGE;
				break;
			case "Pink":
				color = Color.PINK;
				break;
			default:
				return;
		}

		if (Officer.getSelectedShape() == null) {
			Officer.setColor(color);
		} else {
			Officer.getSelectedShape().setColor(color);
			Officer.tellYourBoss();
		}
	}
}
