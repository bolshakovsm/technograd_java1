// 2. Прочитать содержимое текстового файла и вывести его на экран.

import java.io.*;

public class Main {
  public static void main(String[] args) {
    try (FileReader fr = new FileReader("1.txt");
         BufferedReader br = new BufferedReader(fr)) {
      System.out.println(br.readLine());      
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException " + e.getMessage());
    }
  }
}

