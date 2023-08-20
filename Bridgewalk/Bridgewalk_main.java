package Bridgewalk;
public class Bridgewalk_main
{
   private static char [] bridge = new char[7];
   private static int spot;
   private static int step = 0;
   private static boolean keepGoing = true;
   private static int largestSteps = 0;
   private static double averageSteps = 0;
   
   public static void main(String[] args){
      for(int i=0;i<10;i++){
      initialize(0);
      oneWalk();
      System.out.println("\n");
      }
      averageSteps /= 10.0;
      System.out.println("The average is " + averageSteps);
      System.out.println("The most steps are " + largestSteps);
   }
   
   public static void drawBridge(){
      step++;   
      System.out.print("Step " + step + ": ");
      System.out.println(bridge);
   }
   
   public static void oneStep(){
      bridge[spot] = '-';
      int flipVal = flipCoin();
      spot += flipVal;
      if(spot == bridge.length || spot == -1){
         System.out.println("The person left the bridge after " + step + " steps");
         if(largestSteps < step)
            largestSteps = step;
         averageSteps += step;
         keepGoing = false;
      }else{
      //move the person
      bridge[spot] = '*';
      drawBridge();
      }
      //keep doing this until the person walks off the bridge
   }
   
   public static void oneWalk(){
      while(keepGoing){
         oneStep();
      }
   }
   
   public static void initialize(int size){ //Nalin's fillArray 
      spot = bridge.length/2;
      keepGoing = true;
      step = -1;
      bridge[spot]='*';
      step++;
      System.out.print("Step " + step + ": ");
      System.out.println(bridge);
   }
   
   public static int flipCoin()
   {
      int flip = (int)(Math.random()*100);
      int outcome = (flip % 2 == 0)? -1: 1;
      return outcome;
   }
}