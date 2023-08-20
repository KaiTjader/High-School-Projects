package Euler;
//Kai Tjader
//Error with this program!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class Euler12{
   public static void main(String[] args){
      System.out.println(find500());
   }
   public static int countRemander(int num){
      int count = 2;
      for(int i=1;i<Math.sqrt(num);i++){
         if(num%i==0){
            count++;
         }
      }
      return count*2+1;
   }
   public static int find500(){
      for(int i=1000; ; i++){
         if(countRemander(i) > 500){
            return i;
         }
      }
   }
}