package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

	/**
	 * Officer is a class that holds the data of the drawing application.
	 * And communicates to the DrawPanel when a repaint is needed.
	 *
	 * @author javiergs
	 * @version 1.0
	 */
	public class Officer {

		static Box box = new Box();
		static CircleOutline circle = new CircleOutline();

		static ArcOutline arc = new ArcOutline();
		static Stack<Shape> shapes = new Stack<Shape>();

		static Stack<Shape> deletedShapes = new Stack<Shape>();

		public static Box getBox() {
			return box;
		}
		public static void setBox(int x, int y, int w, int h, Color color){
			box.setX(x);
			box.setW(w);
			box.setY(y);
			box.setH(h);
			box.setColor(color);
		}
		public static void setOval(int x, int y, int w, int h, Color color){
			circle.setX(x);
			circle.setW(w);
			circle.setY(y);
			circle.setH(h);
			circle.setColor(color);
		}
		public static void setArc(int x, int y, int w, int h, Color color){
			arc.setX(x);
			arc.setW(w);
			arc.setY(y);
			arc.setH(h);
			arc.setColor(color);
		}

		public static CircleOutline getOval(){
			return circle;
		}
		public static ArcOutline getArc(){
			return arc;
		}


		public static Stack<Shape> getStack() {
			return shapes;
		}
		public static void pushToStack(Shape shape){
			shapes.push(shape);
		}
		public static void pushToDeleted(Shape shape) {deletedShapes.push(shape);}
		public static void popFromStack(){
			pushToDeleted(shapes.pop());
		}


		private static Color color;
		private static String shape;
		private static int x;
		private static int y;
		private static int width;
		private static int height;
		private static JPanel drawPanel;

		public static Color getColor() {
			return color==null?Color.BLACK:color;
		}

		public static void setColor(Color color) {
			Officer.color = color;
		}

		public static String getShape() {
			return shape==null?"Rectangle":shape;
		}

		public static void setShape(String shape) {
			Officer.shape = shape;
		}

		public static int getX() {
			return x;
		}

		public static void setX(int x) {
			Officer.x = x;
		}

		public static int getY() {
			return y;
		}

		public static void setY(int y) {
			Officer.y = y;
		}

		public static int getWidth() {
			return width;
		}

		public static void setWidth(int width) {
			Officer.width = width;
		}

		public static int getHeight() {
			return height;
		}

		public static void setHeight(int height) {
			Officer.height = height;
		}

		public static void tellYourBoss() {
			drawPanel.repaint();
			System.out.println("Tell your boss to repaint.");
		}

		public static void setDrawPanel(JPanel d) {
			drawPanel = d;
		}

	}
