package javiergs.gui.paint.gamma;

import java.awt.*;

public class Circle extends Shape{
    public Circle(int x1,int y1,int w1,int h1, Color color1){
        setColor(color1);
        setX(x1);
        setY(y1);
        setW(w1);
        setH(h1);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getW(), getH());
    }
    @Override
    public Circle clone() {
        Circle clone = (Circle) super.clone();
        return clone;
    }

    @Override
    public boolean contains(int x, int y) {
        double dx = x - (getX() + getW() / 2.0);
        double dy = y - (getY() + getH() / 2.0);
        return (dx * dx) / (getW() * getW() / 4.0) + (dy * dy) / (getH() * getH() / 4.0) <= 1;
    }
}
