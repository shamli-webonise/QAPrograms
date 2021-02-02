import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordGeneratorApproch2 {

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
					System.out.print("Enter brand name of your car name: ");
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
			
			int expectedSize=inputList.size() * 2;
			System.out.println("Expected combinations are  : "+expectedSize);
			
			List<String> combinations=new ArrayList<>();
			String output="";
			for(int i=0;i<inputList.size();i++)
			{
				if(inputList.size()==expectedSize)
					break;
				
				output=inputList.get(i);
				for(int j=i+1;j<inputList.size();j++)
				{
					output+=inputList.get(j);
				}
				combinations.add(output);
				output="";
				
				output=inputList.get(i);
				for(int k=inputList.size()-1;k>i;k--)
				{
					output+=inputList.get(k);
				}
				combinations.add(output);
				output="";
				
				inputList.add(inputList.get(i).toString());
			}
			
			System.out.println("All possible password combinations are : "+combinations);
			
			Random randomObj = new Random(); 
			int randomCombinationPicker=randomObj.nextInt(expectedSize);
			System.out.println("Randomly picked password is : "+combinations.get(randomCombinationPicker));
			
		}//try
		catch(Exception e)
		{
			System.out.println("Exception : "+e.getMessage());
		}
		finally
		{
			scanner.close();
		}
	}//main()

	public static boolean isBirthYearValid(int year) 
	{
		if(year > 0 && String.valueOf(year).trim().length()==4 && year<Calendar.getInstance().get(Calendar.YEAR))
			return true;

        return false;
    }//isBirthYearValid()
}
