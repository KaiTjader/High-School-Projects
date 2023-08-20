package Digital_Dilemma;
//Kai Tjader

public class Digital_main{
   public static void main(String[] args){
      int cordOne = 4045134;
      int cordTwo = 11148430;
      int [] arr1 = {598125, 1195047, 1048117, 2142802, 646879, 839092}; //1
      int [] arr2 = {1950374, 1368592, 1218692, 2071321, 2078088, 517849}; //2
      int [] arr3 = {2018514, 1775987, 972140, 1897428, 1934499, 1044518}; //3
      int [] arr4 = {952851, 1764608, 2112035, 1017429, 1287735, 900413}; //4
      int [] arr5 = {1427394, 1798343, 1190761, 1318674, 1389896, 811757}; //5
      int [] arr6 = {1518060, 1112337, 1944434, 1546657, 2144387, 1167689}; //6
      int [] arr7 = {1109247, 1517359, 1643104, 1142560, 1420322, 1086241}; //7
      int [] arr8 = {1537946, 2157887, 2027591, 1865835, 2176224, 1208445}; //8
      int [] arr9 = {2093132, 552868, 1378216, 1324555, 1555687, 2011169}; //9
      int [] arr10 = {1885726, 1449987, 1635596, 1317029, 587633, 1879723}; //10
      int num1 = getNorth(arr1, arr2, arr3, arr4, cordOne);
      int num2 = getWest(arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, cordTwo);
      System.out.println("N " + num1/100000 + " " + (num1/1000)%100 + "." + num1%1000 + "  W " + num2/10000 + " " + (num2/100)%100 + "." + num2%1000);
   }
   public static int sumOfNum(int num){
      int sum = 0;
      for(int i=0;i<8;i++){
         sum += num % 10;
         num /= 10;
      }
      return sum;
   }
   public static int getWest(int[] arr1, int[] arr2, int[] arr3, int[] arr4, int[] arr5, int[] arr6, int[] arr7, int[] arr8, int[] arr9, int[] arr10, int cordTwo){//odd num
      int sum = 0;
      for(int i1=0;i1<arr1.length;i1++){ //1
         for(int i2=0;i2<arr2.length;i2++){ //2
            for(int i3=0;i3<arr3.length;i3++){ //3
               for(int i4=0;i4<arr4.length;i4++){ //4
                  for(int i5=0;i5<arr5.length;i5++){ //5
                     for(int i6=0;i6<arr6.length;i6++){ //6
                        for(int i7=0;i7<arr7.length;i7++){ //7
                           for(int i8=0;i8<arr8.length;i8++){ //8
                              for(int i9=0;i9<arr9.length;i9++){ //9
                                 for(int i10=0;i10<arr10.length;i10++){ //10
                                    sum = arr1[i1] + arr2[i2] + arr3[i3] + arr4[i4] + arr5[i5] + arr6[i6] + arr7[i7] + arr8[i8] + arr9[i9] + arr10[i10];

                                    if(sumOfNum(sum) == 28 && sum % 10 == 1){
                                       if(sum < cordTwo+40 && sum > cordTwo-40){
                                          return sum;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
      return sum;
   }
   public static int getNorth(int[] arr1, int[] arr2, int[] arr3, int[] arr4, int cordOne){
      int sum = 0;
      for(int i1=0;i1<arr1.length;i1++){ //1
         for(int i2=0;i2<arr2.length;i2++){ //2
            for(int i3=0;i3<arr3.length;i3++){ //3
               for(int i4=0;i4<arr4.length;i4++){ //4
                  sum = arr1[i1] + arr2[i2] + arr3[i3] + arr4[i4];
                  if(sum < cordOne+40 && sum > cordOne-40){
                     return sum;
                  }
               }
            }
         }
      }
      return 0;
   }
}