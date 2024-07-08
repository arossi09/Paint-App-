package javiergs.gui.paint.gamma;
import java.awt.*;

public class Line extends Shape {
    private int x2, y2;
    private float thickness;

    public Line(int x, int y, int x2, int y2,float thickness, Color color1) {
        setColor(color1);
        setX(x);
        setY(y);
        setX2(x2);
        setY2(y2);
        setThickness(thickness);
    }

    public Line() {
        setThickness(getThickness());
    }
    public void setThickness(float thickness){this.thickness = thickness;}
    public float getThickness(){return thickness;}

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX(), getY(), getX2(), getY2());
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }
}

