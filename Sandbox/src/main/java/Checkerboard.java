import com.nami.RobotUtils;
import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;

public class Checkerboard {

    public Checkerboard() {
        World.setSize(10, 10);
        World.setDelay(1);
        World.setVisible(true);

        int coins = (int) Math.ceil((World.getWidth() * World.getHeight() / 2f));
        Robot robot = new Robot(0, 0, Direction.RIGHT, coins);

        int counter = 0;
        for (int y = 0; y < World.getHeight(); y++)
            for (int x = 0; x < World.getWidth(); x++) {
                if (counter % 2 == 0)
                    robot.putCoin();

                boolean lastMove = x + y * World.getWidth() >= (World.getWidth() * World.getHeight()) - 1;
                if (lastMove)
                    break;

                if (robot.isFrontClear()) {
                    robot.move();
                } else {
                    switch (robot.getDirection()) {
                        case RIGHT -> {
                            robot.turnLeft();
                            robot.move();
                            robot.turnLeft();
                        }
                        case LEFT -> {
                            RobotUtils.turnRight(robot);
                            robot.move();
                            RobotUtils.turnRight(robot);
                        }
                    }
                }

                counter++;
            }
    }

    public static void main(String[] args) {
        new Checkerboard();
    }

}
