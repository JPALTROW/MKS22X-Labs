import java.util.*;

public class Merge{
  public static int[] merge(int [] left, int[] right){
    int[] destination = new int[left.length + right.length];
    int leftInd = 0;
    int rightInd = 0;
    for (int i = 0; leftInd < left.length && rightInd < right.length; i++){
      if (left[leftInd] <= right[rightInd]){
        destination[i] = left[leftInd];
        leftInd++;
      }else{
        destination[i] = right[rightInd];
        rightInd++;
      }
    }
    if (leftInd < left.length){
      for (int i = leftInd; i < left.length; i++){
        destination[right.length + i] = left[i];
      }
    }else{
      for (int i = rightInd; i < right.length; i++){
        destination[left.length + i] = right[i];
      }
    }
    return destination;
  }

  public static void mergesort(int[] data){
    int[] temp = mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }

  public static int[] mergesortH(int[] data){
    if (data.length == 1){
      return data;
    }
    int[] left = new int[data.length/2];
    int[] right = new int[data.length - left.length];
    for (int i = 0; i<left.length; i++){
      left[i] = data[i];
    }
    for (int j = left.length; j < data.length; j++){
      right[j-left.length] = data[j];
    }
    return merge(mergesortH(left), mergesortH(right));
  }
}
