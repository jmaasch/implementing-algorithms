/**
 * This implementation of insertion sort
 * is based on the pseudocode provided by
 * CLRS (Chapter 2, p. 26).
 * 
 * @author razel
 *
 */
public class InsertionSort {

	/**
	 * Insertion sort, O(n^2) time complexity.
	 * Alters the input array.
	 * 
	 * @param int[] array
	 * @return void
	 */
	public static void insertionSort(int[] array) {
		int key;
		for (int j = 1; j < array.length; j++) {
			key = array[j];
			int i = j - 1;
			while (i > 0 && array[i] > key) {
				array[i + 1] = array[i];
				i -= 1;
			}
			array[i + 1] = key;
		}
	}

	// Test in main.
	public static void main(String[] args) {
		
		int[] testArray = {0, 0, 9, 5, 4, 8, 2};
		InsertionSort.insertionSort(testArray);
		for (int element : testArray) {
			if (element == testArray[testArray.length - 1]) {
				System.out.print(element);
			}
			else System.out.print(element + ", ");
		}

	}

}
