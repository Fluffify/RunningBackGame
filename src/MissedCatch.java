
import java.awt.Rectangle;
import javax.swing.*;

public class MissedCatch extends JButton{
    private Rectangle bounds;
    public MissedCatch(){
        super();
    }
    public Rectangle getMissBounds(){
        bounds = new Rectangle (1280,0,10,600);
        return bounds;
    }
}
