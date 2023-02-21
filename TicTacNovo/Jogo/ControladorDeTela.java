package TicTacToe.Jogo;

import TicTacToe.telas_de_usuario.Tela_de_tic_tac_toe;
import TicTacToe.telas_de_usuario.Tela_de_configuracao;

import javax.swing.*;
import java.awt.*;

public class ControladorDeTela {

    private JFrame tela_atual;

    public void mudarDeTela(String title, Jogabilidade jogabilidade, ControladorDeTela tl){

        fecharTela(tl);

        tl.tela_atual = new JFrame(title);
        tl.tela_atual.dispose();

        Toolkit tk=Toolkit.getDefaultToolkit();
        int xSize=(int ) tk.getScreenSize().getWidth();
        int ySize= (int) tk.getScreenSize().getHeight();
        tl.tela_atual.setSize(xSize,ySize-50);
        if(title.equals("Tela de Configurações")) {
            tl.tela_atual.setSize(xSize,ySize-50);
            tl.tela_atual.setContentPane(new Tela_de_configuracao(tl).painelMain);
        }else
            tl.tela_atual.setContentPane(new Tela_de_tic_tac_toe(jogabilidade,tl).painelMain);

        tl.tela_atual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tl.tela_atual.setVisible(true);
    }

    public void abrirTela(String title, ControladorDeTela tl) {

        tl.tela_atual = new JFrame(title);
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xSize=(int ) tk.getScreenSize().getWidth();
        int ySize= (int) tk.getScreenSize().getHeight();
        tl.tela_atual.setSize(xSize,ySize-50);
        tl.tela_atual.setContentPane(new Tela_de_configuracao(tl).painelMain);
        tl.tela_atual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tl.tela_atual.setVisible(true);
    }

    public void fecharTela(ControladorDeTela tl) {

        if(tl.tela_atual !=null) {
            tl.tela_atual.setVisible(false);
            tl.tela_atual.dispose();
        }

    }

}
