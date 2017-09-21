
/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author
 */

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author      Carson Ellsworth <cae0462@utulsa.edu>
 * @version     1.81             
 * @since       8/31/2017         
 */
public class Lab1b {
    

    /**stores the data retrived from the file */
    Vector <Double> DoubleVector; 
    /** variable used to compute the run-time */
    long startTime, endTime, totalTime;
    /** Constructor: computes the running time and call readFile
     * method
     */

    /** Constructor: calls method readFile that reads the doubles
     * contained in the file "<code>filename</code>" and computes the
     * average of the elements.
     @param filename name of the file containing doubles.
    */
    public Lab1b(String filename) {
    	startTime = System.currentTimeMillis();
    	this.readFile(filename);
    	endTime = System.currentTimeMillis();    
    	totalTime = endTime - startTime;
    	System.out.println("total time taken: " + totalTime + " milliseconds");
    }

    /** Reads double from a file named <code>filename</code> and
     * computes the average of the elements contained in the file 
     * @param filename name of the file containing the doubles 
     */
    public void readFile(String filename) {
    File dataFile = new File(filename);
	try {
		Scanner input = new Scanner(dataFile);
		DoubleVector = new Vector<Double>();
		double elt;
		while(input.hasNextDouble()) {
			elt = input.nextDouble();
			DoubleVector.add(elt);
		}
		 for (double value: DoubleVector)
				System.out.printf("%f ",value);
			    System.out.println();
		Average(DoubleVector,filename);	    
		input.close();
	} catch (FileNotFoundException e) {
		System.out.println("File Not found");
		e.printStackTrace();
	}
	
    } //end readFile()
    /**
 	 * average: takes in a Vector<Double> and runs through and pulls out each element to calculate the average
 	 * filename is for ending reference of where the values were pulled from
     * @param Dvector,filename
     * @return Dvector
     */
    public Vector<Double> Average(Vector<Double> Dvector,String filename){
    	int count =0;
    	double average = 0;
    	for(int i=0; i < Dvector.size(); i++) { //Find the average value
			count++;
			average += i;
		}
    	average= average/count;
    	System.out.printf("The average of the numbers in %s is: %f\n",filename,average);//outputs the average num
    	return Dvector;
    	}
    
    
    /** main : creates a Lab1b Object with the filename passed in
     * argument*/
    public static void main(String args[]) {
    Lab1b test = new Lab1b("Lab1b.dat");
    if (args.length == 0)
	    System.err.println("enter the data file name!");
	else
	    new Lab1b(args[0]);
    } //end main
    
} //end class Lab1b
