import java.util.Random;
import java.util.Scanner;

class customException extends Exception
{
	customException(String msg)
	{
		super(msg);
	}
}

public class JackpotProgram 
{
	public static void main(String[] args) 
	{
		int counter=5;
		int customerAge, selectedNumber, randomlySelectedNumber,generatedRandomNumber;
		String temp;
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("******************* Welcome To Jackpot Game ********************");
		System.out.print("Enter your temp : ");
		temp=scanner.nextLine();
		temp=temp.trim();
		while(temp.isEmpty() || temp.matches("[a-zA-Z/!@#$%^&*>.<_-]+") || temp.length()>2 || Integer.parseInt(temp)<0)
		{
			System.out.print("Re-enter your valid temp : ");
			temp=scanner.nextLine();
			temp=temp.trim();
		}
		
		customerAge=Integer.parseInt(temp);
		
		try
		{
			if(customerAge>20)
			{
				System.out.println("You are eligible to play game...\n");
				System.out.print("Choose a number greater than "+customerAge+" : ");
		
				temp=scanner.nextLine();
				temp=temp.trim();
				
				while(temp.isEmpty() || temp.matches("[a-zA-Z/!@#$%^&*>.<_-]+") || Integer.parseInt(temp)<0 || Integer.parseInt(temp)<=customerAge)
				{
					System.out.print("Again choose a number greater than "+customerAge+" : ");
					temp=scanner.nextLine();
					temp=temp.trim();
				}
				
				selectedNumber=Integer.parseInt(temp);
				
				Random random=new Random();
				generatedRandomNumber=random.nextInt(selectedNumber+1);
				System.out.println("\nNote: Generated Random Number from System : "+generatedRandomNumber+"\n");
				
				int attempt=1;
				while(counter!=0)
				{
					System.out.print("Attempt "+attempt+" - Guess a number between 1 and "+selectedNumber+" : ");
					randomlySelectedNumber=scanner.nextInt();
					
					if(generatedRandomNumber==randomlySelectedNumber)
					{
						System.out.println("\nCongratulations!! You won $"+(counter*100)+" for choosing number '"+randomlySelectedNumber+"'");
						break;
					}
					else if(generatedRandomNumber<randomlySelectedNumber)
						System.out.println("Guess Again!! Higher than the actual number\n");
					else
						System.out.println("Guess Again!! Lower than the actual number\n");
						
					counter--;
					attempt++;
				}//while
				if(counter==0)
					throw  new customException("Your 5 attemptes are over !!");
								
				System.out.println("\n******************* Thanks for playing. Game Ended !! ********************");
			}
			else
				throw new customException("You are not eligible to play this game. Minimum age is '20' !!");	
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());
			System.out.println("\n******************* Game Terminated !! ********************");
		}
		finally
		{
			scanner.close();
		}
	}//main
}
