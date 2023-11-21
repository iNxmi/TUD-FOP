package h04.strategy;

import com.nami.RobotUtils;
import fopbot.Field;
import fopbot.Robot;

public class MoveByWalk implements MoveStrategyWithCounter {

    private int count = -1;

    @Override
    public void start(Robot robot, Field field) {
        count = RobotUtils.moveToAndCount(robot, field.getX(), field.getY());
    }

    @Override
    public int getMoveCount() {
        return count;
    }

}
