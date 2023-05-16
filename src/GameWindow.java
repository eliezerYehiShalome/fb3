import javax.swing.*;
import java.awt.*;


    public class GameWindow extends JFrame {
        private static final int WIDTH = 800;
        private static final int HEIGHT = 600;

        public GameWindow() {
            setTitle("Flappy Bird");
            setSize(WIDTH, HEIGHT);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);

            GamePanel gamePanel = new GamePanel();
            add(gamePanel);

            setVisible(true);

        }
}
