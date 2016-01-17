package moss.graphs.application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import moss.graphs.component.eulercycle.EulerCycle;
import moss.graphs.component.graphcoloring.GraphColoring;
import moss.graphs.component.hamiltoncycle.HamiltonCycle;
import moss.graphs.component.weightedgraph.WeightedGraph;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Euler Cycle 	: 1");
		System.out.println("Hamilton Cycle  : 2");
		System.out.println("Weighted Graph  : 3");
		System.out.println("Coloring        : 4");
		System.out.println("Coloring        : 5");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		s.close();

		//System.out.print("Data : ");
		//Scanner sFile = new Scanner(System.in);
		//String fileName = sFile.next();
		//sFile.close();

		if (i == 1) {
			EulerCycle eulerCycle = new EulerCycle("eulercycle.txt");
		}
		else if (i == 2) {
			HamiltonCycle hamiltonCycle = new HamiltonCycle("hamiltoncycle.txt");
		}
		else if (i == 3) {
			WeightedGraph weightedGraph = new WeightedGraph("weightedgraph.txt");
		}
		else if (i == 4) {
			GraphColoring graphColoring = new GraphColoring("graphcoloring.txt");
		}
		else if (i == 5) {
			GraphColoring graphColoring = new GraphColoring("graphcoloring1.txt");
		}
	}

}
