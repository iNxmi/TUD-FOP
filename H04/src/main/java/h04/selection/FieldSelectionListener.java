package h04.selection;

import fopbot.Field;

/**
 * The FieldSelectionListener interface defines the contract for classes
 * that listen for and handle field selection events.
 *
 * <p>
 * Implementing classes should provide logic to be executed when a field is selected,
 * typically in response to user interaction or input.
 * </p>
 *
 * <p>
 * The primary purpose of this interface is to allow decoupling of field selection logic
 * from the classes responsible for user input or interaction, such as {@link FieldSelector} implementations.
 * </p>
 *
 * <p>
 * Example implementations include updating robot movement targets, highlighting selected fields, etc.
 * </p>
 *
 * <p>
 * Note: The specific behavior on field selection is defined by implementing classes.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see FieldSelector
 * @see MouseFieldSelector
 * @see KeyboardFieldSelector
 */
public interface FieldSelectionListener {

    /**
     * Invoked when a field is selected.
     *
     * @param field The selected field.
     */
    void onFieldSelection(Field field);

}