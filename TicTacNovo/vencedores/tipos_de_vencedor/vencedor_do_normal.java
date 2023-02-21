package TicTacToe.vencedores.tipos_de_vencedor;

import javax.swing.*;
import java.awt.*;

public class vencedor_do_normal implements vencedores {

    public void wins(JButton[][] btns, int l, int c, int p, int s, String winner, JLabel vez, int larguraTabuleiro) {

        Color green=new Color(158,228,147);


        if(l!=-1)
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[l][i].setBackground(green);
                btns[l][i].setEnabled(false);
            }
        else if(c!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][c].setBackground(green);
                btns[i][c].setEnabled(false);

            }
        }else if(p!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][i].setBackground(green);
                btns[i][i].setEnabled(false);

            }
        }else if(s!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][larguraTabuleiro-i-1].setBackground(green);
                btns[i][larguraTabuleiro-i-1].setEnabled(false);
            }
        }

        vez.setText("Vitória do Jogador "+winner);
    }
}
