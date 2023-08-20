package Euler;
//Kai Tjader 

public class EulerProject
{
   private static int[] prob7Arr;
   public static void main(String[] args){
   //Problum 1
      int total = 0;
      for(int i=0;i<1000;i++){
         if(i % 3 == 0){
            total += i;
         }else if(i % 5 == 0){
            total += i;
         }
      }
      System.out.println("Problem 1: " +total);
   //Problum 5
      boolean notDivisible = true;
      int number = 0;
      int counter = 0;
      int [] oneTwenty = {11,12,13,14,15,16,17,18,19,20};
      while(notDivisible){
         number++;
         for(int i: oneTwenty){
            if(number % i == 0){
               counter++;
               if(counter == 10 && number % 2 == 0){
                  System.out.println("Problem 5: " + number);
                  notDivisible = false;
               }
            }
         }
         counter = 0;
      }
   //Problum 7
      fillArray();
      System.out.println("Problem 7: " + prob7Arr[10000]);
   }
   public static void fillArray(){
      prob7Arr = new int[10001];
      int spot = 0;
      
      for(int i=2;spot<10001;i++){
         if(isPrime(i)){
            prob7Arr[spot] = i;
            spot++;
         }
      }
   }
   
   public static boolean isPrime(int num){
      for(int i=2;i<=num/2;i++){
         if(num % i == 0)
            return false;
      }
      return true;
   }

}