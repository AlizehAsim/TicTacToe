package View;

import Controller.Controller;
import Listener.MyActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class View {

    private JPanel panel;
    private JFrame frame;
    private JButton p1;
    private JButton p2;
    private JButton[] buttons;
    private JButton reset;

    public View() {
        this.frame = new JFrame("TicTacToe");
        this.reset = new JButton("Reset Game");
        GridLayout board = new GridLayout(4, 4);
        this.buttons = new JButton[9];
        this.p1 = new JButton();
        this.p2 = new JButton();
        p1.setEnabled(true);
        p2.setEnabled(false);
        frame.setLayout(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        p1.setText("Player 1 Turn");
        p2.setText("Player 2 Turn");
        for (int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(40,40));
            buttons[i].setName(String.valueOf(i));
            frame.add(buttons[i]);
        }
        frame.add(p1);
        frame.add(reset);
        frame.add(p2);
        frame.setVisible(true);
    }

    public void setListeners(Controller c){
        MyActionListener AL = new MyActionListener(c, this);
        for (int i=0;i<9;i++){
            buttons[i].addActionListener(AL);
        }
        reset.addActionListener(AL);
    }

    public void update(int index, char symbol) {
        buttons[index].setText(Character.toString(symbol));
        buttons[index].setEnabled(false);
        if (p1.isEnabled()){
            p1.setEnabled(false);
            p2.setEnabled(true);
        }
        else if (p2.isEnabled()){
            p2.setEnabled(false);
            p1.setEnabled(true);
        }
    }


    public boolean isReset(ActionEvent e) {
        return e.getSource() == reset;
    }

    public int getButton(ActionEvent e) {
        String name = "";
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                name = buttons[i].getName();
            }
        }
        return Integer.parseInt(name);
    }

    public void resetGame() {
        for (int i=0;i<9;i++){
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        this.p1.setEnabled(true);
        this.p2.setEnabled(false);
    }

    public void isDraw() {
        JDialog d = new JDialog(frame);
        JLabel l = new JLabel("Game Draw");
        d.add(l);
        d.setSize(100, 100);
        d.setVisible(true);
        this.resetGame();
    }

    public void isWinner() {
        JDialog d = new JDialog(frame);
        if (this.p1.isEnabled()){
            JLabel l = new JLabel("Player 2 Won");
            d.add(l);
            d.setSize(100, 100);
            d.setVisible(true);
        }
        else if (this.p2.isEnabled()){
            JLabel l = new JLabel("Player 1 Won");
            d.add(l);
            d.setSize(100, 100);
            d.setVisible(true);
        }
        this.resetGame();
    }
}
