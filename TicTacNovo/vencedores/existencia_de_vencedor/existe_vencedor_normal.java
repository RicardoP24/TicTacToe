package TicTacToe.vencedores.existencia_de_vencedor;

import TicTacToe.vencedores.tipos_de_vencedor.vencedores;
import TicTacToe.vencedores.tipos_de_vencedor.vencedor_do_normal;

import javax.swing.*;

public class existe_vencedor_normal implements existencia_de_vencedor {

        vencedores vencedores;

        public existe_vencedor_normal() {
            this.vencedores = new vencedor_do_normal();
        }

        @Override
        public void check(JButton[][] btns, JLabel vitoriaX, JLabel vitoriaO, int vitoriasX, int vitoriasO, JLabel vez, int larguraTabuleiro) {

            int contX=0;
            int contO=0;


            //Percorre as Linhas do tabuleiro

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
                    vitoriasO++;
                    vitoriaO.setText("Vitórias: "+vitoriasO);
                    vencedores.wins(btns,i,-1,-1,-1,"O",vez,larguraTabuleiro);
                    return;

                }else if (contX==larguraTabuleiro){
                    vitoriasX++;
                    vitoriaX.setText("Vitórias: "+vitoriasX);
                    vencedores.wins(btns,i,-1,-1,-1,"X",vez,larguraTabuleiro);
                    return;

                }

                contO=0;
                contX=0;

            }

            //Percorre as Colunas do tabuleiro

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
                    vitoriasO++;
                    vitoriaO.setText("Vitórias: "+vitoriasO);
                    vencedores.wins(btns,-1,j,-1,-1,"O",vez,larguraTabuleiro);
                    return;

                }else if (contX==larguraTabuleiro){
                    vitoriasX++;
                    vitoriaX.setText("Vitórias: "+vitoriasX);
                    vencedores.wins(btns,-1,j,-1,-1,"X",vez,larguraTabuleiro);
                    return;
                }

                contO=0;
                contX=0;

            }

            //Percorre a diagonal secundaria

            for ( int i=0; i<larguraTabuleiro;i++){
                for (int j=0; j< larguraTabuleiro; j++){

                    if(i+j==larguraTabuleiro-1) {
                        if(btns[i][j].isEnabled()) {
                            if (btns[i][j].getText().equalsIgnoreCase("X")) {
                                contX++;
                            } else if (btns[i][j].getText().equalsIgnoreCase("O"))
                                contO++;
                        }
                    }

                }
            }

            if (contO==larguraTabuleiro){
                    vitoriasO++;
                    vitoriaO.setText("Vitórias: "+vitoriasO);
                    vencedores.wins(btns,-1,-1,-1,1,"O",vez,larguraTabuleiro);

                    return;
                }
            else if (contX==larguraTabuleiro){
                    vitoriasX++;
                    vitoriaX.setText("Vitórias: "+vitoriasX);
                    vencedores.wins(btns,-1,-1,-1,1,"X",vez,larguraTabuleiro);
                    return;

                }

            contO=0;
            contX=0;

            //Percorre a diagonal principal

            for ( int i=0; i<larguraTabuleiro;i++){
                for (int j=0; j< larguraTabuleiro; j++){
                    if(i==j) {
                        if(btns[i][j].isEnabled()) {
                            if (btns[i][j].getText().equalsIgnoreCase("X")) {
                                contX++;
                            } else if (btns[i][j].getText().equalsIgnoreCase("O"))
                                contO++;
                        }
                    }

                }
            }

            if (contO==larguraTabuleiro){
                vitoriasO++;
                vitoriaO.setText("Vitórias: "+vitoriasO);
                vencedores.wins(btns,-1,-1,1,-1,"O",vez,larguraTabuleiro);

            }
            else if (contX==larguraTabuleiro){
                vitoriasX++;
                vitoriaX.setText("Vitórias: "+vitoriasX);
                vencedores.wins(btns,-1,-1,1,-1,"X",vez,larguraTabuleiro);

            }
        }
    }
