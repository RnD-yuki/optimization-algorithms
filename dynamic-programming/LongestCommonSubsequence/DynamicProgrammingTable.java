package LongestCommonSubsequence;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgrammingTable {
	private int[][] c,b;
	private int m,n;
	private Map<String, Integer> arrow;
	
	public DynamicProgrammingTable(String x, String y) {
		this.m = x.length();
		this.n = y.length();
		this.c = new int [ m + 1][ n + 1];
		this.b = new int [ m + 1][ n + 1];
		
		// matching directions and values
		this.arrow = new HashMap<String, Integer>();
		this.arrow.put("left_up", 0);
		this.arrow.put("up", 1);
		this.arrow.put("left", 2);
		
		// initializing DP
		for(int i = 1; i <= this.m; i++) { this.c[i][0] = 0; }
		for(int j = 0; j <= this.n; j++) { this.c[0][j] = 0; }
		
		// setting up DP
		for(int i = 1; i <= this.m; i++) {
			for(int j = 1; j <= this.n; j++) {
				if( x.charAt( i - 1 ) == y.charAt( j - 1 ) ) {
					
					this.c[i][j] = 1 + this.c[ i -1 ][ j - 1 ]; // recurrence formula
					this.b[i][j] = this.arrow.get( "left_up" ); // representing the left up arrow with 0
					
				}
				else if( this.c[ i - 1 ][j] >= this.c[i][ j - 1] ) {
					
					this.c[i][j] = this.c[ i -1 ][j]; // recurrence formula
					this.b[i][j] = this.arrow.get( "up" ); // representing the up arrow with 1
					
				}
				else {
					
					this.c[i][j] = this.c[i][ j - 1 ]; // recurrence formula
					this.b[i][j] = this.arrow.get( "left" ); // representing the left arrow with 2
					
				}
			}
		}
	}
	
	public int getArrow(int i, int j) { return this.b[i][j]; }
	
	public void showTable() {
		System.out.printf("Values of DP:\n");
		for(int i = 0; i <= this.m; i++) {
			for(int j = 0; j <= this.n; j++) {
				System.out.printf("%d ", this.c[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.println();
		System.out.printf("Arrows of DP:\n");
		for(int i = 0; i <= this.m; i++) {
			for(int j = 0; j <= this.n; j++) {
				System.out.printf("%d ", this.b[i][j]);
			}
			System.out.printf("\n");
		}
		System.out.println();
	}
	
}