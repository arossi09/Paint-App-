package javiergs.gui.paint.gamma;

import java.awt.*;

abstract class ShapeDecorator extends ShapeComponent{
    protected ShapeComponent decoratedShape;

    public void add(ShapeComponent s) {
        this.decoratedShape = s;
    }

    public void draw(Graphics g) {
        if(decoratedShape != null) {
            decoratedShape.draw(g);
        }
    }

}
