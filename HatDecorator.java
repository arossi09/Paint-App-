package javiergs.gui.paint.gamma;

import java.awt.*;

public class HatDecorator extends ShapeDecorator{

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        ShapeComponent shape = Officer.findOriginalShape(decoratedShape);

        // Draw hat
        int x = shape.getX();
        int y = shape.getY();
        int w = shape.getW();
        int h = shape.getH();

        int brimHeight = h / 10;
        int brimY = y - brimHeight;

        int topHatWidth = w / 2;
        int topHatHeight = h / 5;
        int topHatX = x + w / 4;
        int topHatY = brimY - topHatHeight;

        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, brimY, w, brimHeight);

        g.fillRect(topHatX, topHatY, topHatWidth, topHatHeight);
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
