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

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[2*size()-1];
    if (start < end){
      for (int i = start; i < end; i++){
        d[i]=data[i];
      }
    }else{
      for (int i = start; i < data.length; i++){
        d[i-start]= data[start];
      }
      for (int i = 0; i < end; i++){
        d[data.length-start+i] = data[i];
      }
    }
    size = 2*size()+1;
    data=d;
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
    if (size == data.length){
      resize();
    }
  }

  public void addLast(E element){
    data[(end)%data.length] = element;
    end=(end+1)%data.length;
    size++;
    if (size == data.length){
      resize();
    }
  }

  public E removeFirst(){
    E datum = data[start];
    data[start]=null;
    start = (start+1)%data.length;
    size--;
    return datum;
  }

  public E removeLast(){
    E datum;
    if(end == 0){
      datum = data[data.length];
      data[data.length-1]=null;
      end = data.length - 1;
    }else{
      datum = data[end-1];
      data[end-1]=null;
      end--;
    }
    size--;
    return datum;
  }
  // public E getFirst(){ }
  // public E getLast(){ }
}
