public class Recursion{
  /*Print all words that are made of the letters a-e inclusive.
  *@param length : the length of the words that are to be printed
  */
  public static void printAllWords(int length){
    printAllWords(length,"");
  }

  /*Print all words that are made of the letters a-e inclusive.
  *@param length : either how many more letters or the total length depending on implementation
  *@param word   : the partial word so far.
  */
  public static void printAllWords(int size,String ans){
    if (size == 0){
      System.out.println(ans);
    }else{
      for (char c = 'a'; c<= 'e'; c++){
        printAllWords(size-1, ans+c);
      }
    }
  }


  /*Print all words that are made of the characters in the array of letters.
  *There may not be consecutive equal letters, so:
  *aax is not allowed, but axa is allowed.
  *@param length : the length of the words that are to be printed
  *@param letters: the letters you should be using,
  *@precondition: letters contains at least 2 characters, and has no duplicates.
  */
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

  /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
  *aax is not allowed, but axa is allowed.
  *@param length : either how many more letters need to be
  *@param word   : the partial word so far.
  *@param letters: the letters you should be using
  */
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    if (length == 0){
      System.out.println(word);
    }else{
      for (char c : letters){
        if (word.length() == 0){
          printNoDoubleLetterWords(length - 1, word + c, letters);
        }else if (c != word.charAt(word.length() - 1)){
          printNoDoubleLetterWords(length - 1, word + c, letters);
        }
      }
    }
  }

  public static String reverse(String s){
    if (s.length() == 0){
      return "";
    }else{
      return reverse(s.substring(1))+s.charAt(0);
    }
  }

  public static double sqrt(double n){
    return sqrt(n, 1);
  }

  public static double sqrt(double n, double guess){
    if (n == 0.0){
      return 0.0;
    }
    if(Math.abs(guess*guess - n) < n*0.00001){
      return guess;
    }
    return sqrt(n, (n/guess + guess)/2);
  }

  public static long countNoDoubleLetterWords(int length,String word){
    long counter = 0;
    if (length == 0){
      return 1l;
    }else{
      for (char c = 'a'; c<= 'z'; c++){
        if (word.length() == 0){
          counter += countNoDoubleLetterWords(length - 1, word + c);
        }else if (c != word.charAt(word.length() - 1)){
          counter += countNoDoubleLetterWords(length - 1, word + c);
        }
      }
      return counter;
    }
  }

  public static int fibIter(int n, int f1, int f2){
    if(n == 0){
      return f1;
    }else if(n == 1){
      return f2;
    }else{
      return fibIter(n-1, f2, f2+f1);
    }
  }



  public static void main(String[] args) {
    //printAllWords(3);
    char[] letters = {'a', 'b', 'c'};
    int[] nums = {2, 4, 8, 16, 32};
    //printNoDoubleLetterWords(4, letters);
    /*
    System.out.println(toWords(0));
    System.out.println(toWords(372));
    System.out.println(toWords(1234));
    System.out.println(reverse("abcde"));
    System.out.println(reverse(""));
    System.out.println(sqrt(10));
    System.out.println(sqrt(100));
    System.out.println(sqrt(1));
    System.out.println(countNoDoubleLetterWords(3, ""));
    System.out.println(countNoDoubleLetterWords(5, ""));


    System.out.println(sqrt(0));
    System.out.println(fibIter(0, 1, 0));
    System.out.println(fibIter(1, 1, 0));
    System.out.println(fibIter(2, 1, 0));
    System.out.println(fibIter(3, 1, 0));
    System.out.println(fibIter(4, 1, 0));*/


  }

}
