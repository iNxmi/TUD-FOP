package h04.selection;

import fopbot.*;

import java.awt.*;

public class KeyboardFieldSelector implements FieldSelector, KeyPressListener {

    private FieldSelectionListener listener;

    public KeyboardFieldSelector() {
        World.addKeyPressListener(this);
    }

    @Override
    public void setFieldSelectionListener(FieldSelectionListener listener) {
        this.listener = listener;
    }

    private boolean pressed;
    private int x, y;

    @Override
    public void onKeyPress(KeyPressEvent event) {
        if (!pressed) {
            x = 0;
            y = 0;

            pressed = true;
        }

        event.getWorld().setFieldColor(x, y, null);

        switch (event.getKey()) {
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }

        if (x < 0)
            x = 0;
        if (x > World.getWidth() - 1)
            x = World.getWidth() - 1;

        if (y < 0)
            y = 0;
        if (y > World.getHeight() - 1)
            y = World.getHeight() - 1;

        event.getWorld().setFieldColor(x, y, Color.RED);

        if (event.getKey() == Key.SPACE)
            listener.onFieldSelection(new Field(event.getWorld(), x, y));
    }

}
