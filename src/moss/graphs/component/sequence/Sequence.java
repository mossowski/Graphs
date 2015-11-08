package moss.graphs.component.sequence;

import java.util.Arrays;
import java.util.Collections;

public class Sequence {

	private Integer[] sequence;

	public Sequence(Integer[] aSequence) {
		sequence = aSequence;
	}

	public Sequence(int aSize) {
		sequence = new Integer[aSize];
	}

	// ----------------------------------------------------------------------

	public Integer[] getSequence() {
		return sequence;
	}

	// ----------------------------------------------------------------------

	public void setSequence(Integer[] aSequence) {
		sequence = aSequence;
	}

	// ----------------------------------------------------------------------

	public int sum() {

		int sum = 0;
		for (int i = 0; i < sequence.length; i++) {
			sum += sequence[i];
		}

		return sum;
	}

	// ----------------------------------------------------------------------

	public int isGraphic() {

		sequence = sortSequence(sequence);
		int sum = sum();

		printSequence();

		if (sum % 2 == 1) {
			System.out.println("Ciag nie jest graficzny!");
			return 0;
		}

		while (sum > 0) {
			Integer temp[] = new Integer[sequence.length - 1];

			for (int i = 0; i < temp.length; i++) {
				if (i < sequence[0])
					temp[i] = sequence[i + 1] - 1;
				else
					temp[i] = sequence[i + 1];

				if (temp[i] < 0) {
					System.out.println("Ciag nie jest graficzny!!");
					return 0;
				}
			}

			sequence = sortSequence(temp);

			sum = sum();
			if (sum % 2 == 1) {
				System.out.println("Ciag nie jest graficzny!");
				return 0;
			}
		}

		System.out.println("Ciag jest graficzny!");
		return 1;
	}

	// ----------------------------------------------------------------------

	public Integer[] sortSequence(Integer aSequence[]) {
		Arrays.sort(aSequence, Collections.reverseOrder());
		return aSequence;
	}

	// ----------------------------------------------------------------------

	public void printSequence() {
		for (int i = 0; i < sequence.length; i++)
			System.out.print(sequence[i]);
		System.out.println();
	}
}
