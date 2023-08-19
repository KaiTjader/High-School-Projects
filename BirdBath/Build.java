//import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Build extends JPanel
{
   public void paintComponent(Graphics g)
   {
//       //Polygon.....array
//       int [] xPoints = {200,500,500,200};
//       int [] yPoints = {200,400,200,400};
//       
//       g.drawPolygon(xPoints,yPoints,4);
      
      //int [] xPoints = {};
      //int [] yPoints = {};
      
      //backround
      Color sky = new Color(76, 130, 230);
      g.setColor(sky);
      g.fillRect(0,0,800,475);
      Color grass = new Color(136, 207, 74);
      g.setColor(grass);
      g.fillRect(0,475,800,300);
      g.setColor(Color.BLACK);
      
      //bath
      Color bath = new Color(89, 89, 89);
      g.setColor(bath);
      g.fillRect(375,500,75,200);
      g.fillOval(340,450,150,75);
      
      //bird pic
      ImageIcon bird = new ImageIcon("Bird.jpg");
      g.drawImage(bird.getImage(),375,425,50,50,null);
      
      //bird text
      g.setColor(Color.RED.brighter());
      g.setFont(new Font("Pacifico",Font.BOLD,20));
      g.drawString("BIRD",375,100);
      
      //Arrow
      g.drawLine(400,150,400,375);
      g.drawLine(400,375,375,350);
      g.drawLine(400,375,425,350);
      
      //packman
      g.setColor(Color.YELLOW);
      g.fillArc(50,500,200,200,0,200);
   }    
}
