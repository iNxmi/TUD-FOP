package h04.selection;

import fopbot.*;

import java.awt.*;

/**
 * The KeyboardFieldSelector class implements the FieldSelector and KeyPressListener interfaces
 * to provide a mechanism for selecting a field using keyboard input.
 *
 * <p>
 * This class registers itself as a KeyPressListener with the World and notifies
 * a registered FieldSelectionListener when a field is selected based on keyboard input.
 * </p>
 *
 * <p>
 * The selection process involves listening for keyboard input and updating the selected field
 * based on arrow keys (UP, DOWN, LEFT, RIGHT). The selected field is highlighted with a red color.
 * Pressing the SPACE key triggers the notification of the selected field to the listener.
 * </p>
 *
 * <p>
 * The class can be used to interactively select fields for robot movement or other purposes.
 * </p>
 *
 * <p>
 * Note: The selected field is highlighted with a red color on the World.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see FieldSelector
 * @see KeyPressListener
 * @see FieldSelectionListener
 * @see World
 * @see KeyPressEvent
 */
public class KeyboardFieldSelector implements FieldSelector, KeyPressListener {

    // The listener for field selection events
    private FieldSelectionListener listener;

    /**
     * Constructs a KeyboardFieldSelector and registers it as a KeyPressListener with the World.
     */
    public KeyboardFieldSelector() {
        World.addKeyPressListener(this);
    }

    /**
     * Sets the FieldSelectionListener to be notified when a field is selected.
     *
     * @param listener The listener to be notified on field selection events.
     */
    @Override
    public void setFieldSelectionListener(FieldSelectionListener listener) {
        this.listener = listener;
    }

    // Variables to handle keyboard input
    private boolean pressed;
    private int x, y;

    /**
     * Handles the KeyPressEvent and updates the selected field based on keyboard input.
     * Notifies the listener when the SPACE key is pressed.
     *
     * @param event The KeyPressEvent indicating a key press.
     */
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
            x = World.getWidth() - 1;
        if (x > World.getWidth() - 1)
            x = 0;

        if (y < 0)
            y = World.getHeight() - 1;
        if (y > World.getHeight() - 1)
            y = 0;

        event.getWorld().setFieldColor(x, y, Color.RED);

        if (event.getKey() == Key.SPACE)
            listener.onFieldSelection(new Field(event.getWorld(), x, y));
    }

}