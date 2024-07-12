package javiergs.gui.paint.gamma;

import java.awt.*;
import java.io.Serializable;
/**
 * @aythor anthony
 * @author blake
 * @version 3.0
 */
public abstract class Shape extends ShapeComponent {


    private boolean selected = false;

    public void setSelected(boolean setter) {
        selected = setter;
    }

    public Shape(){
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);


    public abstract boolean contains(int x, int y);

}
