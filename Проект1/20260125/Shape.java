public abstract class Shape {

  static int idNew;
  int posX;
  int posY;

  {
    System.out.println("trace Shape initialize");
  }

  Shape(int posX, int posY) {
    this.posX = posX;
    this.posY = posY;
    idNew++;
    System.out.printf("trace Shape construct (%d, %d, %d)%n", idNew, posX, posY);
  }

  public abstract String toString();

  int idCurrent() {
    return idNew;
  }

  protected void finalize() {
    System.out.printf("trace Shape finalize (%d, %d)%n", posX, posY);
  }

}
