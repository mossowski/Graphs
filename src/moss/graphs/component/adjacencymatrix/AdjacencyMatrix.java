package moss.graphs.component.adjacencymatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AdjacencyMatrix {

	public static int[][] matrix;
	public static int matrixSize;
	public static int[] vertexesDegrees;
	public static int[] vertexesColors;
	public static int[] vertexesSaturations;

	public static int[] heap;
	public static int heapSize = 0;

	public static int[][] distanceMatrix;

	// ----------------------------------------------------------------------

	public AdjacencyMatrix() {
		matrix = new int[matrixSize][matrixSize];
		vertexesDegrees = new int[matrixSize];
		vertexesColors = new int[matrixSize];
		vertexesSaturations = new int[matrixSize];
		distanceMatrix = new int[matrixSize][matrixSize];
		heap = new int[matrixSize * matrixSize];
	}

	// ----------------------------------------------------------------------

	public void countDegrees() {
		for (int i = 0; i < matrix.length; i++) {
			int degree = 0;
			for (int j = 0; j < matrix.length; j++) {
				degree += matrix[i][j];
			}
			vertexesDegrees[i] = degree;
		}
	}

	// ----------------------------------------------------------------------

	public void addVertex() {
		int size = matrix.length + 1;
		int[][] result = new int[size][size];
		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result.length; j++) {
				if (i < matrix.length && j < matrix.length)
					result[i][j] = matrix[i][j];
				else {
					result[i][j] = 0;
				}
			}
		matrix = result;
	}

	// ----------------------------------------------------------------------

	public void addEdge(int firstVertex, int secondVertex) {
		matrix[firstVertex][secondVertex] = 1;
		matrix[secondVertex][firstVertex] = 1;
	}

	// ----------------------------------------------------------------------

	public void removeVertex(int vertex) {
		int size = matrix.length - 1;
		int[][] result = new int[size][size];

		int removedI = 0;
		for (int i = 0; i < result.length; i++) {
			int removedJ = 0;
			for (int j = 0; j < result.length; j++) {
				if (i != vertex && j != vertex)
					result[i][j] = matrix[i + removedI][j + removedJ];
				else if (i != vertex) {
					result[i][j] = matrix[i + removedI][j + 1];
					removedJ = 1;
				} else if (j != vertex) {
					result[i][j] = matrix[i + 1][j + removedJ];
					removedI = 1;
				} else {
					result[i][j] = matrix[i + 1][j + 1];
					removedJ = 1;
					removedI = 1;
				}
			}
		}
		matrix = result;
	}

	// ----------------------------------------------------------------------

	public void removeEdge(int firstVertex, int secondVertex) {
		matrix[firstVertex][secondVertex] = 0;
		matrix[secondVertex][firstVertex] = 0;
	}

	// ----------------------------------------------------------------------

	public void removeEdge(int vertex) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[vertex][i] = 0;
			matrix[i][vertex] = 0;
		}
	}

	// ----------------------------------------------------------------------

	public int countVertexDegree(int vertex) {
		int degree = 0;

		for (int i = 0; i < matrix[vertex].length; i++) {
			if (matrix[vertex][i] == 1) {
				degree++;
			}
		}
		return degree;
	}

	// ----------------------------------------------------------------------

	public int countMaximumDegree() {
		int maximumDegree = 0;

		for (int i = 0; i < matrix.length; i++) {
			int degree = countVertexDegree(i);
			if (degree > maximumDegree)
				maximumDegree = degree;
		}
		return maximumDegree;
	}

	// ----------------------------------------------------------------------

	public int countMinimumDegree() {
		int minimumDegree = matrix.length - 1;

		for (int i = 0; i < matrix.length; i++) {
			int degree = countVertexDegree(i);
			if (degree < minimumDegree)
				minimumDegree = degree;
		}
		return minimumDegree;
	}

	// ----------------------------------------------------------------------

	public int[] countEvenOddDegree() {
		int[] result = { 0, 0 };

		for (int i = 0; i < matrix.length; i++) {
			int degree = countVertexDegree(i);
			if (degree % 2 == 0)
				result[0]++;
			else
				result[1]++;
		}
		return result;
	}

	// ----------------------------------------------------------------------

	public int[] sortDegrees() {
		int[] degrees = new int[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			int degree = countVertexDegree(i);
			degrees[i] = degree;
		}

		Arrays.sort(degrees);
		return degrees;
	}

	// ----------------------------------------------------------------------

	public int hasCycle() {

		for (int i = 0; i < matrix.length; i++) {
			int connectedVertexes[] = new int[matrix.length - 1];
			int index = 0;
			for (int j = 1; j < matrix.length; j++) {
				if (matrix[i][j] == 1) {
					connectedVertexes[index] = j;
					index++;
				}
			}
			for (int k = 0; k < index; k++) {
				for (int l = k + 1; l < index; l++)
					if (matrix[connectedVertexes[k]][connectedVertexes[l]] == 1) {
						System.out.println("Graf ma cykl : " + matrix[i][0] + " " + connectedVertexes[k] + " " + connectedVertexes[l]);
						return 1;
					}
			}
		}

		System.out.println("Graf nie ma cyklu!");
		return 0;
	}

	// ----------------------------------------------------------------------

	public int[] searchCycle() {
		int[] sequence = new int[matrix.length + 1];
		Random random = new Random();
		int currentVertex = random.nextInt(matrix.length);

		sequence[0] = currentVertex;
		boolean hasChanges = true;
		int index = 1;

		while (hasChanges) {
			int[] neighbours = findNeighbours(matrix[currentVertex], sequence, index);

			if (neighbours.length > 0) {
				currentVertex = neighbours[random.nextInt(neighbours.length)];

				sequence[index] = currentVertex;
				index++;
			} else {
				hasChanges = false;
			}
		}

		for (int i = 0; i < sequence.length; i++) {
			if (matrix[sequence[i]][currentVertex] == 1) {
				sequence[index] = sequence[i];
				break;
			}
		}

		int start = 0;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] == sequence[sequence.length - 1]) {
				start = i + 1;
				break;
			}
		}

		int[] result = new int[sequence.length - start];
		for (int i = 0; i < result.length; i++) {
			result[i] = sequence[i + start];
		}

		return result;
	}

	// ----------------------------------------------------------------------

	public int[] findNeighbours(int[] array, int[] sequence, int size) {
		int[] neighbours = new int[array.length - 1];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] == 1) && !(contain(sequence, i, size))) {
				neighbours[index] = i;
				index++;
			}
		}

		int[] result = new int[index];
		for (int i = 0; i < result.length; i++) {
			result[i] = neighbours[i];
		}

		return result;
	}

	// ----------------------------------------------------------------------

	public int findEdge(int[] array) {
		int[] edges = new int[array.length - 1];
		int index = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				edges[index] = i;
				index++;
			}
		}

		Random random = new Random();
		int result = edges[random.nextInt(index)];

		return result;
	}

	// ----------------------------------------------------------------------

	public boolean contain(int[] array, int element, int size) {
		for (int i = 0; i < size; i++) {
			if (array[i] == element) {
				return true;
			}
		}
		return false;
	}

	// ----------------------------------------------------------------------

	public int findCentrum() {

		int vertexCount = matrix.length;

		while (vertexCount > 2) {

			int[] toRemove = new int[matrix.length];
			int index = 0;

			for (int j = 0; j < matrix.length; j++) {
				int degree = countVertexDegree(j);
				if (degree == 1) {
					toRemove[index] = j;
					index++;
				}
			}
			for (int k = 0; k < index; k++) {
				if (vertexCount > 2) {
					removeEdge(toRemove[k]);
					vertexCount--;
				}
			}
		}

		for (int j = 0; j < matrix.length; j++) {
			int degree = countVertexDegree(j);
			if (degree == 1) {
				return j;
			}
		}

		return 0;
	}

	// ----------------------------------------------------------------------

	public int[][] multiplyMatrix() {
		int[][] resultMatrix = new int[matrix.length][matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix.length; k++) {
					resultMatrix[i][j] += matrix[i][k] * matrix[k][j];
				}
			}
		}

		return resultMatrix;
	}

	// ----------------------------------------------------------------------

	public int[] searchEulerCycle() {
		int[] theHeap = new int[matrix.length * (matrix.length - 1)];
		int theHeapSize = 0;
		int[] euler = new int[matrix.length * (matrix.length - 1)];
		int eulerSize = 0;

		Random random = new Random();
		int u = random.nextInt(matrix.length);
		euler[0] = u;
		eulerSize++;

		do {
			if (countVertexDegree(u) > 0) {
				int v = findEdge(matrix[u]);
				theHeap[theHeapSize] = u;
				theHeapSize++;
				removeEdge(u, v);
				u = v;
			} else {
				u = theHeap[theHeapSize - 1];
				theHeapSize--;
				euler[eulerSize] = u;
				eulerSize++;
			}
		} while (theHeapSize > 0);

		int[] result = new int[eulerSize];

		for (int i = 0; i < result.length; i++) {
			result[i] = euler[i];
		}

		return result;
	}

	// ----------------------------------------------------------------------

	public int[] searchHamiltonCycle() {
		int[] theHeap = new int[matrix.length];
		int theHeapSize = 0;

		int v = 0;
		theHeap[0] = v;
		theHeapSize++;
		int removed = -1;

		do {
			int u = theHeap[theHeapSize - 1];
			// finds neighbor vertexes to u
			int[] neighbors = findNeighbours(matrix[u], theHeap, theHeapSize);
			int w = -1;

			// picks vertex greater than removed
			for (int i = 0; i < neighbors.length; i++) {
				if (neighbors[i] > removed) {
					w = neighbors[i];
					break;
				}
			}

			// adds w to heap
			if (w != -1) {
				theHeap[theHeapSize] = w;
				theHeapSize++;

				// checks if it's Hamilton Cycle
				if (isHamiltonCycle(theHeap, theHeapSize)) {
					break;
				}
			}
			// removes u from heap
			else {
				theHeapSize--;
				removed = u;
			}
		} while (theHeapSize > 0);

		int[] result = new int[theHeapSize];

		for (int i = 0; i < result.length; i++) {
			result[i] = theHeap[i];
		}

		return result;
	}

	// ----------------------------------------------------------------------

	public int[] searchHamiltonCycleRecursive() {
		int v = 0;
		heap[0] = v;
		heapSize++;

		hamiltonCycle(-1);

		int[] result = new int[heapSize];

		for (int i = 0; i < result.length; i++) {
			result[i] = heap[i];
		}

		return result;
	}

	// ----------------------------------------------------------------------

	public int hamiltonCycle(int aRemoved) {
		int u = heap[heapSize - 1];
		int theRemoved = -1;

		// finds neighbor vertexes to u
		int[] neighbors = findNeighbours(matrix[u], heap, heapSize);
		int w = -1;

		// picks vertex greater than removed
		for (int i = 0; i < neighbors.length; i++) {
			if (neighbors[i] > aRemoved) {
				w = neighbors[i];
				break;
			}
		}

		// adds w to heap
		if (w != -1) {
			heap[heapSize] = w;
			heapSize++;

			// checks if it's Hamilton Cycle
			if (isHamiltonCycle(heap, heapSize)) {
				return 1;
			}
		}
		// removes u from heap
		else {
			heapSize--;
			theRemoved = u;
		}

		if (heapSize <= 0) {
			return 0;
		}

		hamiltonCycle(theRemoved);
		return 0;
	}

	// ----------------------------------------------------------------------

	public boolean isHamiltonCycle(int[] cycle, int cycleSize) {

		for (int i = 0; i < cycleSize; i++)
			for (int j = i + 1; j < cycleSize; j++) {
				if (cycle[i] == cycle[j]) {
					return false;
				}
			}
		if (cycleSize == matrix.length) {
			return true;
		}
		return false;
	}

	// ----------------------------------------------------------------------

	public void countDistance(int vertex) {

		for (int i = 0; i < matrixSize; i++) {
			if (i == vertex || matrix[vertex][i] != 0) {
				distanceMatrix[vertex][i] = matrix[vertex][i];
			} else {
				distanceMatrix[vertex][i] = 99;
			}
		}

		ArrayList<Vertex> U = addElements(vertex);

		while (U.size() > 0) {
			Vertex uVertex = minimumWage(U);
			int u = uVertex.getIndex();
			U.remove(uVertex);

			for (Vertex currentVertex : U) {
				int v = currentVertex.getIndex();
				int vDistance = distanceMatrix[vertex][v];
				int uDistance = distanceMatrix[vertex][u];

				int wage = 99;
				if (matrix[u][v] != 0) {
					wage = matrix[u][v];
				}
				distanceMatrix[vertex][v] = Math.min(vDistance, uDistance + wage);
				currentVertex.setValue(distanceMatrix[vertex][v]);
			}
		}

	}

	// ----------------------------------------------------------------------

	public ArrayList<Vertex> addElements(int vertex) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();

		for (int i = 0; i < matrixSize; i++) {
			if (i != vertex) {
				Vertex v = new Vertex(i, distanceMatrix[vertex][i]);
				result.add(v);
			}
		}

		return result;
	}

	// ----------------------------------------------------------------------

	public Vertex minimumWage(ArrayList<Vertex> vertexes) {
		int minimum = vertexes.get(0).getValue();
		Vertex result = vertexes.get(0);

		for (Vertex vertex : vertexes) {
			int vertexWage = vertex.getValue();

			if (vertexWage < minimum) {
				minimum = vertex.getValue();
				result = vertex;
			}
		}

		return result;
	}

	// ----------------------------------------------------------------------

	public void saturatedLargestFirst() {

		// no color for each vector
		for (int i = 0; i < vertexesColors.length; i++) {
			vertexesColors[i] = -1;
		}

		int numberOfColored = 0;

		while (numberOfColored != matrix.length) {
			int coloredVertex = findVertex();
			// color current vertex
			vertexesColors[coloredVertex] = findColor(coloredVertex);
			numberOfColored++;
		}
	}

	// ----------------------------------------------------------------------

	public int findVertex() {

		countSaturations();

		int maxSaturation = -1;
		int maxDegree = -1;
		int vertex = 0;

		for (int i = 0; i < matrix.length; i++) {
			// if vertex is not colored and it has highest saturation and degree
			if (vertexesColors[i] == -1 && vertexesSaturations[i] >= maxSaturation && vertexesDegrees[i] > maxDegree) {
				vertex = i;
				maxSaturation = vertexesSaturations[i];
				maxDegree = vertexesDegrees[i];
			}
		}
		// System.out.println(vertex);
		return vertex;
	}

	// ----------------------------------------------------------------------

	public int findColor(int vertex) {

		int colors[] = new int[matrix.length];
		int color = 0;

		colors = clearArray(colors);

		for (int i = 0; i < matrix.length; i++) {
			// if there is edge and it is colored
			if (matrix[vertex][i] == 1 && vertexesColors[i] != -1) {
				colors[vertexesColors[i]]++;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (colors[i] == 0) {
				return i;
			}
		}

		return color;
	}

	// ----------------------------------------------------------------------

	public void countSaturations() {

		for (int i = 0; i < matrix.length; i++) {

			int colors[] = new int[matrix.length];

			colors = clearArray(colors);

			for (int j = 0; j < matrix.length; j++) {
				// if there is edge and it is colored
				if (matrix[i][j] == 1 && vertexesColors[j] != -1) {
					colors[vertexesColors[j]]++;
				}
			}

			int saturation = 0;

			// count number of different colors
			for (int j = 0; j < matrix.length; j++) {
				if (colors[j] != 0)
					saturation++;
			}

			vertexesSaturations[i] = saturation;
		}
	}

	// ----------------------------------------------------------------------

	public int[] clearArray(int array[]) {
		int result[] = new int[array.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}

		return result;
	}

	// ----------------------------------------------------------------------

	public void printEulerCycle(int[] euler) {
		System.out.println("Euler cycle : ");
		for (int i = 0; i < euler.length; i++) {
			System.out.print(euler[i] + " ");
		}
		System.out.println("");
	}

	// ----------------------------------------------------------------------

	public void printHamiltonCycle(int[] hamilton) {
		System.out.println("Hamilton cycle : ");
		for (int i = 0; i < hamilton.length; i++) {
			System.out.print(hamilton[i] + " ");
		}
		System.out.println("");
	}

	// ----------------------------------------------------------------------

	public void printMatrix() {
		System.out.println("");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	// ----------------------------------------------------------------------

	public void printDistanceMatrix() {
		System.out.println("");
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix[i].length; j++) {
				System.out.print(distanceMatrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	// ----------------------------------------------------------------------

	public void printMatrix(int[][] aMatrix) {
		System.out.println("\n\nMultiply matrix");
		for (int i = 0; i < aMatrix.length; i++) {
			for (int j = 0; j < aMatrix[i].length; j++) {
				System.out.print(aMatrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	// ----------------------------------------------------------------------

	public void printVertexesColors() {
		System.out.println("\n\nVertexes Colors");
		for (int i = 0; i < vertexesColors.length; i++) {
			System.out.println("vertex : " + i + " color : " + vertexesColors[i]);
		}
		System.out.println("");
	}

}
