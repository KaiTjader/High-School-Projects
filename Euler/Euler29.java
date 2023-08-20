package Euler;
//Kai Tjader
import java.math.BigInteger;
import java.util.ArrayList;

public class Euler29{
   public static void main(String[] args){
      System.out.println(bigInt());
   }
   public static int bigInt(){
   //create feild
      ArrayList<BigInteger> arr = new ArrayList<BigInteger>();
   
      BigInteger one = new BigInteger("1");
      BigInteger x = one;
      BigInteger two = new BigInteger("2");
      //BigInteger four = new BigInteger("4");
      BigInteger hundOne = new BigInteger("101");
      //arr.add(four);
      
      for(BigInteger i=two;!i.equals(hundOne);i = i.add(one)){ //loop threw num
         for(int c=2;c<101;c++){ //loop threw power
            x=i;
            x = x.pow(c);
            if(!arr.contains(x)){
               arr.add(x);
            }
         }
      }
      return arr.size();
   }
}