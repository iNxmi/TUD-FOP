package com.nami;

import fopbot.Direction;
import fopbot.Robot;

import java.util.HashMap;
import java.util.LinkedList;

public class RobotUtils {

    public static void setDirection(Robot robot, Direction direction) {
        while (robot.getDirection() != direction)
            robot.turnLeft();
    }

    public static LinkedList<Direction> getPossibleDirectionsList(Robot robot) {
        LinkedList<Direction> list = new LinkedList<>();
        getPossibleDirectionsMap(robot).forEach((k, v) -> {
            if (v)
                list.add(k);
        });

        return list;
    }

    public static HashMap<Direction, Boolean> getPossibleDirectionsMap(Robot robot) {
        HashMap<Direction, Boolean> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(robot.getDirection(), robot.isFrontClear());

            robot.turnLeft();
        }

        return map;
    }

    public static void turnRight(Robot robot) {
        for (int i = 0; i < 3; i++)
            robot.turnLeft();
    }

    public static boolean isFacing(Robot robot, Direction direction) {
        return robot.getDirection() == direction;
    }

    public static void moveTo(Robot robot, int x, int y) {
        int xDiff = x - robot.getX();
        int yDiff = y - robot.getY();

        if (Integer.signum(xDiff) == 1)
            setDirection(robot, Direction.RIGHT);
        if (Integer.signum(xDiff) == -1)
            setDirection(robot, Direction.LEFT);
        for (int i = 0; i < Math.abs(xDiff); i++)
            robot.move();

        if (Integer.signum(yDiff) == 1)
            setDirection(robot, Direction.UP);
        if (Integer.signum(yDiff) == -1)
            setDirection(robot, Direction.DOWN);
        for (int i = 0; i < Math.abs(yDiff); i++)
            robot.move();
    }

}
