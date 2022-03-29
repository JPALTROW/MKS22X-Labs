public class Driver{
  public static void main(String[] args) {
    MyDeque<Integer> tester = new MyDeque<Integer>();
    for (int i = 0; i <30; i++){
      tester.addFirst(i);
      tester.addLast(200-i);
    }
    System.out.println(tester.toStringDebug());
    System.out.println(tester);
  }
}
