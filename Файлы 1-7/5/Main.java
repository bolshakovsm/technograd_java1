// 5. Подсчитать количество слов в текстовом файле.

import java.io.*;

public class Main {
  public static void main(String[] args) {
    int charInt;
    int count = 0;
    boolean isWord = false;
    try (FileReader fr = new FileReader("1.txt");
         BufferedReader br = new BufferedReader(fr)) {
      while((charInt = br.read()) != -1) {
        if (Character.isLetter((char)charInt)) {
          if (!isWord) {isWord = true; count++;}
        } else {
          isWord = false;
        }
      } 
      System.out.println(count);      
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException " + e.getMessage());
    }
  }
}
