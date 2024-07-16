package javiergs.gui.paint.gamma;

import java.awt.*;

public class EyeDecorator extends  ShapeDecorator{


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        ShapeComponent shape = Officer.findOriginalShape(decoratedShape);

        // Draw eyes
        int x = shape.getX();
        int y = shape.getY();
        int w = shape.getW();
        int h = shape.getH();


        int eyeWidth = w / 5;
        int eyeHeight = h / 5;
        int eye1X = x + w / 4 - eyeWidth / 2;
        int eye2X = x + 3 * w / 4 - eyeWidth / 2;
        int eyeY = y + h / 4 - eyeHeight / 2;


        g.setColor(Color.WHITE);
        g.fillOval(eye1X, eyeY, eyeWidth, eyeHeight);
        g.fillOval(eye2X, eyeY, eyeWidth, eyeHeight);

        int pupilWidth = eyeWidth / 3;
        int pupilHeight = eyeHeight / 3;


        int pupil1X = eye1X + 2 * eyeWidth / 3 - pupilWidth / 2;
        int pupil2X = eye2X + eyeWidth / 3 - pupilWidth / 2;
        int pupilY = eyeY + eyeHeight / 2 - pupilHeight / 2;
        g.setColor(new Color(0x95F7FC));
        g.fillOval(pupil1X, pupilY, pupilWidth, pupilHeight);
        g.fillOval(pupil2X, pupilY, pupilWidth, pupilHeight);
        Officer.observerUpdate();
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
