package Programs;
//Kai Tjader

public class Program3{
   public static void main(String[] args){
      int [][] testArr = {{4,2},
                          {3,8},
                          {8,2}};
      int row = 0;
      int col = 0;
      System.out.println(getCoins(testArr, row, col));
   }                              //          vert     horz
   public static int getCoins(int[][] map, int row, int col){
      int total = map[row][col]; 
      map[row][col] = 0;
      int [] coin = new int [4];
      int moveCoin = 0;
      int moveCoinTotal = 0;

      while(true){      
         coin[0] = checkSpot(row-1,col, map); //up
         coin[1] = checkSpot(row,col+1, map); //right
         coin[2] = checkSpot(row+1,col, map); //down
         coin[3] = checkSpot(row,col-1, map); //left
         for(int i=0;i<coin.length;i++){
            if(coin[i] > moveCoinTotal){ //finding witch direction to go
               moveCoinTotal = coin[i];
               moveCoin = i;
               System.out.println("total: " + total + " direction: " + moveCoin + " coinVal: " + moveCoinTotal);
            }
         }
         if(coin[moveCoin] == 0) //or not to move
            return total;
      
         switch(moveCoin){ //moves hunter
            case 0: row -= 1;
               break;
            case 1: col += 1;
               break;
            case 2: row += 1;
               break;
            case 3: col -= 1;
               break;
         }
         //resets
         total += map[row][col]; 
         map[row][col] = 0;
         moveCoin = 0;
         moveCoinTotal = 0;
      }
   }
   public static int checkSpot(int row, int col, int[][] map){
      try{
         return map[row][col];
      }catch(ArrayIndexOutOfBoundsException e){
         return 0;
      }
   }
}