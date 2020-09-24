
import java.awt.*;
import javax.swing.*;

public class RunningBack extends JButton{
    private Rectangle bounds;
    private int xBound,yBound;
    private Boolean up,down,left,right;
    public RunningBack(ImageIcon a){
        super(a);
        up = false;
        down = false;
        left = false;
        right = false;
        
        setXBound((int)((Math.random()*300)+900));
        setYBound((int)(Math.random()*100)+250);
        setFocusable(true);
    }
    
    public Rectangle getRunningBounds(){
        bounds = new Rectangle(getXBound(),getYBound(),50,50);
        return bounds;
    }
    
    public int getXBound(){
        return xBound;
    }
    public void setXBound(int xBound){
        this.xBound = xBound;
    }
    public int getYBound(){
        return yBound;
    }
    public void setYBound(int yBound){
        this.yBound = yBound;
    }
    public boolean getUp(){
        return up;
    }
    public void setUp(boolean up){
        this.up = up;
    }
    public boolean getDown(){
        return down;
    }
    public void setDown(boolean down){
        this.down = down;
    }
    public boolean getLeft(){
        return left;
    }
    public void setLeft(boolean left){
        this.left = left;
    }
    public boolean getRight(){
        return right;
    }
    public void setRight(boolean right){
        this.right = right;
    }
}
