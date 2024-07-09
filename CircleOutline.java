package javiergs.gui.paint.gamma;

import java.awt.*;

/**
 *
 * @author steven
 * @version 3.0
 */
public class CircleOutline extends Shape{

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if(getW() != 0 && getH() != 0){g.drawOval(getX(),getY(),getW(),getH());}

    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }
}

