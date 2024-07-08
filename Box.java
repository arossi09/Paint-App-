package javiergs.gui.paint.gamma;

import java.awt.*;

public class Box extends Shape{


    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if(getW() != 0 && getH() != 0){g.drawRect(getX(),getY(),getW(),getH());}

    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }
}
