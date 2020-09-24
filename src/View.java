
public class View {
    private InitialFrame initial;
    private Model model;
    public View(Model a){
        initial = new InitialFrame("Runningback Game");
        model = a;
    }
    public InitialFrame getIF() {
        return initial;
    }

    public void setIF(InitialFrame initial) {
        this.initial = initial;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
