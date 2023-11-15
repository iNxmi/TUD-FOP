import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;

public class Tham {
    public Tham() {
        World.setSize(10, 10);
        World.setDelay(10);
        World.setVisible(true);

        for (int y = 0; y < World.getHeight(); y++)
            for (int x = 0; x < World.getWidth(); x++) {
                int n = (int) (Math.random() * 2);
                if (n > 0)
                    World.putCoins(x, y, n);
            }
        Robot robot = new Robot(0,0,Direction.RIGHT, 0);

    }
    public static void main(String[] args) {
        new Tham();
    }

}