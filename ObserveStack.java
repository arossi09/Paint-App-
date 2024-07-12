package javiergs.gui.paint.gamma;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Stack;

public class ObserveStack<T> {


    private Stack<T> stack;
    private PropertyChangeSupport support;

    public ObserveStack() {
        stack = new Stack<>();
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener p) {
        support.addPropertyChangeListener(p);
    }

    public void push(T item) {
        stack.push(item);
        support.firePropertyChange("stack", null, item);
    }

    public T pop() {
        T item = stack.pop();
        //support.firePropertyChange("stack", item, null);
        return item;
    }

    public void clear() {
        stack.clear();
        //support.firePropertyChange("stack", null, null);
    }

    public Stack<T> getStack() {
        return stack;
    }


}
