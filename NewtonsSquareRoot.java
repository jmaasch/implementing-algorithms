/**
 * This class enumerates static methods
 * for finding the square root and integer
 * square root of a given integer. These
 * methods are based on Isaac Newton's
 * formula for computing integer square root,
 * one of many historic formulae for computing 
 * square root.
 * 
 * https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
 * 
 * @author razel
 *
 */
public class NewtonsSquareRoot {

	/**
	 * Method to find square root based on the 
	 * following formula, Newton's method for 
	 * finding the integer square root:
	 * 
	 * Solve x^2 - n = 0 to solve sqrt(n)
	 * x_(k+1) = (x_k + (n / x_k)) / 2
	 * 
	 * https://en.wikipedia.org/wiki/Integer_square_root
	 * 
	 * @param int num
	 * @return double squareRoot
	 */
	public static double findSquareRoot(int num) {

		if (num == 0 || num == 1) return num;

		double squareRoot = num / 2;
		double x;

		do {
			x = squareRoot;
			squareRoot = (x + (num / x)) / 2;
		} while ((x - squareRoot) != 0);

		return squareRoot;
	}
	
	/**
	 * Method to find square root based on the 
	 * following formula, Newton's method for 
	 * finding the integer square root:
	 * 
	 * Solve x^2 - n = 0 to solve sqrt(n)
	 * x_(k+1) = (x_k + (n / x_k)) / 2
	 * 
	 * https://en.wikipedia.org/wiki/Integer_square_root
	 * 
	 * This method returns the floor of the sqrt
	 * by casting to int.
	 * 
	 * @param int num
	 * @return int squareRoot
	 */
	public static int findSquareRootFloor(int num) {

		if (num == 0 || num == 1) return num;

		double squareRoot = num / 2;
		double x;

		do {
			x = squareRoot;
			squareRoot = (x + (num / x)) / 2;
		} while ((x - squareRoot) != 0);

		return (int) squareRoot;
	}
	
	// Test in main.
	public static void main(String[] args) {
		System.out.println(NewtonsSquareRoot.findSquareRoot(8));
		System.out.println(NewtonsSquareRoot.findSquareRootFloor(8));
	}

}
