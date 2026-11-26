import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class tree {
    public BufferedImage tree;
    public int x, y;
    public int w_count = 0;

    public tree(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            tree = ImageIO.read(new File("src/img/tree.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(tree, x, y, null);
    }

    public boolean contains(int px, int py) {
        return px >= x && px <= x + tree.getWidth()
                && py >= y && py <= y + tree.getHeight();
    }
}
