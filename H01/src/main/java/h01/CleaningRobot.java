package h01;

import com.nami.RobotUtils;
import fopbot.Direction;
import fopbot.Robot;
import h01.template.Cleaner;
import h01.template.GameConstants;
import h01.template.TickBased;

import java.util.HashMap;
import java.util.Map;

/**
 * A robot that can clean the floor.
 */
public class CleaningRobot extends Robot implements Cleaner, TickBased {

    /**
     * Creates a new {@link CleaningRobot}.
     *
     * @param x             the initial x coordinate of the robot
     * @param y             the initial y coordinate of the robot
     * @param direction     the initial direction of the robot
     * @param numberOfCoins the initial number of coins of the robot
     */

    private final Map<Integer, Direction> directionIndex = new HashMap<>();

    public CleaningRobot(final int x, final int y, final Direction direction, final int numberOfCoins) {
        super(x, y, direction, numberOfCoins);

        directionIndex.put(0, Direction.UP);
        directionIndex.put(2, Direction.DOWN);
        directionIndex.put(1, Direction.RIGHT);
        directionIndex.put(3, Direction.LEFT);
    }

    @Override
    public void handleKeyInput(final int direction, final boolean shouldPutCoins, final boolean shouldPickCoins) {
        if (shouldPutCoins && hasAnyCoins())
            putCoin();
        if (shouldPickCoins && isOnACoin() && getNumberOfCoins() < GameConstants.CLEANER_CAPACITY)
            pickCoin();

        if (direction < 0 || direction > 3)
            return;

        RobotUtils.setDirection(this, directionIndex.get(direction));

        if (isFrontClear())
            move();
    }
}
