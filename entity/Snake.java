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

    public void draw(Graphics g) {
        g.setColor(COLOR);
        for (Point segment : segments) {
            g.fillRect(segment.x, segment.y, SIZE, SIZE);
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

    public Rectangle getHeadBounds() {
        Point head = segments.get(0);
        return new Rectangle(head.x, head.y, SIZE, SIZE);
    }

    public ArrayList<Point> getSegments() {
        return segments;
    }

    public boolean checkSelfCollision() {
        Rectangle headBounds = getHeadBounds();
        for (int i = 1; i < segments.size(); i++) {
            Point segment = segments.get(i);
            Rectangle segmentBounds = new Rectangle(segment.x, segment.y, SIZE, SIZE);
            if (headBounds.intersects(segmentBounds)) {
                return true;
            }
        }
        return false;
    }



    public void setGrowing(boolean growing) {
        this.growing = growing;
    }
}
