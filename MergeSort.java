/**
 * This implementation of merge sort is 
 * based on the pseudocode provided by
 * CLRS (Chapter 2, p. 31).
 * 
 * @author razel
 *
 */
public class MergeSort {

	/**
	 * Merge sort, a classic sorting algorithm
	 * requiring O(n log n) time.
	 * 
	 * Alters the input array.
	 * 
	 * @param int[] array
	 * @return void
	 */
	public void mergeSort(int[] array) {
		// Edge cases.
		if (array == null) return;
		if (array.length <= 1) return;
		
		// Invoke overloaded mergeSort.
		mergeSort(array, 0, array.length - 1);
	}
	
	/**
	 * This private helper method does the
	 * real work of mergeSort(int[] array)
	 * via recursive calls to itself and the
	 * merge() method.
	 * 
	 * @param int[] array
	 * @param int start
	 * @param int mid
	 * @param int end
	 * @return void
	 */
	private void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}

	/**
	 * This private helper method requires
	 * O(n) time to perform the merging stage
	 * of mergeSort.
	 * 
	 * @param int[] array
	 * @param int start
	 * @param int mid
	 * @param int end
	 * @return void
	 */
	private void merge(int[] array, int start, int mid, int end) {
		
		// Instantiate and populate subarrays.
		int leftSize = mid - start + 1;
		int rightSize = end - mid;
		int[] leftSubarray = new int[leftSize + 1];
		int[] rightSubarray = new int[rightSize + 1];
		
		for (int i = 0; i < leftSize; i++) {
			leftSubarray[i] = array[start + i];
		}
		for (int i = 0; i < rightSize; i++) {
			rightSubarray[i] = array[mid + i + 1];
		}
		
		// "Sentinel" values = approximate infinity.
		leftSubarray[leftSize] = Integer.MAX_VALUE;
		rightSubarray[rightSize] = Integer.MAX_VALUE;

		// Merge subarrays.
		int i = 0;
		int j = 0;
		for (int k = start; k <= end; k++) {
			if (leftSubarray[i] < rightSubarray[j]) {
				array[k] = leftSubarray[i];
				i++;
			}
			else {
				array[k] = rightSubarray[j];
				j++;
			}
		}
	}

	// Test in main.
	public static void main(String[] args) {

		int[] testArray = {1, 10, 5, 8, 3, 9, 3};
		MergeSort ms = new MergeSort();
		ms.mergeSort(testArray);

		// Print sorted array.
		if (testArray != null) {
			for (int element : testArray) {
				System.out.print(element + " ");
			}
		}

	}

}
