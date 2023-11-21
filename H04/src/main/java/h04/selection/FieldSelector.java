package h04.selection;

import h04.strategy.MoveStrategy;

/**
 * The FieldSelector interface defines the contract for classes that provide a mechanism
 * for selecting a field and notifying a listener about the selected field.
 *
 * <p>
 * Implementing classes should allow the registration of a {@link FieldSelectionListener}
 * to be notified when a field is selected.
 * </p>
 *
 * <p>
 * The primary purpose of this interface is to facilitate user interaction or input
 * for selecting fields, often used in conjunction with {@link MoveStrategy} implementations.
 * </p>
 *
 * <p>
 * Example implementations include mouse-based selection ({@link MouseFieldSelector})
 * and keyboard-based selection ({@link KeyboardFieldSelector}).
 * </p>
 *
 * <p>
 * Note: The selected field is typically determined based on user input or interaction.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see FieldSelectionListener
 * @see MouseFieldSelector
 * @see KeyboardFieldSelector
 */
public interface FieldSelector {

    /**
     * Sets the FieldSelectionListener to be notified when a field is selected.
     *
     * @param listener The listener to be notified on field selection events.
     */
    void setFieldSelectionListener(FieldSelectionListener listener);

}