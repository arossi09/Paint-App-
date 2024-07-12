package javiergs.gui.paint.gamma;

import java.awt.*;

public class EyeDecorator extends  ShapeDecorator{


    @Override
    public void draw(Graphics g) {
        if (decoratedShape instanceof Shape) {
            Shape shape = (Shape) decoratedShape;
            int centerX = shape.getX() + shape.getW() / 2;
            int centerY = shape.getY() + shape.getH() / 2;

            // Draw eyes
            g.setColor(Color.WHITE);
            g.fillOval(centerX - 20, centerY - 10, 20, 20);
            g.fillOval(centerX + 20, centerY - 10, 20, 20);

        }
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
