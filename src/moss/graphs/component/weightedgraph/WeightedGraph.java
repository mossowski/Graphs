package moss.graphs.component.weightedgraph;

import java.io.FileNotFoundException;

import moss.graphs.component.adjacencymatrix.AdjacencyMatrix;
import moss.graphs.utils.FileReader;

public class WeightedGraph {

	public WeightedGraph(String fileName) throws FileNotFoundException {
		FileReader fReader = new FileReader(fileName);
		fReader.loadDataSize();
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		fReader.loadData();
		matrix.printMatrix();

		for (int i = 0; i < AdjacencyMatrix.matrixSize; i++) {
			matrix.countDistance(i);
		}

		matrix.printDistanceMatrix();
	}

}
