//        if (x < 0 || x > World.getWidth())
//            throw new IllegalArgumentException(String.format("0 <= x <= %s", World.getWidth()));
//
//        if (y < 0 || y > World.getHeight())
//            throw new IllegalArgumentException(String.format("0 <= y <= %s", World.getHeight()));
//
//        if (families == null || families.length == 0)
//            throw new IllegalArgumentException("families can't be null or empty");
//
//package h03.robots;
//
//import fopbot.Direction;
//import fopbot.Robot;
//import fopbot.RobotFamily;
//
//
///**
// * @author Memphis Herghelegiu
// */
//public class MultiFamilyRobot extends Robot {
//    private RobotFamily[] families;
//
//    /**
//     * Constructor for a multifamily robot
//     *
//     * @param x Defines the x position of the {@link Robot}
//     * @param y Defines the y position of the {@link Robot}
//     * @param families Defines the different {@link RobotFamily RobotFamilies} of the Robot
//     * */
//    public MultiFamilyRobot(int x, int y, RobotFamily[] families) {
//        super(x, y, families[0]);
//        this.families = families;
//    }
//
//    private int index = 0;
//
//    /**
//     *Changes the {@link RobotFamily} based on the given list in the {@link #MultiFamilyRobot Constructor}
//     */
//    public void exchange() {
//        index = (index + 1) % families.length;
//        setRobotFamily(families[index]);
//    }
//
//    /**
//     * Moves the robot one step into the {@link Direction direction} it is viewing and changes its {@link RobotFamily}
//     */
//    @Override
//    public void move() {
//        super.move();
//        exchange();
//    }
//
//    /**
//     * Moves the robot one step into the {@link Direction direction} it is viewing
//     * @param exchange decides whether to change the {@link RobotFamily} or not after the robot {@link Robot#move moved}
//     */
//    public void move(boolean exchange) {
//        super.move();
//
//        if (exchange)
//            exchange();
//    }
//
//}

package h03.robots;

import fopbot.Robot;
import fopbot.RobotFamily;

/**
 * MultiFamilyRobot is a subclass of the fopbot.Robot class that can belong to multiple RobotFamilies.
 * It has the ability to exchange its family membership and move accordingly.
 *
 * @author Memphis Herghelegiu
 */
public class MultiFamilyRobot extends Robot {

    /**
     * An array of RobotFamily objects that the MultiFamilyRobot can belong to.
     */
    private RobotFamily[] families;

    /**
     * The current index of the RobotFamily in the families array.
     */
    private int index = 0;

    /**
     * Constructs a MultiFamilyRobot with the specified initial position and families.
     *
     * @param x        The initial x-coordinate of the robot.
     * @param y        The initial y-coordinate of the robot.
     * @param families An array of RobotFamily objects that the robot can belong to.
     */
    public MultiFamilyRobot(int x, int y, RobotFamily[] families) {
        super(x, y, families[0]);
        this.families = families;
    }

    /**
     * Exchanges the current RobotFamily membership to the next one in the array.
     */
    public void exchange() {
        index = (index + 1) % families.length;
        setRobotFamily(families[index]);
    }

    /**
     * Moves the robot one step and then performs an exchange of RobotFamily.
     */
    @Override
    public void move() {
        super.move();
        exchange();
    }

    /**
     * Moves the robot one step and optionally performs an exchange of RobotFamily.
     *
     * @param exchange If true, the robot will perform an exchange of RobotFamily after moving.
     */
    public void move(boolean exchange) {
        super.move();

        if (exchange)
            exchange();
    }
}
