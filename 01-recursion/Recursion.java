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

  public static String toWords(int i){
    String[] small = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] tens = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String[] bigs = {"hundred", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "hextillion", "septillion", "octillion", "nonillion", "decillion"};
    if (i < 10){
      return small[i];
    }else if(i < 20){
      return teens[i];
    }else if(i < 100){
      if (i%10 == 0){
        return tens[i/10 - 2];
      }
      return tens[i/10 - 2]+"-"+toWords(i%10);
    }else if(i < 1000){
      return small[i/100] +" "+ bigs[0] +" "+ toWords(i%100);
    }else{
      int places = (int)(Math.log10(i));
      int first3 = i/(int)(Math.pow(10, places-places%3));
      return toWords(first3) +" "+ bigs[places/3] +" "+toWords(i%(int)(Math.pow(10, places-places%3)));
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


  public static void main(String[] args) {
    //printAllWords(3);
    char[] letters = {'a', 'b', 'c'};
    //printNoDoubleLetterWords(4, letters);
    /*
    System.out.println(toWords(0));
    System.out.println(toWords(372));
    System.out.println(toWords(1234));
    System.out.println(reverse("abcde"));
    System.out.println(reverse(""));
    System.out.println(sqrt(10));
    System.out.println(sqrt(100));
    System.out.println(sqrt(1));*/
    System.out.println(countNoDoubleLetterWords(3, ""));
    System.out.println(countNoDoubleLetterWords(5, ""));
  }

}
