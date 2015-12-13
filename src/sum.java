import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class sum {
	
	static int lastNumber = 999999999;	
	
	public sum() 
	{
		
	}
	
	public static void main(String args[])
	{
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			System.out.println("Enter minimum number you want to found the sum till");
			System.out.println("/n");
			String line = buff.readLine();
			int number = Integer.parseInt(line);
			int sum = checkSum(number);
			System.out.println(sum);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private static int checkSum(int number) 
	{
		int sum = 2;
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		
		for (int i = 2; i <= lastNumber; i++)
		{
			if(isPrime(i))
			{
				primeNumbers.add(i);
				
				sum = sum + i;
				
				Boolean a = false;
				
				if (reachedSum(sum, number))
				{
					a = true;
				}
				
				while (a == true)
				{	
					int lastPrime = primeNumbers.remove(0);
					sum = sum - lastPrime;
					
					while (!reachedSum(sum, number) && isPrime(sum))
					{
						return sum;
					}
				}
			}
		}
		System.out.println(sum);
		return 0;
		
	}

	private static boolean reachedSum(int sum, int number) 
	{
		while (sum >= number)
		{
			return true;
		}
			return false;
	}

	private static boolean isPrime(int number) 
	{
		for (int i = 2; i < Math.sqrt(number) + 1; i++)
		{
			if(number%i == 0)
			{
				return false;
			}
		}
	
		return true;
	}

}
