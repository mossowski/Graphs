package moss.graphs.application;

import java.io.FileNotFoundException;

import moss.graphs.utils.AdjacencyMatrix;
import moss.graphs.utils.FileReader;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "matrix.txt";
		FileReader fReader = new FileReader(fileName);

		int size = fReader.checkSize();

		AdjacencyMatrix aMatrix = new AdjacencyMatrix(size);

		fReader.loadData();
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
	}

}
