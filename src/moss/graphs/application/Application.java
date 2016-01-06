package moss.graphs.application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import moss.graphs.component.eulercycle.EulerCycle;
import moss.graphs.component.graphcoloring.GraphColoring;
import moss.graphs.component.hamiltoncycle.HamiltonCycle;
import moss.graphs.component.weightedgraph.WeightedGraph;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		// EulerCycle eulerCycle = new EulerCycle();
		// HamiltonCycle hamiltonCycle = new HamiltonCycle();
		// WeightedGraph weightedGraph = new WeightedGraph();

		System.out.print("Data : ");
		Scanner in = new Scanner(System.in);
		String fileName = in.next();
		in.close();

		GraphColoring graphColoring = new GraphColoring(fileName);
	}

}
