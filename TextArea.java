package javiergs.gui.paint.gamma;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class TextArea extends JPanel implements PropertyChangeListener{


    public TextArea(){
        setBackground(Color.LIGHT_GRAY);
        JFormattedTextField text = new JFormattedTextField();
        text.setMargin(new Insets(0, 0, 500, 250));
        text.setHorizontalAlignment(JTextField.LEFT);
        text.setEnabled(false);
        add(text);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName().equals("stack") && e.getNewValue() != null){
            ShapeComponent temp = (ShapeComponent) e.getNewValue();
            System.out.println("Got here for now");
            //TODO: Shape type check and the svg stuff in this class
        }
    }
}
