package com.nami;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Utility class providing methods for controlling and navigating a {@link Robot} in a {@link World}.
 * These methods include setting direction, moving, turning, checking possible directions, and more.
 * <p>
 * Author: Memphis Herghelegiu
 *
 * @version 1.0
 * @since 2023-11-16
 */
public class RobotUtils {

    /**
     * Sets the direction of the given {@link Robot} to the specified {@link Direction}.
     *
     * @param robot     The robot to set the direction for.
     * @param direction The desired direction.
     */
    public static void setDirection(@NotNull Robot robot, @NotNull Direction direction) {
        // Continuously turns the robot left until it faces the desired direction.
        while (robot.getDirection() != direction)
            robot.turnLeft();
    }

    /**
     * Moves the given {@link Robot} forward by a specified number of steps.
     *
     * @param robot The robot to move.
     * @param n     The number of steps to move.
     */
    public static void move(@NotNull Robot robot, int n) {
        // Moves the robot forward by the specified number of steps.
        for (int i = 0; i < n; i++)
            robot.move();
    }

    /**
     * Moves the given {@link Robot} in a specified direction for a specified number of steps.
     *
     * @param robot     The robot to move.
     * @param direction The direction in which to move.
     * @param n         The number of steps to move.
     */
    public static void move(@NotNull Robot robot, @NotNull Direction direction, int n) {
        // Sets the direction and then moves the robot forward by the specified number of steps.
        setDirection(robot, direction);
        move(robot, n);
    }

    /**
     * Retrieves a list of possible directions the given {@link Robot} can move to.
     *
     * @param robot The robot to check for possible directions.
     * @return A {@link LinkedList} of possible directions.
     */
    public static LinkedList<Direction> getPossibleDirectionsList(@NotNull Robot robot) {
        // Retrieves a list of directions where the robot can move.
        LinkedList<Direction> list = new LinkedList<>();
        getPossibleDirectionsMap(robot).forEach((k, v) -> {
            if (v)
                list.add(k);
        });

        return list;
    }

    /**
     * Retrieves a map of possible directions and their corresponding clearance status.
     *
     * @param robot The robot to check for possible directions.
     * @return A {@link HashMap} containing directions and their clearance status.
     */
    public static HashMap<Direction, Boolean> getPossibleDirectionsMap(@NotNull Robot robot) {
        // Retrieves a map of directions and their clearance status based on the robot's current position.
        HashMap<Direction, Boolean> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(robot.getDirection(), robot.isFrontClear());

            robot.turnLeft();
        }

        return map;
    }

    /**
     * Turns the given {@link Robot} 90 degrees to the right.
     *
     * @param robot The robot to turn.
     */
    public static void turnRight(@NotNull Robot robot) {
        // Turns the robot 90 degrees to the right by making three left turns.
        for (int i = 0; i < 3; i++)
            robot.turnLeft();
    }

    /**
     * Checks if the given {@link Robot} is facing the specified {@link Direction}.
     *
     * @param robot     The robot to check.
     * @param direction The direction to check against.
     * @return {@code true} if the robot is facing the specified direction, {@code false} otherwise.
     */
    public static boolean isFacing(@NotNull Robot robot, @NotNull Direction direction) {
        // Checks if the robot is facing the specified direction.
        return robot.getDirection() == direction;
    }

    /**
     * Moves the given {@link Robot} to the specified coordinates (x, y) in the {@link World}.
     *
     * @param robot The robot to move.
     * @param x     The target x-coordinate.
     * @param y     The target y-coordinate.
     * @throws IllegalArgumentException If the target coordinates are outside the World boundaries.
     */
    public static void moveTo(@NotNull Robot robot, int x, int y) {
        int xDiff = x - robot.getX();
        if (xDiff != 0)
            move(robot, xDiff > 0 ? Direction.RIGHT : Direction.LEFT, Math.abs(xDiff));

        int yDiff = y - robot.getY();
        if (yDiff != 0)
            move(robot, yDiff > 0 ? Direction.UP : Direction.DOWN, Math.abs(yDiff));
    }

    public static int moveToAndCount(@NotNull Robot robot, int x, int y) {
        int xDiff = x - robot.getX();
        if (xDiff != 0)
            move(robot, xDiff > 0 ? Direction.RIGHT : Direction.LEFT, Math.abs(xDiff));

        int yDiff = y - robot.getY();
        if (yDiff != 0)
            move(robot, yDiff > 0 ? Direction.UP : Direction.DOWN, Math.abs(yDiff));

        return Math.abs(xDiff) + Math.abs(yDiff);
    }

}