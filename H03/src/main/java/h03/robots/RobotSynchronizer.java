package h03.robots;

import com.nami.RobotUtils;
import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;

public class RobotSynchronizer {

    private final Robot[] robots;
    private int x = -1, y = -1;
    private Direction direction = null;

    public RobotSynchronizer(Robot[] robots) {
        this.robots = robots;
    }

    public void sync() {
        for (Robot r : robots) {
            RobotUtils.moveTo(r, x, y);
            RobotUtils.setDirection(r, direction);
        }
    }

    public void setX(int x) {
        if (x >= 0 && x <= World.getWidth())
            this.x = x;
    }

    public void setY(int y) {
        if (y >= 0 && y <= World.getHeight())
            this.y = y;
    }

    public void setDirection(Direction direction) {
        if (direction != null)
            this.direction = direction;
    }

}
