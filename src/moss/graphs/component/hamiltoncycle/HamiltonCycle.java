package moss.graphs.component.hamiltoncycle;

import java.io.FileNotFoundException;

import moss.graphs.component.adjacencymatrix.AdjacencyMatrix;
import moss.graphs.utils.FileReader;

public class HamiltonCycle {

	public HamiltonCycle(String fileName) throws FileNotFoundException {
		FileReader fReader = new FileReader(fileName);
		fReader.loadDataSize();
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		fReader.loadData();
		matrix.printMatrix();
		int[] hamiltonCycle = matrix.searchHamiltonCycleRecursive();
		matrix.printHamiltonCycle(hamiltonCycle);
	}

}
