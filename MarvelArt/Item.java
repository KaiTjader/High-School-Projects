import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Item
{
   Color aTower = new Color(123,156,169);  //main color
   Color aTower2 = new Color(8,96,168);
   Color aTower3 = new Color(190,190,190); //line color
   Color aTower4 = new Color(29,41,81);
   Color aTower5 = new Color(71,78,90);   //darker grey on tower
   Color aTower6 = new Color(17,30,108);
   Color aA = new Color(126,249,255);   
   Color shade = new Color(211,211,211);
   Color jet = new Color(192,192,192);   //iron mans jet color
   Color skin = new Color(255,224,189);
   Color capRed = new Color(255,38,38);
   Color capWhite = new Color(233,233,233);
   Color capBlue = new Color(50,19,170);
   Color capEye = new Color(95,195,245);
   Color capWhiteSheild = new Color(218,218,218);
   Color hammer = new Color(225,225,225);
   Color hammer2 = new Color(152,152,152);
   Color hammer3 = new Color(142, 91, 54);
   Color hammer4 = new Color(118,118,118);
   Color hammer5 = new Color(95,95,35);
   Color hammer6 = new Color(230,238,0);
   Color hammer7 = new Color(129,59,9);
   Color lightning = new Color(100,200,250);
   Color mainWater = new Color(170,230,255);
   Color sideWater = new Color(130,200,255);
   Color mainWatDet = new Color(80,190,220);

   public void drawStar(int n,int y,Graphics g)
   {
      
     //                   1      2        3       4       5       6       7       8      9      10
      int [] xPoints = {n+25+2,n+25+18,n+25+26,n+25+34,n+25+51,n+25+38,n+25+43,n+25+26,n+25+10,n+25+15};
      int [] yPoints = {y-17+60,y-17+60,y-17+42,y-17+60,y-17+60,y-17+72,y-17+89,y-17+80,y-17+90,y-17+72};
     //                    1     2        3       4       5       6       7       8      9      10
      g.fillPolygon(xPoints,yPoints,10);
   }
   public void drawSheild(int x,int y,Graphics g)
   {
      //First Circle
      g.setColor(capRed);
      g.fillOval(x,y,100,100);
      g.setColor(Color.BLACK);
      g.drawOval(x,y,100,100);
      //Second Circle +8 -15
      g.setColor(capWhiteSheild);
      g.fillOval(x+8,y+8,85,85);
      //Third Circle +16 -15
      g.setColor(capRed);
      g.fillOval(x+16,y+16,70,70);
      //Forth Circle +25 -17
      g.setColor(capBlue);
      g.fillOval(x+25,y+25,53,53);
      //Star
      g.setColor(capWhiteSheild);
      drawStar(x,y,g);     
   }   
   public void drawTower(int x,int y,Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      //Tower base
      g.setColor(aTower);
      //               1    2     3   4    5    6     7     8    9      10    11    12   13    14     15   16    17    18    19
      int [] xTower = {0+x,15+x,40+x,55+x,62+x,72+x,168+x,165+x,155+x,160+x,127+x,120+x,153+x,215+x,217+x,200+x,153+x,97+x,168+x}; //94(18)
      int [] yTower = {800+y,200+y,204+y,265+y,265+y,304+y,311+y,316+y,350+y,354+y,365+y,377+y,386+y,386+y,389+y,392+y,393+y,410+y,800+y};
      //                1     2     3     4      5     6    7     8      9    10     11   12    13    14    15     16   17    18    19
      g.fillPolygon(xTower,yTower,19);
      for (int c=0;c<35;c++)
      {
         g.drawArc(36-c,388,275,570,100,47);
      }
      //A tower detail      
      g.setColor(aTower4); //blue base
      int [] xtdetail = {65,165,155,160,127,120,120,65};
      int [] ytdetail = {315,315,350,354,365,377,386,386};
      g.fillPolygon(xtdetail,ytdetail,8);
      
      g.setColor(aTower4);
      g.fillOval(30,314,80,80); //1
      g.setColor(aTower3);
      g.drawArc(30,314,80,80,99,140);
      g.setColor(aTower3);
      g.fillOval(38,322,64,64); //2
      g.setColor(aTower4);
      g.fillOval(41,325,58,58); //3
      g.setColor(aTower);
      g.fillRect(45,386,50,10);
      
      g.setColor(aTower5); //grey base
      int [] xtdetail2 = {120,160,127,120,153,100};
      int [] ytdetail2 = {354,354,365,377,386,386};
      g.fillPolygon(xtdetail2,ytdetail2,6);
      g.setColor(Color.BLACK);
      g.drawLine(120,377,114,386);
      
      g.setColor(aTower3); //light grey base
      int [] xtdetail3 = {120,115,88,75};
      int [] ytdetail3 = {386,381,381,386};
      g.fillPolygon(xtdetail3,ytdetail3,4);
      
      g.setColor(aTower5); //bottom grey base
      int [] xtdetail5 = {214,219,186,150,150};
      int [] ytdetail5 = {386,390,393,393,386};
      g.fillPolygon(xtdetail5,ytdetail5,5);
      
      g.setColor(aTower6); //lower blue base
      int [] xtdetail6 = {30,35,38,49,76,135};
      int [] ytdetail6 = {800,685,600,525,475,800};
      g.fillPolygon(xtdetail6,ytdetail6,6);
      
      g.setColor(aTower3);
      g.drawLine(100,359,142,359);
      g.drawLine(97,367,125,367);
      g.drawLine(90,375,120,375);
      
      g.drawLine(64,315,165,315);
      for(int l=0;l<56;l+=14)
      {
         g.drawLine(105+l,315,105+l,354);
      }
      g.drawLine(75,323,162,323);
      g.drawLine(90,330,160,330);
      g.drawLine(95,337,158,337);
      g.drawLine(99,344,156,344);
      
      //A on tower
      g.setColor(aA);
      String fontPath = "2ndAFont.ttf";
      try{
         File file = new File(fontPath);
         FileInputStream is = new FileInputStream(file);
         //FileInputStream iinputStream = new FileInputStream(file);
         Font font = Font.createFont(Font.TRUETYPE_FONT, is);  //is
         Font biggerFont = font.deriveFont(55f);
         g.setFont(biggerFont);
      }
      catch (Exception e){
         System.out.println("Error:" + e);
      }
      g.drawString("A",49,370 );
      
      //More tower detal
      g.setColor(aTower3);
      g.drawLine(55,265,61,295);
      g2.setStroke(new BasicStroke(2));
      g.drawLine(30,203,46,291);
      g.drawLine(168,311,60,304);
      g.drawArc(47,281,22,22,173,105);
      g2.setStroke(new BasicStroke(1));
      g.drawArc(61,277,22,27,190,73);
      
      int l3 = 0;
      int l4 = 0;
      for (int l2=0;l2<72;l2+=12)
      {
         l3 += 2;
         if(l2 < 48)
         {
            l4 -= 1;
         }
         l4 += 2;
         g.drawLine(31+l3,216+l2,38+l3+l4,216+l2);
      }
      g.drawLine(46,288,59,288);
      g.drawLine(57,275,63,275);
      g.drawLine(61,290,67,290);
      
      g.drawLine(16,213,31,213); //1
      g.drawLine(15,232,34,232); //2
      g.drawLine(14,250,38,250); //3
      g.drawLine(13,268,41,268); //4
      g.drawLine(13,286,45,286); //5
      g.drawLine(13,303,58,303); //6
      g.drawLine(12,319,48,319); //7
      g.drawLine(12,340,33,340); //8
      g.drawLine(11,362,31,362); //9
      
      int l6 = 0;
      for (int l5=0;l5<100;l5 += 20)
      {
         g.drawLine(60+l5,303-l6,60+l5,315);
         l6 -= 2;
         if(l5 >= 60)
         {
            l6 += 1;
         }
      }
      g.drawLine(25,386,25,800);   //1
      g.drawLine(50,386,50,533);   //2
      g.drawLine(75,386,75,465);   //3
      g.drawLine(100,386,100,433); //4
      g.drawLine(125,386,125,405); //5
      g.drawLine(150,386,150,390); //6
      
      g2.setStroke(new BasicStroke(3));
      g2.drawLine(12,386,150,386);
      g2.setStroke(new BasicStroke(1));
      
      g.setColor(aTower3);
      g.drawLine(11,388,150,388); //1
      g.drawLine(10,413,115,413); //2
      g.drawLine(9,438,95,438); //3
      g.drawLine(9,463,75,463); //4
      g.drawLine(8,488,65,488); //5
      g.drawLine(7,513,60,513); //6
      g.drawLine(7,538,50,538); //7
      g.drawLine(6,563,48,563); //8
      g.drawLine(6,588,40,588); //9
      g.drawLine(5,613,35,613); //10
      g.drawLine(4,638,33,638); //11
      g.drawLine(4,663,33,663); //12
      g.drawLine(3,688,33,688); //13
      g.drawLine(2,713,33,713); //14
      g.drawLine(2,738,33,738); //15
      g.drawLine(2,763,150,763); //16
      
      g.setColor(aTower3);
      g.fillRect(35,600,3,200); //1
      g.fillRect(43,580,3,220); //2
      g.fillRect(51,540,3,260); //3
      g.fillRect(59,515,3,270); //4
      g.fillRect(67,490,3,325); //5
      g.fillRect(75,480,3,325); //6
      g.fillRect(83,478,3,325); //7
      g.fillRect(91,500,3,300); //8
      g.fillRect(99,500,3,300); //9
      g.fillRect(107,500,3,300); //10
      g.fillRect(115,525,3,275); //11
      g.fillRect(123,700,3,100); //12
      
      g2.setStroke(new BasicStroke(2));
      g.setColor(aTower3);
      g.drawLine(70,475,80,475); //1
      g.drawLine(60,515,87,515); //2
      g.drawLine(50,555,101,555); //3
      g.drawLine(40,595,108,595); //4
      g.drawLine(40,635,115,635); //5
      g.drawLine(35,675,122,675); //6
      g.drawLine(35,715,129,715); //7
      g.drawLine(35,755,136,755); //8
      g2.setStroke(new BasicStroke(2));
      
      g.setColor(aTower5);
      int xArc [] = {133,75,101,168};
      int yArc [] = {800,470,430,800};
      g.fillPolygon(xArc,yArc,4);
      g.setColor(aTower3);
      int xArc2 [] = {148,85,91,158};
      int yArc2 [] = {800,455,438,800};
      g.fillPolygon(xArc2,yArc2,4);
      g.setColor(aTower3);
      int a2 = 0;
      for(int a=0;a<352;a += 32)
      {
         g.drawLine(94+a2,448+a,105+a2,448+a);
         a2 += 5;
         if(a >= 96)
         {
            a2 += 1;
         }
         if((a/2)*2 == a)
         {
            a += 1;
         }
      }
      g.setColor(Color.BLACK);
      int xArc3 [] = {133,75,101,168};
      int yArc3 [] = {800,470,428,800};
      g.drawPolygon(xArc3,yArc3,4);
      
      //main Arc
      g.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(2));
      g.drawArc(36,388,275,570,99,85);
      g.setColor(aTower3);
      g2.setStroke(new BasicStroke(4));
      g.drawArc(33,386,275,570,99,85);
      g.drawLine(33,690,33,800);
      g.setColor(Color.BLACK);
      g2.setStroke(new BasicStroke(2));
      g.drawArc(32,384,275,570,98,86);
      g.drawLine(32,690,32,800);
      g.drawLine(36,690,36,800);
      g.drawOval(151,389,1,1);
      g.drawLine(150,385,150,390);
      g.drawLine(152,385,152,389);
      g2.setStroke(new BasicStroke(1));
      
      g.setColor(aTower3);
      int [] xTower2 = {100,100,155,161};
      int [] yTower2 = {354,350,350,354};
      g.fillPolygon(xTower2,yTower2,4); 
      g.setColor(Color.BLACK);   
      g.drawLine(105,354,160,354);
            
   }
   public void drawCap(int x, int y,Graphics g)
   {
   
      g.setColor(capBlue); //top half
      int xSuit [] = {260,385,370,275};
      int ySuit [] = {537+y,537+y,615+y,615+y};
      g.fillPolygon(xSuit,ySuit,4);
      g.fillArc(250,533+y,55,35,50,100); //shoulder 
      //masks ears
      g.setColor(capWhite);
      int xEars [] = {285,270,280,295};
      int yEars [] = {455+y,470+y,485+y,470+y};//455,465,480,470
      g.fillPolygon(xEars,yEars,4);
      int xEars2 [] = {360,350,366,375};
      int yEars2 [] = {455+y,470+y,484+y,470+y};
      g.fillPolygon(xEars2,yEars2,4);
      g.setColor(Color.BLACK);
      //left ear lines
      g.drawLine(279,460+y,292,477+y);
      g.drawLine(274,463+y,286,482+y);
      //right ear lines
      g.drawLine(366,460+y,353,476+y);
      g.drawLine(372,462+y,357,482+y);
      //head
      g.setColor(skin);
      g.fillOval(271,495+y,10,23); //ears
      g.fillOval(364,495+y,10,23);
      g.setColor(Color.BLACK);
      g.drawLine(270,495+y,285,510);
      g.drawLine(375,495+y,362,510);
      g.setColor(capBlue);
      g.fillOval(275,450+y,95,95); //head
      g.setColor(skin);
      g.fillArc(275,450+y,95,95,222,100);
      g.setColor(capBlue);
      //               1   2   3   4   5   6   7
      int xMask [] = {288,288,292,322,355,359,359};
      int yMask [] = {495+y,530+y,520+y,510+y,520+y,530+y,495+y};
      g.fillPolygon(xMask,yMask,7);
      g.setColor(capWhite);
      g.setFont(new Font("Arial",Font.BOLD,35));
      g.drawString("A",310,480+y);
      g.setColor(Color.BLACK);
      g.drawLine(323,510+y,325,518+y); //nose
      g.drawLine(325,518+y,320,520+y);
      g.drawLine(311,530+y,342,530+y); //mouth
      g.drawLine(311,530+y,305,526+y);
       //eyes
      g.setColor(skin);
      g.fillOval(295,490+y,20,15);
      g.fillOval(329,490+y,20,15);
      g.setColor(Color.WHITE);
      g.fillOval(299,492+y,12,12);
      g.fillOval(333,492+y,12,12);
      //left eye lightning
      g.setColor(lightning);
      g.drawLine(303,495+y,297,490+y);
      g.drawLine(297,492+y,301,486+y);
      g.drawLine(305,497+y,310,506+y);
      g.drawLine(302,497+y,295,505+y);
      g.drawLine(299,504+y,296,498+y);
      g.drawLine(305,495+y,310,491+y);
      g.drawLine(308,494+y,310,499+y);
      //right eye lightning 
      g.drawLine(335,495+y,329,499+y);
      g.drawLine(340,500+y,343,507+y);
      g.drawLine(342,496+y,347,492+y);
      g.drawLine(345,493+y,348,495+y);
      g.drawLine(338,496+y,336,491+y);
      //eyes
      g.setColor(capEye);
      g.fillOval(301,494+y,8,8);
      g.fillOval(335,494+y,8,8);
      //left arm
      g.setColor(capWhite); 
      g.fillOval(195,537+y,80,23);
      g.setColor(capRed);
      g.fillOval(177,536+y,30,30);
      //bottom half
      g.setColor(capBlue); 
      int xSuit2 [] = {275,250,290,315,329,355,395,370};
      int ySuit2 [] = {615+y,705+y,705+y,641+y,641+y,705+y,705+y,615+y};
      g.fillPolygon(xSuit2,ySuit2,8);
      //shoes
      g.setColor(capRed); 
      int xlShoe [] = {250,290,283,283,218,218,245};
      int ylShoe [] = {705+y,705+y,723+y,733+y,733+y,725+y,717+y};
      g.fillPolygon(xlShoe,ylShoe,7); //left shoe
      g.fillOval(214,725+y,8,8);
      int xrShoe [] = {395,355,360,360,425,425,400};
      int yrShoe [] = {705+y,705+y,723+y,733+y,733+y,725+y,717+y};
      g.fillPolygon(xrShoe,yrShoe,7); //right shoe
      g.fillOval(421,725+y,8,8);
      //straps on cap
      g.setColor(Color.BLACK);
      g.drawArc(195,565,125,75,260,190);
      g.drawArc(324,565,125,75,90,180);
      //star on cap
      int star = 281;
      int star2 = 530;
      g.setColor(capWhite);
      int xStar [] = {22+star,34+star,41+star,47+star,61+star,50+star,54+star,41+star,28+star,32+star}; 
      int yStar [] = {34+star2+y,34+star2+y,20+star2+y,34+star2+y,34+star2+y,44+star2+y,58+star2+y,50+star2+y,58+star2+y,44+star2+y};
      g.fillPolygon(xStar,yStar,10);
      int star3 = 281;
      int star4 = 530;
      g.setColor(Color.BLACK);
      int xStar2 [] = {22+star3,34+star3,41+star3,47+star3,61+star3,50+star3,54+star3,41+star3,28+star3,32+star3}; 
      int yStar2 [] = {34+star4+y,34+star4+y,20+star4+y,34+star4+y,34+star4+y,44+star4+y,58+star4+y,50+star4+y,58+star4+y,44+star4+y};
      g.drawPolygon(xStar2,yStar2,10);
      //belt
      g.setColor(capWhite);
      int xSuit3 [] = {276,272,290,290}; 
      int ySuit3 [] = {615+y,593+y,593+y,615+y};
      g.fillPolygon(xSuit3,ySuit3,4);
      g.setColor(capRed);
      int xSuit4 [] = {272,277,277,276};
      int ySuit4 [] = {593+y,593+y,615+y,615+y};
      g.fillPolygon(xSuit4,ySuit4,4);
      for(int s=0;s<78;s += 13)
      {
         if((s/2)*2 == s){
            g.setColor(capRed);
         }
         else{
            g.setColor(capWhite);
         }
         g.fillRect(290+s,593+y,13,25);
      }
      g.setColor(Color.BLACK);
      int xBelt [] = {274,275,274,369,369};
      int yBelt [] = {612+y,615+y,618+y,618+y,612+y};
      g.fillPolygon(xBelt,yBelt,5);
      g.setColor(capWhite);
      g.fillRect(314,610+y,16,11);
      g.setColor(Color.BLACK);
      g.drawRect(314,610+y,16,11);
   }
   public void drawHammer(int x,int y,Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      //lightning
      g2.setStroke(new BasicStroke(2));
      g.setColor(lightning);
      g.drawLine(5+x,20+y,-5+x,18+y);
      g.drawLine(7+x,8+y,2+x,3+y);
      g.drawLine(2+x,2+y,-3+x,3+y);
      g.drawLine(48+x,39+y,53+x,47+y); 
      g.drawLine(19+x,39+y,15+x,45+y);
      g.drawLine(15+x,45+y,11+x,48+y);
      g.drawLine(67+x,11+y,76+x,17+y);
      g.drawLine(72+x,15+y,77+x,9+y); 
      g.drawLine(52+x,6+y,60+x,1+y);
      g.drawLine(56+x,3+y,51+x,0+y);
      g2.setStroke(new BasicStroke(1));
      g.drawLine(2+x,2+y,-1+x,5+y);
      g.drawLine(0+x,3+y,-4+x,-1+y);
      g.drawLine(15+x,45+y,19+x,47+y);
      g.drawLine(71+x,14+y,69+x,19+y);
      g.drawLine(60+x,1+y,62+x,4+y);
      g.drawLine(50+x,45+y,55+x,46+y);
      g.drawLine(13+x,5+y,15+x,1+y);
      g.drawLine(1+x,30+y,-6+x,32+y);
      g.drawLine(68+x,35+y,72+x,38+y);
      g.drawLine(71+x,38+y,74+x,36+y);
      g.drawLine(-2+x,19+y,-5+x,21+y);
      
      g2.setStroke(new BasicStroke(2));
      g.setColor(hammer7);
      g.drawArc(22+x,92+y,12,12,222,135);
      g.drawArc(24+x,95+y,12,12,100,105);
      g2.setStroke(new BasicStroke(1));
      g.setColor(hammer2);
      g.fillRect(30+x,0+y,13,75);
      int xhammerDet [] = {24+x,29+x,44+x,48+x};
      int yhammerDet [] = {5+y,3+y,3+y,5+y};
      g.fillPolygon(xhammerDet,yhammerDet,4);
      g.setColor(hammer3);
      g.fillRect(30+x,20+y,13,78);
      g.setColor(hammer7);
      for(int line=0;line<72;line += 12)
      {
         g.drawLine(30+x,24+y+line,36+x,31+y+line);
         g.drawLine(30+x,35+y+line,43+x,26+y+line);
      }
      g.setColor(hammer);
      int xHammer [] = {5+x,65+x,65+x,5+x};
      int yHammer [] = {5+y,5+y,40+y,40+y};
      g.fillPolygon(xHammer,yHammer,4);
      g.setColor(hammer4);
      int xHammer2 [] = {5+x,0+x,0+x,5+x};
      int yHammer2 [] = {5+y,15+y,30+y,40+y};
      g.fillPolygon(xHammer2,yHammer2,4);
      g.drawLine(6+x,5+y,6+x,40+y);
      int xHammer3 [] = {65+x,70+x,70+x,65+x};
      int yHammer3 [] = {5+y,15+y,30+y,40+y};
      g.fillPolygon(xHammer3,yHammer3,4);
      g.drawLine(64+x,5+y,64+x,40+y);
      g.drawPolygon(xHammer,yHammer,4);
      //symble
      g.setColor(hammer4);
      g2.setStroke(new BasicStroke(2));
      g.drawArc(21+x,12+y,20,20,245,182); 
      g.drawArc(31+x,12+y,20,20,116,182); 
      g.drawArc(26+x,21+y,20,20,364,180); 
      g2.setStroke(new BasicStroke(1));
   }
      
   public void drawIronman(Graphics g)
   {
      g.setColor(Color.BLACK);
      g.fillOval(125,224,4,5); //head
      int [] xIron = {125,120,122,128};
      int [] yIron = {228,233,233,229};
      g.fillPolygon(xIron,yIron,4); //left arm
      int [] xIron2 = {130,135,134,127};
      int [] yIron2 = {228,233,233,229};
      g.fillPolygon(xIron2,yIron2,4); //right arm
      g.fillOval(125,229,5,7); //body
      int [] xIron3 = {125,124,125,127};
      int [] yIron3 = {235,239,239,234};
      g.fillPolygon(xIron3,yIron3,4); //left leg
      int [] xIron4 = {129,131,130,127};
      int [] yIron4 = {235,239,239,234};
      g.fillPolygon(xIron4,yIron4,4); //right leg
      g.setColor(shade);
      int [] xArc = {125,127,129};
      int [] yArc = {230,232,230};
      g.fillPolygon(xArc,yArc,3);
      g.setColor(jet);  //jet strems
      g.drawOval(120,233,2,2); 
      g.drawLine(121,233,121,272);
      g.drawOval(134,233,2,2);
      g.drawLine(135,233,135,272);
      g.drawOval(124,240,2,2);
      g.drawLine(125,240,125,279);
      g.drawOval(129,240,2,2);
      g.drawLine(130,240,130,279);
   }
   public void drawBackround(Graphics g)
   {
      //sky
      int colorVal=175;
      int n = 0;
      int b = 0;
      int s = 35; //35
      Color sky = new Color(220-s,38-s,colorVal);
      g.setColor(sky);
      while(colorVal>=1)
      {
         g.drawLine(0,0+b,1000,0+b); 
         if(b == n)
         {
            if(s>0)
            {
               s -= 1;
            }
            n += 4;
            colorVal -= 1;
            sky = new Color(220-s,38-s,colorVal);
            g.setColor(sky);
         } 
         b += 1;
      }
      //stars
      ImageIcon star = new ImageIcon("Star1.png");
      for(int st=0;st<25;st++){
         int x = (int)(Math.random()*1000);
         int y = (int)(Math.random()*500);
         g.drawImage(star.getImage(),x,y,20,20,null);
      }
      //buildings
      g.setColor(Color.BLACK);
      g.fillRect(0,500,50,300);    //1
      g.fillRect(50,475,150,325);  //2
      int [] xTop = {50,60,190,200};
      int [] yTop = {475,460,460,475};
      g.fillPolygon(xTop,yTop,4);  
      g.fillRect(200,500,35,300);  //3
      g.fillRect(235,395,75,405); //4
      g.fillRect(310,425,40,375);
      g.fillRect(350,455,60,345);
      g.fillRect(410,522,10,278);  //5
      g.fillRect(420,470,75,330);  //6
      g.fillRect(430,440,55,30);   //6a
      g.fillRect(456,410,3,40);    //6b
      int [] xTop2 = {430,485,457};
      int [] yTop2 = {440,440,415};
      g.fillPolygon(xTop2,yTop2,3);
      g.fillRect(495,395,15,405);  //7
      g.fillRect(510,360,75,440);  //8
      int [] xTop3 = {510,547,585};
      int [] yTop3 = {360,330,360};
      g.fillPolygon(xTop3,yTop3,3);
      g.fillRect(585,380,2,420);  //9
      g.fillRect(587,400,2,400);  //10
      g.fillRect(589,420,21,380); //11
      g.fillRect(610,425,55,375); //12
      g.fillRect(665,510,2,290);  //13
      g.fillRect(667,520,6,280);  //14
      g.fillRect(673,525,15,275); //15
      g.fillRect(688,520,7,280);  //16
      g.fillRect(695,477,2,323);  //17
      g.fillRect(697,435,71,365); //18
      int [] xTop4 = {697,768,753,712};
      int [] yTop4 = {435,435,427,427};
      g.fillPolygon(xTop4,yTop4,4);
      g.fillRect(768,477,2,323);  //19
      g.fillRect(770,500,30,300); //20
      g.fillRect(800,400,75,400); //21
      g.fillRect(875,450,35,350); //22
      g.fillRect(910,575,20,225); //23
      g.fillRect(930,500,30,300); //24
      g.fillRect(960,425,40,375); //25
   } 
   public void drawThanos(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      ImageIcon thanos = new ImageIcon("Thanos.png");
      //water aroud thanos + thanos
      for(int l=0;l<14;l++){
         int w = (int)(Math.random()*255);
         Color water = new Color(0,w,255);
         g.setColor(water);
         int x = (int)(Math.random()*205+615);
         int y = (int)(Math.random()*425+350);
         int s = (int)(Math.random()*25);
         g.fillOval(x,y,s,s);
      }
      g.drawImage(thanos.getImage(),622,350,200,425,null);
      for(int ll=0;ll<13;ll++){
         int w2 = (int)(Math.random()*255);
         Color water = new Color(0,w2,255);
         g.setColor(water);
         int x = (int)(Math.random()*205+615);
         int y = (int)(Math.random()*425+350);
         int s = (int)(Math.random()*25);
         g.fillOval(x,y,s,s);
      }
      //waterbolt
      int up = 55;
      g.setColor(sideWater);
      int line2 = 0;
      for(int line=0;line<72;line++){
         g.drawArc(500+line,325-up,400,400,180,100-line2);
         g.drawArc(500-line,325-up,400,400,0,100-line2);
         if((line/3)*3 == line){
         line2 += 1;
         }
      }
      g.fillArc(501,489-up,72,72,0,180);
      g.fillArc(827,489-up,72,72,180,180);
      g.setColor(mainWater);
      g2.setStroke(new BasicStroke(4));
      g.drawArc(428,325-up,400,400,0,80);
      g.drawArc(572,325-up,400,400,180,80);
      g.drawArc(500,325-up,400,400,0,100);
      g.drawArc(500,325-up,400,400,180,100);
      g.drawArc(501,489-up,72,72,0,180);
      g.drawArc(827,489-up,72,72,180,180);
      g2.setStroke(new BasicStroke(1));
      //waterbolt det
      g.setColor(mainWatDet);
      int c = 497;
      int c2 = 478;
      for(int det=0;det<10;det++){
         int s = (int)(Math.random()*20);
         g.fillOval(c,c2,s,s);
         int x = (int)(Math.random()*20);
         int y = (int)(Math.random()*30);
         c += x;
         c2 += y;
      }
      int c3 = 839;
      int c4 = 487;
      for(int det2=0;det2<13;det2++){
         int s = (int)(Math.random()*20);
         g.fillOval(c3,c4,s,s);
         int x = (int)(Math.random()*13);
         int y = (int)(Math.random()*35);
         c3 -= x;
         c4 -=y;
      }
   }
}