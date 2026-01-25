public class Triangle extends Shape {

  int id;
  int legH;
  int legV;

  {
    System.out.println("trace Triangle initialize");
  }

  Triangle(int posX, int posY, int legH, int legV) {
    super(posX, posY);
    this.legH = legH;
    this.legV = legV;
    id = idCurrent();
    System.out.printf("trace Triangle construct (%d, %d, %d)%n", id, posX, posY);
  }

  public String toString() {
    return "t " + id + " x:" + posX + " y:" + posY + " lh:" + legH + " lv:" + legV;
  }

  protected void finalize() {
    System.out.printf("trace Triangle finalize (%d, %d, %d)%n", id, posX, posY);
  }

}
