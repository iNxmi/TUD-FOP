package h03.robots;

import fopbot.RobotFamily;

public class RGBRobot extends MultiFamilyRobot {

    private static final RobotFamily[]
            NORMAL = new RobotFamily[]{RobotFamily.SQUARE_RED, RobotFamily.SQUARE_GREEN, RobotFamily.SQUARE_BLUE},
            INVERTED = new RobotFamily[]{RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_GREEN, RobotFamily.SQUARE_RED};

    public RGBRobot(int x, int y, boolean inverted) {
        super(x, y, inverted ? INVERTED : NORMAL);
    }

    public void testRGB() {
        for (int i = 0; i < 3; i++)
            exchange();
    }

}
