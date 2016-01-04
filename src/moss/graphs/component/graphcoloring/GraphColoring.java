package moss.graphs.component.graphcoloring;

import java.io.FileNotFoundException;

import moss.graphs.component.adjacencymatrix.AdjacencyMatrix;
import moss.graphs.utils.FileReader;

public class GraphColoring {

	public GraphColoring() throws FileNotFoundException {
		FileReader fReader = new FileReader("graphcoloring1.txt");
		fReader.loadDataSize();
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		fReader.loadData();
		matrix.countDegrees();
		matrix.printMatrix();
		matrix.saturatedLargestFirst();
		matrix.printVertexesColors();
	}
}
