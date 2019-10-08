class Zillion
{
  private int digits[] ; //array of digits
  public Zillion(int size)
  {
    digits = new int[size]; //set digits to size parameter
  }
  public void increment()
  {
    int length = digits.length; //Length of array
    int counter = 0;
    int index = length - 1; //Index in counter

    while (counter < length) // While within the length of the array
    {
      if(digits[index] == 9)//For last digit in index, if equal to 9, set to 0
      {
        digits[index] = 0;
        index--; //go to next digit in index
        counter++;
      }
      else
      {
        digits[index] ++;
        break;
      }
      //int num = Integer.parseInt(digit);
    }

  }
  public String toString()
  {
    String numStr = "";
    for(int i=0; i<digits.length; i++)
    {
      numStr += digits[i]; //adds each element of the array to the string
    }
    return numStr; // returns integer array as a string
  }
}
//  DRIVER. The MAIN method has tests for your class ZILLION. Each test has a
//  comment that shows what the test should print if your code is correct. It
//  also has the number of points you will receive if the test is successful.
//  These tests are worth a total of 25 points.

class Driver
{
  public static void main(String[] args)
  {
    Zillion z = new Zillion(2);
    System.out.println(z);  //  00  2 points

    z.increment();
    System.out.println(z);  //  01  2 points

    z.increment();
    System.out.println(z);  //  02  2 points

    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();

    System.out.println(z);  //  10  2 points
    z.increment();
    System.out.println(z);  //  11  2 points

    z = new Zillion(4);
    System.out.println(z);  //  0000  2 points

    for (int j = 1; j <= 999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  0999  2 points

    z.increment();
    System.out.println(z);  //  1000  2 points

    for (int j = 1; j <= 999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  1999  2 points

    z.increment();
    System.out.println(z);  //  2000  2 points

    for (int j = 1; j <= 7999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  9999  2 points

    z.increment();
    System.out.println(z);  //  0000  2 points

    z.increment();
    System.out.println(z);  //  0001  1 point
  }
}
