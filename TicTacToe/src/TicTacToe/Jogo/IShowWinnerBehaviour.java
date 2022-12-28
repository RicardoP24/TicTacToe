package TicTacToe.Jogo;

import javax.swing.*;

public interface IShowWinnerBehaviour {

     void wins(JButton[][] btns, int l, int c, int p, int s, String winner, JLabel vez,int larguraTabuleiro);


}
