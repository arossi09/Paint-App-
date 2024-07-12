package javiergs.gui.paint.gamma;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

//end goal shape rect = new shape
//HatDecorator hat = new HatDecorator()
//shape.add(hat)
public abstract class ShapeComponent  implements Cloneable, Serializable {

    protected Color color;
    protected int x,y,w,h;

    protected int status = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public int getH() {
        return h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getColor() {
        return color;
    }
    public abstract void draw(Graphics g);

    public abstract void setSelected(boolean b);

    public abstract boolean contains(int x, int y);

    public abstract void setColor(Color color);
    @Override
    public Shape clone() {
        try {
            Shape clone = (Shape) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
