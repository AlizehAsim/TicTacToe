package Controller;

import Model.Model;

public class Controller {
    private Model model;

    public Controller(Model m){
        this.model = m;
    }
    public void setButton(int x){
        model.setBoard(x);
    }

    public void setReset() {
        model.resetBoard();
    }
}
