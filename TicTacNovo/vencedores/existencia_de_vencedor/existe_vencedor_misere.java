package TicTacToe.vencedores.existencia_de_vencedor;

import TicTacToe.vencedores.tipos_de_vencedor.vencedores;
import TicTacToe.vencedores.tipos_de_vencedor.vencedor_do_misere;

import javax.swing.*;

public class existe_vencedor_misere implements existencia_de_vencedor {
    vencedores vencedores;

    public existe_vencedor_misere() {
        this.vencedores = new vencedor_do_misere();
    }

    @Override
    public void check(JButton[][] btns, JLabel vitoriaX, JLabel vitoriaO, int vitoriasX, int vitoriasO, JLabel vez, int larguraTabuleiro) {
        int contX=0;
        int contO=0;

        for (int i=0;i<larguraTabuleiro;i++){

            for (int j=0;j<larguraTabuleiro;j++){
                if(btns[i][j].isEnabled()) {
                    if (btns[i][j].getText().equalsIgnoreCase("X")) {
                        contX++;
                    } else if (btns[i][j].getText().equalsIgnoreCase("O"))
                        contO++;
                }
            }

            if (contO==larguraTabuleiro){
                vitoriaX.setText("Vitórias: "+(++vitoriasX));
                vencedores.wins(btns,i,-1,-1,-1,"X",vez,larguraTabuleiro);
                return;


            }else if (contX==larguraTabuleiro){
                vitoriaO.setText("Vitórias: "+(++vitoriasO));
                vencedores.wins(btns,i,-1,-1,-1,"O",vez,larguraTabuleiro);

                return;
            }
            contO=0;
            contX=0;
        }


        for (int j=0;j<larguraTabuleiro;j++){

            for (int i=0;i<larguraTabuleiro;i++){
                if(btns[i][j].isEnabled()) {

                    if (btns[i][j].getText().equalsIgnoreCase("X")) {
                        contX++;
                    } else if (btns[i][j].getText().equalsIgnoreCase("O"))
                        contO++;
                }
            }

            if (contO==larguraTabuleiro){
                vitoriaX.setText("Vitórias: "+(++vitoriasX));
                vencedores.wins(btns,-1,j,-1,-1,"X",vez,larguraTabuleiro);

                return;

            }else if (contX==larguraTabuleiro){
                vitoriaO.setText("Vitórias: "+(++vitoriasO));
                vencedores.wins(btns,-1,j,-1,-1,"O",vez,larguraTabuleiro);

                return;
            }

            contO=0;
            contX=0;

        }

        for ( int i=0; i<larguraTabuleiro;i++){
            for (int j=0; j< larguraTabuleiro; j++){
                if(btns[i][j].isEnabled()) {

                    if (i + j == larguraTabuleiro - 1) {
                        if (btns[i][j].getText().equalsIgnoreCase("X")) {
                            contX++;
                        } else if (btns[i][j].getText().equalsIgnoreCase("O"))
                            contO++;
                    }
                }

            }
        }

        if (contO==larguraTabuleiro){
            vitoriaX.setText("Vitórias: "+(++vitoriasX));
            vencedores.wins(btns,-1,-1,-1,1,"X",vez,larguraTabuleiro);

            return;
        }
        else if (contX==larguraTabuleiro){
            vitoriaO.setText("Vitórias: "+(++vitoriasO));
            vencedores.wins(btns,-1,-1,-1,1,"O",vez,larguraTabuleiro);
            return;

        }

        contO=0;
        contX=0;

        for ( int i=0; i<larguraTabuleiro;i++){
            for (int j=0; j< larguraTabuleiro; j++){
                if(btns[i][j].isEnabled()) {

                    if (i == j) {
                        if (btns[i][j].getText().equalsIgnoreCase("X")) {
                            contX++;
                        } else if (btns[i][j].getText().equalsIgnoreCase("O"))
                            contO++;
                    }
                }

            }
        }

        if (contO==larguraTabuleiro){
            vitoriaX.setText("Vitórias: "+(++vitoriasX));
            vencedores.wins(btns,-1,-1,1,-1,"X",vez,larguraTabuleiro);

        }

        else if (contX==larguraTabuleiro){
            vitoriaO.setText("Vitórias: "+(++vitoriasO));
            vencedores.wins(btns,-1,-1,1,-1,"O",vez,larguraTabuleiro);

        }
    }
}
