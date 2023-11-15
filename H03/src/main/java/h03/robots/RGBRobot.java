//package h03.robots;
//
//import fopbot.RobotFamily;
//
//public class RGBRobot extends MultiFamilyRobot {
//
//    private static final RobotFamily[]
//            NORMAL = new RobotFamily[]{RobotFamily.SQUARE_RED, RobotFamily.SQUARE_GREEN, RobotFamily.SQUARE_BLUE},
//            INVERTED = new RobotFamily[]{RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_GREEN, RobotFamily.SQUARE_RED};
//
//    public RGBRobot(int x, int y, boolean inverted) {
//        super(x, y, inverted ? INVERTED : NORMAL);
//    }
//
//    public void testRGB() {
//        for (int i = 0; i < 3; i++)
//            exchange();
//    }
//
//}

package h03.robots;

import fopbot.RobotFamily;

/**
 * RGBRobot is a specialized type of MultiFamilyRobot that alternates between different RobotFamily configurations.
 * It can be initialized with normal or inverted color sequences.
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 */
public class RGBRobot extends MultiFamilyRobot {

    /**
     * Array of RobotFamily objects representing the normal color sequence (SQUARE_RED, SQUARE_GREEN, SQUARE_BLUE).
     */
    private static final RobotFamily[] NORMAL = new RobotFamily[]{RobotFamily.SQUARE_RED, RobotFamily.SQUARE_GREEN, RobotFamily.SQUARE_BLUE};

    /**
     * Array of RobotFamily objects representing the inverted color sequence (SQUARE_BLUE, SQUARE_GREEN, SQUARE_RED).
     */
    private static final RobotFamily[] INVERTED = new RobotFamily[]{RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_GREEN, RobotFamily.SQUARE_RED};

    /**
     * Constructs an RGBRobot with the specified initial position and color sequence.
     *
     * @param x        The initial x-coordinate of the robot.
     * @param y        The initial y-coordinate of the robot.
     * @param inverted If true, the robot will use the inverted color sequence; otherwise, it will use the normal sequence.
     */
    public RGBRobot(int x, int y, boolean inverted) {
        super(x, y, inverted ? INVERTED : NORMAL);
    }

    /**
     * Tests the RGBRobot by exchanging the RobotFamily membership three times, cycling through the color sequence.
     */
    public void testRGB() {
        for (int i = 0; i < 3; i++)
            exchange();
    }

}