//package h03;
//
//import com.nami.RobotUtils;
//import fopbot.Direction;
//import fopbot.Robot;
//import fopbot.RobotFamily;
//import fopbot.World;
//import h03.robots.ChessBoardRobot;
//import h03.robots.MultiFamilyRobot;
//import h03.robots.RGBRobot;
//import h03.robots.RobotSynchronizer;
//
//public class Main {
//
//    public Main() {
//        World.setSize(7, 15);
//        World.setDelay(20);
//        World.setVisible(true);
//
//        int moves = 10;
//
//
//        MultiFamilyRobot mfb = new MultiFamilyRobot(0, 0, new RobotFamily[]{
//                RobotFamily.SQUARE_GREEN,
//                RobotFamily.SQUARE_ORANGE,
//                RobotFamily.SQUARE_PURPLE,
//                RobotFamily.SQUARE_AQUA});
//        RobotUtils.setDirection(mfb, Direction.UP);
//        for (int i = 0; i < moves; i++)
//            mfb.move();
//
//
//        RGBRobot rgb1 = new RGBRobot(1, 0, false);
//        RobotUtils.setDirection(rgb1, Direction.UP);
//        for (int i = 0; i < moves; i++)
//            rgb1.move();
//
//        RGBRobot rgb2 = new RGBRobot(2, 0, true);
//        RobotUtils.setDirection(rgb2, Direction.UP);
//        for (int i = 0; i < moves; i++)
//            rgb2.move();
//
//
//        ChessBoardRobot chess1 = new ChessBoardRobot(3, 0, RobotFamily.SQUARE_RED, RobotFamily.SQUARE_BLUE);
//        RobotUtils.setDirection(chess1, Direction.UP);
//        for (int i = 0; i < moves; i++)
//            chess1.move();
//
//        ChessBoardRobot chess2 = new ChessBoardRobot(4, 0);
//        RobotUtils.setDirection(chess2, Direction.UP);
//        for (int i = 0; i < moves; i++)
//            chess2.move();
//
//        ChessBoardRobot chess3 = new ChessBoardRobot(5, 0, RobotFamily.SQUARE_YELLOW, RobotFamily.SQUARE_GREEN);
//        RobotUtils.setDirection(chess3, Direction.UP);
//        for (int i = 0; i < moves; i++)
//            chess3.move();
//
//        ChessBoardRobot chess4 = new ChessBoardRobot(6, 0);
//        RobotUtils.setDirection(chess4, Direction.UP);
//        for (int i = 0; i < moves; i++)
//            chess4.move();
//
//
//        RobotSynchronizer synchronizer = new RobotSynchronizer(new Robot[]{mfb, rgb1, rgb2, chess1, chess2, chess3, chess4});
//        synchronizer.setX(0);
//        synchronizer.setY(0);
//        synchronizer.setDirection(Direction.RIGHT);
//
//        synchronizer.sync();
//    }
//
//    public static void main(String[] args) {
//        new Main();
//    }
//
//}

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
        World.setDelay(20);
        World.setVisible(true);

        int moves = 10;

        MultiFamilyRobot mfb = new MultiFamilyRobot(0, 0, new RobotFamily[]{
                RobotFamily.SQUARE_GREEN,
                RobotFamily.SQUARE_ORANGE,
                RobotFamily.SQUARE_PURPLE,
                RobotFamily.SQUARE_AQUA});
        RobotUtils.setDirection(mfb, Direction.UP);
        for (int i = 0; i < moves; i++)
            mfb.move();

        RGBRobot rgb1 = new RGBRobot(1, 0, false);
        RobotUtils.setDirection(rgb1, Direction.UP);
        for (int i = 0; i < moves; i++)
            rgb1.move();

        RGBRobot rgb2 = new RGBRobot(2, 0, true);
        RobotUtils.setDirection(rgb2, Direction.UP);
        for (int i = 0; i < moves; i++)
            rgb2.move();

        ChessBoardRobot chess1 = new ChessBoardRobot(3, 0, RobotFamily.SQUARE_RED, RobotFamily.SQUARE_BLUE);
        RobotUtils.setDirection(chess1, Direction.UP);
        for (int i = 0; i < moves; i++)
            chess1.move();

        ChessBoardRobot chess2 = new ChessBoardRobot(4, 0);
        RobotUtils.setDirection(chess2, Direction.UP);
        for (int i = 0; i < moves; i++)
            chess2.move();

        ChessBoardRobot chess3 = new ChessBoardRobot(5, 0, RobotFamily.SQUARE_YELLOW, RobotFamily.SQUARE_GREEN);
        RobotUtils.setDirection(chess3, Direction.UP);
        for (int i = 0; i < moves; i++)
            chess3.move();

        ChessBoardRobot chess4 = new ChessBoardRobot(6, 0);
        RobotUtils.setDirection(chess4, Direction.UP);
        for (int i = 0; i < moves; i++)
            chess4.move();

        RobotSynchronizer synchronizer = new RobotSynchronizer(new Robot[]{mfb, rgb1, rgb2, chess1, chess2, chess3, chess4});
        synchronizer.setX(0);
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