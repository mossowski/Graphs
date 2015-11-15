package moss.graphs.component.adjacencymatrix;

import java.io.FileNotFoundException;

import moss.graphs.utils.FileReader;

public class EulerCycle {

	public EulerCycle() throws FileNotFoundException {
		AdjacencyMatrix matrix = new AdjacencyMatrix(6);
		FileReader fReader = new FileReader("matrix.txt");
		fReader.loadData();
		matrix.printMatrix();
		int[] eulerCycle = matrix.searchEulerCycle();
		matrix.printEuler(eulerCycle);
	}
}
