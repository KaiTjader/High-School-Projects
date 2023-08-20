package MoneyClicker;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

class MoneyMain {
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    // frame.setSize(480,360);
  
    frame.setSize(475, 400); // length height
    frame.setLocation(0, 0);
    frame.setTitle("Money Clicker");
   
    JLabel background = new JLabel(new 
    ImageIcon("trees.jpg"));
    frame.add(background);
        background.setLayout(new FlowLayout());

    
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// JFrame.DO_NOTHING_ON_CLOSE

    
    frame.setContentPane(new MoneySetup());
    frame.setVisible(true);
  }
}