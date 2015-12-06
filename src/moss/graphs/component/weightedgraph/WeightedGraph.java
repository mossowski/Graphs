package moss.graphs.component.weightedgraph;

import java.io.FileNotFoundException;

import moss.graphs.component.adjacencymatrix.AdjacencyMatrix;
import moss.graphs.utils.FileReader;

public class WeightedGraph {

	public WeightedGraph() throws FileNotFoundException {
		FileReader fReader = new FileReader("weightedgraph.txt");
		fReader.loadDataSize();
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		fReader.loadData();
		matrix.printMatrix();
	}

}
