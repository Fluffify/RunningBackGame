
import javax.swing.*;

public class Model {
    private Goal goal;
    private RunningBack rB;
    private Tacklers tackler; 
    
    public Model(){
        goal = new Goal(new ImageIcon("images/fieldgoal.png"));
        rB = new RunningBack(new ImageIcon("images/pennState.png"));
    }
    public Goal getGoal() {
        return goal;
    }
    public void setGoal(Goal goal) {
        this.goal = goal;
    }
    public RunningBack getRB() {
        return rB;
    }
    public void setRB(RunningBack rB) {
        this.rB = rB;
    }
    public Tacklers getTackler() {
        return tackler;
    }
    public void setTackler(Tacklers tackler) {
        this.tackler = tackler;
    }
}
