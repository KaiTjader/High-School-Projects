package MagicSquare;
//Kai Tjader
import java.util.*;

public class MagicSquare{
   public static void main(String[] args){ //do while arraySize%3==0
      int size = getSize();
      int xCord = getX(size);
      int yCord = getY(size);
      
      int [][] arr = new int[size][size];
      
      fillArray(arr,xCord,yCord);
      for(int[] t: arr){
         for(int k: t){
            System.out.print(k + " ");
         }
         System.out.println("");
      }
   }
   public static int getSize(){
      Scanner kb = new Scanner(System.in);
      int n = 2;
      do{
         System.out.print("How many rows? ");
         String number = kb.nextLine();
         n = Integer.parseInt(number);
      }while(n%2==0);
      
      return n;
   }
   public static int getX(int size){
      Scanner kb = new Scanner(System.in);
      int n = -1;
      do{
         System.out.print("Starting x postition? ");
         String number = kb.nextLine();
         n = Integer.parseInt(number);
      }while(n < 0  || n > size-1);
      return n;
   }
   public static int getY(int size){
      Scanner kb = new Scanner(System.in);
      int n = -1;
      do{
         System.out.print("Starting y postition? ");
         String number = kb.nextLine();
         n = Integer.parseInt(number);
      }while(n < 0 || n > size-1);
      return n;
   }
   
   public static void fillArray(int[][] arr, int arr1, int arr2){
      int num = 1;
      while(true){
         arr[arr1][arr2] = num;
         num++;
         if(arr1-1>=0 && arr2+1<arr.length && arr[arr1-1][arr2+1] == 0){//regualr
            arr1--;
            arr2++;
         }else if(arr1-1<0 && arr2+1<arr.length && arr[arr.length-1][arr2+1] == 0){//!up
            arr1 = arr.length-1;
            arr2++;
         }else if(arr1-1>=0 && arr2+1>arr.length-1 && arr[arr1-1][0] == 0){//!right
            arr1--;
            arr2 = 0;
         }else if(arr1-1<0 && arr2+1>arr.length-1 && arr[arr.length-1][0] == 0){//!up & !right
            arr1 = arr.length-1;
            arr2 = 0;
         }else if(arr1+1<arr.length && arr[arr1+1][arr2] == 0){//down
            arr1++;
         }else if(arr1+1>arr.length-1 && arr[0][arr2] == 0){ //!down
            arr1 = 0;
         }else{
            break;
         }
      }
   }
}