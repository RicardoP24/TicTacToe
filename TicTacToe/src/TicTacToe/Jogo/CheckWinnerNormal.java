package TicTacToe.Jogo;

import javax.swing.*;

public class CheckWinnerNormal implements ICheckWinnerBehaviour{

    IShowWinnerBehaviour iShowWinnerBehaviour;

    public CheckWinnerNormal() {
        this.iShowWinnerBehaviour = new NormalWinner();
    }

    @Override
    public void check(JButton[][] btns, JLabel vitoriaX, JLabel vitoriaO,int vitoriasX,int vitoriasO, JLabel vez, int larguraTabuleiro) {
        int contX=0;
        int contO=0;

        for (int i=0;i<larguraTabuleiro;i++){

            for (int j=0;j<larguraTabuleiro;j++){

                if(btns[i][j].getText().equalsIgnoreCase("X")){
                    contX++;
                }else if(btns[i][j].getText().equalsIgnoreCase("O"))
                    contO++;
            }

            if (contO==larguraTabuleiro){
                vitoriasO++;
                vitoriaO.setText("Vitórias: "+vitoriasO);
                iShowWinnerBehaviour.wins(btns,i,-1,-1,-1,"O",vez,larguraTabuleiro);
                return;


            }else if (contX==larguraTabuleiro){
                vitoriasX++;
                vitoriaX.setText("Vitórias: "+vitoriasX);
                iShowWinnerBehaviour.wins(btns,i,-1,-1,-1,"X",vez,larguraTabuleiro);

                return;
            }
            contO=0;
            contX=0;
        }


        for (int j=0;j<larguraTabuleiro;j++){

            for (int i=0;i<larguraTabuleiro;i++){
                if(btns[i][j].getText().equalsIgnoreCase("X")){
                    contX++;
                }else if(btns[i][j].getText().equalsIgnoreCase("O"))
                    contO++;
            }

            if (contO==larguraTabuleiro){
                vitoriasO++;
                vitoriaO.setText("Vitórias: "+vitoriasO);
                iShowWinnerBehaviour.wins(btns,-1,j,-1,-1,"O",vez,larguraTabuleiro);

                return;

            }else if (contX==larguraTabuleiro){
                vitoriasX++;
                vitoriaX.setText("Vitórias: "+vitoriasX);
                iShowWinnerBehaviour.wins(btns,-1,j,-1,-1,"X",vez,larguraTabuleiro);

                return;
            }

            contO=0;
            contX=0;

        }

        for ( int i=0; i<larguraTabuleiro;i++){
            for (int j=0; j< larguraTabuleiro; j++){
                if(i+j==larguraTabuleiro-1)
                    if(btns[i][j].getText().equalsIgnoreCase("X")){
                        contX++;
                    }else if(btns[i][j].getText().equalsIgnoreCase("O"))
                        contO++;

            }
        }

        if (contO==larguraTabuleiro){
            vitoriasO++;
            vitoriaO.setText("Vitórias: "+vitoriasO);
            iShowWinnerBehaviour.wins(btns,-1,-1,-1,1,"O",vez,larguraTabuleiro);

            return;
        }
        else if (contX==larguraTabuleiro){
            vitoriasX++;
            vitoriaX.setText("Vitórias: "+vitoriasX);
            iShowWinnerBehaviour.wins(btns,-1,-1,-1,1,"X",vez,larguraTabuleiro);
            return;

        }

        contO=0;
        contX=0;

        for ( int i=0; i<larguraTabuleiro;i++){
            for (int j=0; j< larguraTabuleiro; j++){
                if(i==j)
                    if(btns[i][j].getText().equalsIgnoreCase("X")){
                        contX++;
                    }else if(btns[i][j].getText().equalsIgnoreCase("O"))
                        contO++;

            }
        }

        if (contO==larguraTabuleiro){
            vitoriasO++;
            vitoriaO.setText("Vitórias: "+vitoriasO);
            iShowWinnerBehaviour.wins(btns,-1,-1,1,-1,"O",vez,larguraTabuleiro);

        }

        else if (contX==larguraTabuleiro){
            vitoriasX++;
            vitoriaX.setText("Vitórias: "+vitoriasX);
            iShowWinnerBehaviour.wins(btns,-1,-1,1,-1,"X",vez,larguraTabuleiro);

        }
    }
}
