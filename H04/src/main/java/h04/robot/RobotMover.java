package h04.robot;

import fopbot.Field;
import fopbot.Robot;
import h04.selection.FieldSelectionListener;
import h04.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RobotMover implements FieldSelectionListener {

    private MoveStrategy moveStrategy;
    private List<Robot> robots = new ArrayList();

    public RobotMover(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    @Override
    public void onFieldSelection(Field field) {
        robots.forEach(r -> moveStrategy.start(r, field));
    }

}
