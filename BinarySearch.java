/**
 * Methods of this class perform binary search, whereby a 
 * pre-sorted input array is searched by recursive halving
 * until the desired value is found, resulting in Theta(log n)
 * time complexity.
 * 
 * From CLRS Exercise 2.3-5, p39:
 * Referring back to the searching problem (see Exercise 2.1-3), 
 * observe that if the sequence A is sorted, we can check the 
 * midpoint of the sequence against and eliminate half of the 
 * sequence from further consideration. The binary search
 * algorithm repeats this procedure, halving the size of the 
 * remaining portion of the sequence each time...
 * 
 * Binary search obeys the following recurrence relation:
 * T(n) = T(n / 2) + Theta(1)
 * Which reduces by Master Theorem to:
 * T(n) = Theta(log n)
 * 
 * @author razel
 *
 */
public class BinarySearch {

	/**
	 * Overloaded method. This method calls a private 
	 * helper method to recursively halve the input
	 * array until the desired number is located or 
	 * found to be missing.
	 * 
	 * Recurrence: T(n) = T(n / 2) + Theta(1)
	 * Time complexity: Theta(log n)
	 * 
	 * @param int[] sortedArray
	 * @param int number
	 * @return int index of number (if present) or -1
	 */
	public static int binarySearch(int[] sortedArray, int number) {
		return binarySearch(0, sortedArray.length - 1, sortedArray, number);
	}
	
	/**
	 * Overloaded method. Helper method called by
	 * binarySearch(int[] sortedArray, int number)
	 * to make recursive calls on continually halved
	 * subsets of the input array.
	 * 
	 * Recurrence: T(n) = T(n / 2) + Theta(1)
	 * Time complexity: Theta(log n)
	 * 
	 * @param int start
	 * @param int end
	 * @param int[] sortedArray
	 * @param int number
	 * @return int index of number (if present) or -1
	 */
	private static int binarySearch(int start, int end, int[] sortedArray, int number) {
		
		// Find middle index of current array subset.
		int mid = (start + end) / 2;
		
		// If never found:
		if ((end - start) <= 1 && sortedArray[mid] != number) return -1;
		
		// Test relative size of number.
		if (sortedArray[mid] == number) return mid;
		else if (sortedArray[mid] > number) end = mid - 1;
		else start = mid + 1;
		
		// Recurse.
		return binarySearch(start, end, sortedArray, number);
	}

	// Test in main.
	public static void main(String[] args) {
		int[] testArray = {1, 2, 5, 5, 8, 9};
		System.out.println(BinarySearch.binarySearch(testArray, 3));
		System.out.println(BinarySearch.binarySearch(testArray, 8));
	}

}
