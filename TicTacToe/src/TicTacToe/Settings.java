package TicTacToe;

import TicTacToe.Jogo.Jogo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings extends Quadro {

    private JLabel PLAYERS;
    public JPanel mainPanel;

    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton startButton;
    private JRadioButton normalRadioButton;
    private JRadioButton randomTurnRadioButton;
    private JRadioButton misereRadioButton;


    public Settings() {

        ButtonGroup group = new ButtonGroup();

        group.add(misereRadioButton);
        group.add(randomTurnRadioButton);
        group.add(normalRadioButton);

        final int[] tabuleiro = {9};
        final boolean[] vezDe = {false};
        final int[] victoria = {1};
        group.setSelected(normalRadioButton.getModel(),true);

        Jogo jogo=new Jogo(false,9,3,1,0,0,"normal");
        String[] tabulSizes = { "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" };
        String[] vitorias = { "1", "2", "3", "4", "5", "6", "7" };

        for (int i=0;i<tabulSizes.length;i++){
            comboBox1.addItem(tabulSizes[i]);
        }

        for (int i=0;i<vitorias.length;i++){
            comboBox2.addItem(vitorias[i]);
        }

        mainPanel.setSize(1650,1080);
        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(0);

        normalRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.setSelected(normalRadioButton.getModel(),true);
                jogo.setModoJogo("normal");
            }
        });

        randomTurnRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.setSelected(randomTurnRadioButton.getModel(),true);
                jogo.setModoJogo("random");
            }
        });

        misereRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.setSelected(misereRadioButton.getModel(),true);
                jogo.setModoJogo("misere");
            }
        });

         comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String size = (String)cb.getSelectedItem();
                assert size != null;
                int Tabuleiro = Integer.parseInt(String.valueOf(size.charAt(0)));
                jogo.setLarguraTabuleiro(Tabuleiro);
                jogo.setTabuleiroSize((int)Math.pow(Tabuleiro,2));
              }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String vitoria = (String)cb.getSelectedItem();
                assert vitoria != null;
                jogo.setVitoriasLimit(Integer.parseInt(vitoria));
              }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.super.mudarQuadro("TicTacToe", jogo);

            }
        });

    }






}
