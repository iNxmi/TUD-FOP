package h03;

import com.nami.RobotUtils;
import fopbot.Direction;
import fopbot.Robot;
import fopbot.RobotFamily;
import fopbot.World;
import h03.robots.ChessBoardRobot;
import h03.robots.MultiFamilyRobot;
import h03.robots.RGBRobot;
import h03.robots.RobotSynchronizer;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main class for the H03 project, demonstrating the usage of various robot classes and a RobotSynchronizer.
 * The robots perform movements on the World with different configurations.
 * Note: The class uses RobotUtils from the com.nami package for robot manipulation.
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 */
public class Main {

    /**
     * Constructs a Main object, initializes the World, sets up robots, and demonstrates their movements.
     */
    public Main() {
        World.setSize(7, 15);
        World.setDelay(200);
        World.setVisible(true);

        int moves = 10;

        List<Robot> robots = new ArrayList<>();

        MultiFamilyRobot mfb = new MultiFamilyRobot(0, 0, new RobotFamily[]{
                RobotFamily.SQUARE_GREEN,
                RobotFamily.SQUARE_ORANGE,
                RobotFamily.SQUARE_PURPLE,
                RobotFamily.SQUARE_AQUA});
        RobotUtils.setDirection(mfb, Direction.UP);
        robots.add(mfb);

        RGBRobot rgb1 = new RGBRobot(1, 0, false);
        RobotUtils.setDirection(rgb1, Direction.UP);
        robots.add(rgb1);

        RGBRobot rgb2 = new RGBRobot(2, 0, true);
        RobotUtils.setDirection(rgb2, Direction.UP);
        robots.add(rgb2);

        ChessBoardRobot chess1 = new ChessBoardRobot(3, 0, RobotFamily.SQUARE_RED, RobotFamily.SQUARE_BLUE);
        RobotUtils.setDirection(chess1, Direction.UP);
        robots.add(chess1);

        ChessBoardRobot chess2 = new ChessBoardRobot(4, 0);
        RobotUtils.setDirection(chess2, Direction.UP);
        robots.add(chess2);

        ChessBoardRobot chess3 = new ChessBoardRobot(5, 0, RobotFamily.SQUARE_YELLOW, RobotFamily.SQUARE_GREEN);
        RobotUtils.setDirection(chess3, Direction.UP);
        robots.add(chess3);

        ChessBoardRobot chess4 = new ChessBoardRobot(6, 0);
        RobotUtils.setDirection(chess4, Direction.UP);
        robots.add(chess4);

        for (int i = 0; i < moves; i++)
            robots.forEach(r -> r.move());

        RobotSynchronizer synchronizer = new RobotSynchronizer(new Robot[]{mfb, rgb1, rgb2, chess1, chess2, chess3, chess4});
        synchronizer.setX(3);
        synchronizer.setY(0);
        synchronizer.setDirection(Direction.RIGHT);

        synchronizer.sync();
    }

    /**
     * The main method that creates an instance of the Main class, initiating the program.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        new Main();
    }

}