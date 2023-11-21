package h04.selection;

import fopbot.Field;
import fopbot.FieldClickEvent;
import fopbot.FieldClickListener;
import fopbot.World;

/**
 * The MouseFieldSelector class implements the FieldSelector and FieldClickListener interfaces
 * to provide a mechanism for selecting a field by clicking with the mouse.
 *
 * <p>
 * This class registers itself as a FieldClickListener with the World and notifies
 * a registered FieldSelectionListener when a field is clicked, indicating a selection.
 * </p>
 *
 * <p>
 * The selection process involves listening for mouse clicks and notifying the listener
 * when a new field is clicked. The last clicked field is stored to handle consecutive clicks.
 * </p>
 *
 * <p>
 * The class can be used to select fields for robot movement or other interactive features.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see FieldSelector
 * @see FieldClickListener
 * @see FieldSelectionListener
 * @see World
 */
public class MouseFieldSelector implements FieldSelector, FieldClickListener {

    // The listener for field selection events
    private FieldSelectionListener listener;

    /**
     * Constructs a MouseFieldSelector and registers it as a FieldClickListener with the World.
     */
    public MouseFieldSelector() {
        World.addFieldClickListener(this);
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

    // Variables to handle consecutive clicks
    private boolean clicked = false;
    private Field lastField;

    /**
     * Handles the FieldClickEvent and notifies the listener of field selection.
     *
     * @param event The FieldClickEvent indicating a mouse click on a field.
     */
    @Override
    public void onFieldClick(FieldClickEvent event) {
        if (clicked && event.getField() != lastField)
            listener.onFieldSelection(event.getField());

        lastField = event.getField();
        clicked = true;
    }

}