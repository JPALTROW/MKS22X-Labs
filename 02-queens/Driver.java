public class Driver{
  public static void main(String[] args) {
    QueenBoard tester = new QueenBoard(5);
    tester.addQueen(1,0);
    tester.addQueen(2,1);
    tester.addQueen(2,4);
    tester.addQueen(4,2);
    tester.removeQueen(2,4);
    tester.addQueen(4,2);
    System.out.println(tester);
  }
}
