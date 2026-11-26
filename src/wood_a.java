import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class wood_a {
    public BufferedImage image;
    public int x, y;

    wood_a() {
        try {
            image = ImageIO.read(new File("src/img/wood.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        x = new Random().nextInt(800);
        y = new Random().nextInt(300);

    }
    /*public boolean show =false;
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
    }*/
    /*void move()
    {
        y+=5;
        if (y>450)
        {
            y = -100;
            x = new Random().nextInt(800);
        }
    }*/

    public boolean intersect(BufferedImage img1, int x1, int y1) {
        int left = x1 > x ? x1 : x;
        int right = x1 + img1.getWidth() < x + image.getWidth() ? x1 + img1.getWidth() : x + image.getWidth();
        int top = y1 > y ? y1 : y;
        int down = y1 + img1.getHeight() < y + image.getHeight() ? y1 + img1.getHeight() : y + image.getHeight();

        if (left >= right || top >= down) {
            return false;
        }
        for (int _y = top; _y < down; _y++) {
            for (int _x = left; _x < right; _x++) {
                int pixel1 = img1.getRGB(_x - x1, _y - y1);
                int pixel2 = image.getRGB(_x - x, _y - y);

                int alpha1 = (pixel1 - 24) & 255;
                int alpha2 = (pixel2 - 24) & 255;
                if (alpha1 > 0 && alpha2 > 0)
                    return true;
            }
        }
        return false;
    }
}
