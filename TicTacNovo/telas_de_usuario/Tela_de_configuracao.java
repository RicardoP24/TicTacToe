package TicTacToe.telas_de_usuario;

import TicTacToe.Jogo.Jogabilidade;
import TicTacToe.Jogo.ControladorDeTela;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_de_configuracao extends ControladorDeTela {

    public JPanel painelMain;
    private JSpinner spinnerDeVitorias;
    private JButton start;
    private JComboBox lxc;
    private JRadioButton normal;
    private JRadioButton misere;
    private JRadioButton random;
    private JLabel tabulWidth;
    private JLabel vitorias;
    private JLabel Players;

    public Tela_de_configuracao(ControladorDeTela tl) {

        ButtonGroup group = new ButtonGroup();

        group.add(misere);
        group.add(random);
        group.add(normal);

        group.setSelected(normal.getModel(),true);

        Jogabilidade jogabilidade = new Jogabilidade(9,3,1,0,0,"normal");

        String[] tabulSizes = { "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" };

        for (int i=0;i<tabulSizes.length;i++){
            lxc.addItem(tabulSizes[i]);
        }

        spinnerDeVitorias.setModel(new SpinnerNumberModel(1, 1, 7, 1));

        normal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.setSelected(normal.getModel(),true);
                jogabilidade.config_game_type("normal");
            }
        });

        misere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.setSelected(misere.getModel(),true);
                jogabilidade.config_game_type("misere");
            }
        });

        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                group.setSelected(random.getModel(),true);
                jogabilidade.config_game_type("random");
            }
        });

        lxc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox cb = (JComboBox)e.getSource();
                String size = (String)cb.getSelectedItem();
                assert size != null;
                int Tabuleiro = Integer.parseInt(String.valueOf(size.charAt(0)));
                jogabilidade.setWidthTabul(Tabuleiro);
                jogabilidade.setTamanhoDoTab((int)Math.pow(Tabuleiro,2));

            }
        });

        spinnerDeVitorias.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                JSpinner s = (JSpinner)e.getSource();
                String size = s.getValue().toString();
                assert size!=null;
                jogabilidade.setVitoriassize(Integer.parseInt(size));

            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tl.mudarDeTela("TicTac", jogabilidade,tl);

            }
        });

    }


}
