package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends Quadro {
    private JLabel vitoriasX;
    private JLabel vitoriasO;
    private JLabel vez;
    public JPanel mainPanel;
    private JButton sairButton;
    private JButton reiniciarButton;
    private JPanel btnPanel;
    JButton [] [] buttons;
    public TicTacToe(Jogo jogo) {

        int lxc=jogo.getLarguraTabuleiro();
        buttons = new JButton[lxc][lxc];

        btnPanel.setLayout(new GridLayout(lxc,lxc));
        btnPanel.setBackground(new Color(255,255,255));
        vez.setText("VEZ DO JOGADOR: "+ (jogo.isVezDe()?"X":"O"));

        for(int i=0;i<lxc;i++) {

            for(int j=0; j<lxc;j++){

                buttons[i][j] = new JButton();
                btnPanel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("Pepsi",Font.BOLD,360/lxc));
                buttons[i][j].setFocusable(false);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(new Color(80, 80, 77), 3));
                buttons[i][j].setBackground(new Color(255, 255, 255));
            }

        }

        jogo.clicarBtn(buttons,vez,vitoriasX,vitoriasO);
        jogo.reiniciar(buttons,vez,reiniciarButton);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToe.super.mudarQuadro("Definições",jogo);

            }
        });
    }


    }








