package moss.graphs.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import moss.graphs.component.adjacencymatrix.AdjacencyMatrix;

public class FileReader {

	private Scanner fileScanner;
	private Scanner sizeScanner;
	private File file;

	// ----------------------------------------------------------------------

	public FileReader(String fileName) throws FileNotFoundException {
		file = new File(fileName);
		fileScanner = new Scanner(file);
		sizeScanner = new Scanner(file);
	}

	// ----------------------------------------------------------------------

	/**
	 * Loads file data to matrix
	 * 
	 * @param dataType
	 */
	public void loadData() {

		int ySize = 0;
		fileScanner.nextLine();

		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter(" ");
			int xSize = 0;

			while (lineScanner.hasNextInt()) {
				if (AdjacencyMatrix.matrixSize == xSize) {
					System.out.println("Wrong matrix size!");
					System.exit(0);
				}

				int nextInt = lineScanner.nextInt();
				if (nextInt >= 0)
					AdjacencyMatrix.matrix[ySize][xSize] = nextInt;
				else {
					System.out.println("Number cannot be less than zero!");
					System.exit(0);
				}
				xSize++;
			}

			ySize++;
			lineScanner.close();
		}

		fileScanner.close();

		if (AdjacencyMatrix.matrixSize != ySize) {
			System.out.println("Wrong matrix size!");
			System.exit(0);
		}
	}

	// ----------------------------------------------------------------------

	/**
	 * Loads file data to matrix
	 * 
	 * @param dataType
	 */
	public void loadDataSize() {
		int size = sizeScanner.nextInt();
		AdjacencyMatrix.matrixSize = size;

		sizeScanner.close();
	}

}
