package Euler;
//Kai Tjader
import java.util.ArrayList;

public class Euler21{
   public static void main(String[] args){
      int sum = 0;
      int totalSum = 0;
      ArrayList<Integer> repeated = new ArrayList<Integer>();
      for(int i=0;i<10000;i++){
         sum = sumOfDivisors(i);
         if(!(repeated.contains(i)) && sumOfDivisors(sum)  == i && i != sum){
            //System.out.println(i + " & " + sum);
            repeated.add(sum);
            totalSum += sum + i;
         }
      }
      System.out.println(totalSum);
   }
   public static int sumOfDivisors(int num){
      int sum = 1;
      for(int i=2;i<num-1;i++){
         if(num%i == 0){
            sum += i;
         }
      }
      return sum;
   }
}