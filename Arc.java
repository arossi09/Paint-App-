package javiergs.gui.paint.gamma;

import java.awt.*;

public class Arc extends Shape{
    public Arc(int x1,int y1,int w1,int h1, Color color1){
        setColor(color1);
        setX(x1);
        setY(y1);
        setW(w1);
        setH(h1);
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillArc(getX(), getY(), getW(), getH(), 0, 180);
    }
    @Override
    public Arc clone() {
        Arc clone = (Arc) super.clone();
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return clone;
    }
}