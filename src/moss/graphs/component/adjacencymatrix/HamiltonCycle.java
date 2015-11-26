package moss.graphs.component.adjacencymatrix;

import java.io.FileNotFoundException;

import moss.graphs.utils.FileReader;

public class HamiltonCycle {

	public HamiltonCycle() throws FileNotFoundException {
		AdjacencyMatrix matrix = new AdjacencyMatrix(6);
		FileReader fReader = new FileReader("matrix.txt");
		fReader.loadData();
		matrix.printMatrix();
		int[] hamiltonCycle = matrix.searchHamiltonCycle();
		matrix.printHamiltonCycle(hamiltonCycle);
	}
}
