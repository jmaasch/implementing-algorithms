/**
 * This class implements counting sort, a linear-time sorting 
 * algorithm that makes assumptions about its input.
 * 
 * From CLRS, Ch8 p195:
 * "Counting sort assumes that each of the n input elements is 
 * an integer in the range 0 to k, for some integer k. When 
 * k = O(n), the sort runs in Theta(n) time."
 * 
 * From CLRS, Ch8 p196:
 * "How much time does counting sort require? ... the overall 
 * time is Theta(k + n). In practice, we usually use counting 
 * sort when we have k = O(n), in which case the running time 
 * is Theta(n).
 * 
 * Counting sort beats the lower bound of 􏰂Omega(n lg n) proved 
 * in Section 8.1 because it is not a comparison sort. In fact, 
 * no comparisons between input elements occur anywhere in 
 * the code. Instead, counting sort uses the actual values 
 * of the elements to index into an array. The 􏰂Omega(n lg n) 
 * lower bound for sorting does not apply when we depart from 
 * the comparison sort model."
 * 
 * https://en.wikipedia.org/wiki/Counting_sort
 * "Its running time is linear in the number of items and the 
 * difference between the maximum and minimum key values, so 
 * it is only suitable for direct use in situations where the 
 * variation in keys is not significantly greater than the 
 * number of items. However, it is often used as a subroutine 
 * in another sorting algorithm, radix sort, that can handle 
 * larger keys more efficiently."
 * 
 * @author razel
 *
 */
public class CountingSort {

	/**
	 * This method implements counting sort. Elements of
	 * the input array must be non-negative.
	 * 
	 * Time complexity = Theta(k + n), i.e. linear.
	 * 
	 * @param int[] inputArray
	 * @return int[] sortedArray
	 */
	public static int[] countingSort(int[] inputArray) {

		// Edge cases.
		if (inputArray == null) return null;
		if (inputArray.length < 2) return inputArray;

		// Identify maximum value in input array.
		int k = Integer.MIN_VALUE;
		for (int element : inputArray) {
			if (element < 0) return null; // Input array was invalid.
			if (element > k) k = element + 1;
		}

		// Init data structures.
		int[] sortedArray = new int[inputArray.length];
		int[] tempArray = new int[k];

		// tempArray[i] = total elements equal to i.
		for (int j = 0; j < inputArray.length; j++) {
			tempArray[inputArray[j]] = ++tempArray[inputArray[j]];
		}

		// tempArray[i] = total elements less than or equal to i.
		for (int i = 1; i < k; i++) {
			tempArray[i] = tempArray[i] + tempArray[i - 1];
		}

		// Populate output array.
		for (int j = inputArray.length - 1; j > -1; j--) {
			sortedArray[tempArray[inputArray[j]] - 1] = inputArray[j];
			tempArray[inputArray[j]] = tempArray[inputArray[j]] - 1;
		}

		return sortedArray;
	}

	// Test in main.
	public static void main(String[] args) {
		
		int[] testArray = {8, 5, 2, 0, 154, 13};
		int[] nullArray = null;
		int[] sortedArray = CountingSort.countingSort(testArray);
		if (sortedArray == null) System.out.println("null");
		else {
			for (int element: sortedArray) {
				System.out.print(element + " ");
			}
		}

	}

}
