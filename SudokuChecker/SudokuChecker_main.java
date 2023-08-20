package SudokuChecker;
//Kai Tjader
import java.util.ArrayList;

public class SudokuChecker_main{
   public static void main(String[] args){
      int [][] sudoku = {{6,9,3,8,2,5,7,1,4},
                        {5,4,7,9,1,3,6,2,8},
                        {2,1,8,7,6,4,5,9,3},
                        {8,2,6,1,4,9,3,7,5},
                        {7,3,4,2,5,8,1,6,9},
                        {1,5,9,3,7,6,4,8,2},
                        {3,6,1,4,9,2,8,5,7},
                        {4,7,2,5,8,1,9,3,6},
                        {9,8,5,6,3,7,2,4,1}};
      System.out.println(checkForSolution(sudoku));
   }
   public static boolean checkForSolution(int[][] sudoku){
      ArrayList<Integer> array = new ArrayList<Integer>();
      //square
      for(int x=0;x<9;x+=3){ //brings you to the next row of squares
         for(int y=0;y<9;y+=3){ //brings you the next colum of spots
            fillArray(array);
            for(int c=0;c<3;c++){ // brings you to the next square
               for(int h=0;h<3;h++){ //brings you to the next spot
                  removeArray(sudoku[c+x][h+y], array);
               }
            }
            if(array.size() != 0){
               return false;
            }
         }
      }
      //colum
      for(int i=0;i<8;i++){
         for(int[] r: sudoku){
            int num = r[i];
            System.out.print(num + ", ");
            removeArray(num, array);
         }
         if(array.size() != 0){
            System.out.println("colum ");
            return false;
         }
         System.out.println("");
      }
      //row
      for(int[] r: sudoku){ //gets in to first array
         fillArray(array); //fills testArray
         for(int num: r){
            removeArray(num, array);
         }
         if(array.size() != 0){//make sure nothing was missed
            return false;
         }
      }
      return true;
   }
   public static void fillArray(ArrayList<Integer> list){ //fills array with 1-9
      for(int i=1;i<10;i++){
         list.add(i);
      }
   }
   public static void removeArray(int num, ArrayList<Integer> list){ //fills array with 1-9
      for(int i=0;i<list.size();i++){
         if(list.get(i) == num){
            list.remove(i);
            break;
         }
      }
   }
}