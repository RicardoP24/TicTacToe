package TicTacToe.Jogo;

import javax.swing.*;

public interface ICheckWinnerBehaviour {

    void check(JButton[][] btns, JLabel vitoriaX, JLabel vitoriaO,int vitoriasX,int vitoriasO, JLabel vez, int larguraTabuleiro);

}
