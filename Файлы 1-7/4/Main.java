// 4. Подсчитать количество строк в текстовом файле.

import java.io.*;

public class Main {
  public static void main(String[] args) {
    try (FileReader fr = new FileReader("1.txt");
         LineNumberReader lnr = new LineNumberReader(fr)) {
      while (lnr.readLine() != null);
      System.out.println(lnr.getLineNumber());      
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException " + e.getMessage());
    }
  }
}

