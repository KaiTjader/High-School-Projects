package Programs;
//Kai Tjader

public class Program1{
   public static void main(String[] args){
      int [] test1 = {1,6,3};
      int [] test2 = {4,5,6};
      System.out.println(allLess(test1, test2));
   }
   public static boolean allLess(int[]one,int[]two){
      if(one.length <= two.length){
         for(int i=0;i<one.length;i++){
            if(one[i] >= two[i])
             return false;
         }
      }else{
         for(int i=0;i<two.length;i++){
            if(one[i] >= two[i]){
             return false;
            }
         }
      }
      return true;
   }
}