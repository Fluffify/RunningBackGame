
import java.awt.*;
import javax.swing.*;


public class ScorePanel extends JPanel{
    
    private JButton pennState, giants, patriots,startReStart;
    private JLabel scoreLabel;
    private JSlider chooseDifficulty;
    private int difficulty;
    private boolean canStart;
    public ScorePanel(){
        super();
        difficulty = 1;
        canStart = false;

        setBackground(Color.LIGHT_GRAY);
        GridLayout gr = new GridLayout(2,4);
        setLayout(gr);
        pennState = new JButton("Penn State");
        giants = new JButton("Giants");
        patriots = new JButton("Patriots");
        startReStart = new JButton("Kick-Off!");
        scoreLabel = new JLabel("<html><center>Touchdowns: 0 Missed Attempts: <br>Begin Kick-Off!</html>");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        chooseDifficulty = new JSlider(JSlider.HORIZONTAL,1,3,1);
        chooseDifficulty.setBorder(BorderFactory.createTitledBorder("Difficulty"));
        chooseDifficulty.setMajorTickSpacing(1);
        chooseDifficulty.setPaintTicks(true);
        chooseDifficulty.setPaintLabels(true);

        add(pennState);
        add(giants);
        add(patriots);
        add(startReStart);
        add(scoreLabel);
        add(chooseDifficulty);

        pennState.setFocusable(false);
        giants.setFocusable(false);
        patriots.setFocusable(false);
        startReStart.setFocusable(false);
        chooseDifficulty.setFocusable(false);
    }	
    public JSlider getChooseDifficulty(){
        return chooseDifficulty;
    }
    public void setChooseDifficulty(JSlider chooseDifficulty){
        this.chooseDifficulty = chooseDifficulty;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
    public JLabel getScoreLabel(){
        return scoreLabel;
    }
    public void setScoreLable(JLabel scoreLabel){
        this.scoreLabel = scoreLabel;
    }
    public JButton getStartReStart(){
        return startReStart;
    }
    public void setStartReStart(JButton startReStart){
        this.startReStart = startReStart;
    }
    public boolean getCanStart(){
        return canStart;
    }
    public void setCanStart(boolean canStart){
        this.canStart = canStart;
    }
    public JButton getPennState(){
        return pennState;
    }
    public JButton getGiants(){
        return giants;
    }
    public JButton getPatriots(){
        return patriots;
    }
}
