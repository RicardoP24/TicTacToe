package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class Quadro {

     private JFrame frame;


     public void mudarQuadro(String title, Jogo jogo){
          fecharQuadro();

          frame = new JFrame(title);
          frame.setVisible(false);
          frame.dispose();

          Toolkit tk=Toolkit.getDefaultToolkit();
          int xSize=(int ) tk.getScreenSize().getWidth();
          int ySize= (int) tk.getScreenSize().getHeight();
          frame.setSize(xSize,ySize-50);
          if(title.equals("Definições"))
               frame.setContentPane(new Settings().mainPanel);
          else
               frame.setContentPane(new TicTacToe(jogo).mainPanel);

          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
     }
     public void abrirQuadro(String title) {

          frame = new JFrame(title);
          Toolkit tk=Toolkit.getDefaultToolkit();
          int xSize=(int ) tk.getScreenSize().getWidth();
          int ySize= (int) tk.getScreenSize().getHeight();
          frame.setSize(xSize,ySize-50);
          frame.setContentPane(new Settings().mainPanel);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
     }
     public void fecharQuadro() {

          if(frame!=null) {
               frame.setVisible(false);
               frame.dispose();
          }

     }
}
