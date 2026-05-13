import java.util.ArrayList;

public class UnionFindTree {
	private int[] parent; //index of root node	
	private ArrayList<Edge> edge = new ArrayList<Edge>();
	
	public UnionFindTree(int size) {
		this.parent = new int[size + 1];
		
		
		for (int i = 0; i < size + 1; i++) {
			makeSet(i);
		}
	}
	
	public void makeSet(int i) {
		parent[i] = -1;
	}
	
	public void union(int x, int y) {
		int index_x = find(x); // index of root of x
		int index_y = find(y); // index of root of y
		
		int volume_x = - parent[index_x];
		int volume_y = - parent[index_y];
		
		if( volume_x > volume_y) {
			parent[index_x] += parent[index_y];
			parent[index_y] = index_x;
		}else {
			parent[index_y] += parent[index_x];
			parent[index_x] = index_y;
		}
		
	}
	
	//returning id of root which the argument belongs to
	public int find(int i) {
		if( parent[i] < 0 ) return i;
		else {
			//path compression
			parent[i] = find( parent[i] );
		}
		return parent[i];
	}
	
	//judging the arguments
	public boolean same(int x, int y) {
		return find(x) == find(y);
	}
	
	public void addEdge(Edge edge) { this.edge.add(edge); }
	public Edge getEdge(int index) { return this.edge.get(index); }
	public int getElemt(int index) { return - this.parent[ find(index) ]; }
	
	public void showAllEdge() {
		for(int i = 0; i < this.edge.size(); i++) {
			this.edge.get(i).showAllVertex();
			System.out.printf("%d\n", this.edge.get(i).getWeight());
		}
	}
}