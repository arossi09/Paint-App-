package javiergs.gui.paint.gamma;

import java.awt.*;

public class FaceDecorator extends  ShapeDecorator{


    @Override
    public void draw(Graphics g) {
        if (decoratedShape instanceof Shape) {
            Shape shape = (Shape) decoratedShape;
            int centerX = shape.getX() + shape.getW() / 2;
            int centerY = shape.getY() + shape.getH() / 2;

            // Draw eyes
            g.setColor(Color.WHITE);
            g.fillOval(centerX - 10, centerY - 10, 5, 5);
            g.fillOval(centerX + 10, centerY - 10, 5, 5);

            // Draw mouth
            g.drawArc(centerX - 10, centerY, 20, 10, 0, -180);
        }
    }
}
