public class Square extends Shape {

  int id;
  int side;

  {
    System.out.println("trace Square initialize");
  }

  Square(int posX, int posY, int side) {
    super(posX, posY);
    this.side = side;
    id = idCurrent();
    System.out.printf("trace Square construct (%d, %d, %d)%n", id, posX, posY);
  }

  public String toString() {
    return "s " + id + " x:" + posX + " y:" + posY + " s:" + side;
  }

  protected void finalize() {
    System.out.printf("trace Square finalize (%d, %d, %d)%n", id, posX, posY);
  }

}
