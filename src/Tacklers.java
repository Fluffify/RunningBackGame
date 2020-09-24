
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Tacklers extends JButton{
    private Rectangle bounds;
    private int xBound,yBound,position,targetX,targetY,difficulty;
    private Timer tim;
   
    public Tacklers(ImageIcon a,int d){
        super(a);
        position = d;
        
        setXBound((int)((Math.random()*250)+100));
        setYBound((int)(Math.random()*183+position));
        int delay=100;
        
        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) 
            {
                setBounds(getTacklerBounds());
                if(getDifficulty()==1){
                    tim.setDelay(105);
                }
                if(getDifficulty()==2){
                    tim.setDelay(85);
                }
                if(getDifficulty()==3){
                    tim.setDelay(65);
                }
                if(event.getSource() == tim){

                    if(getXBound()<targetX){
                        setXBound(getXBound()+5);
                    }
                    if(getXBound()>targetX){
                        setXBound(getXBound()-5);
                    }
                    if(getYBound()<targetY){
                        if(getYBound() <= position +183 && getYBound()>=position){
                            setYBound(getYBound()+5);
                        }
                        else if (getYBound() > position +183){
                            setYBound(position+183);
                        }
                        else if (getYBound() < position){
                            setYBound(position);
                        }
                    }
                    if(getYBound()>targetY){
                        if(getYBound() <= position+183 && getYBound()>=position){
                            setYBound(getYBound()-5);
                        }
                        else if (getYBound() > position +183){
                            setYBound(position+183);
                        }
                        else if (getYBound() < position){
                            setYBound(position);
                        }
                    }
                }
            }
        };
        tim = new Timer(delay, action);
    }
    
    public Rectangle getTacklerBounds(){
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
    public int getPosition(){
        return position;
    }
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public int getTargetX(){
        return targetX;
    }
    public void setTargetX(int targetX){
        this.targetX = targetX;
    }
    public int getTargetY(){
        return targetY;
    }
    public void setTargetY(int targetY){
        this.targetY = targetY;
    }
}
