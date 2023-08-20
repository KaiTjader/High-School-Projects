package Hailstone;
//Kai Tjader
import java.util.*;

public class Hailstone{
   public static void main(String[] args){
      System.out.println("Question 1: " + question1(7450));
      System.out.println("Question 2: " + question2(731));
      System.out.println("Question 3: " + question3(472151));
      System.out.println("Question 4: " + question4(140394587));
      System.out.println("Question 5: " + question5(6887)); //370
   }
      
      /*************************************
   	*************************************/
   public static long question1(long num){
      ArrayList<Long> list = getHailstoneList(num);
      return list.size();
   }
   	
   	/*************************************
   	*************************************/
   public static long question2(long num){
      int count = 0;
      while(count!=47){
         if(question1(num) == 140){
            count++;
         }
         num++;
      }
      return num-1;
   }
      
   	/*************************************
   	*************************************/
   public static long question3(long num){
      for(long k=1; ;k++){
         ArrayList<Long> list = getHailstoneList(k);
         if(findSumOfList(list) == num){
            return k;
         }
      }   
   }
   	
   	/*************************************
   	*************************************/
   public static long question4(long highNum){
      int count = 0;
      ArrayList<Long> list = getHailstoneList(highNum);
      for(long i: list){
         if(i > highNum){
            count++;
            highNum = i;
         }
      }
      return count;
   }
      
   	/*************************************
   	*************************************/
   public static long question5(long num){
      int count = 0;
      while(num!=979547){
         if(question4(num) == 20){
            count++;
         }
         num++;
      }
      return count+1;
   }
      
   	/*************************************
   	*************************************/
   public static long howManyHighsOccurs(long num){
      return 1;
   }
    
     /*************************************
   	*************************************/
   public static ArrayList<Long> getHailstoneList(long x){
      ArrayList<Long> temp = new ArrayList<Long>();
      while(x != 1){
         temp.add(x);
         if(x % 2 == 0){
            x /= 2;
         }else{
            x = x*3 + 1;
         }
      }
      temp.add(1L); 
      return temp;
   }
    
     /*************************************
   	*************************************/
   public static long findSumOfList(ArrayList<Long> list){
      int sum = 0;
      for(long k: list){
         sum += k;
      }  		
      return sum;
   }    
}