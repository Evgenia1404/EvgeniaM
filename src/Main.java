import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame {
    public BufferedImage bg, fox;
    public int x=50;
    public KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {                x++;                repaint();            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {                x--;                repaint();            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    Main()
    {
        try {
            bg = ImageIO.read(new File("src/img/фон.jpg"));
            fox = ImageIO.read(new File("src/img/человечек фронт.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        setSize(1670,941);
        setVisible(true);
        addKeyListener(kl);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(bg,0,0,this);
        g.drawImage(fox,x,300,this);
    }

    public static void main(String[] args)
    {
        new Main();
    }




}
