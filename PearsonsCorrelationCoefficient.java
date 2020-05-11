/**
 * Objects of this class compute Pearson's
 * correlation coefficient and R2.
 * 
 * https://en.wikipedia.org/wiki/Pearson_correlation_coefficient
 * 
 * @author razel
 *
 */
public class PearsonsCorrelationCoefficient {

	/**
	 * This method computes the R2 (R-squared) 
	 * value when given a Pearson's correlation 
	 * coefficient.
	 * 
	 * @param double pearsonsR
	 * @return double R2
	 */
	public static double computeR2(double pearsonsR) {
		return Math.pow(pearsonsR, 2);
	}
	
	/**
	 * This method computes Pearson's correlation 
	 * coefficient, r.
	 * 
	 * The output of this method has been validated
	 * against Excel's in-built Pearson's function.
	 * 
	 * @param double[] X
	 * @param double[] Y
	 * @param int sizeOfArray
	 * @return double r
	 */
	public static double computeR(double[] X, double[] Y, int sizeOfArray) { 

		// Arrays must be of same length.
		if (X.length != Y.length) return -2;

		// Variables.
		double sumX = 0;
		double sumY = 0;
		double sumXY = 0; 
		double sumXSquared = 0;
		double sumYSquared = 0; 

		// Summations.
		for (int i = 0; i < sizeOfArray; i++) { 
			// Sum elements in X. 
			sumX += X[i]; 

			// Sum elements in Y. 
			sumY += Y[i]; 

			// Sum all (X[i] * Y[i]). 
			sumXY += (X[i] * Y[i]); 

			// Sum of square of array elements. 
			sumXSquared += (X[i] * X[i]); 
			sumYSquared += (Y[i] * Y[i]); 
		} 

		// Correlation coefficient formula:
		double r = (sizeOfArray * sumXY - (sumX * sumY)) / 
				(Math.sqrt(((sizeOfArray * sumXSquared) - (sumX * sumX)) *
						((sizeOfArray * sumYSquared) - (sumY * sumY)))); 

		return r; 
	} 
	
	// Test in main.
	public static void main(String[] args) {
		double[] X = {4.5, 5.0, 4.7, 4.8, 4.2, 5.1};
		double[] Y = {2.3, 2.8, 2.2, 2.9, 2.0, 3.0};
		double r = PearsonsCorrelationCoefficient.computeR(X, Y, X.length);
		double R2 = PearsonsCorrelationCoefficient.computeR2(r);
		System.out.println("r = " + r + ", R2 = " + R2);
	}

}
