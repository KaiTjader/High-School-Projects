package Programs;
//Kai Tjader

public class Program2{
   public static void main(String[] args){
      int [][] testArr1 = {{1,2,3},{4,2,6}};
      System.out.println(getMostRepeatedNumber(testArr1));
   }
   public static int getMostRepeatedNumber(int[][]array){
      int[] numbers = {0,0,0,0,0,0,0,0,0,0};
      int lowestNum = -1;
      int lowestRepeats = -1;
      int emptyCounter = 0;
      int indexCounter = 0;
      if(array.length == 0)
         return -1;
      for(int[] traverse: array){ //opens all the arrays
         if(traverse.length == 0){ //check if the array is empty
            emptyCounter++;
            if(emptyCounter == array.length){
               return -1;
            }
         }
         for(int i: traverse){ //opens each individual array
            numbers[i]++; //adds to the index in numbers
         }
      }
      for(int i: numbers){ // finds the highest repeating nuber
         if(i > lowestRepeats){ //what if equal
            lowestRepeats = i;
            lowestNum = indexCounter;
         }
         indexCounter++;
      }
      for(int i: numbers){
         System.out.print(i + " ");
      }
      return lowestNum;
   }
}