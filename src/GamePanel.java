import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    private static final int GROUND_HEIGHT = 100;
    private Image image;
    private Image imageBackground;

    private int birdY;
    private int velocity;

    public GamePanel() {
        birdY = getHeight() / 2;
        velocity = 0;
        image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\eliys\\eclipse-workspace\\FlappyBird\\Image\\new_bird1-removebg-preview.png");
        imageBackground = Toolkit.getDefaultToolkit().getImage("C:\\Users\\eliys\\eclipse-workspace\\FlappyBird\\Image\\Beckgraund.png");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                velocity = -10;
            }
        });

        new Thread(() -> {
            while (true) {
                velocity += 1;  // Gravity
                birdY += velocity;

                if (birdY > getHeight() - GROUND_HEIGHT - 50) {
                    birdY = getHeight() - GROUND_HEIGHT - 50;
                }
                if (birdY < 0) {
                    birdY = 0;
                }

                repaint();

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageBackground, 0, 0, getWidth(), getHeight() - GROUND_HEIGHT + 4, this);

        g.setColor(Color.ORANGE);
        g.fillRect(0, getHeight() - GROUND_HEIGHT, getWidth(), GROUND_HEIGHT);

        g.drawImage(image, 350, birdY, 70, 50, this);
    }
}
