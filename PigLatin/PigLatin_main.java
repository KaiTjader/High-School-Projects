package PigLatin;
// Kai Tjader
import java.util.Scanner;

public class PigLatin_main{
   //runs the program
   public static void main(String[] args){
      String word = getWord();
      String pigWord = convertToPigLatin(word);
      System.out.println("Original word: " + word + " converts to " + pigWord);
   }
   //gets the word
   public static String getWord(){
      Scanner keyBoard = new Scanner(System.in);
      System.out.print("Enter a word: ");
      String temp = keyBoard.nextLine();
      keyBoard.close();
      return temp;
   }
   //converts to PigLatin
   public static String convertToPigLatin(String word){
      //quotations
      boolean isQuote = false;
      if(word.charAt(word.length()-1) == '"'){
         isQuote = true;
         word = word.substring(1,word.length()-1); 
      }
      //uppercase
      boolean isUppercase = false;
      if(Character.isUpperCase(word.charAt(0))){
         word = word.toLowerCase();
         isUppercase = true;
      }
      //puncuation
      int end = 0;
      switch(word.charAt(word.length()-1)){
         case '?': end++;
         case '!': end ++;
         case '.': end++;
            word = word.substring(0,word.length()-1);
            break; 
      }
      //translates the word
      int vowelPlace = findVowelPlace(word);
      String prePigWord = "NULL";
      switch(vowelPlace){
         case 0: //if the vowel is in the first place
            if(word.charAt(0) == 'y'){
               prePigWord = word.substring(1) + "yay";
            }else if(word.charAt(0) == 'y'){
               prePigWord = word.substring(1) + "Yay";
            }else{
               prePigWord = word + "way";
            }
            break;
         case -1: prePigWord = word.substring(2) + "quay"; //in case of "qu"
            break;
         case -2: prePigWord = word.substring(3) + "squay";
            break;
         case -3: return "***INVALID***"; //invalid
         default: //regular translation
            prePigWord = word.substring(vowelPlace) + word.substring(0,vowelPlace) + "ay";
      }
      //adds uppercase
      if(isUppercase){
         String firstLetter = prePigWord.substring(0,1);
         String capLetter = firstLetter.toUpperCase();
         prePigWord = capLetter + prePigWord.substring(1);
      }
      //adds puncuation
      switch(end){
         case 1: prePigWord = prePigWord + ".";
         break;
         case 2: prePigWord = prePigWord + "!";
         break;
         case 3: prePigWord = prePigWord + "?";
         break;
      }
      //add quotes
      if(isQuote){
         return '"' + prePigWord + '"';
      }
      return prePigWord;
   }
   //finds where the vowel is | if it doesnt have one
   public static int findVowelPlace(String word){
      for(int i=0;i<word.length();i++){
         switch(word.substring(i,i+1)){
            case "a":
            case "i":
            case "o": 
            case "e": 
            case "y":
               return i;
            case "u":
               if(word.indexOf("u") != 0){
                  if(word.charAt(i-1) == 'q'){
                     if(i == 1){
                        return -1; //has a qu
                     }else{
                        return -2;
                        }
                  }
               }
               return i;
         }
      }
      return -3; //invalid
   }
}