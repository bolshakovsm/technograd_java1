import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Diagram diag = new Diagram(100, 200, 10);
    if (args.length == 0) {
      // automatic demo mode
      diag.addShape("c", 10, 10, 6);
      diag.addShape("s", 30, 50, 3);
      diag.show("#1");
      diag.deleteShape(1);
      diag.show("#2");
      diag.addShape("t", 20, 40, 4, 8);
      diag.show("#3");
      // finalize
      diag.clear();
      diag = null;
      System.gc();
      System.out.println("=============");
      //
    } else {
      // manual mode
      Scanner sc = new Scanner(System.in);
      String op;
      int index = -1;
      while (true) {
        System.out.printf("delete [%s]; add: [c]ircle, [s]quare, [t]riangle; clea[r]; sho[w]; e[x]it%n", diag.indices());
        op = sc.nextLine();
        if ((op.length() == 1) && ("cstrwx".contains(op) || diag.indices().contains(op))) {
          switch (op) {
            case "x":
              // finalize
              diag.clear();
              diag = null;
              System.gc();
              System.out.println("=============");
              //
              System.exit(0);
            case "w":
              diag.show("");
              break;
            case "r":
              diag.clear();
              break;
            case "c": case "s": case "t":
              switch (op) {
                case "c":
                  System.out.println("posX, posY, radius");
                  index = diag.addShape(op, sc.nextInt(), sc.nextInt(), sc.nextInt());
                  break;
                case "s":
                  System.out.println("posX, posY, side");
                  index = diag.addShape(op, sc.nextInt(), sc.nextInt(), sc.nextInt());
                  break;
                case "t":                  
                  System.out.println("posX, posY, legH, legV");
                  index = diag.addShape(op, sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
              }
              op = sc.nextLine(); // ???
              if (index == -1) System.out.println("too many shapes");
              break;
            default:
              diag.deleteShape(Integer.parseInt(op));
              // ? if (!diag.deleteShape(Integer.parseInt(op))) System.out.println("illegal shape index");
          }        
        }
      }
    }
  }
}
