/*
 * Ben Mighall
 * CSCI 112
 * Project 5
 * April 25, 2016
 */

package project5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException{
		
		ArrayList <Sorority> sororityList = new ArrayList <Sorority>();
		PrintWriter print = new PrintWriter("Faber.txt");
		print.println("\nSchool Name: Faber College\nSchool Mascot: Beyonce\n");
		File file1 = new File ("sororityList.txt");
		Scanner scanFile1 = new Scanner(file1);
		while (scanFile1.hasNextLine()){
			String input1 = scanFile1.nextLine();
			String[] tokens1 = input1.split(",");
			sororityList.add(new Sorority(tokens1[0], tokens1[1]));
		}
		scanFile1.close();
		
		File file2 = new File ("pledgeList.txt");
		Scanner scanFile2 = new Scanner(file2);
		while (scanFile2.hasNextLine()){
			String input2 = scanFile2.nextLine();
			String[] tokens2 = input2.split(",");
			if (tokens2[3].equals("AB")){
				sororityList.get(0).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("BEH")){
				sororityList.get(1).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("ZAM")){
				sororityList.get(2).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("ZN")){
				sororityList.get(3).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("IHY")){
				sororityList.get(4).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("IKM")){
				sororityList.get(5).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("MAH")){
				sororityList.get(6).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("OH")){
				sororityList.get(7).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("PEK")){
				sororityList.get(8).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("TOP")){
				sororityList.get(9).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("YNOT")){
				sororityList.get(10).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}else if (tokens2[3].equals("XT")){
				sororityList.get(11).addPledge(tokens2[0], tokens2[1], Double.parseDouble(tokens2[2]));
			}
		}
		scanFile2.close();
		
		
		//Need to read the data from the “sororityList.txt” and “pledgeList.txt” files.
		//Pass the data to the appropriate methods in the Sorority class.
		
		System.out.println("Hello, and welcome to the Sorority Management System!");
		System.out.println("\nSchool Name: Faber College\nSchool Mascot: Beyonce");
		
		//Print all the data associated with each Sorority.
		System.out.println("\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Sorority Data:\n");
		for (int i = 0; i < sororityList.size(); i++){
			sororityList.get(i).outputSororityData();
			System.out.println();
			System.out.println("----------------------------------------------------------------------------------------------------\n");
		}
		
		print.println("UNSORTED DATA:\n");
		for (int i = 0; i < sororityList.size(); i++){
			print.println(sororityList.get(i).sororityPrint());
			print.println();
		}
		
		
		for (int i = 0; i < sororityList.size(); i++){
			sororityList.get(i).quickSort(sororityList.get(i).getPledges(), 0, sororityList.get(i).getPledges().size() -1 );
		}
		
		
		System.out.println("Pledges have been sorted by GPA and ranked from lowest to highest in terms of that value.\n");
		System.out.println("Post-Sort Sorority Data:\n");
		for (int i = 0; i < sororityList.size(); i++){
			sororityList.get(i).outputSororityData();
			System.out.println();
			System.out.println("----------------------------------------------------------------------------------------------------\n");
		}
		
		//Call the method to print which list each Sorority falls under
		
		System.out.println("Sorority List Status:\n");
		
		//I want my list status to look like this, don't take off for this.
		for(int i = 0; i < sororityList.size(); i++){
			System.out.println(sororityList.get(i).sororityListStatus());
		}
		System.out.println("\n----------------------------------------------------------------------------------------------------\n");
		
		//The ability to save all the data for the school, each sorority and its pledges, and
		//its overall GPA and number of pledges to a text file called “Faber.txt”
		
		print.println("\nSORTED DATA:\n");
		
		for (int i = 0; i < sororityList.size(); i++){
			print.println(sororityList.get(i).sororityPrint());
			print.println();
		}print.println("Sorority List Status:\n");
		for (int i = 0; i < sororityList.size(); i++){
			print.println(sororityList.get(i).sororityListStatus());
		}
		
		print.close(); 
		System.out.println("Data printed to file (Faber.txt) successfully.\n");
		
		System.out.println("Goodbye!");

	}

}
