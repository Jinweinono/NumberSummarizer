import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

interface NumberRangeSummarizer {
	//collect the input
	ArrayList<Integer> collect(String input);
	
	//get the summarized string
	String summerizedCollection(ArrayList<Integer> input);
}


public class Numbersummazier implements NumberRangeSummarizer {

	public static void main(String[] args) {
		
		Numbersummazier caseOne = new Numbersummazier();
		System.out.println("Enter a list of numbers in ascending order.");
		System.out.println("Please separate the numbers by a comma.");
		//Taking in user's input by a scanner object.
		Scanner numScan = new Scanner(System.in);
		String userinput = numScan.nextLine();
		numScan.close();
		
		ArrayList<Integer> Temp = new ArrayList<Integer>();
		Temp = caseOne.collect(userinput); // collect the input
		System.out.println("Before number summarization");
		System.out.println(Temp);
		
		//summarisation
		System.out.println("After number summarization:");
		String finalAnswer = caseOne.summerizedCollection(Temp);
		System.out.println(finalAnswer);
	}

	@Override
	public ArrayList<Integer> collect(String input) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		String str[] = input.split(",");
		List<String> str_temp = new ArrayList<String>();
		str_temp = Arrays.asList(str);
		for(String s: str_temp) {
			Integer num = Integer.parseInt(s); // Converting string input to integer.
			numbers.add(num);
		}
		return numbers;
	}

	@Override
	public String summerizedCollection(ArrayList<Integer> input) {
		// TODO Auto-generated method stub
		Integer start = input.get(0); //first number of the arraylist
		Integer count = 1;
		Integer end = null;
		ArrayList<String> output = new ArrayList<String>(); // summarized arraylist
		String F_output = "";
		
		if(input.size() == 0) {
			System.out.println("Invalid input!");// check for empty list.
		}
		else {
			for(int x = 1; x < input.size(); x++) {// Using one for loop to reduce the computational complexity
				
				if(start+count == input.get(x)) {
					end = input.get(x);
					count ++;
				}
				
				else {
					if( end == null ){
							output.add(Integer.toString(start));
							start = input.get(x);
							count = 1;
						}
						else {
							output.add(Integer.toString(start)+"-"+Integer.toString(end)); 
							start = input.get(x);
							end = null;
							count = 1;
						}
				}
				
				if(input.get(x) == input.get(input.size()-1) & end == null) {
					output.add(Integer.toString(start));
					break;
				}
				
				if(input.get(x) == input.get(input.size()-1) & end != null) {
					output.add(Integer.toString(start)+"-"+Integer.toString(end));
					break;
				}
			}
		}
		
		for (String K: output) {
			F_output = F_output+K+","; //Converting back to string
		}
		return F_output;
	}

}
