import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class game_a extends JFrame {
    public BufferedImage bg, gamer;
    public int x = 1012;
    public int y = 325;
    public ArrayList<wood> wood_ = new ArrayList<wood>();
    public ArrayList<tree> tree_ = new ArrayList<tree>();
    public KeyListener kl = new KeyListener() {

        public boolean show = false;

        public void ClickImage() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int x = e.getX(), y = e.getY();
                    if (x >= 100 && x <= 300 && y >= 100 && y >= 300) {
                        show = true;
                        repaint();
                    }
                }
            });
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (x > 1475) {
                    x = 1475;

                } else {
                    x++;
                    repaint();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (x < 228) {
                    x = 228;

                } else {
                    x--;
                    repaint();
                }
                }

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (y < 126) {
                    y = 126;
                } else {
                    y--;
                    repaint();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (y > 696) {
                    y = 696;
                } else {
                    y++;
                    repaint();
                }
            }
            /* if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (wood_.size() > 0) {
                    wood_.remove(new Random().nextInt(wood_.size()));
                    repaint();
                }
            }*/
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    };

        /*ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < wood_.size(); i++)
                    wood_.get(i).move();
                repaint();
            }
        };*/
    //Timer time = new Timer(100,al);

    public game_a() {

        try {
            bg = ImageIO.read(new File("src/img/фон1.png"));
            gamer = ImageIO.read(new File("src/img/чел ф.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, this);
                for (tree t : tree_) {
                    t.draw(g);
                }
                for (wood w : wood_) {
                    w.draw(g);
                }
                g.drawImage(gamer, x, y, this);
            }
        };

        panel.addMouseListener(new tree_click(tree_, wood_, panel));

        tree_.add(new tree(1273, 270));

        tree_.add(new tree(1167, 285));
        tree_.add(new tree(1217, 285));
        tree_.add(new tree(1245, 285));
        tree_.add(new tree(1300, 285));

        tree_.add(new tree(1217, 300));
        tree_.add(new tree(1273, 300));
        tree_.add(new tree(1328, 300));

        tree_.add(new tree(1167, 330));
        tree_.add(new tree(1222, 330));
        tree_.add(new tree(1278, 330));
        tree_.add(new tree(1333, 330));
        tree_.add(new tree(1383, 330));

        tree_.add(new tree(1137, 360));
        tree_.add(new tree(1192, 360));
        tree_.add(new tree(1247, 360));
        tree_.add(new tree(1303, 360));
        tree_.add(new tree(1358, 360));
        tree_.add(new tree(1413, 360));

        tree_.add(new tree(1177, 390));
        tree_.add(new tree(1232, 390));
        tree_.add(new tree(1288, 390));
        tree_.add(new tree(1343, 390));

        tree_.add(new tree(1202, 420));
        tree_.add(new tree(1258, 420));
        tree_.add(new tree(1313, 420));

        tree_.add(new tree(1262, 440));
        add(panel);
        setSize(1672, 941);
        setVisible(true);
        addKeyListener(kl);
        // time.start();
    }


    public static void main(String[] args) {
        new game_a();
    }


}

