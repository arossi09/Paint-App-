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
 * @author Noa
 * @author Blake Masters
 *
 *
 * @version 2.0
 */
	/**
	 * MouseNanny listens for mouse events.
	 * Send information to Officer.
	 *
	 * @author javiergs
	 * @author Blake
	 * @author Noa
	 * @author Steven
	 * @author Anthony
	 * @version 2.0
	 */
	public class MouseNanny implements MouseListener, MouseMotionListener {

		int tempx;
		int tempy;
		Boolean movingFlag = false;
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
			Officer.setLine(0,0,0,0,Color.BLACK);


			int x = e.getX();
			int y = e.getY();
			int xd = x - tempx;
			int yd = y - tempy;
			if(x == tempx && y == tempy){
				return;
			}
			int temp;
			if(tempx > x){
				temp = x;
				x = tempx;
				tempx = temp;
			}
			if(tempy > y){
				temp = y;
				y = tempy;
				tempy = temp;
			}


			int xdif = Math.abs(x - tempx);
			int ydif = Math.abs(y - tempy);
			if(movingFlag){
				System.out.println(tempx - x);
				Officer.getSelectedShape().setX(Officer.getSelectedShape().getX() + xd);
				Officer.getSelectedShape().setY(Officer.getSelectedShape().getY() + yd);
				movingFlag = false;
				Officer.setSelectedShape(null);
			}
			else {
				if (Officer.getShape().equals("Rectangle")) {
					Officer.pushToStack(new Rectangle(tempx, tempy, xdif, ydif, Officer.getColor()));
				} else if (Officer.getShape().equals("Circle")) {
					Officer.pushToStack(new Circle(tempx, tempy, xdif, ydif, Officer.getColor()));
				} else if (Officer.getShape().equals("Arc")) {
					Officer.pushToStack(new Arc(tempx, tempy, xdif, ydif, Officer.getColor()));
				} else if (Officer.getShape().equals("Line")) {
					Officer.pushToStack(new Line(tempx, tempy, x, y, 1, Officer.getColor()));
				}


			}

			Officer.tellYourBoss();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			int dragx = tempx > x ? x : tempx;
			int dragy = tempy > y ? y : tempy;
			int xdif = Math.abs(x - tempx);
			int ydif = Math.abs(y - tempy);

			Officer.setSelectedShape(null);
			if(Officer.getShapeAt(tempx, tempy)){
				movingFlag = true;
			}
			else {
				movingFlag = false;
				if (Officer.getShape().equals("Rectangle")) {
					Officer.setBox(dragx, dragy, xdif, ydif, Officer.getColor());
					Officer.setOval(0, 0, 0, 0, Officer.getColor());
					Officer.setArc(0, 0, 0, 0, Officer.getColor());
					Officer.setLine(0, 0, 0, 0, Officer.getColor());
				} else if (Officer.getShape().equals("Circle")) {
					Officer.setOval(dragx, dragy, xdif, ydif, Officer.getColor());
					Officer.setBox(0, 0, 0, 0, Officer.getColor());
					Officer.setArc(0, 0, 0, 0, Officer.getColor());
					Officer.setLine(0, 0, 0, 0, Officer.getColor());
				} else if (Officer.getShape().equals("Arc")) {
					Officer.setArc(dragx, dragy, xdif, ydif, Officer.getColor());
					Officer.setBox(0, 0, 0, 0, Officer.getColor());
					Officer.setOval(0, 0, 0, 0, Officer.getColor());
					Officer.setLine(0, 0, 0, 0, Officer.getColor());
				} else if (Officer.getShape().equals("Line")) {
					Officer.setLine(tempx, tempy, x, y, Officer.getColor());
					Officer.setArc(0, 0, 0, 0, Officer.getColor());
					Officer.setBox(0, 0, 0, 0, Officer.getColor());
					Officer.setOval(0, 0, 0, 0, Officer.getColor());
				}
			}
			Officer.tellYourBoss();
		}

		@Override
		public void mouseMoved(MouseEvent e) {

		}
	}
