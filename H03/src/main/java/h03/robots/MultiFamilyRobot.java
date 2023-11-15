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
