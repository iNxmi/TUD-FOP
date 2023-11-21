package h04.strategy;

/**
 * The MoveStrategyWithCounter interface extends the MoveStrategy interface
 * and introduces a method to retrieve the move count.
 *
 * <p>
 * Implementing classes should provide a mechanism to track the number of moves
 * made according to the specific strategy.
 * </p>
 *
 * @author Memphis Herghelegiu
 * @version 1.0
 * @see MoveStrategy
 */
public interface MoveStrategyWithCounter extends MoveStrategy {

    /**
     * Gets the number of moves made using the specific strategy.
     *
     * @return The total count of moves made.
     */
    int getMoveCount();

}