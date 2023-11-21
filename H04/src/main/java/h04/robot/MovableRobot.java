package h04.robot;

import fopbot.Field;
import fopbot.Robot;
import h04.selection.FieldSelectionListener;
import h04.strategy.MoveStrategy;
import h04.strategy.MoveStrategyWithCounter;

public class MovableRobot extends Robot implements FieldSelectionListener {

    private MoveStrategy moveStrategy;

    public MovableRobot(MoveStrategy moveStrategy) {
        super(0, 0);
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void onFieldSelection(Field field) {
        moveStrategy.start(this, field);

        if (moveStrategy instanceof MoveStrategyWithCounter) {
            MoveStrategyWithCounter moveStrategyWithCounter = (MoveStrategyWithCounter) moveStrategy;
            for (int i = 0; i < moveStrategyWithCounter.getMoveCount(); i++)
                turnLeft();
        }
    }

}
