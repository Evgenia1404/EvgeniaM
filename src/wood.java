import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class wood {
    public BufferedImage wood;
    public int x, y;


    public wood(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            wood = ImageIO.read(new File("src/img/wood.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(wood, x, y, null);
    }

}
