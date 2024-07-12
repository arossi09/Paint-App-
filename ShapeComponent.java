package javiergs.gui.paint.gamma;

import java.awt.*;
import java.util.ArrayList;

//end goal shape rect = new shape
//HatDecorator hat = new HatDecorator()
//shape.add(hat)
public abstract class ShapeComponent {

    protected int status = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public abstract void draw(Graphics g);

}
