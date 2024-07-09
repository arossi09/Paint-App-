package javiergs.gui.paint.gamma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_C:
                    Officer.Copy();
                    break;
                case KeyEvent.VK_V:
                    Officer.Paste();
                    Officer.tellYourBoss();
                    break;

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
