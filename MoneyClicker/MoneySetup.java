package MoneyClicker;
//Names: Kai Tjader & Chris Sibrian
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.green;

public class MoneySetup extends JPanel {
  private ImageIcon dollar;
  private JButton dollarButton;
  private JButton shopItemZero, shopItemOne, shopItemTwo, shopItemThree, shopItemFour, shopItemFive;
  // shop item display
  private JLabel shopItemZeroDisplay, shopItemOneDisplay, shopItemTwoDisplay, shopItemThreeDisplay, shopItemFourDisplay,
      shopItemFiveDisplay;
  // stats display
  private JLabel statDislayItems, statDislayCPS, statDislayBestCPS;
  private static JLabel statDislayTot;
  // other display
  private JLabel shopDisplay, feedbackDisplay, statsLabel;
  private static JLabel pointsDisplay;
  private JPanel middleSplit, leftSide, rightSide, leftInside, bottomLeft, bottomLeftInside, bottomRight, bottomRightInsideOne, bottomRightInsideTwo, bottomRightInsideThree;
  // updates the clicks for item
  private Timer grannyTimer, robotTimer, farmTimer, factoryTimer, clonerTimer;
  // updates the stats
  private Timer statSecTimer, statMinTimer;
  // golden dollar timer
  private Timer goldenTimer, goldWaitTimer;
  private boolean goldenOn;
  // the main currency
  private static int clicks;
  // adds this much every time
  private int clickerAdder, grannyAdder, robotAdder, farmAdder, factoryAdder, clonerAdder;
  //how much the items will cost
  private static int clickerCost, grannyCost, robotCost, farmCost, factoryCost, clonerCost;
  //Items displays
  private JLabel clickerDisplay, grannyDisplay, robotDisplay, farmDisplay, factoryDisplay, clonerDisplay;
  private JLabel clickerLevelDisplay, grannyLevelDisplay, robotLevelDisplay, farmLevelDisplay, factoryLevelDisplay, clonerLevelDisplay;
  private JLabel clickerIntake, grannyIntake, robotIntake, farmIntake, factoryIntake, clonerIntake;
  private int clickerLevel, grannyLevel, robotLevel, farmLevel, factoryLevel, clonerLevel;
  //stat var
  private static int totalStat, goldenMultiplier;
  private double cpsStat, bestcpsStat, shopItemStat, itemPS;
  //colors
  private Color lightBlue, darkBlue, purple, lightPurple, darkPurple;
  

  // didi
  ImageIcon reg = new ImageIcon("Dollar.png");
  ImageIcon golden = new ImageIcon("GDollar.png");


  public MoneySetup() {
    clicks = 0;
    totalStat = 0;
    // adders
    clickerAdder = 1;
    grannyAdder = 0;
    robotAdder = 0;
    farmAdder = 0;
    factoryAdder = 0;
    clonerAdder = 0;
    // costs
    clickerCost = 10;
    grannyCost = 10;
    robotCost = 100;
    farmCost = 1000;
    factoryCost = 5000;
    clonerCost = 10000;
    //levels
    clickerLevel = 1;
    // stats
    shopItemStat = 0;
    cpsStat = 0;
    bestcpsStat = 0;
    itemPS = 0.0;
    goldenMultiplier = 1;
    // golden dollar
    goldenOn = false;
    //creates colors   darkBlue, regBlue, purple, lightPurple
    lightBlue = new Color(140,158,255);
    darkBlue = new Color(26,35,126);
    purple = new Color(185,96,236);
    lightPurple = new Color(177,156,217);
    darkPurple = new Color(123,31,162);

    // feilds
    middleSplit = new JPanel(false); // creats the split between the left and right
    middleSplit.setLayout(new GridLayout(2, 2));
    middleSplit.setSize(new Dimension(437, 200));
    add(middleSplit);

    leftSide = new JPanel(); // creats the left side where the shop will be
    leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.Y_AXIS));
    leftSide.setBackground(purple);

    leftInside = new JPanel(); // creats the left side where the shop will be
    leftInside.setLayout(new GridLayout(6, 2));
    leftInside.setBackground(purple);

    rightSide = new JPanel(); // creats the right side where the dollarButton will be
    rightSide.setLayout(new GridLayout(3, 1));
    rightSide.setBackground(lightPurple);
    middleSplit.add(leftSide);
    middleSplit.add(rightSide);

    bottomLeft = new JPanel();
    bottomLeft.setLayout(new BoxLayout(bottomLeft, BoxLayout.Y_AXIS));
    bottomLeft.setBackground(lightPurple);

    bottomLeftInside = new JPanel();
    bottomLeftInside.setLayout(new GridLayout(6, 1));
    bottomLeftInside.setBackground(lightPurple);

    bottomRight = new JPanel();
    bottomRight.setLayout(new GridLayout(1, 3));
    bottomRight.setBackground(purple);
    
    middleSplit.add(bottomLeft);
    middleSplit.add(bottomRight);

    bottomRightInsideOne = new JPanel();
    bottomRightInsideOne.setLayout(new GridLayout(6, 1));
    bottomRightInsideOne.setBackground(purple);
    bottomRightInsideTwo = new JPanel();
    bottomRightInsideTwo.setLayout(new GridLayout(6, 1));
    bottomRightInsideTwo.setBackground(lightBlue);
    bottomRightInsideThree = new JPanel();
    bottomRightInsideThree.setLayout(new GridLayout(6, 1));
    bottomRightInsideThree.setBackground(purple);

    // Top Left side
    shopDisplay = new JLabel("Shop: ");
    shopDisplay.setFont(new Font("Serif", Font.BOLD, 25));
    shopDisplay.setForeground(darkBlue);
    leftSide.add(shopDisplay);

    leftSide.add(leftInside);

    shopItemZeroDisplay = new JLabel("Clicker");
    jlabelCreater(shopItemZeroDisplay, darkBlue);
    leftInside.add(shopItemZeroDisplay);
    shopItemZero = new JButton("Cost: " + clickerCost);
    shopItemZero.addActionListener(new ShopListenerZero());
    jbuttonCreater(shopItemZero);
    leftInside.add(shopItemZero);

    shopItemOneDisplay = new JLabel("Granny");
    jlabelCreater(shopItemOneDisplay, darkBlue);
    leftInside.add(shopItemOneDisplay);
    shopItemOne = new JButton("Cost: " + grannyCost);
    shopItemOne.addActionListener(new ShopListenerOne());
    jbuttonCreater(shopItemOne);
    leftInside.add(shopItemOne);
    grannyTimer = new Timer(10000, new GannyListener());
    grannyTimer.start();

    shopItemTwoDisplay = new JLabel("Robot");
    jlabelCreater(shopItemTwoDisplay, darkBlue);
    leftInside.add(shopItemTwoDisplay);
    shopItemTwo = new JButton("Cost: " + robotCost);
    shopItemTwo.addActionListener(new ShopListenerTwo());
    jbuttonCreater(shopItemTwo);
    leftInside.add(shopItemTwo);
    robotTimer = new Timer(10000, new RobotListener());
    robotTimer.start();

    shopItemThreeDisplay = new JLabel("Farm");
    jlabelCreater(shopItemThreeDisplay, darkBlue);
    leftInside.add(shopItemThreeDisplay);
    shopItemThree = new JButton("Cost: " + farmCost);
    shopItemThree.addActionListener(new ShopListenerThree());
    jbuttonCreater(shopItemThree);
    leftInside.add(shopItemThree);
    farmTimer = new Timer(15000, new FarmListener());
    farmTimer.start();

    shopItemFourDisplay = new JLabel("Factory");
    jlabelCreater(shopItemFourDisplay, darkBlue);
    leftInside.add(shopItemFourDisplay);
    shopItemFour = new JButton("Cost: " + factoryCost);
    shopItemFour.addActionListener(new ShopListenerFour());
    jbuttonCreater(shopItemFour);
    leftInside.add(shopItemFour);
    factoryTimer = new Timer(15000, new FactoryListener());
    factoryTimer.start();

    shopItemFiveDisplay = new JLabel("Cloner");
    jlabelCreater(shopItemFiveDisplay, darkBlue);
    leftInside.add(shopItemFiveDisplay);
    shopItemFive = new JButton("Cost: " + clonerCost);
    shopItemFive.addActionListener(new ShopListenerFive());
    jbuttonCreater(shopItemFive);
    leftInside.add(shopItemFive);
    clonerTimer = new Timer(30000, new ClonerListener());
    clonerTimer.start();

    // Top Right side
    pointsDisplay = new JLabel("Money: " + clicks);
    pointsDisplay.setFont(new Font("Serif", Font.BOLD, 25));
    jlabelCreater(pointsDisplay, darkPurple);
    rightSide.add(pointsDisplay);

    dollar = new ImageIcon("Dollar.png");
    // GDollar.png is the golden dollar
    // Dollar.png is the normal dollar
    dollarButton = new JButton(dollar);
    dollarButton.setSize(150, 100);
    dollarButton.addActionListener(new mainListener());
    dollarButton.setContentAreaFilled(false); // No fill
    dollarButton.setFocusable(false);
    dollarButton.setBorder(null);
    goldenTimer = new Timer(100000, new GoldenDollarListener());
    goldenTimer.start();
    goldWaitTimer = new Timer(3000, new WaitListener());
    // jbuttonCreater(dollarButton);
    rightSide.add(dollarButton);

    dollarButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        dollarButton.setBorder(BorderFactory.createLineBorder(green, 2, true));
      }

      @Override
      public void mouseExited(MouseEvent e) {
        dollarButton.setBorder(null);
      }
    });

    feedbackDisplay = new JLabel("Click the dollar!");
    jlabelCreater(feedbackDisplay, darkPurple);
    feedbackDisplay.setFont(new Font("Serif", Font.BOLD, 25));
    rightSide.add(feedbackDisplay);

    // Bottom Left side
    statSecTimer = new Timer(2000, new StatSecListener());
    statSecTimer.start();
    statMinTimer = new Timer(30000, new StatMinListener());
    statMinTimer.start();

    statsLabel = new JLabel("Stats:");
    statsLabel.setFont(new Font("Serif", Font.BOLD, 25));
    jlabelCreater(statsLabel, darkPurple);
    bottomLeft.add(statsLabel);

    bottomLeft.add(bottomLeftInside);

    statDislayTot = new JLabel("Total made: 0");
    jlabelCreater(statDislayTot, darkPurple);
    bottomLeftInside.add(statDislayTot);

    statDislayCPS = new JLabel("CPS: 0.0");
    jlabelCreater(statDislayCPS, darkPurple);
    bottomLeftInside.add(statDislayCPS);

    statDislayBestCPS = new JLabel("Best CPS: 0.0");
    jlabelCreater(statDislayBestCPS, darkPurple);
    bottomLeftInside.add(statDislayBestCPS);

    statDislayItems = new JLabel("Items PS: 0.0");
    jlabelCreater(statDislayItems, darkPurple);
    bottomLeftInside.add(statDislayItems);

    // Bottom Right side
    bottomRight.add(bottomRightInsideOne);
    bottomRight.add(bottomRightInsideTwo);
    bottomRight.add(bottomRightInsideThree);

    //Names
    clickerDisplay = new JLabel("Clicker");
    jlabelCreater(clickerDisplay, darkBlue);
    bottomRightInsideOne.add(clickerDisplay);

    grannyDisplay = new JLabel("Granny");
    jlabelCreater(grannyDisplay, darkBlue);
    bottomRightInsideOne.add(grannyDisplay);

    robotDisplay = new JLabel("Robot");
    jlabelCreater(robotDisplay, darkBlue);
    bottomRightInsideOne.add(robotDisplay);

    farmDisplay = new JLabel("Farm");
    jlabelCreater(farmDisplay, darkBlue);
    bottomRightInsideOne.add(farmDisplay);

    factoryDisplay = new JLabel("Factory");
    jlabelCreater(factoryDisplay, darkBlue);
    bottomRightInsideOne.add(factoryDisplay);

    clonerDisplay = new JLabel("Cloner");
    jlabelCreater(clonerDisplay, darkBlue);
    bottomRightInsideOne.add(clonerDisplay);

    //Item Levels
    clickerLevelDisplay = new JLabel("lv.0");
    jlabelCreater(clickerLevelDisplay, darkBlue);
    bottomRightInsideTwo.add(clickerLevelDisplay);

    grannyLevelDisplay = new JLabel("lv.0");
    jlabelCreater(grannyLevelDisplay, darkBlue);
    bottomRightInsideTwo.add(grannyLevelDisplay);

    robotLevelDisplay = new JLabel("lv.0");
    jlabelCreater(robotLevelDisplay, darkBlue);
    bottomRightInsideTwo.add(robotLevelDisplay);

    farmLevelDisplay = new JLabel("lv.0");
    jlabelCreater(farmLevelDisplay, darkBlue);
    bottomRightInsideTwo.add(farmLevelDisplay);

    factoryLevelDisplay = new JLabel("lv.0");
    jlabelCreater(factoryLevelDisplay, darkBlue);
    bottomRightInsideTwo.add(factoryLevelDisplay);

    clonerLevelDisplay = new JLabel("lv.0");
    jlabelCreater(clonerLevelDisplay, darkBlue);
    bottomRightInsideTwo.add(clonerLevelDisplay);

    //Intake from Items
    clickerIntake = new JLabel("+1/click");
    jlabelCreater(clickerIntake, darkBlue);
    bottomRightInsideThree.add(clickerIntake);

    grannyIntake = new JLabel("+0/10s");
    jlabelCreater(grannyIntake, darkBlue);
    bottomRightInsideThree.add(grannyIntake);

    robotIntake = new JLabel("+0/10s");
    jlabelCreater(robotIntake, darkBlue);
    bottomRightInsideThree.add(robotIntake);

    farmIntake = new JLabel("+0/15s");
    jlabelCreater(farmIntake, darkBlue);
    bottomRightInsideThree.add(farmIntake);

    factoryIntake = new JLabel("+0/15s");
    jlabelCreater(factoryIntake, darkBlue);
    bottomRightInsideThree.add(factoryIntake);

    clonerIntake = new JLabel("+0/30s");
    jlabelCreater(clonerIntake, darkBlue);
    bottomRightInsideThree.add(clonerIntake);
  }

  public void jbuttonCreater(JButton temp) {
    temp.setBackground(lightBlue);
    temp.setForeground(darkPurple);
  }
  public void jlabelCreater(JLabel temp, Color color) {
    temp.setForeground(color);
    temp.setVerticalAlignment(SwingConstants.CENTER);
  }


  // Main Button Listener
  private class mainListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(goldenOn){
        goldenMultiplier = 2;
      }else{
        goldenMultiplier = 1;
      }
      clicks += clickerAdder*goldenMultiplier;
      totalStat += clickerAdder*goldenMultiplier;
      cpsStat++;

      pointsDisplay.setText("Money: " + clicks);
      feedbackDisplay.setText("+" + clickerAdder*goldenMultiplier);
      statUpdate(statDislayTot, "Total made: ", totalStat);
    }
  }

  public static int update(int cost, JButton temp) {
    clicks -= cost;
    pointsDisplay.setText("Money: " + clicks);
    cost *= 1.5;
    temp.setText("Cost: " + cost);
    return cost;
  }
  public static int levelUpdate(int level, JLabel temp){
    level++;
    temp.setText("lv." + level);
    return level;
  }
  
  // Shop Item Listeners
  private class ShopListenerZero implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (clicks >= clickerCost) {
        clickerCost = update(clickerCost, shopItemZero);
        clickerAdder++;
        clickerIntake.setText("+" + clickerAdder + "/click");
        clickerLevel = levelUpdate(clickerLevel, clickerLevelDisplay);
      } else {
        feedbackDisplay.setText("Not Enough");
      }
    }
  }

  private class ShopListenerOne implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (clicks >= grannyCost) {
        grannyCost = update(grannyCost, shopItemOne);
        grannyAdder += 5;
        grannyIntake.setText("+" + grannyAdder + "/10s");
        grannyLevel = levelUpdate(grannyLevel, grannyLevelDisplay);
      } else {
        feedbackDisplay.setText("Not Enough");
      }
    }
  }

  private class ShopListenerTwo implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (clicks >= robotCost) {
        robotCost = update(robotCost, shopItemTwo);
        robotAdder += 20;
        robotIntake.setText("+" + robotAdder + "/10s");
        robotLevel = levelUpdate(robotLevel, robotLevelDisplay);
      } else {
        feedbackDisplay.setText("Not Enough");
      }
    }
  }

  private class ShopListenerThree implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (clicks >= farmCost) {
        farmCost = update(farmCost, shopItemThree);
        farmAdder += 100;
        farmIntake.setText("+" + farmAdder + "/15s");
        farmLevel = levelUpdate(farmLevel, farmLevelDisplay);
      } else {
        feedbackDisplay.setText("Not Enough");
      }
    }
  }

  private class ShopListenerFour implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (clicks >= factoryCost) {
        factoryCost = update(factoryCost, shopItemFour);
        factoryAdder += 500;
        factoryIntake.setText("+" + factoryAdder + "/15s");
        factoryLevel = levelUpdate(factoryLevel, factoryLevelDisplay);
      } else {
        feedbackDisplay.setText("Not Enough");
      }
    }
  }

  private class ShopListenerFive implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (clicks >= clonerCost) {
        clonerCost = update(clonerCost, shopItemFive);
        clonerAdder += 2000;
        clonerIntake.setText("+" + clonerAdder + "/30s");
        clonerLevel = levelUpdate(clonerLevel, clonerLevelDisplay);
      } else {
        feedbackDisplay.setText("Not Enough");
      }
    }
  }

  public static void listenerUpdate(int adder) {
    clicks += adder;
    pointsDisplay.setText("Money: " + clicks);
    totalStat += adder;
    statUpdate(statDislayTot, "Total made: ", totalStat);
  }

  // Timers buttons
  private class GannyListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      listenerUpdate(grannyAdder);
    }
  }

  private class RobotListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      listenerUpdate(robotAdder);
    }
  }

  private class FarmListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      listenerUpdate(farmAdder);
    }
  }

  private class FactoryListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      listenerUpdate(factoryAdder);
    }
  }

  private class ClonerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      listenerUpdate(clonerAdder);
    }
  }

  // stat updaters
  public static void statUpdate(JLabel temp, String item, double stat) {
    temp.setText(item + stat);
  }

  public static void statUpdate(JLabel temp, String item, int stat) {
    temp.setText(item + stat);
  }

  private class StatSecListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      cpsStat /= 2;
      statUpdate(statDislayCPS, "CPS: ", cpsStat);
      if (cpsStat > bestcpsStat) {
        bestcpsStat = cpsStat;
        statUpdate(statDislayBestCPS, "Best CPS: ", cpsStat);
      }
      cpsStat = 0;
      
      statUpdate(statDislayItems, "Items PS: ", itemPS);
      
    }
  }

  private class StatMinListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      shopItemStat *= 2;
      statUpdate(statDislayItems, "Items PS: ", shopItemStat);
    }
  }

  // oporates the golden dollar
  private class GoldenDollarListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if(goldenOn){
        dollarButton.setIcon(reg);
        goldenOn = false;
      }else{
        dollarButton.setIcon(golden);
        goldenOn = true;
        goldWaitTimer.start();
      }
    }
  }
  private class WaitListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      dollarButton.setIcon(reg);
      goldenOn = false;
      goldWaitTimer.stop();
    }
  }
}