
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FieldPanel extends JPanel{
    private Goal goal;
    private Tacklers t1,t2,t3;
    private RunningBack hero;
    private Ball ball;
    private ScorePanel score;
    private int touchDowns,tackles;
    private JLabel backGround;
    private MissedCatch miss;
    public FieldPanel(ScorePanel a){
        super();
        score = a;
        touchDowns = 0;
        tackles = 0;
        setLayout(null);
            
        ball = new Ball(new ImageIcon("images/football.jpg"));
        goal = new Goal(new ImageIcon("images/fieldgoal.png"));
        t1 = new Tacklers(new ImageIcon("images/michigan.png"),0);
        t2 = new Tacklers(new ImageIcon("images/michigan.png"),180);
        t3 = new Tacklers(new ImageIcon("images/michigan.png"),360);
        hero = new RunningBack(new ImageIcon("images/pennState.png"));
        backGround = new JLabel(new ImageIcon("images/pennStateField.png"));
        backGround.setSize(1280,600);
        miss = new MissedCatch();
        
        t1.setFocusable(false);
        t2.setFocusable(false);
        t3.setFocusable(false);
        ball.setFocusable(false);
        goal.setFocusable(false);
        miss.setFocusable(false);
        setFocusable(false);
        
        ball.setBounds(ball.getBallBounds());
        goal.setBounds(goal.getGoalBounds());
        miss.setBounds(miss.getMissBounds());
        t1.setBounds(t1.getTacklerBounds());
        t2.setBounds(t2.getTacklerBounds());
        t3.setBounds(t3.getTacklerBounds());
        hero.setBounds(hero.getRunningBounds());
        
        add(goal);
        add(ball);
        add(t1);
        add(t2);
        add(t3);
        add(hero);
        
        add(backGround);
        add(miss);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        requestFocusInWindow();
    }
    public int getTouchDowns(){
        return touchDowns;
    }
    public void setTouchDowns(int touchDowns){
        this.touchDowns = touchDowns;
    }
    public int getTackles(){
        return tackles;
    }
    public void setTackles(int tackles){
        this.tackles = tackles;
    }
    public RunningBack getHero(){
        return hero;
    }
    public void setHero(RunningBack hero){
        this.hero = hero;
    }
    public Tacklers getT1(){
        return t1;
    }
    public void setT1(Tacklers t1){
        this.t1 = t1;
    }
    public Tacklers getT2(){
        return t2;
    }
    public void setT2(Tacklers t2){
        this.t2 = t2;
    }
    public Tacklers getT3(){
        return t3;
    }
    public void setT3(Tacklers t3){
        this.t3 = t3;
    }
    public Ball getBall(){
        return ball;
    }
    public void setBall(Ball ball){
        this.ball = ball;
    }
    public Goal getGoal(){
        return goal;
    }
    public void setGoal(Goal goal){
        this.goal = goal;
    }
    public MissedCatch getMiss(){
        return miss;
    }
    public void setMiss(MissedCatch miss){
        this.miss = miss;
    }
    public JLabel getOurBackGround(){
        return backGround;
    }
    public void setOurBackGround(JLabel backGround){
        this.backGround = backGround;
    }
}
