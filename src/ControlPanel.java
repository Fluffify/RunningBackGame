import java.awt.*;
import javax.swing.*;


public class ControlPanel extends JPanel {
    private FieldPanel field;
    private ScorePanel score;
    public ControlPanel()
    {
        super();
        setBackground(Color.gray);
        setLayout(null);
        
        score = new ScorePanel();
        field = new FieldPanel(score);
        
        score.setBounds(0,0,1280,120);
        field.setBounds(0,120,1280,600);
        add(score);
        add(field);
    }
    
    public FieldPanel getField(){
        return field;
    }
    public void setField(FieldPanel field){
        this.field=field;
    }
    public ScorePanel getScore(){
        return score;
    }
    public void setScore(ScorePanel score){
        this.score=score;
    }
}
