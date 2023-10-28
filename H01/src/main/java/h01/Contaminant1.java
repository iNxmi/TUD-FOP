package h01;

import com.nami.RobotUtils;
import fopbot.Direction;
import fopbot.Robot;
import fopbot.RobotFamily;
import h01.template.Contaminant;
import h01.template.GameConstants;
import h01.template.TickBased;
import h01.template.Utils;

import java.util.List;

/**
 * A {@link Contaminant}-{@link Robot} that moves randomly and contaminates the floor.
 */
public class Contaminant1 extends Robot implements Contaminant, TickBased {

    /**
     * Creates a new {@link Contaminant1}.
     *
     * @param x             the initial x coordinate of the robot
     * @param y             the initial y coordinate of the robot
     * @param direction     the initial direction of the robot
     * @param numberOfCoins the initial number of coins of the robot
     */
    public Contaminant1(final int x, final int y, final Direction direction, final int numberOfCoins) {
        super(x, y, direction, numberOfCoins, RobotFamily.SQUARE_ORANGE);
    }

    @Override
    public int getUpdateDelay() {
        return 10;
    }

    @Override
    public void doMove() {
        if (!hasAnyCoins())
            turnOff();

        if (isTurnedOff())
            return;

        int rand = Utils.getRandomInteger(GameConstants.CONTAMINANT_ONE_MIN_PUT_COINS, GameConstants.CONTAMINANT_ONE_MAX_PUT_COINS);
        for (int i = 0; i < rand; i++)
            if (hasAnyCoins() && Utils.getCoinAmount(getX(), getY()) < 20)
                putCoin();

        List<Direction> possibleDirections = RobotUtils.getPossibleDirections(this);
        int randDirIndex = Utils.getRandomInteger(0, possibleDirections.size() - 1);
        Direction dir = possibleDirections.get(randDirIndex);

        RobotUtils.setDirection(this, dir);

        if (isFrontClear())
            move();
    }
}
