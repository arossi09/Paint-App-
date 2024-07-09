package javiergs.gui.paint.gamma;
import java.awt.*;

/**
 * @author steven
 * @version 3.0
 */
public class ArcOutline extends Shape{
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if(getW() != 0 && getH() != 0){g.drawArc(getX(),getY(),getW(),getH(), 0, 180);}
    }

    @Override
    public boolean contains(int x, int y) {
        return false;
    }
}
