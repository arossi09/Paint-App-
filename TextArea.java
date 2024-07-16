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
        text.setPreferredSize(new Dimension( 300, 500));
        text.setEnabled(true);
        text.setVisible(true);
        add(text);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if(e != null){
            text.setText("");
            Stack<ShapeComponent> temp = (Stack<ShapeComponent>) e.getNewValue();
            Iterator<ShapeComponent> iter = temp.iterator();
            while(iter.hasNext()){
                ShapeComponent curShape = iter.next();
                text.append(new String("<" + curShape.getClass().getSimpleName() + " width= " +
                        curShape.getW() + " height= " + curShape.getH() + " fill " + curShape.color.getRGB() + " />\n"));
            }
        }
    }
}
