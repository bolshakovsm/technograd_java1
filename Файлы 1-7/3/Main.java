// 3. Дописать в конец файла новую строку без удаления старого содержимого.

import java.io.*;

public class Main {
  public static void main(String[] args) {
    try (FileWriter fw = new FileWriter("1.txt", true)) {
      fw.write("\n2nd line");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}

