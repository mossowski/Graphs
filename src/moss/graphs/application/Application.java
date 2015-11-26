package moss.graphs.application;

import java.io.FileNotFoundException;

import moss.graphs.component.adjacencymatrix.EulerCycle;
import moss.graphs.component.adjacencymatrix.HamiltonCycle;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		//EulerCycle eulerCycle = new EulerCycle();
		HamiltonCycle hamiltonCycle = new HamiltonCycle();
	}

}
