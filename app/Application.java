package app;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Application extends JFrame {

    private ScorePanel scorePanel;

    public Application() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        scorePanel = new ScorePanel();

        add(scorePanel, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Application();
    }
}
