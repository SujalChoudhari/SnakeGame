package app;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Application extends JFrame {

    private GamePanel gamePanel;
    private ScorePanel scorePanel;

    public Application() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel();
        scorePanel = new ScorePanel();

        add(gamePanel);
        add(scorePanel, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Application();
    }
}
