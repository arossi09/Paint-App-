package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
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

	static Shape selectedShape;

	static Shape clipBoardShape;

	static ArcOutline arc = new ArcOutline();
	static Line line = new Line();
	static Stack<Shape> shapes = new Stack<Shape>();

	static Stack<Shape> deletedShapes = new Stack<Shape>();

	static boolean erased = false;


	public static void saveShapesToFile() throws IOException {
		JFileChooser fileChooser = new JFileChooser();
		int approvedValue = fileChooser.showSaveDialog(null);

		if(approvedValue == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(shapes);
		}
	}

	public static void loadShapesFromFile() throws IOException, ClassNotFoundException {
		JFileChooser fileChooser = new JFileChooser();
		int approvedValue = fileChooser.showOpenDialog(null);

		if(approvedValue == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			shapes = (Stack<Shape>) in.readObject();
		}
	}

	public static void Copy(){
		if(selectedShape != null){
			clipBoardShape = selectedShape.clone();
			return;
		}
		System.out.println("No shape selected to copy!");

	}

	public static void Paste(){
		if(clipBoardShape != null){
			Shape newShape = clipBoardShape.clone();
			newShape.setX(clipBoardShape.getX()+10);
			newShape.setY(clipBoardShape.getY()+10);
			newShape.setColor(getColor());
			shapes.add(newShape);
			selectedShape = newShape.clone();
			return;
		}
		System.out.println("No shape copied to clipboard to paste!");
	}

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
	public static void setLine(int x, int y, int x2, int y2, Color color){
		line.setX(x);
		line.setX2(x2);
		line.setY(y);
		line.setY2(y2);
		line.setColor(color);
	}

	public static CircleOutline getOval(){
		return circle;
	}

	public static ArcOutline getArc(){
		return arc;
	}
	public static Line getLine(){
		return line;
	}


	public static Stack<Shape> getStack() {
		return shapes;
	}

	public static void clearShapes(){
		shapes.clear();
	}

	public static void clearDeletedShapes(){
		deletedShapes.clear();
	}

	public static Stack<Shape> getDeletedShapes() {
		return deletedShapes;
	}

	public static void pushToStack(Shape shape){
		shapes.push(shape);
	}

	public static void pushToDeleted(Shape shape) {deletedShapes.push(shape);}

	public static void popFromStack(){
		pushToDeleted(shapes.pop());
	}

	public static void undo(){

		if (erased) {
			Officer.loopStacks(deletedShapes, shapes);
			Officer.tellYourBoss();


		} else {
			if (shapes.isEmpty()){
				return;
			}
			pushToDeleted(shapes.pop());
			Officer.tellYourBoss();

		}
	}

	public static void redo(){

		if (erased) {
			Officer.loopStacks(shapes, deletedShapes);
			Officer.tellYourBoss();
		} else {
			if (deletedShapes.isEmpty()){
				return;
			}
			pushToStack(deletedShapes.pop());
			Officer.tellYourBoss();
		}
	}

	public static void loopStacks (Stack<Shape> source, Stack<Shape> dest){
		while (!source.isEmpty()) {
			dest.push(source.pop());
		}
	}

	public static void setErased(boolean update) {
		erased = update;
	}

	public static void erase() {
		Officer.loopStacks(Officer.getDeletedShapes(), new Stack<Shape>()); //clear deleted
		Officer.loopStacks(shapes, deletedShapes);
		Officer.tellYourBoss();

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

	public static void getShapeAt(int x, int y) {
		for (Shape shape : shapes) {
			if (shape.contains(x, y)) {
				System.out.println("Found shape!");
				shape.setSelected(true);
				selectedShape = shape;
				return;
			}
			shape.setSelected(false);
		}
		System.out.println("No shape found!");
		selectedShape = null;

	}

	public static Shape getSelectedShape(){
		return selectedShape;
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

	public static void CreateMenu(MainHomework hw){

		ActionNanny actionNanny = new ActionNanny();
		JMenu colorMenu = new JMenu("Colors");
		ButtonGroup colorGroup = new ButtonGroup();
		String[] colors = {"Black", "Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
		for(String color : colors){
			JRadioButtonMenuItem colorItem;
			colorItem = new JRadioButtonMenuItem(color);

			colorItem.addActionListener(actionNanny);
			colorGroup.add(colorItem);
			colorMenu.add(colorItem);
		}

		JMenu file = new JMenu("File");
		JMenuItem newFile = new JMenuItem("new");
		JMenuItem save = new JMenuItem("save");
		JMenuItem load = new JMenuItem("load");

		file.add(newFile);
		file.add(save);
		file.add(load);

		newFile.addActionListener(actionNanny);
		save.addActionListener(actionNanny);
		load.addActionListener(actionNanny);


		JMenu edit = new JMenu("Edit");
		ButtonGroup editGroup = new ButtonGroup();
		JMenuItem undo = new JMenuItem("undo");
		JMenuItem redo = new JMenuItem("redo");
		JMenuItem erase = new JMenuItem("erase");
		JMenuItem copy = new JMenuItem("copy");
		JMenuItem paste = new JMenuItem("paste");

		edit.add(undo);
		edit.add(redo);
		edit.add(erase);
		edit.add(copy);
		edit.add(paste);

		editGroup.add(undo);
		editGroup.add(redo);
		editGroup.add(erase);
		editGroup.add(copy);
		editGroup.add(paste);

		undo.addActionListener(actionNanny); // new line compared to version 1.0
		redo.addActionListener(actionNanny); // new line compared to version 1.0
		erase.addActionListener(actionNanny);
		copy.addActionListener(actionNanny);
		paste.addActionListener(actionNanny);


		copy.setMnemonic(KeyEvent.VK_P);
		paste.setMnemonic(KeyEvent.VK_C );

		JMenu shapes = new JMenu("Shapes");
		ButtonGroup shapeGroup = new ButtonGroup();
		JRadioButtonMenuItem rectangle = new JRadioButtonMenuItem("Rectangle");
		JRadioButtonMenuItem circle = new JRadioButtonMenuItem("Circle");
		JRadioButtonMenuItem arc = new JRadioButtonMenuItem("Arc");
		JRadioButtonMenuItem line = new JRadioButtonMenuItem("Line");
		shapes.add(rectangle);
		shapes.add(circle);
		shapes.add(arc);
		shapes.add(line);
		shapeGroup.add(rectangle);
		shapeGroup.add(circle);
		shapeGroup.add(arc);
		shapeGroup.add(line);

		rectangle.addActionListener(actionNanny);
		circle.addActionListener(actionNanny);
		arc.addActionListener(actionNanny);
		line.addActionListener(actionNanny);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		menuBar.add(colorMenu);
		menuBar.add(edit);
		menuBar.add(shapes);


		hw.setJMenuBar(menuBar);


	}
}
