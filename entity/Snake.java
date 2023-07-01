package entity;

import java.awt.*;
import java.util.ArrayList;

import app.GamePanel;

public class Snake {

    private static final int SIZE = 20;
    private static final int START_LENGTH = 3;
    private static final Color COLOR = Color.GREEN;

    private ArrayList<Point> segments;
    private Direction direction;
    private boolean growing;

    public Snake() {
        segments = new ArrayList<>();
        direction = Direction.RIGHT;
        growing = false;

        // Initialize snake segments
        int startX = GamePanel.PANEL_WIDTH / 2;
        int startY = GamePanel.PANEL_HEIGHT / 2;
        for (int i = 0; i < START_LENGTH; i++) {
            segments.add(new Point(startX - i * SIZE, startY));
        }
    }

    public void move() {
        Point head = new Point(segments.get(0));
        switch (direction) {
            case UP:
                head.y -= SIZE;
                break;
            case DOWN:
                head.y += SIZE;
                break;
            case LEFT:
                head.x -= SIZE;
                break;
            case RIGHT:
                head.x += SIZE;
                break;
        }

        segments.add(0, head);

        if (!growing) {
            segments.remove(segments.size() - 1);
        } else {
            growing = false;
        }
    }

   

    public void setDirection(Direction direction) {
        if (this.direction == Direction.UP && direction == Direction.DOWN) {
            return;
        }
        if (this.direction == Direction.DOWN && direction == Direction.UP) {
            return;
        }
        if (this.direction == Direction.LEFT && direction == Direction.RIGHT) {
            return;
        }
        if (this.direction == Direction.RIGHT && direction == Direction.LEFT) {
            return;
        }
        this.direction = direction;
    }

}
