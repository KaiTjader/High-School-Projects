package VowelCounter;
import java.util.Scanner;

public class VowelCounter_main{
   public static void main(String[] args){
      String word = getWord();
      int total = countVowels(word);
      System.out.println("there are " + total + "vowels");
   }
   public static String getWord(){
      Scanner keyBoard = new Scanner(System.in);
      System.out.print("Enter a word: ");
      String temp = keyBoard.nextLine();
      keyBoard.close();
      return temp;
   }
   public static int countVowels(String word){
      int numOfVow = 0;
      //char vowel = ' ';
      word = word.toLowerCase();
      for(int i=0;i<word.length();i++){
         switch(word.charAt(i)){
            case 'a': numOfVow++;
               break;
            case 'i': numOfVow++;
               break;
            case 'o': numOfVow++;
               break;
            case 'u': numOfVow++;
               break;
            case 'e': numOfVow++;
               break;
         }
      }
      return numOfVow;
   }
}