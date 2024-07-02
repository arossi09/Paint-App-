package javiergs.gui.paint.gamma;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(){
        ActionNanny actionNanny = new ActionNanny();

        JMenu edit = new JMenu("Edit");
        JMenuItem undo = new JMenuItem("undo");
        JMenuItem redo = new JMenuItem("redo");
        JMenuItem erase = new JMenuItem("erase");

        JMenu shapes = new JMenu("Shapes");
        JMenuItem rectangle = new JMenuItem("Rectangle");
        JMenuItem circle = new JMenuItem("Circle");
        JMenuItem arc = new JMenuItem("Arc");

        JMenu colors = new JMenu("Colors");
        JMenuItem black = new JMenuItem("Black");
        JMenuItem red = new JMenuItem("Red");
        JMenuItem blue = new JMenuItem("Blue");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem yellow = new JMenuItem("Yellow");
        JMenuItem orange = new JMenuItem("Orange");
        JMenuItem pink = new JMenuItem("Pink");

        undo.addActionListener(actionNanny); // new line compared to version 1.0
        redo.addActionListener(actionNanny); // new line compared to version 1.0
        erase.addActionListener(actionNanny);

        rectangle.addActionListener(actionNanny);
        circle.addActionListener(actionNanny);
        arc.addActionListener(actionNanny);

        black.addActionListener(actionNanny);
        red.addActionListener(actionNanny);
        blue.addActionListener(actionNanny);
        green.addActionListener(actionNanny);
        yellow.addActionListener(actionNanny);
        orange.addActionListener(actionNanny);
        pink.addActionListener(actionNanny);

        edit.add(undo);
        edit.add(redo);
        edit.add(erase);

        shapes.add(rectangle);
        shapes.add(circle);
        shapes.add(arc);

        colors.add(black);
        colors.add(red);
        colors.add(blue);
        colors.add(green);
        colors.add(yellow);
        colors.add(orange);
        colors.add(pink);

        add(colors);
        add(shapes);
        add(edit);
    }
}
