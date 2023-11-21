package h04.strategy;


import fopbot.Field;
import fopbot.Robot;

/**
 * The MoveStrategy interface provides a blueprint for classes implementing
 * specific strategies for robot movement in a given field.
 *
 * <p>
 * Classes implementing this interface should define the behavior of the robot
 * when it starts moving in a specific direction on the provided field.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 */
public interface MoveStrategy {

    /**
     * Initiates the robot movement based on the specific strategy.
     *
     * @param robot The robot to move according to the strategy.
     * @param field The field on which the robot is positioned.
     */
    void start(Robot robot, Field field);

}