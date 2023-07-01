package entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final Color COLOR = Color.GRAY;

    private int x;
    private int y;

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}

