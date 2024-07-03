package javiergs.gui.paint.gamma;

import java.awt.*;

public class CircleOutline extends Shape{

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if(getW() != 0 && getH() != 0){g.drawOval(getX(),getY(),getW(),getH());}

    }
}

