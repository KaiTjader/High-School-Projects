package Programs;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Program4{
   public static void main(String[] args){
      System.out.print("Enter a sentence: ");
      Scanner kb = new Scanner(System.in);
      String str = kb.nextLine();
      
      StringTokenizer st = new StringTokenizer(str);
      
      //1
      int count = 0;
      while(st.hasMoreTokens()){
         st.nextToken();
         count++;
      }
      System.out.println("A1: " + count);
      
      //2 wrong
      System.out.println("A2: " + st.countTokens());
      
      //3
      count = 1;
      for(int i=0;i<str.length();i++){
         if(str.charAt(i) == ' '){
            count++;
         }
      }
      System.out.println("A3: " + count);
      
      //4
      count = 0;
      String [] array = str.split(" ");
      System.out.println("A4: " + array.length);
      kb.close();
   }
}