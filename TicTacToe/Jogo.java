package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jogo {

    private boolean vezDe;
    private int tabuleiroSize;
    private int larguraTabuleiro;
    private int vitoriasLimit;
    private int vitoriasX;
    private int vitoriasO;


    public Jogo(boolean vezDe, int tabuleiroSize, int larguraTabuleiro, int vitoriasLimit, int vitoriasX, int vitoriasO) {
        this.vezDe = vezDe;
        this.tabuleiroSize = tabuleiroSize;
        this.larguraTabuleiro = larguraTabuleiro;
        this.vitoriasLimit = vitoriasLimit;
        this.vitoriasX = vitoriasX;
        this.vitoriasO = vitoriasO;
    }

    public void clicarBtn(JButton[] []buttons, JLabel vez, JLabel vitoriasX,JLabel vitoriasO) {

        for (int i = 0; i < larguraTabuleiro; i++) {
            for(int j=0;j < larguraTabuleiro; j++) {

                int finalI = i;
                int finalJ = j;

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (vezDe) {

                            if (buttons[finalI][finalJ].getText().equals("")) {
                                buttons[finalI][finalJ].setForeground(new Color(255, 0, 0));
                                buttons[finalI][finalJ].setText("X");
                                vezDe = false;
                                vez.setText("Vez do Jogador O");
                                check(buttons,vitoriasX,vitoriasO,vez);
                            }

                        } else {
                            if (buttons[finalI][finalJ].getText().equals("")) {
                                buttons[finalI][finalJ].setForeground(new Color(0, 0, 255));
                                buttons[finalI][finalJ].setText("O");
                                vezDe = true;
                                vez.setText("Vez do Jogador X");
                                check(buttons,vitoriasX,vitoriasO,vez);

                            }
                        }
                    }
                }
                );

            }
        }
    }

    public void reiniciar(JButton[][]buttons,JLabel vez,JButton reiniciarButton ){

        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<larguraTabuleiro;i++){
                    for (int j=0;j<larguraTabuleiro;j++){
                        buttons[i][j].setEnabled(true);
                        buttons[i][j].setText("");
                        buttons[i][j].setBackground(Color.white);
                    }
                }

                vez.setText("Vez do Jogador "+(isVezDe()?"X":"O"));
            }
        });


    }
    private void check(JButton [][] btns, JLabel vitoriaX,JLabel vitoriaO,JLabel vez){
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
                this.setVitoriasO(this.getVitoriasO()+1);
                vitoriaO.setText("Vitórias: "+this.getVitoriasO());
                Wins(btns,i,-1,-1,-1,"O",vez);
                return;

            }else if (contX==larguraTabuleiro){
                this.setVitoriasX(this.getVitoriasX()+1);
                vitoriaX.setText("Vitórias: "+this.getVitoriasX());
                Wins(btns,i,-1,-1,-1,"X",vez);

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
                this.setVitoriasO(this.getVitoriasO()+1);
                vitoriaO.setText("Vitórias: "+this.getVitoriasO());
                Wins(btns,-1,j,-1,-1,"O",vez);

                return;

            }else if (contX==larguraTabuleiro){
                this.setVitoriasX(this.getVitoriasX()+1);
                vitoriaX.setText("Vitórias: "+this.getVitoriasX());
                Wins(btns,-1,j,-1,-1,"X",vez);

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
            this.setVitoriasO(this.getVitoriasO()+1);
            vitoriaO.setText("Vitórias: "+this.getVitoriasO());
            Wins(btns,-1,-1,-1,1,"O",vez);

            return;
        }
        else if (contX==larguraTabuleiro){
            this.setVitoriasX(this.getVitoriasX()+1);
            vitoriaX.setText("Vitórias: "+this.getVitoriasX());
            Wins(btns,-1,-1,-1,1,"X",vez);

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
            this.setVitoriasO(this.getVitoriasO()+1);
            vitoriaO.setText("Vitórias: "+this.getVitoriasO());
            Wins(btns,-1,-1,1,-1,"O",vez);

        }
        else if (contX==larguraTabuleiro){
            this.setVitoriasX(this.getVitoriasX()+1);
            vitoriaX.setText("Vitórias: "+this.getVitoriasX());
            Wins(btns,-1,-1,1,-1,"X",vez);


        }

    }
    private void Wins(JButton[][]btns, int l,int c, int p, int s, String winner, JLabel vez) {


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



    public boolean isVezDe() {
        return vezDe;
    }


    public int getTabuleiroSize() {
        return tabuleiroSize;
    }

    public void setTabuleiroSize(int tabuleiroSize) {
        this.tabuleiroSize = tabuleiroSize;
    }

    public int getLarguraTabuleiro() {
        return larguraTabuleiro;
    }

    public void setLarguraTabuleiro(int larguraTabuleiro) {
        this.larguraTabuleiro = larguraTabuleiro;
    }

    public int getVitoriasLimit() {
        return vitoriasLimit;
    }

    public void setVitoriasLimit(int vitoriasLimit) {
        this.vitoriasLimit = vitoriasLimit;
    }

    public int getVitoriasX() {
        return vitoriasX;
    }

    public void setVitoriasX(int vitoriasX) {
        this.vitoriasX = vitoriasX;
    }

    public int getVitoriasO() {
        return vitoriasO;
    }

    public void setVitoriasO(int vitoriasO) {
        this.vitoriasO = vitoriasO;
    }


}


