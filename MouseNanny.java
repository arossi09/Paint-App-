package javiergs.gui.paint.gamma;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;

/**
 * MouseNanny listens for mouse events.
 * Send information to Officer.
 *
 * @author javiergs
 * @version 2.0
 */
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
		Officer.getShapeAt(e.getX(), e.getY());
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

		Officer.setErased(false);
		Officer.setBox(0,0,0,0, Color.BLACK);
		Officer.setArc(0,0,0,0,Color.BLACK);
		Officer.setOval(0,0,0,0,Color.BLACK);

		int x = e.getX();
		int y = e.getY();
		if(tempx == x && tempy == y){
			return;
		}
		if(Officer.getShape().equals("Rectangle")){
			Officer.pushToStack(new Rectangle(tempx, tempy, x - tempx, y - tempy, Officer.getColor()));
		}
		else if(Officer.getShape().equals("Circle")){
			Officer.pushToStack(new Circle(tempx, tempy, x-tempx, y-tempy, Officer.getColor()));
		}
		else if(Officer.getShape().equals("Arc")){
			Officer.pushToStack(new Arc(tempx, tempy, x - tempx, y - tempy, Officer.getColor()));
		}

		Officer.tellYourBoss();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(Officer.getShape().equals("Rectangle")){
			Officer.setBox(tempx, tempy, x - tempx, y-tempy, Officer.getColor());
			Officer.setOval(0,0,0,0,Officer.getColor());
			Officer.setArc(0,0,0,0,Officer.getColor());
		}
		else if(Officer.getShape().equals("Circle")){
			Officer.setOval(tempx, tempy, x - tempx, y-tempy, Officer.getColor());
			Officer.setBox(0,0,0, 0, Officer.getColor());
			Officer.setArc(0,0,0,0,Officer.getColor());
		}
		else if(Officer.getShape().equals("Arc")){
			Officer.setArc(tempx, tempy, x - tempx, y - tempy, Officer.getColor());
			Officer.setBox(0,0,0, 0, Officer.getColor());
			Officer.setOval(0,0,0,0,Officer.getColor());
		}
		Officer.tellYourBoss();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
