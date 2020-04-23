/*
 * Ben Mighall
 * CSCI 112
 * Project 5
 * April 25, 2016
 */

package project5;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Sorority {
	
	private String name = "Gamma Delta Iota";
	private String letters = "GDI";
	ArrayList <Pledge> pledgeList = new ArrayList<Pledge>();
	private DecimalFormat gpaFormat = new DecimalFormat("#.00");

	public Sorority(){
	}
	
	public Sorority(String newName, String newLetters){
		name = newName;
		letters = newLetters;
	}

	public void setName(String newName){
		name = newName;
	}
	
	public void setLetters(String newLetters){
		letters = newLetters;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLetters(){
		return letters;
	}
	
	public ArrayList <Pledge> getPledges(){
		return pledgeList;
	}
	
	public void addPledge(String newName, String newHometown, double newGPA){
		pledgeList.add(new Pledge(newName, newHometown, newGPA));
	}
	
	public void outputSororityData(){
		System.out.println("Sorority Name: " + name);
		System.out.println("Greek Letters: " + letters);
		System.out.println("\nPledges:");
		
		int numPledges = 0;
		
		for (int i = 0; i < pledgeList.size(); i++){
			System.out.println(pledgeList.get(i).toString());
			numPledges++;
		}
		
		System.out.println("\nNumber of Pledges: " + numPledges);
		System.out.println("Average/Overall GPA: " + overallGPA());
	}
	
	public double calculateOverallGPA(){
		double averageGPA = 0.0;
		int numPledges = 0;
		for (int i = 0; i < pledgeList.size(); i++){
			averageGPA += pledgeList.get(i).getGPA();
			numPledges++;
		}
		averageGPA = averageGPA/numPledges;
		return averageGPA;
	}
	
	public String overallGPA(){
		String outputGPA = gpaFormat.format(calculateOverallGPA());
		return outputGPA;
		//I have two methods for GPA stuff, because it allows me to massively simplify and shorten my code due to removing
		//a ton of redundancy. The "calculateOverallGPA" method is a usable GPA for use in other methods. The "overallGPA"
		//is strictly for output to the user.
	}
	
	public static void quickSort(ArrayList <Pledge> newList, int min, int max){
		int pivot;
		if (min < max){
			pivot = partition(newList, min, max);
			quickSort(newList, min, (pivot - 1));
			quickSort(newList, (pivot + 1), max);
		}
	}
	
	public static int partition(ArrayList <Pledge> newList, int min, int max){
		
		double pivot = newList.get(min).getGPA();
		int left = min;
		int right = max;
		
		while(left < right){
			while(newList.get(left).getGPA() <= pivot && left < right){
				left++;
			}
			while(newList.get(right).getGPA() > pivot){
				right--;
			}
			if (left < right){
				swap(newList, left, right);
			}
		}
		swap(newList, min, right);
		
		return right;
	}
	
	public static void swap(ArrayList <Pledge> newList, int left, int right){
		Pledge temp = new Pledge(newList.get(left).getName(), newList.get(left).getHometown(), newList.get(left).getGPA());
		newList.set(left, newList.get(right));
		newList.set(right, temp);
	}
	
	public String sororityListStatus(){
		String output = "";
		output += name + ": ";
		if (calculateOverallGPA() >= 3.50){
			output += "Chancellor's List";
		}else if (calculateOverallGPA() < 3.50 && calculateOverallGPA() >= 3.00){
			output += "Honors List";
			//changed it from Honors Roll List because it sounded weird. Hope that's ok.
		}else if (calculateOverallGPA() < 3.00 && calculateOverallGPA() >= 2.50){
			output += "Free-Spirited List";
		}else if (calculateOverallGPA() < 2.50 && calculateOverallGPA() >= 2.00){
			output += "Party House";
		}else{
			output += "Not Applicable";
			//implemented as an indicator of an issue in the coding
		}
		return output;
	}
	
	public String sororityPrint(){
		String s = "Sorority Name: " + name + "\nGreek Letters: " + letters +"\n\nPledges:\n";
		
		int numPledges = 0;
		
		for (int i = 0; i < pledgeList.size(); i++){
			s += pledgeList.get(i).toString() + "\n";
			numPledges++;
		}
		
		s += "\nNumber of Pledges: " + numPledges;
		s += "\nAverage/Overall GPA: " + overallGPA();
		
		return s;
	}
	
}
