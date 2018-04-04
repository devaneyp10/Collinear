// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  
 *  @version 03/10/16 17:10:35
 */
class Collinear
{

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *
     * ----------------------------------------------------------
     *
     * Experimental Performance:
     * -------------------------
     *  Write the running time of the algorithm when run with the following input sizes
     *  
     *  Input Size N      Running Time (sec)
     *  ------------------------------------
     *  1000              0.402
     *  2000              2.578
     *  4000              20.454
     *
     *  Assuming that the running time of your algorithm is of the form aN^b,
     *  estimate 'b' and 'a' by fitting a line to the experimental points:
     *
     *  b = 3
     *  a = 1/3
     *
     *  What running time do you predict using your results for input size 5000?
     *  What is the actual running time you get with such an input?
     *  What is the error in percentage?
     *
     *  Error = ( (Actual time) - (Predicted time) ) * 100 / (Predicted time)
     *
     *  Input Size N      Predicted Running Time (sec)        Actual Running Time (sec)       Error (%)
     *  ------------------------------------------------------------------------------------------------
     *  5000              40 secs                                40.189                           0.4703 
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of growth: n^3
     *
     *  Explanation: it is a cubic order of growth as it runs through every value in every loop it checks each and every possible triple.
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3)
    {
      int y1=1;
      int y2=2;
      int y3=3;
      int count=0;
      
      for(int i=0;i<a1.length;i++)
      {
    	  for(int j=0;j<a2.length;j++)
    	  {
    		  for(int k=0;k<a3.length;k++)
    		  {
    			  if (a1[i]*(y2-y3)+a2[j]*(y3-y1)+a3[k]*(y1-y2)==0) count++;
    		  }
    	  }
    	  
      }
      return count;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     * Experimental Performance:
     * -------------------------
     *  Measure the running time of the algorithm when run with the following input sizes
     *  
     *  Input Size N      Running Time (sec)
     *  ------------------------------------
     *  1000              0.015
     *  2000              0.076
     *  4000              0.244
     *  5000              0.341
     *
     *
     *  Compare Implementations:
     *  ------------------------
     *  Show the speedup achieved by this method, using the times you got from your experiments.
     *
     *  Input Size N      Speedup = (time of countCollinear)/(time of countCollinearFast)
     *  ---------------------------------------------------------------------------------
     *  1000              26.8
     *  2000              33.92
     *  4000              83.828
     *  5000              117.85
     *
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2logN
     *
     *  Explanation: uses insertion sort to first sort one of the arrays then uses binary search on that sorted array in the inner most for loop
     *
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
      sort(a1);
      int key;
      int count=0;
      for(int i=0;i<a2.length;i++)
      {
    	  for(int j=0;j<a3.length;j++)
    	  {
    		  /*
    		   * x1*(y2-y3)+x2*(y3-y1)+x3(y1-y2)=0
    		   * x1*(2-3)+x2*(3-1)+x3*(1-2)=0
    		   * -1*x1+2*x2+-1*x3=0
    		   * -1*x1=-2*x2+1*x3
    		   * x1=2*x2-1*x3
    		   *
    		   */
    		  key = (2*a2[i]-a3[j]);
    		  if(binarySearch(a1,key)) count++;
    	  }
      }
      
      
      return count;
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     * Approximate Mathematical Performance:
     * -------------------------------------
     *  Using an appropriate cost model, give the performance of your algorithm.
     *  Explain your answer.
     *
     *  Performance: N^2
     *
     *  Explanation: nested for loop:checks each value in the array twice
     *
     */
    static void sort(int[] a)
    {
    	  //this method is taken from java2novice.com
    	  int tmp;
          for (int i=1; i<a.length; i++) 
          {
              for(int j=i; j>0; j--)
              {
                  if(a[j]<a[j-1])
                  {
                      tmp=a[j];
                      a[j]=a[j-1];
                      a[j-1]=tmp;
                  }
              }
          }
          
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     * Approximate Mathematical Performance:
     * -------------------------------------
     *  Using an appropriate cost model, give the performance of your algorithm.
     *  Explain your answer.
     *
     *  Performance: lgN
     *
     *  Explanation: Splits the number of values in the array in half repeatedly until the key is found within the array
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
    	 //taken from www.cs.toronto.edu
    	 int low=0;
    	 int high=a.length-1;
    	    
    	 while(high>=low) 
    	 {
    		 int middle=(low+high)/2;
    		 if(a[middle]==x) 
    		 {
    			 return true;
    		 }
	    	 if(a[middle]<x)
	    	 {
	    		 low=middle+1;
	    	 }
	    	 if(a[middle]>x) 
	    	 {
	    		 high=middle-1;
	    	 }
    	}
    	return false;
     
    }

}
