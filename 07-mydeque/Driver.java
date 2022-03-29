public class Driver{
  public static void main(String[] args) {
    MyDeque<Integer> tester = new MyDeque<Integer>();
    System.out.println(tester);
    tester.addFirst(1345);
    tester.addLast(987654);
    System.out.println(tester);
    tester.removeLast();
    tester.addLast(1);
    tester.addLast(123456);
    tester.removeFirst();
    System.out.println(tester);
  }
}
