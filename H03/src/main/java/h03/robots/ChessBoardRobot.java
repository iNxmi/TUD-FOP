package h03.robots;

import fopbot.RobotFamily;

public class ChessBoardRobot extends MultiFamilyRobot {

    public ChessBoardRobot(int x, int y, RobotFamily initialEven, RobotFamily initialOdd) {
        super(x, y, (x + y) % 2 == 0 ? new RobotFamily[]{initialEven, initialOdd} : new RobotFamily[]{initialOdd, initialEven});
    }

    public ChessBoardRobot(int x, int y) {
        super(x, y, new RobotFamily[]{RobotFamily.SQUARE_BLACK, RobotFamily.SQUARE_WHITE});
    }


}
