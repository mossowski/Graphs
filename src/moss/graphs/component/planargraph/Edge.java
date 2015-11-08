package moss.graphs.component.planargraph;

public class Edge {

	private String name;
	private Vertex beginning;
	private Edge twin;
	private Wall incidentWall;
	private Edge next;
	private Edge previous;

	public Edge(String aName, Vertex aBeginning, Edge aTwin, Wall aIncidentWall, Edge aNext, Edge aPrevious) {
		name = aName;
		beginning = aBeginning;
		twin = aTwin;
		incidentWall = aIncidentWall;
		next = aNext;
		previous = aPrevious;
	}
	
	public Vertex getBeginning() {
		return beginning;
	}
	
	public Edge getTwin() {
		return twin;
	}

}
