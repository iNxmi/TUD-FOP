package h04.strategy;

import fopbot.Field;
import fopbot.Robot;

/**
 * The MoveByTeleport class implements the MoveStrategy interface
 * to define a strategy for robot movement by teleporting to a specific location on the field.
 *
 * <p>
 * This class directly sets the robot's position to the specified coordinates on the field,
 * effectively teleporting the robot to the target location.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see MoveStrategy
 */
public class MoveByTeleport implements MoveStrategy {

    /**
     * Initiates the robot movement by teleporting to the specified location on the field.
     *
     * @param robot The robot to move according to the teleporting strategy.
     * @param field The field with the destination coordinates.
     */
    @Override
    public void start(Robot robot, Field field) {
        // Sets the robot's position to the specified coordinates
        robot.setField(field.getX(), field.getY());
    }

}