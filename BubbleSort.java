/**
 * Methods of this class perform bubble sort, an intuitive yet 
 * slow comparison sort algorithm.
 * 
 * This implementation is based on the pseudocode provided by
 * CLRS, Ch2 p40: "Bubblesort is a popular, but inefficient, 
 * sorting algorithm. It works by repeatedly swapping adjacent 
 * elements that are out of order."
 * 
 * "This simple algorithm performs poorly in real world use and 
 * is used primarily as an educational tool. More efficient 
 * algorithms such as timsort, or merge sort are used by the 
 * sorting libraries built into popular programming languages 
 * such as Python and Java."
 * - https://en.wikipedia.org/wiki/Bubble_sort
 * 
 * Time complexity: O(n^2)
 * 
 * @author razel
 *
 */
public class BubbleSort {

	/**
	 * This method bubble sorts an integer array
	 * in O(n^2) time.
	 * 
	 * @param int[] array
	 * @return void
	 * 
	 */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = array.length - 1; j > i; j--) {
				// Swap if out of order.
				if (array[j] < array[j - 1]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	// Test in main.
	public static void main(String[] args) {
		int[] testArray = {0, 8, -19, 4, 7, 3, 4, 2, 1, 25};
		BubbleSort.bubbleSort(testArray);
		for (int element: testArray) {
			System.out.print(element + " ");
		}

	}

}
