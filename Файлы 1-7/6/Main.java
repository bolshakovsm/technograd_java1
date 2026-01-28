// 6. Подсчитать количество символов в текстовом файле.

import java.io.*;

public class Main {
  public static void main(String[] args) {
    int charInt;
    char c;
    int count = 0;
    try (FileReader fr = new FileReader("1.txt");
         BufferedReader br = new BufferedReader(fr)) {
      while((charInt = br.read()) != -1) {
        c = (char)charInt;
        if ( ! ( Character.isLetter(c) || Character.isDigit(c) || Character.isWhitespace(c) ) ) count++;
      } 
      System.out.println(count);      
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException " + e.getMessage());
    }
  }
}

