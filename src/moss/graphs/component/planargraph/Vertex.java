package moss.graphs.component.planargraph;

public class Vertex {

	private String name;
	private int[] coordinates = new int[2];
	private Edge incidentEdge;

	public Vertex(String aName, int aX, int aY, Edge aIncidentEdge) {
		name = aName;
		coordinates[0] = aX;
		coordinates[1] = aY;
		incidentEdge = aIncidentEdge;
	}

}
