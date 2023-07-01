package entity;

import java.awt.*;

import app.GameDimensions;
import app.GamePanel;

public class Food {

    private static final int SIZE = GameDimensions.FOOD_SIZE;
    private static final Color COLOR = Color.RED;

    private Point position;

    public Food() {
        position = generateRandomPosition();
    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillRect(position.x, position.y, SIZE, SIZE);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    private Point generateRandomPosition() {
        int x = (int) (Math.random() * (GamePanel.PANEL_WIDTH - 20) / SIZE) * SIZE;
        int y = (int) (Math.random() * (GamePanel.PANEL_HEIGHT - 20) / SIZE) * SIZE;
        return new Point(x, y);
    }
}
