import java.util.*;

public class Quick{
  /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the
  * corresponding element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element
  * are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are
  *placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */
  public static int partition ( int [] data, int start, int end){
    int pivot = (int)(Math.random() * (end-start+1))+start;
    int store = data[pivot];
    data[pivot] = data[start];
    boolean lastEq = true;
    pivot = start;
    data[start] = store;
    int hold;
    int pivotP = start;

    for(int i = start+1; i <= end; i++){
      hold = data[i];
      if (hold == store){
        lastEq = !lastEq;
      }
      if (hold < store || (!lastEq && hold == store)){
        pivotP++;
      }else if(hold > store || (lastEq && hold == store)){
        data[i]=data[end];
        data[end] = hold;
        end--;
        i--;
      }
    }
    data[start]=data[pivotP];
    data[pivotP]=store;
    return pivotP;
  }

  public static void quicksort(int[]data){
    quicksort(data,0,data.length-1);
  }

  public static void quicksort(int[]data,int lo,int hi){
    if (lo <= hi - 1){
      int p = partition(data, lo, hi);
      quicksort(data, lo, p-1);
      quicksort(data, p+1, hi);
    }
  }


  /*return the value that is the kth smallest value of the array.
  *@param data must have a length > 0
  *@param k is 0 to data.length-1 inclusive
  *@postcondition The array may be modified.*/
  public static int quickselect(int []data, int k){
    int pivot;
    int start = 0;
    int end = data.length - 1;
    boolean go = true;
    while(go){
      pivot = partition(data, start, end);
      if (k == pivot){
        return data[pivot];
      }else if(pivot < k){
        start = pivot + 1;
      }else{
        end = pivot - 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    /*int [] data = new int[] {4,3,2,1,0};
    System.out.println(quickselect(data, 0));
    System.out.println(quickselect(data, 1));
    System.out.println(quickselect(data, 2));
    System.out.println(quickselect(data, 3));
    System.out.println(quickselect(data, 4));*/
    int[] data = new int[1000000];
    for(int i = 0; i < 1000000; i++){
      data[i] = (int)(1000*Math.random());
    }
    quicksort(data);
    for(int i = 1; i < 1000000; i++){
      if(data[i]<data[i-1]){
        System.out.println("bad");
      }
    }
  }
}
