class Sieve
{
	boolean [] numbers; //initializes an array of booleans
	
	public Sieve(int max)
	{
		if(max<2) //throws an exception if max is less than 2
		{
			throw new IllegalArgumentException();
		}
		else
		{
			numbers = new boolean[max]; //declares an array of booleans to the size of max	
			numbers[0] = false; //Sets first and second element of number array to false as they cannot be prime
			numbers[1] = false;
			for(int i=2; i<numbers.length;i++)
			{
				numbers[i] = true; //sets each element besides 0 and 1 to true
			}
		}
	}
	public void findPrimes()
	{
		for(int i = 0; i < numbers.length; i++)
		{
			if(!numbers[i]) //if element is false for given i, do nothing
			{
				;
			}
			else if(numbers[i]) //if element is true, set multiple of i to false as it cannot be prime
			{
				for(int w = 2; w*i < numbers.length; w++)
				{
					numbers[i*w] = false;
				}
			}
		}
	}
	public String toString()
	{
		String str = "";
		for(int x=0; x<numbers.length; x++)
		{
			if(numbers[x])
			{
				str += x + " "; //If prime, adds to string and adds a space
			}
		}
		return str;//Returns string of all primes up to max
	}
	
}




//
//  SIEVE. The Sieve of Eratosthenes.
//
//    James B. Moen
//    08 Oct 19
//
//  Test the SIEVE class, for 30 points total.
//

//
//  Put your code for the class SIEVE here!!!
//

//  TOSS THE KNEES. Run SIEVE on some examples.

class TossTheKnees
{

//  MAIN. Find some primes.

  public static void main(String [] args)
  {
    Sieve sieve = null;  //  We must initialize SIEVE or Java will cry.

//  5 points. This must print "Sieve size must be at least 2." but without the
//  quotes.

    try
    {
      sieve = new Sieve(0);
    }
    catch (IllegalArgumentException oops)
    {
      System.out.println("Sieve size must be at least 2.");
    }

//  5 points. This must print nothing.

    try
    {
      sieve = new Sieve(100);
    }
    catch (IllegalArgumentException oops)
    {
      System.out.println("Sieve size must be at least 2.");
    }

//  10 points. This must print integers from 2 to 99, separated by blanks.

    System.out.println(sieve);

//  10 points. This must print the prime numbers between 2 and 99, separated by
//  blanks. They are:
//
//  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

    sieve.findPrimes();
    System.out.println(sieve);
  }
}
