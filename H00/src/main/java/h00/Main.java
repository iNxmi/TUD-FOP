package h00;

import fopbot.Robot;
import fopbot.RobotFamily;
import fopbot.World;

import static fopbot.Direction.LEFT;
import static fopbot.Direction.RIGHT;
import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        // variable representing width/size of world
        final int worldSize = 5;

        // setting world size symmetrical, meaning height = width
        World.setSize(worldSize, worldSize);

        // speed of how fast the world gets refreshed (e.g. how fast the robot(s) act)
        // the lower the number, the faster the refresh
        World.setDelay(300);

        // make it possible to see the world window
        World.setVisible(true);

        // our program/assignment shall be tested/run !
        runExercise();
    }

    /**
     * Runs the exercise.
     */
    public static void runExercise() {
        Robot kaspar = new Robot(0, 0, LEFT, 20, RobotFamily.SQUARE_ORANGE);
        Robot alfred = new Robot(4, 4, RIGHT, 0, RobotFamily.SQUARE_BLUE);

        kaspar(kaspar);
        alfred(alfred);
    }

    private static void kaspar(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();

        while (robot.isFrontClear()) {
            robot.putCoin();
            robot.move();
        }

        robot.turnLeft();

        while (robot.isFrontClear()) {
            robot.putCoin();
            robot.move();
        }

        robot.putCoin();
        robot.turnLeft();
        robot.move();
    }

    private static void alfred(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();

        while (robot.isFrontClear()) {
            robot.pickCoin();
            robot.move();
        }

        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();

        while (robot.isFrontClear()) {
            robot.pickCoin();
            robot.move();
        }

        robot.turnLeft();
        robot.turnLeft();
        robot.turnLeft();

        robot.pickCoin();
        robot.move();
    }

}
