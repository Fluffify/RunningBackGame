
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Controller {
    private Model model;
    private View view;
    private Timer fieldTim;
    private Timer heroTim;
    public Controller(Model a, View b){
        model = a;
        view = b;
        newActionListener();
        newKeyListener();
    }
    
    private void newActionListener(){
        
        //==============================
        //visual listeners
        //==============================
        ActionListener visualAction = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource() == getView().getIF().getCP().getScore().getPennState()){
                    getView().getIF().getCP().getField().getHero().setIcon(new ImageIcon("images/pennState.png"));
                    getView().getIF().getCP().getField().getOurBackGround().setIcon(new ImageIcon("images/pennStateField.png"));
                }
                if(event.getSource() == getView().getIF().getCP().getScore().getGiants()){
                    getView().getIF().getCP().getField().getHero().setIcon(new ImageIcon("images/giants.jpg"));
                    getView().getIF().getCP().getField().getOurBackGround().setIcon(new ImageIcon("images/giantsField.png"));
                }
                if(event.getSource() == getView().getIF().getCP().getScore().getPatriots()){
                    getView().getIF().getCP().getField().getHero().setIcon(new ImageIcon("images/patriots.jpg"));
                    getView().getIF().getCP().getField().getOurBackGround().setIcon(new ImageIcon("images/patriotsField.png"));
                }
                if(event.getSource() == getView().getIF().getCP().getScore().getStartReStart()){
                    getView().getIF().getCP().getScore().setCanStart(true);
                    fieldTim.start();
                    heroTim.start();
                    getView().getIF().getCP().getField().getT1().getTim().start();
                    getView().getIF().getCP().getField().getT2().getTim().start();
                    getView().getIF().getCP().getField().getT3().getTim().start();
                    getView().getIF().getCP().getField().getBall().getTim().start();
                }
            }
        };
        //==============================
        //intersect listeners
        //==============================
        ActionListener intersectAction = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                getView().getIF().getCP().getField().getT1().setTargetX(getView().getIF().getCP().getField().getHero().getXBound());
                getView().getIF().getCP().getField().getT2().setTargetX(getView().getIF().getCP().getField().getHero().getXBound());
                getView().getIF().getCP().getField().getT3().setTargetX(getView().getIF().getCP().getField().getHero().getXBound());
                
                getView().getIF().getCP().getField().getT1().setTargetY(getView().getIF().getCP().getField().getHero().getYBound());
                getView().getIF().getCP().getField().getT2().setTargetY(getView().getIF().getCP().getField().getHero().getYBound());
                getView().getIF().getCP().getField().getT3().setTargetY(getView().getIF().getCP().getField().getHero().getYBound());
                
                
                if(getView().getIF().getCP().getField().getHero().getBounds().intersects(getView().getIF().getCP().getField().getT1().getTacklerBounds())||getView().getIF().getCP().getField().getHero().getBounds().intersects(getView().getIF().getCP().getField().getT2().getTacklerBounds())||getView().getIF().getCP().getField().getHero().getBounds().intersects(getView().getIF().getCP().getField().getT3().getTacklerBounds())||getView().getIF().getCP().getField().getHero().getBounds().intersects(getView().getIF().getCP().getField().getGoal().getGoalBounds())||getView().getIF().getCP().getField().getBall().getBounds().intersects(getView().getIF().getCP().getField().getMiss().getMissBounds())){
                    //==============================
                    //Miss
                    //==============================
                    if(getView().getIF().getCP().getField().getBall().getBounds().intersects(getView().getIF().getCP().getField().getMiss().getMissBounds())){
                        getView().getIF().getCP().getField().setTackles(getView().getIF().getCP().getField().getTackles()+1);
                        getView().getIF().getCP().getScore().getScoreLabel().setText("<html><center>Touchdowns: " + getView().getIF().getCP().getField().getTouchDowns() + " Missed Attempts: "+ getView().getIF().getCP().getField().getTackles()+"<br>Failed to catch the ball.</html>");
                    }
                    //==============================
                    //Goal
                    //==============================
                    else if(getView().getIF().getCP().getField().getHero().getBounds().intersects(getView().getIF().getCP().getField().getGoal().getGoalBounds())){
                        getView().getIF().getCP().getField().setTouchDowns(getView().getIF().getCP().getField().getTouchDowns()+1);
                        getView().getIF().getCP().getScore().getScoreLabel().setText("<html><center>Touchdowns: " + getView().getIF().getCP().getField().getTouchDowns() + " Missed Attempts: "+ getView().getIF().getCP().getField().getTackles()+"<br>TOUCH DOWN!!</html>");
                    }
                    //==============================
                    //Tackled
                    //==============================
                    else{
                        getView().getIF().getCP().getField().setTackles(getView().getIF().getCP().getField().getTackles()+1);
                        getView().getIF().getCP().getScore().getScoreLabel().setText("<html><center>Touchdowns: " + getView().getIF().getCP().getField().getTouchDowns() + " Missed Attempts: "+ getView().getIF().getCP().getField().getTackles()+"<br>You were tackled.</html>");
                    }
                       
                    getView().getIF().getCP().getScore().setCanStart(false);
                    getView().getIF().getCP().getField().getHero().setUp(false);
                    getView().getIF().getCP().getField().getHero().setDown(false);
                    getView().getIF().getCP().getField().getHero().setLeft(false);
                    getView().getIF().getCP().getField().getHero().setRight(false);

                    fieldTim.stop();
                    getView().getIF().getCP().getField().getT1().getTim().stop();
                    getView().getIF().getCP().getField().getT2().getTim().stop();
                    getView().getIF().getCP().getField().getT3().getTim().stop();
                    getView().getIF().getCP().getField().getBall().getTim().stop();

                    getView().getIF().getCP().getField().getHero().setXBound((int)((Math.random()*300)+900));
                    getView().getIF().getCP().getField().getHero().setYBound((int)(Math.random()*100+250));
                    getView().getIF().getCP().getField().getT1().setXBound((int)((Math.random()*250)+100));
                    getView().getIF().getCP().getField().getT1().setYBound((int)(Math.random()*183+getView().getIF().getCP().getField().getT1().getPosition()));
                    getView().getIF().getCP().getField().getT2().setXBound((int)((Math.random()*250)+100));
                    getView().getIF().getCP().getField().getT2().setYBound((int)(Math.random()*183+getView().getIF().getCP().getField().getT2().getPosition()));
                    getView().getIF().getCP().getField().getT3().setXBound((int)((Math.random()*250)+100));
                    getView().getIF().getCP().getField().getT3().setYBound((int)(Math.random()*183+getView().getIF().getCP().getField().getT3().getPosition()));
                    getView().getIF().getCP().getField().getBall().setXBound(430);
                    getView().getIF().getCP().getField().getBall().setYBound(270);
                    getView().getIF().getCP().getField().getBall().setPath((int)(Math.random()*3));
                    getView().getIF().getCP().getField().getBall().setMySpeed((int)(Math.random()*30+10));
                    System.out.println(getView().getIF().getCP().getField().getBall().getPath());
                    System.out.println(getView().getIF().getCP().getField().getBall().getMySpeed());

                    getView().getIF().getCP().getField().getT1().setBounds(getView().getIF().getCP().getField().getT1().getTacklerBounds()); 
                    getView().getIF().getCP().getField().getT2().setBounds(getView().getIF().getCP().getField().getT2().getTacklerBounds()); 
                    getView().getIF().getCP().getField().getT3().setBounds(getView().getIF().getCP().getField().getT3().getTacklerBounds()); 
                    getView().getIF().getCP().getField().getHero().setBounds(getView().getIF().getCP().getField().getHero().getRunningBounds());
                    getView().getIF().getCP().getField().getBall().setBounds(getView().getIF().getCP().getField().getBall().getBallBounds()); 
                    
                    
                }
                else if(getView().getIF().getCP().getField().getHero().getBounds().intersects(getView().getIF().getCP().getField().getBall().getBallBounds()))
                {
                    getView().getIF().getCP().getField().getBall().setBounds(2000,2000,50,50); 
                    getView().getIF().getCP().getField().getBall().getTim().stop();
                    getView().getIF().getCP().getScore().getScoreLabel().setText("<html><center>Touchdowns: " + getView().getIF().getCP().getField().getTouchDowns() + " Missed Attempts: "+ getView().getIF().getCP().getField().getTackles()+"<br>Ball has been caught!</html>");
                    
                }
            }
        };
        //==============================
        //Controlling Hero
        //==============================
        getView().getIF().getCP().getField().getHero().addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent event) {
                int action = event.getKeyCode();
                boolean start  = getView().getIF().getCP().getScore().getCanStart();

                if(start == true){
                    if(action ==  event.VK_LEFT){
                        getView().getIF().getCP().getField().getHero().setLeft(true);
                    }
                    if(action ==  event.VK_RIGHT){
                        getView().getIF().getCP().getField().getHero().setRight(true);
                    }
                    if(action ==  event.VK_UP){
                        getView().getIF().getCP().getField().getHero().setUp(true);
                    }
                    if(action ==  event.VK_DOWN){
                        getView().getIF().getCP().getField().getHero().setDown(true);
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent event) {
                int action = event.getKeyCode();
                if(action ==  event.VK_LEFT){
                        getView().getIF().getCP().getField().getHero().setLeft(false);
                }
                if(action ==  event.VK_RIGHT){
                        getView().getIF().getCP().getField().getHero().setRight(false);
                }
                if(action ==  event.VK_UP){
                        getView().getIF().getCP().getField().getHero().setUp(false);
                }
                if(action ==  event.VK_DOWN){
                        getView().getIF().getCP().getField().getHero().setDown(false);
                }
            }
        });
        
        ActionListener heroAction = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                if(event.getSource() == heroTim){
                    if(getView().getIF().getCP().getField().getHero().getLeft() == true){
                        if(getView().getIF().getCP().getField().getHero().getXBound()>0){
                            getView().getIF().getCP().getField().getHero().setXBound(getView().getIF().getCP().getField().getHero().getXBound()-5);
                            getView().getIF().getCP().getField().getHero().setBounds(getView().getIF().getCP().getField().getHero().getRunningBounds()); 
                        }
                   }
                   if(getView().getIF().getCP().getField().getHero().getRight() == true){
                        if(getView().getIF().getCP().getField().getHero().getXBound()<1230){
                            getView().getIF().getCP().getField().getHero().setXBound(getView().getIF().getCP().getField().getHero().getXBound()+5);
                            getView().getIF().getCP().getField().getHero().setBounds(getView().getIF().getCP().getField().getHero().getRunningBounds()); 
                        }
                   }
                   if(getView().getIF().getCP().getField().getHero().getUp() == true){
                        if(getView().getIF().getCP().getField().getHero().getYBound()>0){
                            getView().getIF().getCP().getField().getHero().setYBound(getView().getIF().getCP().getField().getHero().getYBound()-5);
                            getView().getIF().getCP().getField().getHero().setBounds(getView().getIF().getCP().getField().getHero().getRunningBounds()); 
                        }
                   }
                   if(getView().getIF().getCP().getField().getHero().getDown() == true){
                        if(getView().getIF().getCP().getField().getHero().getYBound()<550){
                            getView().getIF().getCP().getField().getHero().setYBound(getView().getIF().getCP().getField().getHero().getYBound()+5);
                            getView().getIF().getCP().getField().getHero().setBounds(getView().getIF().getCP().getField().getHero().getRunningBounds()); 
                        }
                    }
                }
            }
        };
        //==============================
        //Controlling Tacklers
        //==============================
        
        
        //==============================
        //for the dificulty
        //==============================
        ChangeListener change = new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent event) {
                if(event.getSource() == getView().getIF().getCP().getScore().getChooseDifficulty())
                {
                    getView().getIF().getCP().getField().getT1().setDifficulty(getView().getIF().getCP().getScore().getChooseDifficulty().getValue());
                    getView().getIF().getCP().getField().getT2().setDifficulty(getView().getIF().getCP().getScore().getChooseDifficulty().getValue());
                    getView().getIF().getCP().getField().getT3().setDifficulty(getView().getIF().getCP().getScore().getChooseDifficulty().getValue());
                }
            }
        };
        //==============================
        //adding the listeners
        //==============================
        getView().getIF().getCP().getScore().getChooseDifficulty().addChangeListener(change); 
        getView().getIF().getCP().getScore().getPennState().addActionListener(visualAction);
        getView().getIF().getCP().getScore().getGiants().addActionListener(visualAction);
        getView().getIF().getCP().getScore().getPatriots().addActionListener(visualAction);
        getView().getIF().getCP().getScore().getStartReStart().addActionListener(visualAction);
        
        getView().getIF().getCP().getField().getHero().addActionListener(heroAction);
        
        int delay = 100;
        fieldTim = new Timer(delay, intersectAction);
        heroTim = new Timer(35, heroAction);
    }
    
    private void newKeyListener(){
        
    }
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
    public Timer getFieldTim(){
        return fieldTim;
    }
    public void setFieldTimer(Timer fieldTim){
        this.fieldTim = fieldTim;
    }
    public Timer getHeroTim(){
        return heroTim;
    }
    public void setHeroTimer(Timer heroTim){
        this.heroTim = heroTim;
    }
}
