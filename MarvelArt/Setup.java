import javax.swing.JPanel;
import java.awt.Graphics;

public class Setup extends JPanel
{
   public void paintComponent(Graphics g)
   {
      Item item = new Item(); 

      item.drawBackround(g); 
      item.drawTower(0,0,g);  
      item.drawCap(0,28,g);
      item.drawSheild(333,553,g);
      item.drawHammer(154,513,g);
      item.drawIronman(g);
      item.drawThanos(g);
   }
}