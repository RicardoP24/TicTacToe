package TicTacToe.Jogo;

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
    private String modoJogo;

    protected ICheckWinnerBehaviour iCheckWinnerBehaviour;
    protected IvezDe ivezDe;

    public Jogo(boolean vezDe, int tabuleiroSize, int larguraTabuleiro, int vitoriasLimit, int vitoriasX, int vitoriasO, String modoJogo) {

        this.vezDe = vezDe;
        this.tabuleiroSize = tabuleiroSize;
        this.larguraTabuleiro = larguraTabuleiro;
        this.vitoriasLimit = vitoriasLimit;
        this.vitoriasX = vitoriasX;
        this.vitoriasO = vitoriasO;
        this.modoJogo = modoJogo;
        iCheckWinnerBehaviour = new CheckWinnerNormal();
        ivezDe = new VezGeral();



    }

    public void jogar(JButton[] []buttons, JLabel vez, JLabel vitoriasX, JLabel vitoriasO) {


        for (int i = 0; i < larguraTabuleiro; i++) {
            for(int j=0;j < larguraTabuleiro; j++) {

                int finalI = i;
                int finalJ = j;

                buttons[i][j].addActionListener(e-> {
                    if (vezDe) {

                        if (buttons[finalI][finalJ].getText().equals("")) {
                            buttons[finalI][finalJ].setForeground(new Color(255, 0, 0));
                            buttons[finalI][finalJ].setText("X");
                            vezDe = false;
                            vez.setText("Vez do Jogador O");

                            iCheckWinnerBehaviour.check(buttons,vitoriasX,vitoriasO, this.vitoriasX, this.vitoriasO, vez,larguraTabuleiro);
                            if(this.modoJogo.equals("normal") || this.modoJogo.equals("random")) {
                                this.vitoriasX = Integer.parseInt(String.valueOf(vitoriasX.getText().charAt(vitoriasX.getText().length() - 1)));
                            }else{
                                this.vitoriasO = Integer.parseInt(String.valueOf(vitoriasO.getText().charAt(vitoriasO.getText().length() - 1)));
                            }
                        }

                    } else {

                        if (buttons[finalI][finalJ].getText().equals("")) {
                            buttons[finalI][finalJ].setForeground(new Color(0, 0, 255));
                            buttons[finalI][finalJ].setText("O");
                            vezDe = true;
                            vez.setText("Vez do Jogador X");
                            iCheckWinnerBehaviour.check(buttons,vitoriasX,vitoriasO, this.vitoriasX, this.vitoriasO, vez,larguraTabuleiro);
                            if(this.modoJogo.equals("misere")) {
                                this.vitoriasX = Integer.parseInt(String.valueOf(vitoriasX.getText().charAt(vitoriasX.getText().length() - 1)));
                            }else{
                                this.vitoriasO = Integer.parseInt(String.valueOf(vitoriasO.getText().charAt(vitoriasO.getText().length() - 1)));
                            }
                        }
                    }
                }
                );



            }
        }
    }

    public void reiniciar(JButton[][]buttons,JLabel vez,JButton reiniciarButton ){



        reiniciarButton.addActionListener(e -> {
            System.out.println(this.vitoriasX);
            if(this.getVitoriasLimit()<=(this.vitoriasO) || this.getVitoriasLimit()<=(this.vitoriasX)){

                JFrame frame = new JFrame("JOGADOR "+(this.vitoriasX>this.vitoriasO?"X":"O")+" VENCEU");


                JOptionPane.showMessageDialog(frame,
                        "Acabaram-se os limites de vitórias\nDeverá sair do jogo",
                        "JOGADOR "+(this.vitoriasX>this.vitoriasO?"X":"O")+" VENCEU",
                        JOptionPane.INFORMATION_MESSAGE);

                return;
            }
            for (int i=0;i<larguraTabuleiro;i++){
                for (int j=0;j<larguraTabuleiro;j++){
                    buttons[i][j].setEnabled(true);
                    buttons[i][j].setText("");
                    buttons[i][j].setBackground(Color.white);
                }
            }

            vez.setText("Vez do Jogador "+(vezDe?"O":"X"));
        });


    }

    public boolean primeiraVez() {
        return ivezDe.isVezDe();
    }

    public void setModoJogo(String modoJogo) {
        this.modoJogo = modoJogo;
        if ("normal".equals(modoJogo)) {
            iCheckWinnerBehaviour = new CheckWinnerNormal();
            ivezDe = new VezGeral();
        } else if ("random".equals(modoJogo)) {
            iCheckWinnerBehaviour = new CheckWinnerNormal();
            ivezDe = new RandomVez();
        } else if ("misere".equals(modoJogo)) {
            iCheckWinnerBehaviour = new CheckWinnerMisere();
            ivezDe = new VezGeral();
        }
    }
    public void setVezDe(boolean vezDe) {
        this.vezDe = vezDe;
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




}


