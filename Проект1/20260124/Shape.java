public class Shape {

  String kind;
  int posX;
  int posY;

  {
    System.out.println("trace Shape initialize");
  }

  Shape(String kind, int posX, int posY) {
    System.out.printf("trace Shape construct (%s, %d, %d)%n", kind, posX, posY);
    this.kind = kind;
    this.posX = posX;
    this.posY = posY;
  }

  protected void finalize() {
    System.out.printf("trace Shape finalize (%s, %d, %d)%n", kind, posX, posY);
  }

}
