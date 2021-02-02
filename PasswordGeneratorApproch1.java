import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordGeneratorApproch1 {

	public static void main(String[] args) {
		String userName="",flag,alternateText="";
		int birthYear;
		Scanner scanner = null;
		try
		{
			scanner=new Scanner(System.in);
			System.out.print("Enter user's name* : ");
			userName=scanner.nextLine();
			userName=userName.replaceAll(" +", "").trim(); //Removing extra spaces from string to check all characters are present
			while(!userName.chars().allMatch(Character::isLetter) || userName.length()>15)
			{
				System.out.print("Re-Enter user's name*: ");
				userName=scanner.nextLine();
				userName=userName.replaceAll(" +", "").trim();
			}
			
			System.out.print("Enter user's birth year* : ");
			birthYear=scanner.nextInt();		
			while(String.valueOf(birthYear).matches("^[0-9]+") && !isBirthYearValid(birthYear))
			{
				System.out.print("Re-Enter user's birth year* : ");
				birthYear=scanner.nextInt();
			}
			
			System.out.print("Do you have pet ? (yes/no) : ");
			flag=scanner.next();
			if(flag.toLowerCase().equals("yes"))
			{
				System.out.print("Enter your pet name:");
				alternateText=scanner.next();
			}
			else
			{
				System.out.print("Do you have car ? (yes/no) : ");
				flag=scanner.next();
				if(flag.toLowerCase().equals("yes"))
				{
					System.out.print("Enter brand name of your car: ");
					alternateText=scanner.next();
				}
				else
				{
					System.out.print("Enter your city name: ");
					alternateText=scanner.next();
				}
			}
			
			List<String> inputList=new ArrayList<String>();
			
			inputList.add(userName); //Here we can limit the size of string using subString()
			inputList.add(String.valueOf(birthYear).trim());
			inputList.add(alternateText.replaceAll(" +", "").trim());
			Collections.shuffle(inputList);
			
			System.out.println("Random password is : ");
			for(String text:inputList)
			{
				System.out.print(text);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+e.getMessage());
		}
		finally
		{
			scanner.close();
		}
	}
	
	public static boolean isBirthYearValid(int year) 
	{
		if(year > 0 && String.valueOf(year).trim().length()==4 && year<Calendar.getInstance().get(Calendar.YEAR))
			return true;

        return false;
    }//isBirthYearValid()
}
