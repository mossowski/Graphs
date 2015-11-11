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
	 * 
	 * @param aVertex
	 * @return
	 */
	public ArrayList<Vertex> findNeighborVertexes(Vertex aVertex) {
		ArrayList<Vertex> neighbors = new ArrayList<Vertex>();

		for (Edge currentEdge : edges) {
			if (currentEdge.getBeginning() == aVertex) {
				Vertex neighborVertex = currentEdge.getTwin().getBeginning();
				neighbors.add(neighborVertex);
			}
		}
		return neighbors;
	}

	/**
	 * Return edges belonging to specified wall
	 * 
	 * @param aWall
	 * @return
	 */
	public ArrayList<Edge> findEdges(Wall aWall) {
		ArrayList<Edge> wallEdges = new ArrayList<Edge>();

		for (Edge currentEdge : edges) {
			if (currentEdge.getIncidentWall() == aWall) {
				wallEdges.add(currentEdge);
			}
		}
		return wallEdges;
	}

	/**
	 * Prints neighbors vertexes
	 * 
	 * @param neighbors
	 */
	public void printNeighbors(Vertex vertex, ArrayList<Vertex> neighbors) {
		System.out.print("\nNeighbors " + vertex.getName() + " : ");
		for (Vertex v : neighbors) {
			System.out.print(v.getName() + " ");
		}
		System.out.println();
	}

	/**
	 * Prints edges
	 * 
	 * @param neighbors
	 */
	public void printEdges(Wall aWall, ArrayList<Edge> aEdges) {
		System.out.print("\nEdges belonging to  " + aWall.getName() + " : ");
		for (Edge e : aEdges) {
			System.out.print(e.getName() + " ");
		}
		System.out.println();
	}

	/**
	 * Prints planar graph
	 */
	public void printGraph() {

		printVertexes();
		printWalls();
		printEdges();
	}

	/**
	 * Prints vertexes
	 */
	public void printVertexes() {
		System.out.println("Vertex Coordinates IncidentEdge");
		for (Vertex vertex : vertexes) {
			System.out.println("  " + vertex.getName() + "     (" + vertex.getCoordinateX() + "," + vertex.getCoordinateY() + ")        " + vertex.getIncidentEdge().getName());
		}
		System.out.println();
	}

	/**
	 * Prints walls
	 */
	public void printWalls() {
		System.out.println("Wall ExternalComponent InternalComponent");
		for (Wall wall : walls) {
			System.out.println(" " + wall.getName() + "       " + wall.getExternalComponent().getName() + "                 " + wall.getInternalComponents().get(0).getName());
		}
		System.out.println();
	}

	/**
	 * Prints edges
	 */
	public void printEdges() {
		System.out.println("Edge Beginning Twin IncidentWall Next Previous");
		for (Edge edge : edges) {
			System.out.println(edge.getName() + "     " + edge.getBeginning().getName() + "      " + edge.getTwin().getName() + "      " + edge.getIncidentWall().getName() + "       "
					+ edge.getNext().getName() + "    " + edge.getPrevious().getName());
		}
		System.out.println();
	}

}
