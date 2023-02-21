package TicTacToe.telas_de_usuario;

import TicTacToe.Jogo.Jogabilidade;
import TicTacToe.Jogo.ControladorDeTela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_de_tic_tac_toe extends Container {
    public JPanel painelMain;
    private JButton reiniciarButton;
    private JButton ButtonSair;
    private JLabel VitoriasJogadorX;
    private JLabel VitoriasJogadorO;
    private JPanel Painel_de_botoes;
    private JLabel vez;

    JButton [] [] botoesDaTela;

    public Tela_de_tic_tac_toe(Jogabilidade jogo, ControladorDeTela tl) {

        int lxc=jogo.getWidthTabul();
        botoesDaTela = new JButton[lxc][lxc];

        Painel_de_botoes.setLayout(new GridLayout(lxc,lxc));
        Painel_de_botoes.setBackground(new Color(255,255,255));
        vez.setText("JOGADOR: "+ (jogo.primeiraVez()?"X":"O"));
        jogo.SetTurn(jogo.primeiraVez());

        for(int i=0;i<lxc;i++) {

            for(int j=0; j<lxc;j++){

                botoesDaTela[i][j] = new JButton();
                Painel_de_botoes.add(botoesDaTela[i][j]);
                botoesDaTela[i][j].setFont(new Font("Pepsi",Font.BOLD,360/lxc));
                botoesDaTela[i][j].setFocusable(false);
                botoesDaTela[i][j].setBorder(BorderFactory.createLineBorder(new Color(80, 80, 77), 3));
                botoesDaTela[i][j].setBackground(new Color(255, 255, 255));
            }

        }

        jogo.PreencherTabuleiro(botoesDaTela,vez, VitoriasJogadorX, VitoriasJogadorO);

        jogo.reiniciar(botoesDaTela,vez,reiniciarButton);

        ButtonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ControladorDeTela().mudarDeTela("Tela de Configurações",jogo,tl);
            }
        });
    }


}

