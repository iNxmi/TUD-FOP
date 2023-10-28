package h01;

import com.nami.RobotUtils;
import fopbot.Direction;
import fopbot.Robot;
import fopbot.RobotFamily;
import h01.template.Contaminant;
import h01.template.TickBased;
import h01.template.Utils;
import org.tudalgo.algoutils.student.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * A {@link Contaminant}-{@link Robot} that moves in a predefined way and contaminates the floor.
 */
public class Contaminant2 extends Robot implements Contaminant, TickBased {

    /**
     * Creates a new {@link Contaminant2}.
     *
     * @param x             the initial x coordinate of the robot
     * @param y             the initial y coordinate of the robot
     * @param direction     the initial direction of the robot
     * @param numberOfCoins the initial number of coins of the robot
     */
    public Contaminant2(final int x, final int y, final Direction direction, final int numberOfCoins) {
        super(x, y, direction, numberOfCoins, RobotFamily.SQUARE_AQUA);
    }

    @Override
    public int getUpdateDelay() {
        return 8;
    }

    @Override
    public void doMove() {
        if (!hasAnyCoins())
            turnOff();

        if (isTurnedOff())
            return;

        int coinDiff = 2 - Utils.getCoinAmount(getX(), getY());
        for (int i = 0; i < coinDiff; i++)
            if (hasAnyCoins())
                putCoin();

        Direction dir = getDirection();
        for (int i = 0; i < 4; i++) {
            if (i == 0)
                turnLeft();
            else
                RobotUtils.turnRight(this);

            if (isFrontClear()) {
                dir = getDirection();
                break;
            }
        }

        RobotUtils.setDirection(this, dir);

        if (isFrontClear())
            move();
    }
}
