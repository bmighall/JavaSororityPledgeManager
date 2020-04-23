/*
 * Ben Mighall
 * CSCI 112
 * Project 5
 * April 25, 2016
 */

package project5;
import java.text.DecimalFormat;
public class Pledge {

	private String name = "Jane Doe";
	private String hometown = "Anytown, USA";
	private DecimalFormat gpaFormat = new DecimalFormat("#.00");
	private double gpa = 0.0;
	
	public Pledge(){	
	}
	
	public Pledge(String newName, String newHometown, double newGPA){
		name = newName;
		hometown = newHometown;
		gpa = newGPA;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	
	public void setHometown(String newHometown){
		hometown = newHometown;
	}
	
	public void setGPA(double newGPA){
		gpa = newGPA;
	}
	
	public String getName(){
		return name;
	}
	
	public String getHometown(){
		return hometown;
	}
	
	public double getGPA(){
		return gpa;
	}
	
	public String toString(){
		String s = "Student Name: " + name + "; Hometown: " + hometown + "; GPA: " + gpaFormat.format(gpa);
		return s;
	}
	
}
