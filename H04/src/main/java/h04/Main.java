package h04;

import fopbot.Robot;
import fopbot.World;
import h04.robot.RobotMover;
import h04.selection.KeyboardFieldSelector;
import h04.selection.MouseFieldSelector;
import h04.strategy.MoveByTeleport;
import h04.strategy.MoveByWalk;

public class Main {

    public Main() {
        World.setSize(15,15);
        World.setVisible(true);

        RobotMover rm = main01();
        rm.addRobot(new Robot(2,3));
        rm.addRobot(new Robot(5,6));
        rm.addRobot(new Robot(7,3));
    }

    public RobotMover main01() {
        MouseFieldSelector mfs = new MouseFieldSelector();
        RobotMover rm = new RobotMover(new MoveByWalk());
        mfs.setFieldSelectionListener(rm);

        return rm;
    }

    public RobotMover main02() {
        KeyboardFieldSelector kfs = new KeyboardFieldSelector();
        RobotMover rm = new RobotMover(new MoveByTeleport());
        kfs.setFieldSelectionListener(rm);

        return rm;
    }

    public static void main(String[] args) {
        new Main();
    }

}
