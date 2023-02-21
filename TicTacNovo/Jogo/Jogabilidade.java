package TicTacToe.Jogo;

import TicTacToe.vencedores.existencia_de_vencedor.existe_vencedor_misere;
import TicTacToe.vencedores.existencia_de_vencedor.existe_vencedor_normal;
import TicTacToe.vencedores.existencia_de_vencedor.existencia_de_vencedor;

import javax.swing.*;
import java.awt.*;

public class Jogabilidade {

    private boolean vezDe;
    private int tamanhoDoTab;
    private int widthTabul;
    private int qtdVitorias;
    private int jogadorXWins;
    private int jogadorOWins;
    private String modoDeJogo;
    protected existencia_de_vencedor existencia_de_vencedor;



    public Jogabilidade(int tamanhoDoTab, int widthTabul, int qtdVitorias, int jogadorXWins, int jogadorOWins, String modoDeJogo){


        this.tamanhoDoTab = tamanhoDoTab;
        this.widthTabul = widthTabul;
        this.qtdVitorias = qtdVitorias;
        this.jogadorXWins = jogadorXWins;
        this.jogadorOWins = jogadorOWins;
        this.modoDeJogo = modoDeJogo;
        existencia_de_vencedor = new existe_vencedor_normal();

    }

    public void PreencherTabuleiro(JButton[] []buttons, JLabel v, JLabel vitoriasX, JLabel vitoriasO){

        for (int i = 0; i < widthTabul; i++) {
            for(int j = 0; j < widthTabul; j++) {

                int finalI = i;
                int finalJ = j;

                buttons[i][j].addActionListener(e-> {

                    if(this.jogadorOWins == qtdVitorias || this.jogadorXWins == qtdVitorias){

                        for (int k = 0; k< widthTabul; k++){
                            for (int l = 0; l< widthTabul; l++){
                                buttons[k][l].setEnabled(false);
                            }
                        }

                        JFrame frame = new JFrame("JOGADOR "+(this.jogadorXWins >this.jogadorOWins ?"X":"O")+" VENCEU");


                        JOptionPane.showMessageDialog(frame,
                                "Jogo Encerrado!",
                                "JOGADOR "+(this.jogadorXWins >this.jogadorOWins ?"X":"O")+" VENCEU",
                                JOptionPane.INFORMATION_MESSAGE);

                        return;

                    }
                            if (vezDe) {

                                if (buttons[finalI][finalJ].getText().equals("")) {

                                    buttons[finalI][finalJ].setForeground(new Color(25, 14, 66));
                                    buttons[finalI][finalJ].setText("X");
                                    vezDe = false;
                                    v.setText("Jogador O");

                                    existencia_de_vencedor.check(buttons,vitoriasX,vitoriasO, this.jogadorXWins, this.jogadorOWins, v, widthTabul);

                                    if(this.modoDeJogo.equals("normal") || this.modoDeJogo.equals("random")) {

                                        this.jogadorXWins = Integer.parseInt(String.valueOf(vitoriasX.getText().charAt(vitoriasX.getText().length() - 1)));

                                    }else{

                                        this.jogadorOWins = Integer.parseInt(String.valueOf(vitoriasO.getText().charAt(vitoriasO.getText().length() - 1)));

                                    }
                                }

                            } else {

                                if (buttons[finalI][finalJ].getText().equals("")) {
                                    buttons[finalI][finalJ].setForeground(new Color(40, 0, 0));
                                    buttons[finalI][finalJ].setText("O");
                                    vezDe = true;
                                    v.setText("Jogador X");
                                    existencia_de_vencedor.check(buttons,vitoriasX,vitoriasO, this.jogadorXWins, this.jogadorOWins, v, widthTabul);
                                    if(this.modoDeJogo.equals("misere")) {
                                        this.jogadorXWins = Integer.parseInt(String.valueOf(vitoriasX.getText().charAt(vitoriasX.getText().length() - 1)));
                                    }else{
                                        this.jogadorOWins = Integer.parseInt(String.valueOf(vitoriasO.getText().charAt(vitoriasO.getText().length() - 1)));
                                    }
                                }
                            }
                        }
                );



            }
        }

    }

    public void reiniciar(JButton[][]buttons,JLabel vez,JButton reniciarButton ){

        reniciarButton.addActionListener(e -> {
            System.out.println(this.jogadorXWins);
            if(this.getQtdVitorias()<=(this.jogadorOWins) || this.getQtdVitorias()<=(this.jogadorXWins)){

                JFrame frame = new JFrame("JOGADOR "+(this.jogadorXWins >this.jogadorOWins ?"X":"O")+" VENCEU");


                JOptionPane.showMessageDialog(frame,
                        "O Jogo Acabou! Deve sair do jogo.",
                        "JOGADOR "+(this.jogadorXWins >this.jogadorOWins ?"X":"O")+" VENCEU",
                        JOptionPane.INFORMATION_MESSAGE);

                return;
            }
            for (int i = 0; i< widthTabul; i++){
                for (int j = 0; j< widthTabul; j++){
                    buttons[i][j].setEnabled(true);
                    buttons[i][j].setText("");
                    buttons[i][j].setBackground(Color.white);
                }
            }

            vez.setText("Vez do Jogador "+(vezDe ?"O":"X"));
        });


    }

    public boolean primeiraVez() {

        if(this.modoDeJogo.equals("random")){
            this.vezDe =Math.random() < 0.5;
        }else
            this.vezDe =true;

        return this.vezDe;
    }

    public void config_game_type(String modoJogo) {
        this.modoDeJogo = modoJogo;
        if ("normal".equals(modoJogo)) {
            existencia_de_vencedor = new existe_vencedor_normal();
        } else if ("random".equals(modoJogo)) {
            existencia_de_vencedor = new existe_vencedor_normal();
            this.vezDe =primeiraVez();
        } else if ("misere".equals(modoJogo)) {
            existencia_de_vencedor = new existe_vencedor_misere();
        }
    }

    public void SetTurn(boolean turn) {
        this.vezDe = turn;
    }


    public void setTamanhoDoTab(int tamanhoDoTab) {
        this.tamanhoDoTab = tamanhoDoTab;
    }

    public int getWidthTabul() {

        return widthTabul;
    }

    public void setWidthTabul(int widthTabul) {

        this.widthTabul = widthTabul;
    }

    public int getQtdVitorias() {

        return qtdVitorias;
    }

    public void setVitoriassize(int vitoriassize) {

        this.qtdVitorias = vitoriassize;
    }


}
