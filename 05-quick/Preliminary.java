import java.util.*;

public class Preliminary{
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
    int pivotP = 0;


    for(int i = start+1; i <= end; i++){
      hold = data[i];
      if (hold == store){
        lastEq = !lastEq;
      }
      if (hold < store || (lastEq && hold == store)){
        pivotP++;

      }else if(hold > store || (lastEq && hold == store)){
        data[i]=data[end];
        data[end] = hold;
        end--;
        i--;
      }

    }
    data[0]=data[pivotP];
    data[pivotP]=store;

    return pivotP;
  }

  public static void main(String[] args) {
    //int [] data = new int[] {4,3,2,1,0};
    int[] data = new int[] {0,0,0,0,0,0,0,0,0};
    System.out.println("Original: "+Arrays.toString(data));
    int pivot = partition( data , 0, 7);
    System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
    System.out.println("Modified: "+Arrays.toString(data));
    System.out.println();

  }
}
