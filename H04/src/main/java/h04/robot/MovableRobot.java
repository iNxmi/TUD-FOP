package h04.robot;

import fopbot.Field;
import fopbot.Robot;
import h04.selection.FieldSelectionListener;
import h04.strategy.MoveStrategy;
import h04.strategy.MoveStrategyWithCounter;

/**
 * The MovableRobot class extends the standard Robot class and implements the FieldSelectionListener interface.
 *
 * <p>
 * This class represents a robot that can respond to field selection events by moving to the selected field
 * using a specified {@link MoveStrategy}. Additionally, if the MoveStrategy is an instance of
 * {@link MoveStrategyWithCounter}, the robot performs additional rotations based on the move count.
 * </p>
 *
 * <p>
 * Example usage includes creating instances of this class with different MoveStrategy implementations
 * and registering them with a {@link RobotMover}.
 * </p>
 *
 * <p>
 * Note: The actual movement behavior is defined by the specified {@link MoveStrategy}.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see Robot
 * @see FieldSelectionListener
 * @see MoveStrategy
 * @see MoveStrategyWithCounter
 * @see RobotMover
 */
public class MovableRobot extends Robot implements FieldSelectionListener {

    // The strategy used for robot movement
    private MoveStrategy moveStrategy;

    /**
     * Constructs a MovableRobot with the specified MoveStrategy and initializes it at coordinates (0, 0).
     *
     * @param moveStrategy The strategy used for robot movement.
     */
    public MovableRobot(MoveStrategy moveStrategy) {
        super(0, 0);
        this.moveStrategy = moveStrategy;
    }

    /**
     * Responds to a field selection event by instructing the robot to move to the selected field
     * using the specified MoveStrategy. Additionally, performs rotations based on the move count
     * if the MoveStrategy is an instance of {@link MoveStrategyWithCounter}.
     *
     * @param field The selected field.
     */
    @Override
    public void onFieldSelection(Field field) {
        moveStrategy.start(this, field);

        if (moveStrategy instanceof MoveStrategyWithCounter) {
            MoveStrategyWithCounter moveStrategyWithCounter = (MoveStrategyWithCounter) moveStrategy;
            for (int i = 0; i < moveStrategyWithCounter.getMoveCount(); i++)
                turnLeft();
        }
    }

}