package h04.robot;

import fopbot.Field;
import fopbot.Robot;
import h04.selection.FieldSelectionListener;
import h04.selection.FieldSelector;
import h04.selection.KeyboardFieldSelector;
import h04.selection.MouseFieldSelector;
import h04.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * The RobotMover class coordinates the movement of multiple robots using a specified MoveStrategy.
 *
 * <p>
 * This class implements the {@link FieldSelectionListener} interface, allowing it to respond
 * to field selection events, typically triggered by a {@link FieldSelector}.
 * </p>
 *
 * <p>
 * The main functionality involves adding robots to the mover and responding to field selection events
 * by instructing all registered robots to move to the selected field using the specified {@link MoveStrategy}.
 * </p>
 *
 * <p>
 * Example usage includes selecting a target field using a {@link FieldSelector} and instructing multiple
 * robots to move to that field using this class.
 * </p>
 *
 * <p>
 * Note: The actual movement behavior is defined by the specified {@link MoveStrategy}.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see FieldSelectionListener
 * @see MoveStrategy
 * @see Robot
 * @see FieldSelector
 * @see MouseFieldSelector
 * @see KeyboardFieldSelector
 */
public class RobotMover implements FieldSelectionListener {

    // The strategy used for robot movement
    private MoveStrategy moveStrategy;

    // List of robots managed by the mover
    private List<Robot> robots = new ArrayList<>();

    /**
     * Constructs a RobotMover with the specified MoveStrategy.
     *
     * @param moveStrategy The strategy used for robot movement.
     */
    public RobotMover(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    /**
     * Adds a robot to the list of robots managed by the mover.
     *
     * @param robot The robot to be added.
     */
    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    /**
     * Responds to a field selection event by instructing all registered robots
     * to move to the selected field using the specified MoveStrategy.
     *
     * @param field The selected field.
     */
    @Override
    public void onFieldSelection(Field field) {
        robots.forEach(r -> moveStrategy.start(r, field));
    }

}