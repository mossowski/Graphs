package moss.graphs.component.planargraph;

public class Vertex {

	private String name;
	private int[] coordinates = new int[2];
	private Edge incidentEdge;

	public Vertex(String aName, int aX, int aY) {
		name = aName;
		coordinates[0] = aX;
		coordinates[1] = aY;
	}

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}

	public Edge getIncidentEdge() {
		return incidentEdge;
	}

	public void setIncidentEdge(Edge aIncidentEdge) {
		incidentEdge = aIncidentEdge;
	}

}
