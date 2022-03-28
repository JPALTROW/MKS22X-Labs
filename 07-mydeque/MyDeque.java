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
    if (size == 0){
      return "";
    }
    String compile = "";
    for (int i = start; i%size < end; i++){
      compile += data[i];
    }
    return compile;
  }
  // public void addFirst(E element){ }
  // public void addLast(E element){ }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }
}
