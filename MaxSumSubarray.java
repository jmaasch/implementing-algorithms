/**
 * This class enumerates static methods for
 * solving the maximum sum subarray problem
 * (aka max subinterval sum) in O(n^2) and 
 * O(n) time.
 * 
 * @author razel
 *
 */
public class MaxSumSubarray {

	/**
	 * An O(n^2) time approach to finding
	 * the maximum subinterval sum. If no 
	 * subinterval sum exceeds 0, the empty 
	 * set with sum 0 will be considered the 
	 * max sum subarray.
	 * 
	 * This method returns the max sum along
	 * with the start and end indices of the
	 * subinterval. Indices (-1, -1) indicate
	 * empty subarray.
	 * 
	 * @param int[] array
	 * @return int[] {bestSum, startIndex, endIndex}
	 */
	public static int[] findMaxSumSubarray(int[] array) {
		
		if (array == null) return new int[] {};
		if (array.length == 0) return new int[] {0, -1, -1}; 
		if (array.length == 1) {
			if (array[0] >= 0) return new int[] {array[0], 0, 0};
			return new int[] {0, -1, -1};
		}
		
		int bestSum = 0;
		int startIndex = -1;
		int endIndex = -1;
		
		for (int i = 0; i < array.length; i++) {
			int currentSum = 0;
			for (int j = i; j < array.length; j++) {
				currentSum += array[j];
				if (currentSum > bestSum) {
					bestSum = currentSum;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		
		return new int[] {bestSum, startIndex, endIndex};
	}

	/**
	 * Kadane's algorithm for identifying
	 * maximum sum subarray in O(n) time.
	 * If no subinterval sum exceeds 0,
	 * the empty set with sum 0 will be
	 * considered the max sum subarray.
	 * 
	 * @param int[] array
	 * @return int bestGlobal
	 */
	public static int kadanesAlgorithm(int[] array) {
		
		if (array == null) return -1; // True max sum will never be negative.
		if (array.length == 0) return 0;
		if (array.length == 1) {
			if (array[0] > 0) return array[0];
			return 0;
		}
		
		int bestGlobal = 0; // Best sum considering all indices.
		int bestLocal = 0; // Best sum ending at current index.
		for (int i = 0; i < array.length; i++) {
			if ((array[i] + bestLocal) > array[i]) {
				bestLocal += array[i];
			}
			else {
				bestLocal = array[i];
			}
			if (bestLocal > bestGlobal) {
				bestGlobal = bestLocal;
			}
		}
		
		return bestGlobal;
	}

	// Test in main.
	public static void main(String[] args) {
		int[] testArray = {-3, 2, -1, 3, -5, 4, -2, 7, -5, 3, -8, 3, 5, -3, 2};
		int[] testArray2 = {-3, -1, -5};

		System.out.println("Kadane's max subinterval sum = " + 
				MaxSumSubarray.kadanesAlgorithm(testArray));
		System.out.println("O(n^2) time result = " + 
				MaxSumSubarray.findMaxSumSubarray(testArray)[0]);
	}

}
