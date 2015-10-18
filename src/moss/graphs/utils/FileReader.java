package moss.graphs.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	private Scanner fileScanner;
	private Scanner sizeScanner;

	// ----------------------------------------------------------------------

	public FileReader(String fileName) throws FileNotFoundException {
		fileScanner = new Scanner(new File(fileName));
		sizeScanner = new Scanner(new File(fileName));
	}

	// ----------------------------------------------------------------------

	/**
	 * Loads file data to matrix
	 * 
	 * @param dataType
	 */
	public void loadData() {

		int i = 0;
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter(" ");
			int j = 0;
			while (lineScanner.hasNextInt()) {
				AdjacencyMatrix.matrix[i][j] = lineScanner.nextInt();
				j++;
			}
			lineScanner.close();
			i++;
		}
		fileScanner.close();

	}

	// ----------------------------------------------------------------------

	public int checkSize() {

		int i = 0;
		int checkX = 0;
		int checkY = 0;

		while (sizeScanner.hasNextLine()) {
			String line = sizeScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter(" ");
			int j = 0;
			while (lineScanner.hasNextInt()) {
				lineScanner.nextInt();
				j++;
			}
			checkY = j;
			lineScanner.close();
			i++;
		}
		checkX = i;
		sizeScanner.close();

		if (checkX != checkY) {
			System.out.println("Wrong matrix size!");
			System.exit(0);
		}

		return checkX;
	}
}
