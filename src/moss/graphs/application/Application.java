package moss.graphs.application;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;

import moss.graphs.utils.AdjacencyMatrix;
import moss.graphs.utils.FileReader;

public class Application {

	// ----------------------------------------------------------------------

	public static int sum(Integer sequence[]) {

		Integer sum = 0;
		for (int i = 0; i < sequence.length; i++) {
			sum += sequence[i];
		}

		return sum;
	}

	// ----------------------------------------------------------------------

	public static int isGraphic(Integer aSequence[]) {

		Integer[] sequence = sortSequence(aSequence);
		int sum = sum(sequence);

		printSequence(sequence);

		if (sum % 2 == 1) {
			System.out.println("Ciag nie jest graficzny!");
			return 0;
		}

		while (sum > 0) {
			Integer temp[] = new Integer[sequence.length - 1];

			for (int i = 0; i < temp.length; i++) {
				if (i < sequence[0])
					temp[i] = sequence[i + 1] - 1;
				else
					temp[i] = sequence[i + 1];

				if (temp[i] < 0) {
					System.out.println("Ciag nie jest graficzny!!");
					return 0;
				}
			}

			printSequence(temp);

			sequence = sortSequence(temp);

			sum = sum(sequence);
			if (sum % 2 == 1) {
				System.out.println("Ciag nie jest graficzny!");
				return 0;
			}
		}

		System.out.println("Ciag jest graficzny!");
		return 1;
	}

	// ----------------------------------------------------------------------

	public static void printSequence(Integer sequence[]) {
		for (int i = 0; i < sequence.length; i++)
			System.out.print(sequence[i]);
		System.out.println();
	}

	// ----------------------------------------------------------------------

	public static Integer[] sortSequence(Integer sequence[]) {
		Arrays.sort(sequence, Collections.reverseOrder());
		return sequence;
	}

	// ----------------------------------------------------------------------

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "matrix.txt";
		FileReader fReader = new FileReader(fileName);

		int size = fReader.checkSize();

		AdjacencyMatrix aMatrix = new AdjacencyMatrix(size);

		fReader.loadData();
		aMatrix.printMatrix();
		
		aMatrix.hasCycle();

		aMatrix.removeVertex(0);

		aMatrix.printMatrix();

		aMatrix.addVertex();

		aMatrix.printMatrix();

		aMatrix.addEdge(0, 2);

		aMatrix.printMatrix();

		System.out.println("Minimum degree : " + aMatrix.countMinimumDegree());
		System.out.println("Maximum degree : " + aMatrix.countMaximumDegree());

		int[] evenOdd = aMatrix.countEvenOddDegree();
		System.out.println("Even degree : " + evenOdd[0]);
		System.out.println("Odd degree : " + evenOdd[1]);

		int[] sortedDegrees = aMatrix.sortDegrees();
		System.out.print("Sorted by degree : ");
		for (int i = 0; i < sortedDegrees.length; i++)
			System.out.print(sortedDegrees[i] + " ");
		System.out.println();
		//int[][] multiplyMatrix = aMatrix.multiplyMatrix();
		

		Integer[] sequence = { 5, 4, 2, 2, 6, 3, 2, 2 };

		isGraphic(sequence);

	}

}
