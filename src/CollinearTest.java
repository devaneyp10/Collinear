import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 03/10/16 17:10:35
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     *  You should read the lecture notes and/or book to understand how to correctly implement the main methods.
     *  You can use any of the provided classes to read from files, and time your code.
     * @throws FileNotFoundException 
     *
     */
    
    public void countCollinearTest() 
    {
    	 int[] array1 = {2,78,23,13,5,6};
    	 int[] array2 = {3,41,4,53,10,109};
    	 int[] array3 = {4,6,31,97,23,15};
    	 
    	 int[] array4 = {42,34,23,44,97};
    	 int[] array5 = {1,20,12,74,89};
    	 int[] array6 = {3,25,56,73,0};
    	 
    	 
    	 int expectedResult1=3;
    	 int expectedResult2=0;
    	
    	 
    	 assertEquals("countCollinear test for array1,array2,array3",expectedResult1,Collinear.countCollinear(array1,array2,array3));//tests if there are 3 sets of collinear points in array1,array2,array3
    	 assertEquals("countCollinear test for array4,array5,array6",expectedResult2,Collinear.countCollinear(array4,array5,array6));//tests if there are 0 sets of collinear points in array4,array5,array6
    	 
    }
    public void countCollinearFastTest()
    {
    	 int[] array1 = {2,78,23,13,5,6};
    	 int[] array2 = {3,41,4,53,10,109};
    	 int[] array3 = {4,6,31,97,23,15};
    	 
    	 int[] array4 = {42,34,23,44,97};
    	 int[] array5 = {1,20,12,74,89};
    	 int[] array6 = {3,25,56,73,0};
    	 
    	 
    	 int expectedResult1=3;
    	 int expectedResult2=0;
    	 
    	 
    	 assertEquals("countCollinear test for array1,array2,array3",expectedResult1,Collinear.countCollinearFast(array1,array2,array3));//tests if there are 3 sets of collinear points in array1,array2,array3
    	 assertEquals("countCollinear test for array4,array5,array6",expectedResult2,Collinear.countCollinearFast(array4,array5,array6));//tests if there are 0 sets of collinear points in array4,array5,array6
    	 
    }
     public static void main(String[] args) throws FileNotFoundException
     {
    	Scanner scanner = new Scanner(new File("r05000-1.txt"));
     	int[] array1 = new int[5000];
     	int i = 0;
     	while (scanner.hasNextInt())
     	{
     		array1[i++]=scanner.nextInt();
     	}
     	
     	
     	Scanner scanner2= new Scanner(new File("r05000-2.txt"));
     	int[] array2 = new int[5000];
     	i = 0;
     	while (scanner.hasNextInt())
     	{
     		array2[i++]=scanner.nextInt();
     	}
     	
     	
     	
     	Scanner scanner3 = new Scanner(new File("r05000-3.txt"));
     	int[] array3 = new int[5000];
     	i = 0;
     	while (scanner.hasNextInt())
     	{
     		array3[i++]=scanner.nextInt();
     	}
     	
     	
     	Stopwatch timer1 =new Stopwatch();
     	Collinear.countCollinear(array1,array2,array3);
     	System.out.println(timer1.elapsedTime());
     	
     	Stopwatch timer2 =new Stopwatch();
     	Collinear.countCollinearFast(array1,array2,array3);
     	System.out.println(Double.toString(timer2.elapsedTime()));
     	
     	
     	
     	
     }

}
