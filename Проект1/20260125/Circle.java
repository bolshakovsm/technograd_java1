public class Circle extends Shape {

  int id;
  int radius;

  {
    System.out.println("trace Circle initialize");
  }

  Circle(int posX, int posY, int radius) {
    super(posX, posY);
    this.radius = radius;
    id = idCurrent();
    System.out.printf("trace Circle construct (%d, %d, %d)%n", id, posX, posY);
  }

  public String toString() {
    return "c " + id + " x:" + posX + " y:" + posY + " r:" + radius;
  }

  protected void finalize() {
    System.out.printf("trace Circle finalize (%d, %d, %d)%n", id, posX, posY);
  }

}
