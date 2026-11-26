import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class tree_click extends MouseAdapter {
    public ArrayList<tree> tree_;
    public ArrayList<wood> wood_;
    public JPanel panel;
    public int ax, ay;


    public tree_click(ArrayList<tree> tree_, ArrayList<wood> wood_, JPanel panel) {
        this.tree_ = tree_;
        this.wood_ = wood_;
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            for (tree t : tree_) {
                if (t.contains(e.getX(), e.getY())) {
                    ax = new Random().nextInt(35);
                    ay = new Random().nextInt(15);
                    wood_.add(new wood(t.x - ax + 10, t.y + ay + 108));
                    t.w_count++;
                    if (t.w_count >= 3) tree_.remove(t);
                    panel.repaint();
                    break;
                }
            }
        }
    }
}
