package h04.strategy;

import com.nami.RobotUtils;
import fopbot.Field;
import fopbot.Robot;

/**
 * The MoveByWalk class implements the MoveStrategyWithCounter interface
 * to define a strategy for robot movement by walking to a specific location on the field.
 *
 * <p>
 * This class utilizes the RobotUtils class for movement and counts the number of steps taken.
 * </p>
 *
 * <p>
 * The movement is achieved by calling the moveToAndCount method from the RobotUtils class.
 * The count of steps taken is then accessible through the getMoveCount method.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see MoveStrategyWithCounter
 * @see RobotUtils
 */
public class MoveByWalk implements MoveStrategyWithCounter {

    // Variable to store the count of steps taken
    private int count = -1;

    /**
     * Initiates the robot movement by walking to the specified location on the field.
     *
     * @param robot The robot to move according to the walking strategy.
     * @param field The field with the destination coordinates.
     */
    @Override
    public void start(Robot robot, Field field) {
        // Utilizes RobotUtils to move the robot and count the steps
        count = RobotUtils.moveToAndCount(robot, field.getX(), field.getY());
    }

    /**
     * Gets the count of steps taken during the last movement.
     *
     * @return The total count of steps taken by the robot.
     */
    @Override
    public int getMoveCount() {
        return count;
    }

}