
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ball extends JButton{
    private int xBound, yBound,path,delay;
    private Rectangle bounds;
    private Timer tim;
    
    public Ball(ImageIcon a){
        super(a);
        
        setXBound(430);
        setYBound(270);
        setFocusable(false);
        path = (int)(Math.random()*3);
        int delay= (int)(Math.random()*30+10);
        System.out.println(path);
        System.out.println(delay);
        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) 
            {
                setBounds(getBallBounds());
                if(event.getSource() == tim){
                    if(path == 0){
                        setXBound(getXBound()+5);
                        setYBound(getYBound()+0);
                    }
                    if(path == 1){
                        setXBound(getXBound()+5);
                        setYBound(getYBound()+2);
                    }
                    if(path == 2){
                        setXBound(getXBound()+5);
                        setYBound(getYBound()-2);
                    }
                }
            }
        };
        tim = new Timer(delay, action);
    }
    
    public Rectangle getBallBounds(){
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
    public Timer getTim(){
        return tim;
    }
    public void setTimer(Timer tim){
        this.tim = tim;
    }
    public int getPath(){
        return path;
    }
    public void setPath(int path){
        this.path = path;
    }
    public int getMySpeed(){
        return delay;
    }
    public void setMySpeed(int delay){
        this.delay = delay;
    }
}
