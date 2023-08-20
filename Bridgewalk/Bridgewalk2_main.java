//Kai Tjader
package Bridgewalk;
public class Bridgewalk2_main
{
   private static char [] bridge;
   private static int spot;
   private static int step = 0;
   private static boolean keepGoing = true;
   private static double averageSteps = 0;
   
   public static void main(String[] args){
      printAverage(5);
      printAverage(9);
      printAverage(11);
      printAverage(13);
      printAverage(17);
      printAverage(23);
      printAverage(31);
      printAverage(63);
   }
   
   public static void printAverage(int size){
      for(int i=0;i<100000;i++){
      initialize(size);
      oneWalk();
      }
      averageSteps /= 100000.0;
      averageSteps++;
      System.out.println("The average is for " + size + " is " + averageSteps);
   }
   
   public static void oneStep(){
      bridge[spot] = '-';
      int flipVal = flipCoin();
      spot += flipVal;
      if(spot == bridge.length || spot == -1){
         averageSteps += step;
         keepGoing = false;
      }else{
      //move the person
      bridge[spot] = '*';
      step++;
      }
      //keep doing this until the person walks off the bridge
   }
   
   public static void oneWalk(){
      while(keepGoing){
         oneStep();
      }
   }
   
   
   public static void initialize(int size){ //Nalin's fillArray 
      bridge = new char[size];
      spot = bridge.length/2;
      keepGoing = true;
      step = -1;
      bridge[spot]='*';
      step++;
   }
   
   public static int flipCoin()
   {
      int flip = (int)(Math.random()*100000);
      int outcome = (flip % 2 == 0)? -1: 1;
      return outcome;
   }
}
/*
The average is for 5 is 9.0118
The average is for 9 is 25.013110118
The average is for 11 is 36.081310131101176
The average is for 13 is 48.90622081310131
The average is for 17 is 81.45272906220814
The average is for 23 is 144.9259745272906
The average is for 31 is 256.4580892597453
The average is for 63 is 1025.8353045808926
*/