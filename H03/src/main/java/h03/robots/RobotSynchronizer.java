//package h03.robots;
//
//import com.nami.RobotUtils;
//import fopbot.Direction;
//import fopbot.Robot;
//import fopbot.World;
//
//public class RobotSynchronizer {
//
//    private final Robot[] robots;
//    private int x = -1, y = -1;
//    private Direction direction = null;
//
//    public RobotSynchronizer(Robot[] robots) {
//        this.robots = robots;
//    }
//
//    public void sync() {
//        for (Robot r : robots) {
//            RobotUtils.moveTo(r, x, y);
//            RobotUtils.setDirection(r, direction);
//        }
//    }
//
//    public void setX(int x) {
//        if (x >= 0 && x <= World.getWidth())
//            this.x = x;
//    }
//
//    public void setY(int y) {
//        if (y >= 0 && y <= World.getHeight())
//            this.y = y;
//    }
//
//    public void setDirection(Direction direction) {
//        if (direction != null)
//            this.direction = direction;
//    }
//
//}

package h03.robots;

import com.nami.RobotUtils;
import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;

/**
 * RobotSynchronizer is a utility class designed to synchronize the positions and directions of multiple robots.
 * It provides methods to set a common position and direction for all robots.
 * Note: The class uses RobotUtils from the com.nami package for robot manipulation.
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 */
public class RobotSynchronizer {

    /**
     * An array of Robot objects to be synchronized.
     */
    private final Robot[] robots;

    /**
     * The common x-coordinate to set for all robots.
     */
    private int x = -1;

    /**
     * The common y-coordinate to set for all robots.
     */
    private int y = -1;

    /**
     * The common direction to set for all robots.
     */
    private Direction direction = null;

    /**
     * Constructs a RobotSynchronizer with the specified array of robots.
     *
     * @param robots An array of Robot objects to be synchronized.
     */
    public RobotSynchronizer(Robot[] robots) {
        this.robots = robots;
    }

    /**
     * Synchronizes the positions and directions of all robots based on the common x-coordinate, y-coordinate, and direction.
     */
    public void sync() {
        for (Robot r : robots) {
            RobotUtils.moveTo(r, x, y);
            RobotUtils.setDirection(r, direction);
        }
    }

    /**
     * Sets the common x-coordinate for all robots if it is within the valid range (0 to World.getWidth()).
     *
     * @param x The x-coordinate to set.
     */
    public void setX(int x) {
        if (x >= 0 && x <= World.getWidth())
            this.x = x;
    }

    /**
     * Sets the common y-coordinate for all robots if it is within the valid range (0 to World.getHeight()).
     *
     * @param y The y-coordinate to set.
     */
    public void setY(int y) {
        if (y >= 0 && y <= World.getHeight())
            this.y = y;
    }

    /**
     * Sets the common direction for all robots.
     *
     * @param direction The direction to set.
     */
    public void setDirection(Direction direction) {
        if (direction != null)
            this.direction = direction;
    }

}