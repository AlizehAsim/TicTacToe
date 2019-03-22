package Listener;

import Controller.Controller;
import java.awt.event.*;
import View.View;

public class MyActionListener implements ActionListener {
    private Controller c;
    private View v;

    public MyActionListener(Controller c, View v){
        this.c = c;
        this.v = v;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (v.isReset(e)){
            c.setReset();
        }
        else {
            int position = v.getButton(e);
            c.setButton(position);
        }
    }
}
