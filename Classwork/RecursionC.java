import java.util.*;

public class RecursionC{
  public static String toWords(long i){
    String[] small = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] tens = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String[] bigs = {"hundred", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "hextillion", "septillion", "octillion", "nonillion", "decillion"};
    if (i < 10l){
      return small[(int)i];
    }else if(i < 20l){
      return teens[(int)i-10];
    }else if(i < 100l){
      if (((int)i)%10 == 0){
        return tens[((int)i)/10 - 2];
      }
      return tens[((int)i)/10 - 2]+"-"+toWords(((int)i)%10);
    }else if(i < 1000){
      return small[((int)i)/100] +" "+ bigs[0] +" "+ toWords(((int)i)%100);
    }else{
      int places = (int)(Math.log10(i)+1);
      long first3 = i/(long)(Math.pow(10, (places-1)-(places-1)%3));
      System.out.println(places);
      return toWords(first3) +" "+ bigs[(places-1)/3] +" "+toWords(i%(long)(Math.pow(10, (places-1)-(places-1)%3)));
    }
  }

  public static String toWords(int i){
    return(toWords((long)(i)));
  }

  public static boolean partialSum(int[] arr, int num){
    return partialSum(arr, num, 0);
  }

  public static boolean partialSum(int[] arr, int num, int start){
    if (num == 0){
      return true;
    }else if(arr.length == 0){
      return false;
    }else if(start >= arr.length){
      return false;
    }else{
      return partialSum(arr, num, start+1) || partialSum(arr, num-arr[start], start+1);
    }
  }

  public static int summer(int start, int[] arr, int counter){
    if (start >= arr.length){
      return 0;
    }else{
      return summer(start+1, arr, counter+arr[start]);
    }
  }

  public static boolean splitArrayDiff(int[]arr, int diff, int index){
    if(arr.length == 0){
      return (diff == 0);
    }else if(index >= arr.length){
      return (diff == 0);
    }

    else{
      return splitArrayDiff(arr, diff+arr[index], index+1)||splitArrayDiff(arr, diff-arr[index], index+1);
    }
  }


  public static boolean splitArray(int[] arr){
    /*int sum = summer(0, arr, 0);
    if (sum%2 == 1){
      return false;
    }
    return partialSum(arr, sum/2);*/
    return splitArrayDiff(arr, 0, 0);
  }

  public static Boolean groupSum6(int start, int[] nums, int target){
    if(start >= nums.length){
      return (target == 0);
    }else if(nums[start] == 6){
      return groupSum6(start+1, nums, target-6);
    }else{
      return groupSum6(start+1, nums, target) || groupSum6(start+1, nums, target-nums[start]);
    }
  }

  public static boolean groupNoAdj(int start, int[] nums, int target) {
    if (start >= nums.length){
      return (target == 0);
    }else{
      return groupNoAdj(start+1, nums, target)||groupNoAdj(start+2, nums, target-nums[start]);
    }
  }

  public static void main(String[] args) {
    /*System.out.println(splitArray(new int[]{2, 2}));
    System.out.println(splitArray(new int[]{2, 3}));
    System.out.println(splitArray(new int[]{2, 3, 5}));
    System.out.println(splitArray(new int[]{}));
    System.out.println(splitArray(new int[]{10, 2, 3, 1}));
    System.out.println(groupSum6(0, new int[] {5,6,2}, 8));
    System.out.println(groupSum6(0, new int[] {5,6,2}, 9));
    System.out.println(groupSum6(0, new int[] {5,6,2}, 7));
    System.out.println(groupSum6(0, new int[] {}, 8));
    System.out.println(groupSum6(0, new int[] {6}, 0));
    System.out.println(groupSum6(0, new int[] {}, 0));*/
    System.out.println(groupNoAdj(0, new int[]{2, 5, 10, 4}, 12));
    System.out.println(groupNoAdj(0, new int[]{2, 5, 10, 4}, 14));
    System.out.println(groupNoAdj(0, new int[]{2, 5, 10, 4}, 10));
    System.out.println(groupNoAdj(0, new int[]{2, 5, 10, 4}, 7));
    System.out.println(groupNoAdj(0, new int[]{2, 5, 10, 4}, 0));
    System.out.println(groupNoAdj(0, new int[]{}, 0));
    System.out.println(groupNoAdj(0, new int[]{}, 12));


  }


}
