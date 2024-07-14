package javiergs.gui.paint.gamma;

import java.awt.*;

public class MouthDecorator extends ShapeDecorator{

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        ShapeComponent shape = Officer.findOriginalShape(decoratedShape);


        int x = shape.getX();
        int y = shape.getY();
        int w = shape.getW();
        int h = shape.getH();

        int mouthWidth = w / 2;
        int mouthHeight = h / 5;
        int mouthX = x + w / 4;
        int mouthY = y + 2 * h / 3;

        g.setColor(Color.DARK_GRAY);
        g.fillArc(mouthX, mouthY, mouthWidth, mouthHeight, 0, -180);
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
