package h02;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * A class that controls the {@linkplain Robot robots} and their actions.
 */
public class ControlCenter {

    /**
     * Creates a new line of {@linkplain ScanRobot ScanRobots}.
     *
     * @return An array containing the newly initialised robots
     */
    public ScanRobot[] initScanRobots() {
        ScanRobot[] arr = new ScanRobot[World.getWidth() - 1];
        for (int i = 0; i < World.getWidth() - 1; i++)
            arr[i] = new ScanRobot(1 + i, 0, Direction.UP, 0);

        return arr;
    }

    /**
     * Creates a new line of {@linkplain CleanRobot CleanRobots}.
     *
     * @return An array containing the newly initialised robots
     */
    public CleanRobot[] initCleaningRobots() {
        CleanRobot[] arr = new CleanRobot[World.getHeight() - 1];
        for (int i = 0; i < World.getHeight() - 1; i++)
            arr[i] = new CleanRobot(0, 1 + i, Direction.RIGHT, 0);

        return arr;
    }

    /**
     * Inverts the given array by swapping the first and last entry, continuing with the second and second last entry and so on until the entire array has been inverted.
     *
     * @param robots The array to invert
     */
    public void reverseRobots(Robot[] robots) {
        int length = robots.length;
        for (int i = 0; i < length / 2; i++) {
            Robot r = robots[i];
            robots[i] = robots[length - 1];
            robots[length - 1] = r;
        }
    }

    /**
     * Rotates the {@linkplain Robot robots} in the given array in ascending order and calls {@link #checkForDamage} on every {@link Robot} after its rotation.
     *
     * @param robots The array of {@linkplain Robot robots} to rotate
     */
    public void rotateRobots(Robot[] robots) {
        for (Robot r : robots) {
            r.turnLeft();
            r.turnLeft();

            checkForDamage(r);
        }
    }

    /**
     * Simulates inspecting a {@link Robot} for wear, turning it off if it should no longer serve. Currently implemented as a coin flip.
     *
     * @param robot The {@link Robot} to inspect
     */
    public void checkForDamage(Robot robot) {
        final double p = 0.5;
        if (Math.random() > p) {
            robot.turnOff();
        }
    }

    /**
     * Replaces the {@linkplain Robot robots} that are turned off in the provided array with new ones. <br>
     * The method expects either an array of {@linkplain ScanRobot ScanRobots} or {@linkplain CleanRobot CleanRobots} and uses the correct class when replacing the robots.
     *
     * @param robots An array possibly containing {@linkplain Robot robots} that are turned off and need to be replaced
     */
    public void replaceBrokenRobots(Robot[] robots) {
        for (int i = 0; i < robots.length; i++) {
            Robot r = robots[i];
            if (r.isTurnedOff())
                if (isScanRobotArray(robots)) {
                    robots[i] = new ScanRobot(r.getX(), r.getY(), r.getDirection(), r.getNumberOfCoins());
                } else {
                    robots[i] = new CleanRobot(r.getX(), r.getY(), r.getDirection(), r.getNumberOfCoins());
                }
        }
    }

    /**
     * Tests whether the given array is an array of {@linkplain ScanRobot ScanRobots} or not.
     *
     * @param robots The array to test
     * @return Whether the given array is an array of {@linkplain ScanRobot ScanRobots}
     */
    public boolean isScanRobotArray(Robot[] robots) {
        return robots instanceof ScanRobot[];
    }

    /**
     * Calls {@link #reverseRobots}, {@link #rotateRobots} and {@link #replaceBrokenRobots} in that order, with the given array as the argument
     *
     * @param robots The array to perform the aforementioned actions on
     */
    public void spinRobots(Robot[] robots) {
        reverseRobots(robots);
        rotateRobots(robots);
        replaceBrokenRobots(robots);
    }

    /**
     * Moves the robots to the end of the world, in ascending order and one at a time.
     *
     * @param robots The robots to move
     */
    public void returnRobots(Robot[] robots) {
        for (Robot r : robots)
            while (r.isFrontClear())
                r.move();
    }

    /**
     * Scans the world using the provided {@linkplain ScanRobot ScanRobots} and returns an array containing the scan results.
     *
     * @param scanRobots The robots to scan the world with
     * @return An array detailing which world fields contain at least one coin
     */
    public boolean[][] scanWorld(ScanRobot[] scanRobots) {
        boolean[][] coinPositions = new boolean[World.getWidth()][World.getHeight()];

        for (int y = 0; y < World.getHeight() - 1; y++)
            for (int x = 0; x < World.getWidth() - 1; x++) {
                ScanRobot r = scanRobots[x];

                coinPositions[x][y] = r.isOnACoin();

                r.move();
            }

        spinRobots(scanRobots);
        returnRobots(scanRobots);
        spinRobots(scanRobots);

        return coinPositions;
    }

    /**
     * Performs one iteration of collecting coins, using the provided arrays to clean and determine where to clean.
     *
     * @param positionsOfCoins An array with all the coin positions to be collected
     * @param cleanRobots      An array containing the {@linkplain CleanRobot CleanRobots} to collect the coins with.
     */
    public void moveCleanRobots(CleanRobot[] cleanRobots, boolean[][] positionsOfCoins) {
        for (int y = 0; y < World.getHeight() - 1; y++)
            for (int x = 0; x < World.getWidth() - 1; x++) {
                CleanRobot r = cleanRobots[x];

                if(positionsOfCoins[x][y])
                    r.pickCoin();

                r.move();
            }

        spinRobots(cleanRobots);
        returnRobots(cleanRobots);
        spinRobots(cleanRobots);
    }

    /**
     * Collects all the coins in the world using all the previously implemented helper methods.
     */
    public void cleanWorld() {
        ScanRobot[] scanRobots = initScanRobots();
        CleanRobot[] cleanRobots = initCleaningRobots();
        boolean coinsGathered = false;
        while (!coinsGathered) {
            boolean[][] coinsInWorld = scanWorld(scanRobots);
            if (allCoinsGathered(coinsInWorld)) {
                break;
            }
            moveCleanRobots(cleanRobots, coinsInWorld);
            coinsGathered = allCoinsGathered(coinsInWorld);
        }
        System.out.println("Finished cleaning the world!");
    }

    /**
     * Returns whether there are no coins left in the world.
     *
     * @param coins The array to search for coins
     * @return Whether the provided array contains at least one entry that is not false
     */
    public boolean allCoinsGathered(boolean[][] coins) {
        for (boolean[] coinRow : coins) {
            for (boolean b : coinRow) {
                if (b) {
                    return false;
                }
            }
        }
        return true;
    }
}
