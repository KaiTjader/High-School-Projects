package RPNCalculator;
//Kai Tjader
import java.util.Stack;
import java.util.StringTokenizer;

public class RPNCalculator_main {
   public static void main(String[] args){
      System.out.println(findResults("5 4 + 5 2 - *"));
   }
   public static int findResults(String str){ // + - * /
      //set up
      Stack<Integer> calc = new Stack<Integer>();
      StringTokenizer st = new StringTokenizer(str);
      
      while(st.hasMoreTokens()){
         String n = st.nextToken();
         if(n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/")){
            int secNum = calc.pop();
            int firNum = calc.pop();
            switch(n){
            case "+": calc.push(firNum + secNum); 
            break;
            case "-": calc.push(firNum - secNum);
            break;
            case "*": calc.push(firNum * secNum);
            break;
            case "/": calc.push(firNum / secNum);
            break;
            }
         }else{
            calc.push(Integer.parseInt(n));
         }
      }
      
      return calc.pop();
   }
}