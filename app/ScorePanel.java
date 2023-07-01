package app;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class ScorePanel extends JPanel {
    public static ScorePanel Instance; 
    private int score;

    public ScorePanel() {
        ScorePanel.Instance = this;
        score = 0;
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(800, 50));
    }

    public void setScore(int score) {
        this.score = score;
        repaint();
    }

    public int getScore(){
        return this.score;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
    }
}
