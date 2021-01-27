package Exam.Projection;

public class Obstacle {
    private final int x;
    private final int y;
    private final int width;

    public Obstacle(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public boolean covers(Spot spot) {
        // TODO
        return false;
    }

    public boolean isCoveredBy(Obstacle[] obstacles) {
        // TODO
        return false;
    }

}
