package Model;

import View.View;

import javax.swing.*;

public class Model {
    private View view;
    private char symbol;
    private int moves;
    private char[] board;

    public Model(){
        moves = 0;
        this.symbol = 'X';
        board = new char[9];
    }

    public void setView(View v){
        this.view = v;
    }

    public void resetBoard() {
        this.moves = 0;
        this.board = new char[9];
        view.resetGame();
    }

    private boolean isWinner(){
        boolean flag = false;
        if ((this.board[0] == 'X' &&  this.board[1] == 'X' && this.board[2] == 'X') || (this.board[3] == 'X' &&  this.board[4] == 'X' && this.board[5] == 'X') || (this.board[6] == 'X' &&  this.board[7] == 'X' && this.board[8] == 'X') || (this.board[0] == 'X' &&  this.board[3] == 'X' && this.board[6] == 'X') || (this.board[1] == 'X' &&  this.board[4] == 'X' && this.board[7] == 'X') || (this.board[2] == 'X' &&  this.board[5] == 'X' && this.board[8] == 'X') || (this.board[0] == 'X' &&  this.board[4] == 'X' && this.board[8] == 'X') || (this.board[2] == 'X' &&  this.board[4] == 'X' && this.board[6] == 'X')){
            flag = true;
        }
        else if ((this.board[0] == '0' &&  this.board[1] == '0' && this.board[2] == '0') || (this.board[3] == '0' &&  this.board[4] == '0' && this.board[5] == '0') || (this.board[6] == '0' &&  this.board[7] == '0' && this.board[8] == '0') || (this.board[0] == '0' &&  this.board[3] == '0' && this.board[6] == '0') || (this.board[1] == '0' &&  this.board[4] == '0' && this.board[7] == '0') || (this.board[2] == '0' &&  this.board[5] == '0' && this.board[8] == '0') || (this.board[0] == '0' &&  this.board[4] == '0' && this.board[8] == '0') || (this.board[2] == '0' &&  this.board[4] == '0' && this.board[6] == '0')){

            return true;
        }
        return flag;
    }

    public void setBoard(int x) {
        if (moves <9){
            board[x] = symbol;
            view.update(x,symbol);
            if (symbol == 'X'){
                symbol = '0';
            }
            else if (symbol == '0'){
                symbol = 'X';
            }
            moves += 1;
            if (isWinner()){
                view.isWinner();
            }
        }
        if (moves+1 == 10 && !isWinner()){
           view.isDraw();
        }
    }
}
