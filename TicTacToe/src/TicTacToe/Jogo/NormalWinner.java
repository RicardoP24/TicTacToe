package TicTacToe.Jogo;

import javax.swing.*;
import java.awt.*;

public class NormalWinner implements IShowWinnerBehaviour {

    @Override
    public void wins(JButton[][] btns, int l, int c, int p, int s, String winner, JLabel vez,int larguraTabuleiro) {
        for (int i=0;i<larguraTabuleiro;i++){
            for (int j=0;j<larguraTabuleiro;j++){
                btns[i][j].setEnabled(false);
            }
        }

        if(l!=-1)
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[l][i].setBackground(Color.GREEN);
            }
        else if(c!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][c].setBackground(Color.GREEN);
            }
        }else if(p!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][i].setBackground(Color.GREEN);
            }
        }else if(s!=-1){
            for (int i=0;i<larguraTabuleiro;i++) {
                btns[i][larguraTabuleiro-i-1].setBackground(Color.GREEN);
            }
        }

        vez.setText("Vitória do Jogador "+winner);
    }
}
