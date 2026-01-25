public class Diagram {

  int sizeX;
  int sizeY;
  int indexLast;
  Shape[] shapes;

  {
    System.out.println("trace Diagram initialize");
    indexLast = -1;
  }
  
  Diagram(int sizeX, int sizeY, int shapesMax) {
    System.out.printf("trace Diagram construct (%d, %d, %d)%n", sizeX, sizeY, shapesMax);
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    shapes = new Shape[shapesMax];
  }

  int addShape(String kind, int posX, int posY, int ... prop) {
    if (indexLast < shapes.length - 1) {
      indexLast++;
      System.out.printf("trace Diagram addShape (%d)%n", indexLast);
      switch (kind) {
        case "c":
          shapes[indexLast] = new Circle(posX, posY, prop[0]);
          break;
        case "s":
          shapes[indexLast] = new Square(posX, posY, prop[0]);
          break;
        case "t":
          shapes[indexLast] = new Triangle(posX, posY, prop[0], prop[1]);
          break;
      }
      return indexLast;
    } else {
      return -1;
    }
  }

  boolean deleteShape(int index) {
    System.out.printf("trace Diagram deleteShape (%d)%n", index);
    if (index > indexLast || index == -1) {
      return false; 
    } else {
      // finalize
      shapes[index] = null;
      System.gc();
      //
      if (index < indexLast) {
        for (int i = index; i < indexLast; i++) {
          shapes[i]=shapes[i+1];
        }
        shapes[indexLast] = null;
      }
      indexLast--;
      return true;
    }
  }

  void show(String mark) {
    for (int i = 0; i <= indexLast; i++) {
      System.out.printf("  %s %d %s%n", mark, i, shapes[i].toString());
    }
  }

  void clear() {
    for (int i = 0; i <= indexLast; i++) {
      System.out.printf("trace Diagram clear (%d)%n", i);
      shapes[i] = null;
    }
    indexLast = -1;
    System.gc();
  }

  String indices() {
    String s = "";
    for (int i = 0; i <= indexLast; i++) s += Integer.toString(i);
    return s;
  }

  protected void finalize() {
    System.out.println("trace Diagram finalize");
  }

}
