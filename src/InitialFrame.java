import javax.swing.*;

public class InitialFrame extends JFrame{
    private ControlPanel initial;
    public InitialFrame(String name){
        super (name);
        
        initial = new ControlPanel();
        add(initial);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,750);
        setResizable(false);
        setVisible(true);   
    }
    public ControlPanel getCP(){
        return initial;
    }
    
    public void setCP(ControlPanel initial){
        this.initial = initial;
    }
}