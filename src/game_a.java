import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class game_a extends JFrame {
    public BufferedImage bg, gamer;
    public int x = 835;
    public int y = 627;
    public ArrayList<wood> wood_ = new ArrayList<wood>();
    public KeyListener kl = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    x++;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    x--;
                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (wood_.size() > 0) {
                    wood_.remove(new Random().nextInt(wood_.size()));
                    repaint();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {

                    y--;

                repaint();
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                    y++;

                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < wood_.size(); i++)
                wood_.get(i).move();
            repaint();
        }
    };
    //Timer time = new Timer(100,al);

    public game_a() {

        try {
            bg = ImageIO.read(new File("src/img/фон.png"));
            gamer = ImageIO.read(new File("src/img/чел.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JPanel panel = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, this);
                g.drawImage(gamer, x,y, this);
                for (int i = 0; i < wood_.size(); i++) {
                    g.drawImage(wood_.get(i).wood, wood_.get(i).x, wood_.get(i).y, this);
                }
            }
        };
        add(panel);
        setSize(1670, 941);
        setVisible(true);
        addKeyListener(kl);
        for (int i = 0; i < 5; i++) {
            wood_.add(new wood());
        }
        // time.start();
    }

    public static void main(String[] args) {
        new game_a();
    }


}
