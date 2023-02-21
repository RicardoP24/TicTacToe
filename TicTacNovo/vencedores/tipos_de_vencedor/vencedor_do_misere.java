package TicTacToe.vencedores.tipos_de_vencedor;

import javax.swing.*;
import java.awt.*;

public class vencedor_do_misere implements vencedores {
    @Override
    public void wins(JButton[][] btns, int l, int c, int p, int s, String winner, JLabel vez, int larguraTabuleiro) {

        Color red = new Color(222, 124, 90);


        if(l!=-1)
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[l][i].setBackground(red);
                btns[l][i].setEnabled(false);
            }
        else if(c!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][c].setBackground(red);
                btns[i][c].setEnabled(false);

            }
        }else if(p!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][i].setBackground(red);
                btns[i][i].setEnabled(false);

            }
        }else if(s!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][larguraTabuleiro-i-1].setBackground(red);
                btns[i][larguraTabuleiro-i-1].setEnabled(false);
            }
        }

        vez.setText("Vitória do Jogador "+winner);
    }
}
