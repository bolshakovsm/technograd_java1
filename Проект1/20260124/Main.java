import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Diagram diag = new Diagram(100, 200, 10);
    if (args.length == 0) {
      // automatic demo mode
      diag.addShape("c", 10, 10);
      diag.addShape("s", 30, 50);
      diag.show("#1");
      diag.deleteShape(1);
      diag.show("#2");
      diag.addShape("t", 20, 40);
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
      while (true) {
        System.out.printf("delete [%s], add [c]ircle, [s]quare, [t]riangle, sho[w], [e]xit%n", diag.indices());
        op = sc.nextLine();
        if ((op.length() == 1) && ("cstwe".contains(op) || diag.indices().contains(op))) {
          switch (op) {
            case "e":
              // finalize
              diag.clear();
              diag = null;
              System.gc();
              //
              System.exit(0);
            case "w":
              diag.show("");
              break;
            case "c": case "s": case "t":
              System.out.println("posX, posY");
              if (diag.addShape(op, sc.nextInt(), sc.nextInt()) >=0 ) {
                switch (op){
                  case "c":
                    System.out.println("circle radius");
                    // . . . 
                  case "s":
                    System.out.println("square side");
                    // . . . 
                  case "t":                  
                    System.out.println("triangle legs (horizontal, vertical)");
                    // . . . 
                }  
              } else {
                System.out.println("too many shapes");
              }
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
