package BreakoutProject;
//Name: Kai Tjader Date 6/8/22
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.*;
import java.awt.Graphics;

public class Breakout extends GraphicsProgram 
{
   Color textCol = new Color(126,249,255); 
   Color grey = new Color(114,124,129);
   Color brown = new Color(101,67,33);
   Color lokiGreen = new Color(76,255,88);
   Color gamora = new Color(45,115,1);
   Color mantis = new Color(247,252,187);
   Color strange = new Color(135,18,3);
   Color ironMan = new Color(214,35,15);
   Color cap = new Color(8,142,252);
   Color missingStone = new Color(255,215,0); 
   Color power = new Color(188,0,255);
   Color space = new Color(5,142,247);
   Color reality = new Color(148,15,3);
   Color soul = new Color(245,153,49);
   Color time = new Color(70,240,2);
   Color mind = new Color(247,247,6);
   private Timer endTime;
   //size of display
   private static final int WIDTH = 400; 
   private static final int HEIGHT = 600;
   
	//    PADDLE
   private static final int PADDLE_WIDTH = 40; 
   private static final int PADDLE_HEIGHT = 10; 
	
	//offset of paddle up from the bottom
   private static final int PADDLE_Y_OFFSET = 100; 
   private static double PaddleY = 475;
   private static double PaddleX = 150;
	
	//    BRICKS
   private int NBRICKS_PER_ROW = 10;
   private int NBRICK_ROWS = 6; 
   private static final int BRICK_SEP = 4; 
   private int BRICK_WIDTH = WIDTH / NBRICKS_PER_ROW - BRICK_SEP;
   private static final int BRICK_HEIGHT = 8;
	
	//                                                      BALL
   GImage ball = new GImage("gauntlet.png"); 
   private static double BallY = 300;
   private static double BallX = 200;
   private static final int Ball_Width = 50;
   private static final int Ball_Height = 50;
	
   //GLine
   public GLine line;
   
   //start
   public GLabel instruc, title;
   
	//offset of the top brick row from top
   private static final int BRICK_Y_OFFSET = 70; 
	
	//number of turns
   private static final int NTURNS = 3;
	
	//the paddle
   private GRect paddle;
   
   // colider
   GObject collider = getCollidingObject(0,0);
   GObject colliderPaddle = getCollidingObject(0,0);
   int yOrx = 0;
	//ball velocity in both directions (x-direction, and y-direction)
   private double vx, vy;
	
	//records the last x position of the mouse (see mouseMoved method)
   private double lastX;
	
	//used for mouse events (only moves the paddle every 5th mouse move)
   private int toggle = 0;
   
   public boolean stopPro = true;
   
   //text
   double labelX = 47;
   double labelY = 350;
   double labelPostion = 0;
   int r = 126;
   int g = 249;
   int b = 255;
   
   //Rounds
   int lives = 3;
   int brickTotal = 0; 
   int scoreNum = 0;
   int round = 4;    //this will change you levels 0 - 13 you have to comment out the delete (level)
   public GImage maw, midnight, cull;
   public Timer roundSwitch;
   public GOval stone;
   private GLabel score;
   
   //INSTRUCTION
   public GImage background0;
   //instr 1
   public GLabel howTo1, howTo2, howTo3, howTo4, howTo5, howTo6, howTo7;
   //instr 2
   public GLabel howTo8, howTo9, howTo10, howTo11, howTo12, howTo13, howTo14, howTo15;
   public GLabel howTo16, howTo17, howTo18, howTo19, howTo20, howTo21, howTo22, howTo23;
   public GLabel howTo24, howTo25, howTo26, howTo27, howTo28, howTo29, howTo30, howTo31;
   
   //INSTRUCTION 4
   public GOval soulStone;
   
   //ROUND 1
   int wallLabVis = 0;
   public Timer wallTimer, wallLabTimer;
   public GRect wall1, wall2, wall3;
   private GImage background1;
   public GOval powerStone;
   
   //ROUND 2
   public int shipHealth, hulkHealth,stopThorBall;
   public GImage background3, asgardShip;
   public GRect spaceStone, shipWall;
   public GOval thorBrick, hulkBrick, lokiBrick, thorBall;
   public GLabel thorLabel, hulkLabel, lokiLabel, hulkHealthLab;
   
   //Round 3
   public GImage background4;
   public GLabel collecterLabel;
   public GOval collecterBrick, realityStone;
   
   //Round 4 
   int gogDeaths = 3;
   int draxHealth = 2;
   int leftRight = 0;
   public GImage background5;
   public GOval gamoraBrick, starLordBrick, draxBrick, mantisBrick;
   public GLabel gamoraLabel, starLordLabel, draxLabel, mantisLabel, draxHealthLab;
   public GRect gogWall;
   
   //Round 5
   int stopIronBall, ironMove, ironMoveMain = 0;
   int ironHealth = 3;
   int strangeHealth = 2;
   boolean makeClone = true;
   public Timer strangeTimer;
   public GRect clone;
   public GOval ironManBrick, strangeBrick, timeStone, ironManBall;
   public GLabel ironManLabel, strangeLabel, ironHealthLab;
   public GImage butterfly, mirror;
   
   //Round 6 
   boolean bomb = true;
   public GOval mindStone, capBrick, wandaBrick, wandaBall;
   public GLabel capLabel, wandaLabel, visLabel;
   public GImage background6;
   
   //Round 7
   public GOval thorBrick2;
   public GLabel thorLabel2, thorInstr;
   public GImage background7, lightning, hammer;
   
   //win
   public GImage background8;
   public GLabel congrats, congrats2;
	
   //starting
   public static void main(String[] args){
      String[] sizeArgs = { "width=" + WIDTH, "height=" + HEIGHT };
      new Breakout().start(sizeArgs);
   }
   public void nextRound(){
      switch(round){
         case 0: menu();   //title
            pause(3000);
            round++;
            nextRound();
            break;
         case 1: deleteMenu(); //instr1
            instr1();
            pause(9000);
            round++;
            nextRound();
            break;
         case 2: round++;   //Round 1    Xandar
            deleteInstr1(); 
            Round1();
            break;
         case 3: round++;    //instr2
            deleteRound1();
            instr2();
            pause(5000);
            nextRound();
            break;
         case 4: round++;  //    Round2 asgardian ship
            //deleteInstr2();
            Round2();
            break;
         case 5: round++;  //instr3
            deleteRound2();
            instr3();
            pause(9000);
            nextRound();
            break;
         case 6: round++;  //Round3   Knowhere
            deleteInstr3();
            Round3();
            break;
         case 7: round++;  //Gardians of the galaxy gamaora
            deleteRound3();
            Round4();
            break;
         case 8: round++;   //  instr4
            deleteRound4();
            instr4();
            pause(9000);
            nextRound();
            break;
         case 9: round++; //stange iron man fight
            deleteInstr4();
            Round5();
            break;
         case 10: round++; //instr5
            deleteRound5();
            instr5();
            pause(9000);
            nextRound();
            break;
         case 11: round++;  //wakanda
            deleteInstr5();
            Round6();
            break;
         case 12: round++;  //thor
            deleteRound6();
            Round7();
            break;
         case 13: round++;  //win screen
            deleteRound7();
            endScreen();
            break;
         default: System.out.println("Round problum not any");
            break;
      }
   }
   
   public void run(){
      nextRound();
   }
   public void menu(){
      createBackground(1);
      creatLabel();
   }
   public void instr1(){
      createBackground(2);
      createStones();
      creatInstrLable();
   }
   public void instr2(){
      createBackground(2);
      createStones();
      creatInstrLable();
   }
   public void instr3(){
      createBackground(2);
      createStones();
      creatInstrLable();
   }
   public void instr4(){
      createBackground(2);
      createStones();
      createSoulStone();
      creatInstrLable();
   }
   public void instr5(){
      createBackground(2);
      createStones();
      creatInstrLable();
   }
   
   public void deleteInstr1(){
      remove(background0);
      remove(stone);
      remove(howTo1);
      remove(howTo2);
      remove(howTo3);
      remove(howTo4);
      remove(howTo5);
      remove(howTo6);
      remove(howTo7);
   }
   public void deleteMenu(){
      remove(instruc);
      remove(title);
      remove(background1);
   }
   public void deleteRound1(){
      remove(score);
      remove(paddle);
      remove(stone);
      remove(powerStone);
      remove(ball);
   }
   public void deleteInstr2(){
      remove(background0);
      remove(stone);
   }
   public void deleteRound2(){
      remove(background3);
      remove(stone);
      remove(spaceStone);
      remove(paddle);
      remove(ball);
      remove(hulkHealthLab);
   }
   public void deleteInstr3(){
      remove(background0);
      remove(stone);
   }
   public void deleteRound3(){
      remove(background4);
      remove(stone);
      remove(paddle);
      remove(ball);
      remove(realityStone);
      remove(collecterLabel);
      remove(collecterBrick);
   }
   public void deleteRound4(){
      remove(background4);
      remove(stone);
      remove(paddle);
      remove(ball);
      remove(gamoraBrick);
   }
   public void deleteInstr4(){
      remove(background0);
      remove(stone);
      remove(soulStone);
   }
   public void deleteRound5(){
      remove(background5);
      remove(paddle);
      remove(ball);
      remove(stone);
      remove(timeStone);
   }
   public void deleteInstr5(){
      remove(background0);
      remove(stone);
   }
   public void deleteRound6(){
      remove(background6);
      remove(stone);
      remove(capBrick);
      remove(capLabel);
      remove(ball);
   }
   public void deleteRound7(){
      remove(background7);
      remove(stone);
      remove(paddle);
      remove(thorBrick2);
      remove(thorLabel2);
      remove(lightning);
      remove(thorInstr);
      remove(ball);
      remove(hammer);
   }
   
   public void Round1(){
      createBackground(3);
      createLives();
      createBricks();
      creatWall();
      createPaddle();
      createStones();
      createPowerstone();
      createBall();
      addMouseListeners();
      play();
   }
   public void Round2(){
      createBackground(4);
      createLives();
      createStones();
      createPaddle();
      NBRICK_ROWS = 7;
      createBricks();
      createBall();
      addMouseListeners();
      play();
   }
   public void Round3(){
      createBackground(5);
      createLives();
      createStones();
      createPaddle();
      createRealityStone();
      createCollecter();
      addMouseListeners();
      createBall();
      play();
   }
   public void Round4(){
      createBackground(6);
      createLives();
      createStones();
      createPaddle();
      createGoG();
      createBall();
      addMouseListeners();
      play();
   }
   public void Round5(){
      createBackground(7);
      createLives();
      createStones();
      createPaddle();
      createTitianGroup();
      createBall();
      addMouseListeners();
      play();
   }
   public void Round6(){
      createBackground(8);
      createLives();
      createStones();
      createPaddle();
      createWakanda();
      createBall();
      addMouseListeners();
      play();
   }
   public void Round7(){
      createBackground(9);
      createLives();
      createStones();
      createPaddle();
      createThorBattle();
      createBall();
      addMouseListeners();
      play();
   }
   public void endScreen(){
      createBackground(10);
      createLives();
      createStones();
      congratulations();
   }
   
   public void createLives(){
      maw = new GImage("Maw.png");
      maw.setBounds(360,5,45,35);
      add(maw);
      midnight = new GImage("midnight.png");
      midnight.setBounds(350,5,25,35);
      add(midnight);
      cull = new GImage("cull.png");
      cull.setBounds(315,5,30,30);
      add(cull);
   }
   
   public void creatLabel(){
      title = new GLabel("WELCOME TO INFINATE SEARCH",-1,50);
      instruc = new GLabel("Get ready to collect the infinty stones",25,115);
      title.setFont(new Font("Pacifico",Font.BOLD,25));
      instruc.setFont(new Font("Pacifico",Font.BOLD,20));
      title.setColor(textCol);
      instruc.setColor(textCol);
      add(title);
      add(instruc);
   }
   public void congratulations(){
      congrats = new GLabel("YOU WIN!!!",130,25);
      congrats.setFont(new Font("Pacifico",Font.BOLD,30));
      congrats.setColor(textCol);
      add(congrats);
      congrats2 = new GLabel("At what cost?",135,250);
      congrats2.setFont(new Font("Pacifico",Font.BOLD,25));
      congrats2.setColor(textCol);
      add(congrats2);
   }
   
   public void createStones(){
      int dis = 0;
      for(int x=0;x<6;x++){
         stone = new GOval(10+dis,550,17,17);
         stone.setFilled(true);
         switch(x){
            case 0: 
               if(round > 3)
                  stone.setColor(power);
               else
                  stone.setColor(missingStone);
               break;
            case 1: 
               if(round > 5)
                  stone.setColor(space);
               else
                  stone.setColor(missingStone);
               break;
            case 2:
               if(round > 7)
                  stone.setColor(reality);
               else
                  stone.setColor(missingStone);
               break;
            case 3:
               if(round > 8)
                  stone.setColor(soul);
               else
                  stone.setColor(missingStone);
               break;
            case 4:
               if(round > 10)
                  stone.setColor(time);
               else
                  stone.setColor(missingStone);
               break;
            case 5:
               if(round > 12)
                  stone.setColor(mind);
               else
                  stone.setColor(missingStone);
               break;
            default:
               break;
         }
         dis += 30;
         add(stone);
      }
   }
   public void creatInstrLable(){
      if(round == 1){
         howTo1 = new GLabel("You are Thanos a god on a journy to",10,50);
         howTo2 = new GLabel("gain all 6 infinity stones. First is the",10,73);
         howTo3 = new GLabel("Powerstone you must steal it from a",10,96);
         howTo4 = new GLabel("civilization whose ships creat barriers.",10,119);
         howTo5 = new GLabel("You must destroy every ship to take",10,142);
         howTo6 = new GLabel("down the walls and gain the Powerstone!",10,165);
         howTo7 = new GLabel("Good luck!",110,400);
         howTo1.setColor(textCol);
         howTo2.setColor(textCol);
         howTo3.setColor(textCol);
         howTo4.setColor(textCol);
         howTo5.setColor(textCol);
         howTo6.setColor(textCol);
         howTo7.setColor(textCol);
         howTo1.setFont(new Font("Pacifico",Font.BOLD,20));
         howTo2.setFont(new Font("Pacifico",Font.BOLD,20));
         howTo3.setFont(new Font("Pacifico",Font.BOLD,20));
         howTo4.setFont(new Font("Pacifico",Font.BOLD,20));
         howTo5.setFont(new Font("Pacifico",Font.BOLD,20));
         howTo6.setFont(new Font("Pacifico",Font.BOLD,20));
         howTo7.setFont(new Font("Pacifico",Font.BOLD,35));
         add(howTo1);
         add(howTo2);
         add(howTo3);
         add(howTo4);
         add(howTo5);
         add(howTo6);
         add(howTo7);
      }
      if(round == 4){
         howTo8 = new GLabel("Next you must get the Power stone from",10,50);
         howTo8.setColor(textCol);
         howTo8.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo8);
         howTo9 = new GLabel("the Asgardians. be carful they have",10,73);
         howTo9.setColor(textCol);
         howTo9.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo9);
         howTo10 = new GLabel("Superheros. Kill there ship then collect",10,96);
         howTo10.setColor(textCol);
         howTo10.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo10);
         howTo11 = new GLabel("the stone threw loki.",10,119);
         howTo11.setColor(textCol);
         howTo11.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo11);
      }
      if(round == 6){
         howTo12 = new GLabel("Next you must get the Reality stone and",10,50);
         howTo12.setColor(textCol);
         howTo12.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo12);
         howTo13 = new GLabel("Get gamora for a sacrfice for the Soul",10,73);
         howTo13.setColor(textCol);
         howTo13.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo13);
         howTo14 = new GLabel("stone. Kill the Gardians and get the",10,96);
         howTo14.setColor(textCol);
         howTo14.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo14);
         howTo15 = new GLabel("Stones.",10,119);
         howTo15.setColor(textCol);
         howTo15.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo15);
      }
      if(round == 9){
         howTo16 = new GLabel("You have just killed Gamora and gained",10,70);
         howTo16.setColor(textCol);
         howTo16.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo16);
         howTo17 = new GLabel("the Soul stone. Next is the Time stone",10,93);
         howTo17.setColor(textCol);
         howTo17.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo17);
         howTo18 = new GLabel("almost kill Iron man and it will be",10,116);
         howTo18.setColor(textCol);
         howTo18.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo18);
         howTo19 = new GLabel("given.",10,139);
         howTo19.setColor(textCol);
         howTo19.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo19);
      }
      if(round == 11){
         howTo20 = new GLabel("Wanda will try to kill Vision to",10,50);
         howTo20.setColor(textCol);
         howTo20.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo20);
         howTo21 = new GLabel("stop you from getting the Mind stone",10,73);
         howTo21.setColor(textCol);
         howTo21.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo21);
         howTo22 = new GLabel("kill wanda and you will use the Time",10,96);
         howTo22.setColor(textCol);
         howTo22.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo22);
         howTo23 = new GLabel("Stone to bring back Vision, watch out.",10,119);
         howTo23.setColor(textCol);
         howTo23.setFont(new Font("Pacifico",Font.BOLD,20));
         add(howTo23);
      }
   }
   
   public void createPowerstone(){
      powerStone = new GOval(165,15,30,40);
      powerStone.setFilled(true);
      powerStone.setColor(power);
      add(powerStone);
   }
   public void createSpaceStone(){
      spaceStone = new GRect(180,15,35,35);
      spaceStone.setFilled(true);
      spaceStone.setColor(space);
      add(spaceStone);
   }
   public void createRealityStone(){
      realityStone = new GOval(183,15,30,40);
      realityStone.setFilled(true);
      realityStone.setColor(reality);
      add(realityStone);
   }
   public void createSoulStone(){
      soulStone = new GOval(183,15,30,40);
      soulStone.setFilled(true);
      soulStone.setColor(soul);
      add(soulStone);
   }
   public void createTimeStone(){
      timeStone = new GOval(183,15,30,40);
      timeStone.setFilled(true);
      timeStone.setColor(time);
      add(timeStone);
   }
   public void createMindStone(){
      mindStone = new GOval(183,15,30,40);
      mindStone.setFilled(true);
      mindStone.setColor(mind);
      add(mindStone);
      visLabel = new GLabel("Vision",181,41);
      visLabel.setColor(Color.BLACK);
      visLabel.setFont(new Font("Pacifico",Font.BOLD,11));
      add(visLabel);
   }
   public void deleteMindStone(){
      bomb = false;
      wandaBall.move(-20,-10);
      wandaBall.setSize(60,60);
      pause(1000);
      remove(mindStone);
      remove(visLabel);
      remove(wandaBall);
   }
   
   public void creatWall(){
      //wall 1
      wall1 = new GRect(0,68,WIDTH,5);
      wall1.setFilled(true);
      wall1.setColor(Color.YELLOW);
      add(wall1);
      //wall 2
      wall2 = new GRect(0,93,WIDTH,5);
      wall2.setFilled(true);
      wall2.setColor(Color.YELLOW);
      add(wall2);
      //wall 3
      wall3 = new GRect(0,117,WIDTH,5);
      wall3.setFilled(true);
      wall3.setColor(Color.YELLOW);
      add(wall3);
   
      wallTimer = new Timer(1000, new WallListener());
      wallTimer.start();
   }
   
   public void createTitianGroup(){
      strangeBrick = new GOval(100,75,BRICK_WIDTH+15,BRICK_HEIGHT+5);
      strangeBrick.setFilled(true);
      strangeBrick.setColor(strange);
      add(strangeBrick);
      strangeLabel = new GLabel("Strange",108,84);
      strangeLabel.setColor(Color.WHITE);
      strangeLabel.setFont(new Font("Pacifico",Font.BOLD,10));
      add(strangeLabel);
      strangeTimer = new Timer(1000, new StrangeListener());
   }
   
   public void createGoG(){
      gamoraBrick = new GOval(170,30,BRICK_WIDTH+20,BRICK_HEIGHT+7);
      gamoraBrick.setFilled(true);
      gamoraBrick.setColor(gamora);
      add(gamoraBrick);
      gamoraLabel = new GLabel("Gamora",177,40);
      gamoraLabel.setColor(Color.BLACK);
      gamoraLabel.setFont(new Font("Pacifico",Font.BOLD,10));
      add(gamoraLabel);
      
      gogWall = new GRect(5,60,WIDTH-10,BRICK_HEIGHT);
      gogWall.setFilled(true);
      gogWall.setColor(grey);
      add(gogWall);
      
      starLordBrick = new GOval(100,75,BRICK_WIDTH+5,BRICK_HEIGHT+2);
      starLordBrick.setFilled(true);
      starLordBrick.setColor(brown);
      add(starLordBrick);
      starLordLabel = new GLabel("lord",110,83);
      starLordLabel.setColor(Color.WHITE);
      starLordLabel.setFont(new Font("Pacifico",Font.BOLD,10));
      add(starLordLabel);
      
      draxBrick = new GOval(40,115,BRICK_WIDTH+5,BRICK_HEIGHT+2);
      draxBrick.setFilled(true);
      draxBrick.setColor(gamora);
      add(draxBrick);
      draxLabel = new GLabel("Drax",49,123);
      draxLabel.setColor(Color.BLACK);
      draxLabel.setFont(new Font("Pacifico",Font.BOLD,10));
      add(draxLabel);
      draxHealthLab = new GLabel("Drax: " + draxHealth,2,25);
      draxHealthLab.setColor(textCol);
      draxHealthLab.setFont(new Font("Pacifico",Font.BOLD,30));
      add(draxHealthLab);
      
      mantisBrick = new GOval(300,115,BRICK_WIDTH+5,BRICK_HEIGHT+2);
      mantisBrick.setFilled(true);
      mantisBrick.setColor(mantis);
      add(mantisBrick);
      mantisLabel = new GLabel("mantis",303,123);
      mantisLabel.setColor(Color.BLACK);
      mantisLabel.setFont(new Font("Pacifico",Font.BOLD,10));
      add(mantisLabel);
   }
   public void createCollecter(){
      collecterBrick = new GOval(5,90,WIDTH-10,30);
      collecterBrick.setFilled(true);
      collecterBrick.setColor(Color.WHITE);
      add(collecterBrick);
      collecterLabel = new GLabel("Collecter",167,111);
      collecterLabel.setColor(Color.BLACK);
      collecterLabel.setFont(new Font("Pacifico",Font.BOLD,15));
      add(collecterLabel);
   }
   
   public void createThorBattle(){
      thorInstr = new GLabel("Aviod the hammer before its to late",25,50);
      thorInstr.setColor(textCol);
      thorInstr.setFont(new Font("Pacifico",Font.BOLD,20));
      add(thorInstr);
      lightning = new GImage("lightning.png");
      lightning.setBounds(160,80,BRICK_WIDTH+41, BRICK_HEIGHT+34);
      add(lightning);
      hammer = new GImage("hammer.png");
      hammer.setBounds(165,85,100,225);
      add(hammer);
      thorBrick2 = new GOval(176,95,BRICK_WIDTH+10, BRICK_HEIGHT+4);
      thorBrick2.setFilled(true);
      thorBrick2.setColor(space);
      add(thorBrick2);
      thorLabel2 = new GLabel("Thor",185,105);
      thorLabel2.setColor(Color.BLACK);
      thorLabel2.setFont(new Font("Pacifico",Font.BOLD,11));
      add(thorLabel2);
   }
   public void createWakanda(){
      for(int x = 0; x < 2; x++){
         for(int y = 0; y < NBRICKS_PER_ROW; y++){
            GRect brick = new GRect((y * BRICK_WIDTH) + BRICK_SEP*y + BRICK_SEP/2, 
               						BRICK_Y_OFFSET + (BRICK_HEIGHT * x) + BRICK_SEP*x + 175, 
               							BRICK_WIDTH, BRICK_HEIGHT);
            brick.setFilled(true);
            brick.setColor(brown);
            if(x != 1 || y != 4)
               add(brick);
         }
      }
      capBrick = new GOval(163,257,BRICK_WIDTH, BRICK_HEIGHT);
      capBrick.setFilled(true);
      capBrick.setColor(cap);
      add(capBrick);
      capLabel = new GLabel("Cap",170,263);
      capLabel.setColor(Color.WHITE);
      capLabel.setFont(new Font("Pacifico",Font.BOLD,10));
      add(capLabel);
      
      wandaBall = new GOval(190,95,20,20);
      wandaBall.setColor(Color.RED);
      wandaBall.setFilled(true);
      add(wandaBall);
      wandaBrick = new GOval(176,95,BRICK_WIDTH+10, BRICK_HEIGHT+4);
      wandaBrick.setFilled(true);
      wandaBrick.setColor(reality);
      add(wandaBrick);
      wandaLabel = new GLabel("Wanda",184,103);
      wandaLabel.setColor(Color.WHITE);
      wandaLabel.setFont(new Font("Pacifico",Font.BOLD,10));
      add(wandaLabel);
      
      createMindStone();
   }
   public void createClones(){
      int xDif = -BRICK_WIDTH - BRICK_SEP;
      int yDif = BRICK_HEIGHT + BRICK_SEP;
      for(int x=0;x<3;x++){
         clone = new GRect(strangeBrick.getX()+xDif, strangeBrick.getY()+yDif, BRICK_WIDTH, BRICK_HEIGHT);
         clone.setColor(strange);
         clone.setFilled(true);
         add(clone);
         xDif += -BRICK_WIDTH - BRICK_SEP;
         yDif += BRICK_HEIGHT + BRICK_SEP;
      }
      xDif = BRICK_WIDTH + BRICK_SEP;
      yDif = BRICK_HEIGHT + BRICK_SEP;
      for(int x=0;x<3;x++){
         GRect clone = new GRect(strangeBrick.getX()+xDif, strangeBrick.getY()+yDif, BRICK_WIDTH, BRICK_HEIGHT);
         clone.setColor(strange);
         clone.setFilled(true);
         add(clone);
         xDif += BRICK_WIDTH + BRICK_SEP;
         yDif += BRICK_HEIGHT + BRICK_SEP;
      }
   }
   public void createBrick10(){
      for(int x = 0; x < 3; x++){
         for(int y = 0; y < NBRICKS_PER_ROW; y++){
            GRect brick = new GRect((y * BRICK_WIDTH) + BRICK_SEP*y + BRICK_SEP/2, 
               						BRICK_Y_OFFSET + (BRICK_HEIGHT * x) + BRICK_SEP*x + 175, 
               							BRICK_WIDTH, BRICK_HEIGHT);
            //color bricks
            brick.setFilled(true);
            brick.setColor(ironMan);
            add(brick);
         }
      }
   }
	//createBricks method -- called from the setup method
   public void createBricks(){
   	//make the bricks
      for(int x = 0; x < NBRICK_ROWS; x++)
      {
         for(int y = 0; y < NBRICKS_PER_ROW; y++)
         {
            GRect brick = new GRect((y * BRICK_WIDTH) + BRICK_SEP*y + BRICK_SEP/2, 
               						BRICK_Y_OFFSET + (BRICK_HEIGHT * x) + BRICK_SEP*x, 
               							BRICK_WIDTH, 
               								BRICK_HEIGHT);
            //color bricks
            brick.setFilled(true);
            if(round == 3)
               brick.setColor(Color.BLUE);
            if(round == 5){
               switch(x){
                  case 0: brick.setColor(Color.RED);
                     break;
                  case 1: brick.setColor(Color.ORANGE);
                     break;
                  case 2: brick.setColor(Color.YELLOW);
                     break;
                  case 3: brick.setColor(Color.GREEN);
                     break;
                  case 4: brick.setColor(space);
                     break;
                  case 5: brick.setColor(Color.BLUE);
                     break;
                  case 6: brick.setColor(power);
                     break;
               }
               if(x != 6 || y != 5){ //thor
                  if(x != 3 || y != 3){ //hulk
                     add(brick);
                  }
               }
            }else
               add(brick);
         }
      }
      if(round == 5){
         thorBrick = new GOval(202,142,BRICK_WIDTH,BRICK_HEIGHT); //Thor
         thorBrick.setFilled(true);
         thorBrick.setColor(space);
         add(thorBrick);
         thorLabel = new GLabel("Thor",210,150);
         thorLabel.setColor(Color.BLACK);
         thorLabel.setFont(new Font("Pacifico",Font.BOLD,10));
         add(thorLabel);
         thorBall = new GOval(202,142,15,15);
         thorBall.setColor(textCol);
         thorBall.setVisible(false);
         thorBall.setFilled(true);
         add(thorBall);
         
         hulkBrick = new GOval(122,106,BRICK_WIDTH,BRICK_HEIGHT); //hulk
         hulkBrick.setFilled(true);
         hulkBrick.setColor(Color.GREEN);
         add(hulkBrick);
         hulkLabel = new GLabel("Hulk",130,114);
         hulkLabel.setColor(Color.BLACK);
         hulkLabel.setFont(new Font("Pacifico",Font.BOLD,10));
         add(hulkLabel);
         hulkHealth = 3;
         hulkHealthLab = new GLabel("Hulk: " + hulkHealth,2,25);
         hulkHealthLab.setColor(textCol);
         hulkHealthLab.setFont(new Font("Pacifico",Font.BOLD,30));
         add(hulkHealthLab);
         
         lokiBrick = new GOval(180,30,BRICK_WIDTH,BRICK_HEIGHT); //loki
         lokiBrick.setFilled(true);
         lokiBrick.setColor(lokiGreen);
         add(lokiBrick);
         lokiLabel = new GLabel("Loki",187,38);
         lokiLabel.setColor(Color.BLACK);
         lokiLabel.setFont(new Font("Pacifico",Font.BOLD,10));
         add(lokiLabel);
         
         shipWall = new GRect(1,154,WIDTH-2,BRICK_HEIGHT);
         shipWall.setFilled(true);
         shipWall.setColor(grey);
         add(shipWall);
         asgardShip = new GImage("Ship.png");
         asgardShip.setBounds(100,154,200,100);
         add(asgardShip);
      }
   }
	
	//create Paddle
   public void createPaddle()
   {
      paddle = new GRect(PaddleX, PaddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
      paddle.setColor(textCol);     
      paddle.setFilled(true);			
      add(paddle);
   }
	
	//create Ball
   public void createBall(){
      ball = new GImage("gauntlet.png");
      ball.setBounds(200,350,Ball_Width,Ball_Height);
      add(ball);
   }

	//play method -- called from the run method after setup
   public void play()
   {
      startTheObjects();
      playBall();
   }
	
	//startTheBall method -- called from the play method
   public void startTheObjects()
   {
      vx = 1;
      vy = -1;
      paddle.setLocation(lastX - (PADDLE_WIDTH/2),475);
   }
	
	//playBall method -- called from the play method
   public void playBall()
   {
      while(stopPro){
         ball.move(vx, vy);
         pause(10);
         if(round == 3)
            score.setLabel("Ships destroyed: " + brickTotal);
         if(round == 5){
            if(thorBall.isVisible())
               thorBall.move(0,1);
         }
         if(round == 8){
            if(starLordBrick.getX() == WIDTH-50)
               leftRight = 1;
            if(starLordBrick.getX() == 50)
               leftRight = 0;
            switch(leftRight){
               case 0: starLordBrick.move(1,0);
                  starLordLabel.move(1,0);
                  break;
               case 1: starLordBrick.move(-1,0);
                  starLordLabel.move(-1,0);
                  break;
            }
         }
         if(round == 10){
            if(ironManBrick != null){
               switch(ironMoveMain){
                  case 300: ironMove++; 
                     ironMoveMain++;
                     break;
                  case 600: ironMove++;
                     ironMoveMain++;
                     break;
                  case 900: ironMove++;
                     ironMoveMain++;
                     break;
                  case 1200: ironMove = 0;
                     ironMoveMain = 0;
                     break;
                  default: ironMoveMain++;
                     break;
               }
               if(ironMove == 0){
                  ironManBrick.move(1,0);
                  ironManLabel.move(1,0);
               }else if(ironMove == 1){
                  ironManBrick.move(-1,0.5);
                  ironManLabel.move(-1,0.5);
               }else if(ironMove == 2){
                  ironManBrick.move(1,0);
                  ironManLabel.move(1,0);
               }else if(ironMove == 3){
                  ironManBrick.move(-1,-0.5);
                  ironManLabel.move(-1,-0.5);
               }
            }
            if(ironManBall != null){
               if(ironManBall.isVisible())
                  ironManBall.move(0,1);
            }
            if(strangeBrick.getX() == WIDTH-50)
               leftRight = 1;
            if(strangeBrick.getX() == 50)
               leftRight = 0;
            switch(leftRight){
               case 0: strangeBrick.move(1,0);
                  strangeLabel.move(1,0);
                  break;
               case 1: strangeBrick.move(-1,0);
                  strangeLabel.move(-1,0);
                  break;
            }
            if(makeClone){
               if(strangeBrick.getX() + 27 == WIDTH/2){
                  createClones();
                  makeClone = false;
               }
            }
         }
         if(round == 12){
            if(bomb){
               if(wandaBall.getY() != mindStone.getY())
                  wandaBall.move(0,-0.5);
               else
                  deleteMindStone();
            }
         }
         if(round == 13){
            ball.setVisible(false);
            hammer.move(0,1.5);
         }
         //checking contact along the outer walls
         if(ball.getY()<0)  //top
            vy = -vy;
         if(ball.getY()+Ball_Height>HEIGHT) //bottom
            end();
         if(ball.getX()<0) //left
            vx = -vx;
         if(ball.getX()+Ball_Width>WIDTH) //right
            vx = -vx;
            
         //check for collisions
         int preChangeX = -1;
         int preChangeY = -1;
         int leftRight = 0;
         for(int repeatCol = 0;repeatCol<4;repeatCol++){
            switch(repeatCol){
               case 1: preChangeY = 50;
                  break;
               case 2: preChangeX = 50;
                  break;
               case 3: preChangeY = -1;
                  break;
               default: 
                  break;
            }
            collider = getCollidingObject(preChangeX,preChangeY);
            if(round == 3){
               if(collider == powerStone){
                  nextRound();
               }else if(collider == wall1 || collider == wall2 || collider == wall3)
                  bounceOff(repeatCol);  
            }
            if(round == 5){
               if(collider == spaceStone)
                  nextRound();
               if(collider == asgardShip){
                  bounceOff(repeatCol);
                  shipHealth++;
                  if(shipHealth == 4){
                     remove(asgardShip);
                     remove(shipWall);
                  }
               }
               if(collider == lokiBrick || collider == lokiLabel){
                  remove(lokiBrick);
                  remove(lokiLabel);
                  createSpaceStone();
                  ball.setLocation(200,350);
               }
               if(collider == hulkBrick || collider == hulkLabel){
                  hulkHealth--;
                  hulkHealthLab.setLabel("Hulk: " + hulkHealth);
                  if(hulkHealth == 0){
                     remove(hulkHealthLab);
                     remove(hulkBrick);
                     remove(hulkLabel);
                  }
                  bounceOff(repeatCol);
               }
               if(collider == thorBrick || collider == thorLabel){
                  remove(thorBrick);
                  bounceOff(repeatCol);
                  thorBall.setVisible(true);
               }
               if(stopThorBall == 0){
                  colliderPaddle = getCollidingObjectPaddle(preChangeX,preChangeY);
                  if(thorBall.getY()+40 == HEIGHT){
                     end();
                     remove(thorBall);
                  }else if(colliderPaddle == thorBall){  // thorBall.getX()+8 >= paddle.getX() && thorBall.getX()+8 <= paddle.getX()+40 && thorBall.getY()+40 == paddle.getY()
                     remove(thorBall); 
                     stopThorBall++;            //here
                  }
               }
               if(collider == shipWall){
                  bounceOff(repeatCol);
               }
            }
            if(round == 7){
               if(collider == collecterBrick || collider == collecterLabel){
                  remove(collecterBrick);
                  remove(collecterLabel);
                  bounceOff(repeatCol);
               }
               if(collider == realityStone){
                  nextRound();
               }
            }
            if(round == 8){
               if(collider == gogWall){
                  bounceOff(repeatCol);
               }
               if(collider == gamoraBrick || collider == gamoraLabel){
                  nextRound();
               }
               if(collider == draxBrick || collider == draxLabel){
                  draxHealth--;
                  draxHealthLab.setLabel("Drax: " + draxHealth);
                  if(draxHealth == 0){
                     remove(draxHealthLab);
                     remove(draxBrick);
                     remove(draxLabel);
                     gogDeaths--;
                     if(gogDeaths == 0)
                        remove(gogWall);
                  }
                  bounceOff(repeatCol);
               }
               if(collider == mantisBrick || collider == mantisLabel){
                  remove(mantisBrick);
                  remove(mantisLabel);
                  gogDeaths--;
                  if(gogDeaths == 0)
                     remove(gogWall);
                  bounceOff(repeatCol);
               }
               if(collider == starLordBrick || collider == starLordLabel){
                  remove(starLordBrick);
                  remove(starLordLabel);
                  gogDeaths--;
                  if(gogDeaths == 0)
                     remove(gogWall);
                  bounceOff(repeatCol);
               }
            }
            if(round == 10){
               if(collider == timeStone && timeStone != null){
                  nextRound();
               }
               if(collider == ironManBrick && ironManBrick != null || collider == ironManLabel && ironManBrick != null){
                  ironHealth--;
                  ironHealthLab.setLabel("Iron man: " + ironHealth);
                  if(ironHealth == 0){
                     remove(ironHealthLab);
                     remove(ironManBrick);
                     remove(ironManLabel);
                     createTimeStone();
                  }
                  bounceOff(repeatCol);
               }
               if(collider == strangeBrick || collider == strangeLabel){
                  switch(strangeHealth){
                     case 2: ball.setLocation(200,350);
                        strangeHealth--;
                        butterfly = new GImage("butterfly.png");
                        butterfly.setBounds(strangeBrick.getX()-20,strangeBrick.getY()-22,100,75);
                        add(butterfly);
                        strangeTimer.start();
                        break;
                     case 1:ball.setLocation(200,350);
                        strangeHealth--;
                        mirror = new GImage("mirror.png");
                        mirror.setBounds(0,0,400,600);
                        add(mirror);
                        strangeTimer.start();
                        break;
                     case 0: remove(strangeBrick);
                        remove(strangeLabel);
                        remove(clone);
                        //creat iron man
                        ironManBrick = new GOval(50,50,BRICK_WIDTH+15,BRICK_HEIGHT+5);
                        ironManBrick.setFilled(true);
                        ironManBrick.setColor(ironMan);
                        add(ironManBrick);
                        ironManLabel = new GLabel("Ironman",56,59);
                        ironManLabel.setColor(Color.WHITE);
                        ironManLabel.setFont(new Font("Pacifico",Font.BOLD,10));
                        add(ironManLabel); 
                        ironHealthLab = new GLabel("Iron Man: " + ironHealth,2,25);
                        ironHealthLab.setColor(textCol);
                        ironHealthLab.setFont(new Font("Pacifico",Font.BOLD,30));
                        add(ironHealthLab);
                        createBrick10();
                        ball.setLocation(0,375);
                        if(vy < 0)
                           vy = -vy;
                        bounceOff(repeatCol);
                        break;
                  }
               }
            }
            if(round == 12){
               if(collider == capBrick || collider == capLabel){
                  pause(1000);
                  remove(capBrick);
                  remove(capLabel);
               }
               if(collider == wandaBrick || collider == wandaLabel){
                  remove(wandaBrick);
                  remove(wandaLabel);
                  createMindStone();
               }
               if(collider == mindStone && mindStone != null || collider == visLabel && visLabel != null)
                  nextRound();
            }
            if(round == 13){
               colliderPaddle = getCollidingObjectPaddle(preChangeX,preChangeY);
               if(colliderPaddle == hammer){
                  end();
               }
               if(hammer.getY() >=  HEIGHT-100){
                  remove(hammer);
                  nextRound();
               }
            }
            
            if(collider == paddle){ 
               vy = -vy;
               ball.move(0,-1); //stops it from constainly read
            }else if(collider instanceof GRect && collider != spaceStone && collider != shipWall && collider != gogWall){ //collided with a brick
               bounceOff(repeatCol);
               remove(collider); //remove the brick
               brickTotal++;
            }
         }
      }
   }
   public void bounceOff(int way){
      switch(way){
         case 0: vy = -vy;
            ball.move(0,1);
            break;
         case 1: vy = -vy;
            ball.move(1,0);
            break;
         case 2: vy = -vy;
            ball.move(-1,0);
            break;
         case 3: vy = -vy;
            ball.move(0,1);
            break;
      } 
   }

	//getCollidingObject -- called from the playBall method
	//discovers and returns the object that the ball collided with
   public GObject getCollidingObject(int changeX, int changeY){
      return getElementAt(ball.getX()+changeX, ball.getY()+changeY);
   } 
   public GObject getCollidingObjectPaddle(int changeX, int changeY){
      return getElementAt(paddle.getX()+changeX, paddle.getY()+changeY);
   } 
      
	//mouseMoved method -- called by the mouseListener when the mouse is moved
   public void mouseMoved(MouseEvent e)
   {
   	//only move the paddle every 5th mouse event 
   	//otherwise the play slows every time the mouse moves
      if(toggle == 5)
      {
      	//get the x-coordinate of the mouse
         double eX = e.getX();
      	
      	//if the mouse moved to the right
         if(eX - lastX > 0)
         {
           	//if paddle is not already at the right wall
            if(paddle.getX() < WIDTH - PADDLE_WIDTH)
            {
            	//move to the right
               paddle.move(eX - lastX, 0);
            }
         }
         else //(if the mouse moved to the left)
         {
           	//if paddle is not already at the left wall
            if(paddle.getX() > 0)
            {
            	//move to the left
               paddle.move(eX - lastX, 0);
            }
         }
           	
           //record this mouse x position for next mouse event         	
         GPoint last = new GPoint(e.getPoint());
         lastX = last.getX();
      	
      	//reset toggle to 1 
         toggle = 1;
      }
      else
      {
      	//increment toggle by 1
      	//(when toggle gets to 5 the code will move the paddle 
      	// and reset toggle back to 1)
         toggle++;
      }	
   }
   public void createBackground(int witchBack){
      if(witchBack == 1){
         background1 = new GImage("marvel.png");
         background1.setBounds(0,0,400,600);
         add(background1);
      }
      if(witchBack == 2){
         background0 = new GImage("ThanosBack.jpg");
         background0.setBounds(-100,0,600,600);
         add(background0);
      }
      if(witchBack == 3){
         int r = 50;
         int g = 50;
         int b = 170;
         for(int i=0;i<HEIGHT;i++){
            Color background = new Color(r,g,b);
            if(i%3 == 0){
               if(r<190){
                  r += 1;
               }else{
                  b -= 1;
               }
            }
            GLine line = new GLine(0,0+i,WIDTH,0+i);
            line.setColor(background);
            add(line);
         }
         score = new GLabel("Ships destroyed: " + brickTotal, 2,17);
         score.setFont(new Font("Pacifico",Font.BOLD,20));
         score.setColor(textCol);
         add(score);
      }
      if(witchBack == 4){
         background3 = new GImage("Space.jpg");
         background3.setBounds(-50,0,500,650);
         add(background3);
      }
      if(witchBack == 5){
         background4 = new GImage("knowhere.jpg");
         background4.setBounds(0,0,400,600);
         add(background4);
      }
      if(witchBack == 6){
         background4 = new GImage("flame.jpg");
         background4.setBounds(0,0,400,600);
         add(background4);
      }
      if(witchBack == 7){
         background5 = new GImage("titian.jpg");
         background5.setBounds(0,0,400,600);
         add(background5);
      }
      if(witchBack == 8){
         background6 = new GImage("wakanda.jfif");
         background6.setBounds(-76,-50,552,700);
         add(background6);
      }
      if(witchBack == 9){
         background7 = new GImage("lastFight.jpg");
         background7.setBounds(-50,-50,500,700);
         add(background7);
      }
      if(witchBack == 10){
         background8 = new GImage("end.jfif");
         background8.setBounds(0,0,400,600);
         add(background8);
      }
   }
   
   public void end(){
   lives--;
      if(lives == 2){
      ball.setLocation(150,350);
      vy = -vy;
      remove(cull);
      }
      if(lives == 1){
      ball.setLocation(150,350);
      vy = -vy;
      remove(midnight);
      }
      if(lives == 0){
      remove(maw);
      GLabel endLabel = new GLabel("Game Over",labelX,labelY);
      endLabel.setColor(textCol);
      endLabel.setFont(new Font("Pacifico",Font.BOLD,60));
      endLabel.setVisible(true);
         
      add(endLabel);
      vx = 0;
      vy = 0;
      toggle = 0; 
      stopPro = false;
      }
   }
   private class StrangeListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(strangeHealth == 1)
            remove(butterfly);
         else 
            remove(mirror);
         strangeTimer.stop();
      }
   }
   private class WallListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         switch(brickTotal){
            case 15: remove(wall3);
               break;
            case 35: remove(wall2);
               break;
            case 50: remove(wall1);
               wallTimer.stop();
               break;
            default:
               break;
         }
      } 
   }
}
