package javiergs.gui.paint.gamma;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.Stack;


public class TextArea extends JPanel implements PropertyChangeListener{

    private Stack<String> stack = new Stack<String>();
    private int stSize = 0;
    private JTextArea text;
    public TextArea(){
        this.setSize(100, 500);
        setBackground(Color.LIGHT_GRAY);

        text = new JTextArea();
        text.setMargin(new Insets(0, 0, 5, 5));
        text.setPreferredSize(new Dimension( 350, 500));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEnabled(true);
        text.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(text);
        add(scrollPane);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if(e != null){
            text.setText("");
            Stack<ShapeComponent> temp = (Stack<ShapeComponent>) e.getNewValue();
            Iterator<ShapeComponent> iter = temp.iterator();
            while(iter.hasNext()) {
                ShapeComponent curShape = iter.next();
                String objName = "<" + curShape.getClass().getSimpleName();
                 if(curShape instanceof ShapeDecorator){
                    curShape = Officer.findOriginalShape(curShape);
                    objName = objName.concat(" " + curShape.getClass().getSimpleName());
                }
                    text.append(new String(objName + " x = \"" + curShape.getX()
                            + "\" y=\"" + curShape.getY() + "\" width= " + curShape.getW() + " height=\"" + curShape.getH()
                            + " fill\"" + curShape.getColor().getRGB() + "\" />\n"));
                }
            }
        }
    }
