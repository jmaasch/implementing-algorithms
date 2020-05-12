/**
 * This class enumerates methods for computing 
 * Fibonacci numbers. Fibonacci numbers form a 
 * sequence such that each number is the sum of 
 * the two preceding, starting from 0 and 1:
 * 
 * {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...}
 * 
 * The Fibonacci sequence arises from the following
 * recurrence relation:
 * 
 * F_n = F_n-1 + F_n-2
 * 
 * Given this simple recurrence relation, recursive
 * and iterative dynamic programming algorithms
 * are easily implemented.
 * 
 * @author razel
 *
 */
public class Fibonacci {

	/**
	 * This method returns the Fibonacci sequence 
	 * up to F_n, the (n + 1)^th Fibonacci number. 
	 * This method uses a bottom-up (iterative) 
	 * dynamic programming approach with memoization.
	 * 
	 * Time complexity: O(n)
	 * 
	 * This method obeys the recurrence relation: 
	 * F_n = F_n-1 + F_n-2
	 * 
	 * @param int n
	 * @return int[] fibN
	 */
	public static int[] computeFibonacciSeq(int n) {

		if (n == 0) return new int[] {0};
		if (n == 1) return new int[] {0, 1};

		int[] fibSeq = new int[n + 1];
		fibSeq[0] = 0; 						 // Base case: F_0 = 0.
		fibSeq[1] = 1; 						 // Base case: F_1 = 1.

		for (int i = 2; i < n + 1; i++) {
			fibSeq[i] = fibSeq[i - 1] + fibSeq[i - 2];
		}

		return fibSeq;
	}

	/**
	 * This recursive method returns F_n, the 
	 * (n + 1)^th number in the Fibonacci sequence.
	 * 
	 * Time complexity: O(n)
	 * 
	 * This method obeys the recurrence relation: 
	 * F_n = F_n-1 + F_n-2
	 * 
	 * @param int n
	 * @return int F_n
	 */
	public static int computeFibonacciRecurse(int n) {

		if (n == 0) return 0;	// Base case: F_0 = 0.
		if (n == 1) return 1;	// Base case: F_1 = 1.

		return computeFibonacciRecurse(n - 1) +
				computeFibonacciRecurse(n - 2);
	}

	/**
	 * This method returns F_n, the (n + 1)^th 
	 * Fibonacci number using an iterative approach. 
	 * Because only the (n + 1)^th number in the 
	 * sequence is needed, memoization of the entire 
	 * sequence is unnecessary.
	 * 
	 * Time complexity: O(n)
	 * 
	 * This method obeys the recurrence relation: 
	 * F_n = F_n-1 + F_n-2
	 * 
	 * @param int n
	 * @return int fibN
	 */
	public static int computeFibonacciN(int n) {

		if (n == 0) return 0;
		if (n == 1) return 1;

		int fibNMinus2 = 0;		// Base case: F_0 = 0.
		int fibNMinus1 = 1;		// Base case: F_1 = 1.
		int fibN = 1;

		for (int i = 2; i < n + 1; i++) {
			fibN = fibNMinus1 + fibNMinus2;
			fibNMinus2 = fibNMinus1;
			fibNMinus1 = fibN;
		}

		return fibN;
	}

	// Test in main.
	public static void main(String[] args) {
		System.out.println("Iterative approach = " + 
				Fibonacci.computeFibonacciN(12));

		System.out.println("Recursive approach = " + 
				Fibonacci.computeFibonacciRecurse(12));

		int[] fibSeq = Fibonacci.computeFibonacciSeq(12);
		System.out.print("Full seq = ");
		for (int value : fibSeq) {
			System.out.print(value + " ");
		}
	}
}
