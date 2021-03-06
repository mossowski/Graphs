package moss.graphs.component.eulercycle;

import java.io.FileNotFoundException;

import moss.graphs.component.adjacencymatrix.AdjacencyMatrix;
import moss.graphs.utils.FileReader;

public class EulerCycle {

	public EulerCycle(String fileName) throws FileNotFoundException {
		FileReader fReader = new FileReader(fileName);
		fReader.loadDataSize();
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		fReader.loadData();
		matrix.printMatrix();
		int[] eulerCycle = matrix.searchEulerCycle();
		matrix.printEulerCycle(eulerCycle);
	}

}
