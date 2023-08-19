import javax.swing.JFrame;

public class BirdMain
{
   public static void main(String[] args)
   {
      //Constuct a frame
      JFrame frame = new JFrame();
      frame.setLocation(900,0);
      frame.setSize(800,800);
      frame.setTitle("BirdBath");
      frame.setVisible(true);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Build());
   }
}