package Breakout;

import java.awt.*;
import java.util.Arrays;

public class BreakoutMap {
    public int[][] map;
    public int brickWidth;
    public int brickHeight;

    public BreakoutMap(int row, int col) {
        map = new int[row][col];
        for (int[] ints : map) {
            Arrays.fill(ints, 1);
        }
        brickWidth = 540 / col;
        brickHeight = 150 / row;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(5));
                    g.setColor(Color.BLUE);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
