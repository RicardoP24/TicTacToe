package TicTacToe.vencedores.tipos_de_vencedor;

import javax.swing.*;

public interface vencedores {
    void wins(JButton[][] btns, int l, int c, int p, int s, String winner, JLabel vez, int larguraTabuleiro);
}
