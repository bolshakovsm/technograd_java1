// 7. Считать из файла список чисел и вывести их сумму.

import java.io.*;
import java.util.Scanner;

public class Main {

  static String path;

  public static void main(String[] args) {
    path = "1.txt";

    parse();

    scan(); // не работает

  }

  static void parse() { 
    int charInt;
    char c;
    String nStr = "";
    double sum = 0;
    boolean isNumber = false;
    try (FileReader fr = new FileReader(path);
         BufferedReader br = new BufferedReader(fr)) {
      while((charInt = br.read()) != -1) {
        c = (char)charInt;
        if (Character.isDigit(c) || c == '-' || c == '.') {
          if (!isNumber) isNumber = true;
          nStr += c; 
        } else {
          if (isNumber) {
            isNumber = false;
            sum += nNum(nStr);
            nStr = "";
          }
        }
      } 
      if (nStr.length() > 0) sum += nNum(nStr);
      System.out.println(sum);
      br.close();
      fr.close();
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException " + e.getMessage());
    }
  }

  static double nNum(String nStr) {
    try {
      return Double.valueOf(nStr);
    }
    catch (NumberFormatException e) {
      return 0;
    }
  }

  /////////////////////////////////////////////////////////

  static void scan() {
    double sum = 0;
    double nDouble;
    int nInt;

    //try (FileInputStream fis = new FileInputStream(path);
    //     Scanner sc = new Scanner(fis)) {

    File f = new File(path);
    try (Scanner sc = new Scanner(f)) {

      //System.out.println("rx " + sc.radix());  
      //System.out.println("ln " + sc.nextLine());  

      /*
      while (true) {
        if (sc.hasNextDouble()) {
          nDouble = sc.nextDouble();
          System.out.println("d " + nDouble);
          sum += nDouble;
        } else if (sc.hasNextInt()) {
          nInt = sc.nextInt();
          System.out.println("i " + nInt);
          sum += nInt;
        } else {
          break;
        }
      }
      */

      /*
      while (sc.hasNextDouble()) {
        System.out.println("+++");
        nDouble = sc.nextDouble();
        System.out.println("d " + nDouble);
        sum += nDouble;
      }
      */

      /*
      while (true) {
        System.out.println("+++");
        nDouble = sc.nextDouble();
        System.out.println("d " + nDouble);
        sum += nDouble;
        break;
      }
      */

      sc.close();
      //fis.close();
      System.out.println(sum);
    }
    catch (Exception e) {
      System.out.println("Exception " + e.getMessage());
    }
  }  

}

