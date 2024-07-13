package javiergs.gui.paint.gamma;

import java.awt.*;

public class MouthDecorator extends ShapeDecorator{

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        ShapeComponent shape = Officer.findOriginalShape(decoratedShape);
        g.setColor(Color.RED);
        int x = shape.getX();
        int y = shape.getY();
        g.drawArc(x, y + 10, 20, 10, 0, -180);
    }

    @Override
    public void setSelected(boolean b) {

    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }

    @Override
    public void setColor(Color color) {

    }
}
