public class Diagram {

  int sizeX;
  int sizeY;
  int shapesCount;
  Shape[] shapes;

  {
    System.out.println("trace Diagram initialize");
    shapesCount = -1;
  }
  
  Diagram(int sizeX, int sizeY, int shapesMax) {
    System.out.printf("trace Diagram construct (%d, %d, %d)%n", sizeX, sizeY, shapesMax);
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    shapes = new Shape[shapesMax];
  }

  int addShape(String kind, int posX, int posY) {
    if (shapesCount < shapes.length) {
      shapesCount++;
      shapes[shapesCount] = new Shape(kind, posX, posY);
      return shapesCount;
    } else {
      return -1;
    }
  }

  boolean deleteShape(int index) {
    System.out.printf("trace Diagram deleteShape (%d)%n", index);
    if (index > shapesCount) {
      return false; 
    } else {
      // finalize
      shapes[index] = null;
      System.gc();
      //
      for (int i = index; i < shapesCount; i++) {
        shapes[i]=shapes[i+1];
      }
      shapes[shapesCount] = null;
      shapesCount--;
      return true;
    }
  }

  void show(String mark) {
    for (int i = 0; i <= shapesCount; i++) {
      System.out.printf("  %s: %d %s %d %d%n", mark, i, shapes[i].kind, shapes[i].posX, shapes[i].posY);
    }
  }

  void clear() {
    for (int i = 0; i <= shapesCount; i++) {
      System.out.printf("trace Diagram clear (%d)%n", i);
      shapes[i] = null;
    }
    System.gc();
  }

  String indices() {
    String s = "";
    for (int i = 0; i <= shapesCount; i++) {s += Integer.toString(i);}
    return s;
  }

  protected void finalize() {
    System.out.println("trace Diagram finalize");
  }

}
