/**
 * 
 * @author andrewzheng
 * Question:R-5.1 to find max element in a array through recursion
 * The runtime for this code is O(n) as the runtime for recursive function is based on how times 
 * the code is being called. For example, if it repeats 4 times, the runtime is O(4n) 
 * which is the same as O(n).
 * As for the space usage, it is also O(n) as it recursive calling for array, which is has a
 * memory of n, so space should also be O(n)
 */
public class MaxArray {

	    public static int findMax(int[] array, int max, int n){

	        if (array[n] > max) { //Compare each element whether which is greater
	            max = array[n]; //set the next max as we go through the array
	        }
	        if (n == 0) {//if n equal to 0, then this element is the max value
	           return max;
	        } else {
	            return findMax(array, max, n-1); //recursive call back to check the next element
	            //until it reaches n=0
	        }

	    }
		  public static void main(String[] args) {
		        int array[] = {2,1,3,5,11,4}; //array list

		        int max = findMax(array, 0, array.length-1);//store the max value
		        System.out.println("The max value is " + max); //printing the max value
		    }

}
