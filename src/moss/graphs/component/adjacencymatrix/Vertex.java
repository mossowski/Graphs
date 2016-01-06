package moss.graphs.component.adjacencymatrix;

public class Vertex {

	private int index;
	private int value;

	public Vertex(int aIndex, int aValue) {
		index = aIndex;
		value = aValue;
	}

	public int getIndex() {
		return index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int aValue) {
		value = aValue;
	}

}
