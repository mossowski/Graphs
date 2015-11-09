package moss.graphs.component.planargraph;

public class PlanarGraphController {

	public PlanarGraphController() {
	
		// NIL edge
		Edge nil = new Edge("nil");
		
		// Vertexes
		Vertex v1 = new Vertex("v1", 0, 4);
		Vertex v2 = new Vertex("v2", 2, 4);
		Vertex v3 = new Vertex("v3", 2, 2);
		Vertex v4 = new Vertex("v4", 1, 1);
		
		// Walls
		Wall f1 = new Wall("f1");
		Wall f2 = new Wall("f2");
		
		// Edges
		Edge e11 = new Edge("e11");
		Edge e12 = new Edge("e12");
		Edge e21 = new Edge("e21");
		Edge e22 = new Edge("e22");
		Edge e31 = new Edge("e31");
		Edge e32 = new Edge("e32");
		Edge e41 = new Edge("e41");
		Edge e42 = new Edge("e42");
		
		// Setting vertexes
		v1.setIncidentEdge(e11);
		v2.setIncidentEdge(e42);
		v3.setIncidentEdge(e21);
		v4.setIncidentEdge(e22);
		
		// Setting walls
		f1.setExternalComponent(nil);
		f1.addInternalComponent(e11);
		f2.setExternalComponent(e41);
		f2.addInternalComponent(nil);
		
		// Setting edges
		e11.setBeginning(v1);
		e11.setTwin(e12);
		e11.setIncidentWall(f1);
		e11.setNext(e42);
		e11.setPrevious(e31);
		
		e12.setBeginning(v2);
		e12.setTwin(e11);
		e12.setIncidentWall(f2);
		e12.setNext(e32);
		e12.setPrevious(e41);
		
		e21.setBeginning(v3);
		e21.setTwin(e22);
		e21.setIncidentWall(f1);
		e21.setNext(e22);
		e21.setPrevious(e42);
		
		e22.setBeginning(v4);
		e22.setTwin(e21);
		e22.setIncidentWall(f1);
		e22.setNext(e31);
		e22.setPrevious(e21);
		
		e31.setBeginning(v3);
		e31.setTwin(e32);
		e31.setIncidentWall(f1);
		e31.setNext(e11);
		e31.setPrevious(e22);
		
		e32.setBeginning(v1);
		e32.setTwin(e31);
		e32.setIncidentWall(f2);
		e32.setNext(e41);
		e32.setPrevious(e12);
		
		e41.setBeginning(v3);
		e41.setTwin(e42);
		e41.setIncidentWall(f2);
		e41.setNext(e12);
		e41.setPrevious(e32);
		
		e42.setBeginning(v2);
		e42.setTwin(e41);
		e42.setIncidentWall(f1);
		e42.setNext(e21);
		e42.setPrevious(e11);
		
		// Planar graph
		PlanarGraph planarGraph = new PlanarGraph();
		
		// Adding vertexes
		planarGraph.addVertex(v1);
		planarGraph.addVertex(v2);
		planarGraph.addVertex(v3);
		planarGraph.addVertex(v4);
		
		// Adding walls
		planarGraph.addWall(f1);
		planarGraph.addWall(f2);
		
		// Adding edges
		planarGraph.addEdge(e11);
		planarGraph.addEdge(e12);
		planarGraph.addEdge(e21);
		planarGraph.addEdge(e22);
		planarGraph.addEdge(e31);
		planarGraph.addEdge(e32);
		planarGraph.addEdge(e41);
		planarGraph.addEdge(e42);
	}
}
