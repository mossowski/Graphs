package moss.graphs.component.planargraph;

import java.util.ArrayList;

public class Wall {

	private String name;
	private Edge externalComponent;
	private ArrayList<Edge> internalComponents;

	public Wall(String aName) {
		name = aName;
		internalComponents = new ArrayList<Edge>();
	}

	public Wall(String aName, Edge aExternalComponent, ArrayList<Edge> aInternalComponent) {
		name = aName;
		externalComponent = aExternalComponent;
		internalComponents = aInternalComponent;
	}

	public Edge getExternalComponent() {
		return externalComponent;
	}

	public void setExternalComponent(Edge aExternalComponent) {
		externalComponent = aExternalComponent;
	}
	
	public void addInternalComponent(Edge aEdge) {
		internalComponents.add(aEdge);
	}

}
