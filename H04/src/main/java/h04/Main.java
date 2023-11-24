package h04;

import fopbot.Robot;
import fopbot.World;
import h04.robot.RobotMover;
import h04.selection.KeyboardFieldSelector;
import h04.selection.MouseFieldSelector;
import h04.strategy.MoveByTeleport;
import h04.strategy.MoveByWalk;

/**
 * The Main class is the entry point for the program, initializing the world and robots.
 * It also contains methods for setting up different strategies for robot movement.
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 */
public class Main {

    /**
     * Constructs a new Main object, initializes the world, and adds robots with a default strategy.
     */
    public Main() {
        World.setSize(15, 15);
        World.setVisible(true);

        Robot r1 = new Robot(2, 3);
        Robot r2 = new Robot(5, 6);
        Robot r3 = new Robot(7, 3);

        RobotMover keyboardRobotMover = main01();
        keyboardRobotMover.addRobot(r1);
        keyboardRobotMover.addRobot(r2);
        keyboardRobotMover.addRobot(r3);

        RobotMover mouseRobotMover = main02();
        mouseRobotMover.addRobot(r1);
        mouseRobotMover.addRobot(r2);
        mouseRobotMover.addRobot(r3);
    }

    /**
     * Initializes a MouseFieldSelector and a RobotMover with MoveByWalk strategy.
     *
     * @return The RobotMover instance with the specified strategy.
     */
    public RobotMover main01() {
        MouseFieldSelector mfs = new MouseFieldSelector();
        RobotMover rm = new RobotMover(new MoveByWalk());
        mfs.setFieldSelectionListener(rm);

        return rm;
    }

    /**
     * Initializes a KeyboardFieldSelector and a RobotMover with MoveByTeleport strategy.
     *
     * @return The RobotMover instance with the specified strategy.
     */
    public RobotMover main02() {
        KeyboardFieldSelector kfs = new KeyboardFieldSelector();
        RobotMover rm = new RobotMover(new MoveByTeleport());
        kfs.setFieldSelectionListener(rm);

        return rm;
    }

    /**
     * The main method, the entry point for the program. Creates a new instance of the Main class.
     *
     * @param args The command-line arguments (unused in this program).
     */
    public static void main(String[] args) {
        new Main();
    }

}