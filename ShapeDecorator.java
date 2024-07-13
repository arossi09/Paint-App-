package javiergs.gui.paint.gamma;

import java.awt.*;

abstract class ShapeDecorator extends ShapeComponent{
    protected ShapeComponent decoratedShape;

    protected ShapeComponent lastShape;
    public ShapeComponent getDecoratedShape() {
        return decoratedShape;
    }

    public void add(ShapeComponent s) {
        decoratedShape = s;
    }

    public void draw(Graphics g) {
        if(decoratedShape != null) {
            decoratedShape.draw(g);
        }
    }
    public ShapeComponent getLast(){
        return lastShape;
    }

    public void setLast(ShapeComponent last){
        lastShape = last;
    }


}
