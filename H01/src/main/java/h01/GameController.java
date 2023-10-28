package h01;

import fopbot.Robot;
import fopbot.World;
import h01.template.GameControllerBase;
import h01.template.Utils;

/**
 * A {@link GameController} controls the game loop and the {@link Robot}s and checks the win condition.
 */
public class GameController extends GameControllerBase {

    /**
     * Creates a new {@link GameControllerBase}.
     */
    public GameController() {
        setup();
    }

    @Override
    public void checkWinCondition() {
        Robot cleaner = getCleaningRobot();
        Robot con1 = getContaminant1();
        Robot con2 = getContaminant2();

        boolean has200Coins = Utils.getCoinAmount(0, World.getHeight() - 1) >= 2;
        boolean robotsAreOff = con1.isTurnedOff() && con2.isTurnedOff();
        if (has200Coins || robotsAreOff) {
            if (!con1.isTurnedOff())
                getContaminant1().turnOff();
            if (!con2.isTurnedOff())
                getContaminant2().turnOff();

            System.out.println("Cleaning robot won!");

            stopGame();
        }

        int tilesWithCoins = 0;
        for (int y = 0; y < World.getHeight(); y++)
            for (int x = 0; x < World.getWidth(); x++)
                if (Utils.getCoinAmount(x, y) > 0)
                    tilesWithCoins++;

        boolean consWin = ((double) tilesWithCoins) / ((double) (World.getWidth() * World.getWidth())) >= 0.5d;
        if (consWin) {
            if (!cleaner.isTurnedOff())
                cleaner.turnOff();

            System.err.println("Contaminants won!");

            stopGame();
        }
    }
}
