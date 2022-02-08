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
}
