package moss.graphs.utils;

import java.util.Arrays;

public class AdjacencyMatrix {

	public static int[][] matrix;

	// ----------------------------------------------------------------------

	public AdjacencyMatrix(int size) {
		matrix = new int[size][size];
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

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
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
}
