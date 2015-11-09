package moss.graphs.component.planargraph;

public class Edge {

	private String name;
	private Vertex beginning;
	private Edge twin;
	private Wall incidentWall;
	private Edge next;
	private Edge previous;

	public Edge(String aName) {
		name = aName;
	}

	public Edge(String aName, Vertex aBeginning, Edge aTwin, Wall aIncidentWall, Edge aNext, Edge aPrevious) {
		name = aName;
		beginning = aBeginning;
		twin = aTwin;
		incidentWall = aIncidentWall;
		next = aNext;
		previous = aPrevious;
	}

	public String getName() {
		return name;
	}

	public void setName(String aName) {
		name = aName;
	}

	public Vertex getBeginning() {
		return beginning;
	}

	public void setBeginning(Vertex aBeginning) {
		beginning = aBeginning;
	}

	public Edge getTwin() {
		return twin;
	}

	public void setTwin(Edge aTwin) {
		twin = aTwin;
	}

	public Wall getIncidentWall() {
		return incidentWall;
	}

	public void setIncidentWall(Wall aIncidentWall) {
		incidentWall = aIncidentWall;
	}

	public Edge getNext() {
		return next;
	}

	public void setNext(Edge aNext) {
		next = aNext;
	}

	public Edge getPrevious() {
		return previous;
	}

	public void setPrevious(Edge aPrevious) {
		previous = aPrevious;
	}

}
