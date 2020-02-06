class Polygon
{
  private int[] sideLengths;

  public Polygon(int sides, int ... lengths)
  {
    int index = 0;
    sideLengths = new int[sides];
    for (int length: lengths)
    {
      sideLengths[index] = length;
      index += 1;
    }
  }

  public int side(int number)
  {
    return sideLengths[number];
  }

  public int perimeter()
  {
    int total = 0;
    for (int index = 0; index < sideLengths.length; index += 1)
    {
      total += side(index);
    }
    return total;
  }
}
class Rectangle extends Polygon
{
  private int sideA = 0;
  private int sideB = 0;
  private int sideC = 0;
  private int sideD = 0;
  public Rectangle(int side1, int side2)
  {
    super(4, side1, side2, side1, side2);
  }
  public int side(int number)
    {
      return (super.side(number));
    }
  public int area()
  {
    return side(0)*side(1);
  }
  public int perimeter()
  {
    return(super.perimeter());
  }
}
class Square extends Rectangle
{
  public Square(int side1)
  {
    super(side1, side1);
  }
}