import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class wood_a {
    public BufferedImage wood;
    public int x, y;

    wood_a() {

    }

    public boolean intersect(BufferedImage w, int x1, int y1) {
        int left = x1 > x ? x1 : x;
        int right = x1 + w.getWidth() < x + wood.getWidth() ? x1 + wood.getWidth() : x + wood.getWidth();
        int top = y1 > y ? y1 : y;
        int down = y1 + w.getHeight() < y + wood.getHeight() ? y1 + w.getHeight() : y + wood.getHeight();

        if (left >= right || top >= down) {
            return false;
        }
        for (int _y = top; _y < down; _y++) {
            for (int _x = left; _x < right; _x++) {
                int pixel1 = w.getRGB(_x - x1, _y - y1);
                int pixel2 = wood.getRGB(_x - x, _y - y);

                int alpha1 = (pixel1 - 24) & 255;
                int alpha2 = (pixel2 - 24) & 255;
                if (alpha1 > 0 && alpha2 > 0)
                    return true;
            }
        }
        return false;
    }
}
