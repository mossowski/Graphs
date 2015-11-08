package moss.graphs.component.planargraph;

import java.util.ArrayList;

public class PlanarGraph {

	private ArrayList<Edge> edges;
	private ArrayList<Vertex> vertexes;
	private ArrayList<Wall> walls;
	
	public PlanarGraph(ArrayList<Edge> aEdges, ArrayList<Vertex> aVertexs, ArrayList<Wall> aWalls) {
		edges = aEdges;
		vertexes = aVertexs;
		walls = aWalls;
	}

	public PlanarGraph() {
		edges = new ArrayList<Edge>();
		vertexes = new ArrayList<Vertex>();
		walls = new ArrayList<Wall>();
	}

	public void addEdge(Edge aEdge) {
		edges.add(aEdge);
	}

	public void addVertex(Vertex aVertex) {
		vertexes.add(aVertex);
	}

	public void addWall(Wall aWall) {
		walls.add(aWall);
	}
	
	/**
	 * Return neighbors vertexes to specified vertex
	 * @param aVertex
	 * @return
	 */
	public ArrayList<Vertex> findNeighborVertexs(Vertex aVertex) {
		ArrayList<Vertex> neighbors = new ArrayList<Vertex>();

		for (Edge currentEdge : edges) {
			if (currentEdge.getBeginning() == aVertex) {
				Vertex neighborVertex = currentEdge.getTwin().getBeginning();
				neighbors.add(neighborVertex);
			}
		}
		return neighbors;
	}

}
