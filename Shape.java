package javiergs.gui.paint.gamma;

import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Cloneable, Serializable {
    private Color color;
    private int x,y,w,h;

    public Shape(){
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
    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);

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
