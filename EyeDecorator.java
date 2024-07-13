package javiergs.gui.paint.gamma;

import java.awt.*;

public class EyeDecorator extends  ShapeDecorator{


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        ShapeComponent shape = Officer.findOriginalShape(decoratedShape);
        int centerX = shape.getX() + shape.getW() / 2;
        int centerY = shape.getY() + shape.getH() / 2;

        int eyeWidth = shape.getW() / 5;
        int eyeHeight = shape.getH() / 5;
        int eyeOffsetX = shape.getW() / 4;
        int eyeOffsetY = shape.getH() / 4;
        int pupilWidth = eyeWidth - 10;
        int pupilHeight = eyeHeight - 10;

        g.setColor(Color.WHITE);
        g.fillOval(centerX - eyeOffsetX, centerY - eyeOffsetY, eyeWidth, eyeHeight);
        g.fillOval(centerX + eyeOffsetX - eyeWidth, centerY - eyeOffsetY, eyeWidth, eyeHeight);


        g.setColor(new Color(0x06E1FD));
        g.fillOval(centerX - eyeOffsetX, centerY - eyeOffsetY, pupilWidth, pupilHeight);
        g.fillOval(centerX + eyeOffsetX - eyeWidth, centerY - eyeOffsetY, pupilWidth,  pupilHeight);
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
