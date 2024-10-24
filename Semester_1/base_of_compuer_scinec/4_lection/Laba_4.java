
import java.util.Scanner;

public class Laba_4 {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    String [] words = in.nextLine().split(" ");
    for (String word: words){
      boolean flag = false;
      for(char chr: word.toCharArray()){
        if(!Character.isAlphabetic(chr)) flag = true;
      }
      if (flag) System.out.println(word);
    }

    in.close();
    
  }

  public String doubleChar(String str) {
      String result = "";
      for (char symbol : str.toCharArray()) {
          result += symbol + "" +symbol;
      }
      return result;
    }

  public int countHi(String str) {
    int result = 0;
    for(int i = 0; i < str.length()-1 ; i++){
      if(str.substring(i, i+2).equals("hi")){
        result++;
      }
    }
    return result;
  }

  int count(String needle, String haystack) {
    return haystack.split(needle, -1).length - 1;
  }
  public boolean catDog(String str) {
    return count("dog", str) == count("cat", str);
  }
  

  public int countCode(String str) {
    int count = 0;
  
    if (str.length() < 4)
      return 0;
  
    for (int i = 0; i < str.length() - 3; i++) {
      if (str.substring(i,i+2).compareTo("co") == 0 && str.substring(i+3, i+4).compareTo("e") == 0)
        count++;
    }
    return count;
  }

  public boolean endOther(String a, String b) {
  
    int aLen = a.length();
    int bLen = b.length();
  
    if (aLen < bLen) {
      if (b.toLowerCase().substring(bLen - aLen, bLen).compareTo(a.toLowerCase()) == 0)
        return true;
      else
        return false;
    
  } else {
    if (a.toLowerCase().substring(aLen - bLen, aLen).compareTo(b.toLowerCase()) == 0)
      return true;
    else
      return false;
  }}
  
  public Boolean xyzThere(String str) {
    int len = str.length();
    String xyz = "xyz";
  
    Boolean match = false;

    if (len < 3)
      return false;

    for (int i = 0; i < len - 2; i ++) {
      String temp = str.substring(i, i+3); 
      if (temp.compareTo(xyz) == 0 && i == 0)
        match = true;
      else if(temp.compareTo(xyz) == 0 && str.charAt(i-1) != 46)
        match = true;  
      }  
    return match;
  }

  public boolean bobThere(String str) {
    int len = str.length();
  
    for (int i = 0; i < len - 2; i++) {
      if (str.charAt(i) == 'b' && str.charAt(i+2) == 'b')
      return true;
    }
    return false;
  }
}