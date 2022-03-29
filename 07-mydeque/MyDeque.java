import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;


  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = 0;
    size = 0;
  }
  public MyDeque(){
    this(10);
  }

  public int size(){
    return size;
  }
  public String toString(){
    if (data.length == 0){
      return "[]";
    }
    String compile = "[";
    if (start <= end){
      for (int i = start; i < end; i++){
        compile+=data[i];
        if (i <end-1){
          compile+=", ";
        }
      }
    }else{
      for (int i = start; i < data.length; i++){
        compile+=data[i];
        compile+=", ";
      }
      for (int i = 0; i < end; i++){
        compile+=data[i];
        if (i <end-1){
          compile+=", ";
        }
      }
    }
    return compile+"]";
  }

  public void addFirst(E element){
    if (start == 0){
      data[data.length - 1] = element;
      start = data.length - 1;
    }else{
      data[start-1] = element;
      start--;
    }
    size++;
  }

  public void addLast(E element){
    data[(end)%data.length] = element;
    end=(end+1)%data.length;
    size++;
  }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }
}
