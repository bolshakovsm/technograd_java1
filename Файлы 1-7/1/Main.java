// 1. Создать текстовый файл и записать в него строку "Hello, File!".

import java.io.*;

public class Main {
  public static void main(String[] args) {
    try (FileWriter fw = new FileWriter("1.txt")) {  // exception test "x://1.txt"
      fw.write("Hello, File!");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}

