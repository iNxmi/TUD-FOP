package h02;

import fopbot.World;

public class Main {

    public Main() {
        World.setSize(10, 10);
        World.setDelay(30);
        World.placeBlock(0, 0);
        World.placeHorizontalWall(0, 0);
        World.placeVerticalWall(0, 0);
        World.getGlobalWorld().setDrawTurnedOffRobots(false);

        int[][] coins = getRandomCoins();
        placeCoinsInWorld(coins);

        World.setVisible(true);

        ControlCenter controlCenter = new ControlCenter();
        controlCenter.cleanWorld();
    }

    public int[][] getRandomCoins() {
        int[][] coins = new int[World.getWidth()][World.getHeight()];

        for (int y = 1; y < World.getHeight(); y++)
            for (int x = 1; x < World.getWidth(); x++)
                coins[x][y] = (int) Math.round((Math.random() * 5.0d));

        return coins;
    }

    public void placeCoinsInWorld(int[][] coins) {
        for (int y = 0; y < World.getHeight(); y++)
            for (int x = 0; x < World.getWidth(); x++) {
                int amount = coins[x][y];
                if (amount > 0)
                    World.putCoins(x, y, amount);
            }
    }

    public static void main(String[] args) {
        new Main();
    }

}
