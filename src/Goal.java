
import java.awt.*;
import javax.swing.*;

public class Goal extends JButton{
    private Rectangle bounds;
    public Goal(ImageIcon a){
        super(a);
    }
    public Rectangle getGoalBounds(){
        bounds = new Rectangle (0,0,100,600);
        return bounds;
    }
}
