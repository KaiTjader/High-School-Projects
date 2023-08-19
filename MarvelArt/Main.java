import javax.swing.JFrame;

public class Main
{
   public static void main(String[] args)
   {
      //Constuct a frame
      JFrame frame = new JFrame();
      frame.setLocation(900,0);
      frame.setSize(1000,800);
      frame.setTitle("Buckets");
      frame.setVisible(true);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Setup());
   }
}