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
