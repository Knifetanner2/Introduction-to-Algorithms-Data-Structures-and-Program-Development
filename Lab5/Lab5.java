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
