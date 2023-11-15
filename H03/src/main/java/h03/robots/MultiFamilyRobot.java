//        if (x < 0 || x > World.getWidth())
//            throw new IllegalArgumentException(String.format("0 <= x <= %s", World.getWidth()));
//
//        if (y < 0 || y > World.getHeight())
//            throw new IllegalArgumentException(String.format("0 <= y <= %s", World.getHeight()));
//
//        if (families == null || families.length == 0)
//            throw new IllegalArgumentException("families can't be null or empty");

package h03.robots;

import fopbot.Robot;
import fopbot.RobotFamily;


public class MultiFamilyRobot extends Robot {
    private RobotFamily[] families;

    public MultiFamilyRobot(int x, int y, RobotFamily[] families) {
        super(x, y, families[0]);
        this.families = families;
    }

    private int index = 0;

    public void exchange() {
        index = (index + 1) % families.length;
        setRobotFamily(families[index]);
    }

    @Override
    public void move() {
        super.move();
        exchange();
    }

    public void move(boolean exchange) {
        super.move();

        if (exchange)
            exchange();
    }

}
