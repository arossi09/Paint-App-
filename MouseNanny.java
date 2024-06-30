package javiergs.gui.paint.gamma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * MouseNanny listens for mouse events.
 * Send information to Officer.
 *
 * @author javiergs
 * @version 2.0
 */
public class MouseNanny implements MouseListener, MouseMotionListener {

	int tempx;
	int tempy;
	public void mouseClicked(MouseEvent e) {
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	
	public void mouseExited(MouseEvent e) {
	}
	
	public void mousePressed(MouseEvent e) {
		tempx = e.getX();
		tempy = e.getY();

	}
	
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(Officer.getShape().equals("Rectangle")){

			Officer.pushToStack(new Rectangle(tempx, tempy, x - tempx, y - tempy, Officer.getColor()));

		}
		//Officer.setWidth(x - Officer.getX());
		//Officer.setHeight(y - Officer.getY());
		Officer.tellYourBoss();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Officer.setBox(tempx, tempy, x -tempx, y-tempy, Officer.getColor());
		Officer.tellYourBoss();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}