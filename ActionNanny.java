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
			if (menuItem.getActionCommand().equals("Black")) {
				Officer.setColor(Color.BLACK);
			} else if (menuItem.getActionCommand().equals("Red")) {
				Officer.setColor(Color.RED);
			} else if (menuItem.getActionCommand().equals("Blue")) {
				Officer.setColor(Color.BLUE);
			} else if (menuItem.getActionCommand().equals("Green")) {
				Officer.setColor(Color.GREEN);
			} else if (menuItem.getActionCommand().equals("Yellow")) {
				Officer.setColor(Color.YELLOW);
			} else if (menuItem.getActionCommand().equals("Orange")) {
				Officer.setColor(Color.ORANGE);
			} else if (menuItem.getActionCommand().equals("Pink")) {
				Officer.setColor(Color.PINK);
			} else if (menuItem.getActionCommand().equals("undo")) {
				System.out.println("undo");
				Officer.undo();
			} else if (menuItem.getActionCommand().equals("erase")) {
				System.out.println("erase");
				Officer.setErased(true);
				Officer.erase();
			} else if (menuItem.getActionCommand().equals("redo")) {
				System.out.println("redo");
				Officer.redo();
			}else if(menuItem.getActionCommand().equals("copy")){
				Officer.Copy();
			}else if(menuItem.getActionCommand().equals("paste")) {
				Officer.Paste();
				Officer.tellYourBoss();
			}else if(menuItem.getActionCommand().equals("save")) {
				try {
					Officer.saveShapesToFile();
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}else if(menuItem.getActionCommand().equals("load")) {
				try {
					Officer.loadShapesFromFile();
					Officer.tellYourBoss();
				} catch (IOException | ClassNotFoundException ex) {
					throw new RuntimeException(ex);
				}
			}else if(menuItem.getActionCommand().equals("new")){
				Officer.erase();
				Officer.clearShapes();
				Officer.clearDeletedShapes();
			}else{
				System.out.println(e.getActionCommand());
				Officer.setShape(e.getActionCommand());
			}
		}
	}


}