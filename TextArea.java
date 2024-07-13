package javiergs.gui.paint.gamma;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class TextArea extends JPanel implements PropertyChangeListener{


    public TextArea(){
        //TODO: make the panel
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
