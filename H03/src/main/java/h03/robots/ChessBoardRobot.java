package h03.robots;

import fopbot.RobotFamily;

/**
 * Represents a robot that can move on a chessboard-like grid with alternating colors.
 *
 * @author Memphis Herghelegiu
 */
public class ChessBoardRobot extends MultiFamilyRobot {

    /**
     * Constructor for ChessBoardRobot with initial positions and families for even and odd cells.
     *
     * @param x           The initial x-coordinate.
     * @param y           The initial y-coordinate.
     * @param initialEven The RobotFamily for even cells.
     * @param initialOdd  The RobotFamily for odd cells.
     */
    public ChessBoardRobot(int x, int y, RobotFamily initialEven, RobotFamily initialOdd) {
        super(x, y, (x + y) % 2 == 0 ? new RobotFamily[]{initialEven, initialOdd} : new RobotFamily[]{initialOdd, initialEven});
    }

    /**
     * Constructor for ChessBoardRobot with default families for even and odd cells.
     *
     * @param x The initial x-coordinate.
     * @param y The initial y-coordinate.
     */
    public ChessBoardRobot(int x, int y) {
        super(x, y, new RobotFamily[]{RobotFamily.SQUARE_BLACK, RobotFamily.SQUARE_WHITE});
    }
}
