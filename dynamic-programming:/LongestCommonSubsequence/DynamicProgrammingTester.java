package LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DynamicProgrammingTester {
	public static void main(String arg[]) {
		Scanner sc = new Scanner( System.in );
		
		// scanning strings
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.printf("input data:\n");
		
		String X = sc.nextLine();
		String Y = sc.nextLine();
		
		sc.close();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// preparing dynamic programming table
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		int m = X.length();
		int n = Y.length();
		
		DynamicProgrammingTable dp = new DynamicProgrammingTable(X, Y);
		
		// matching directions and values
		Map<String, Integer> arrow = new HashMap<String, Integer>();
		arrow.put("left_up", 0); // the left up arrow is 0
		arrow.put("up", 1);      // the up arrow is 1
		arrow.put("left", 2);    // the left arrow is 2
		
		dp.showTable();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// dynamic programming method
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.printf("Answer:\n");
		List<Character> ans = new ArrayList<Character>();
		// backtracking
		int i = m;
		int j = n;
		
		while( i > 0 && j > 0) {
			if( dp.getArrow(i, j) == arrow.get("left_up") ) { // if the arrow of DP is equal to left up
				ans.add(X.charAt(i - 1));
				i--;
				j--;
			}
			else if( dp.getArrow(i, j) == arrow.get("up") ) { // if the arrow of DP is equal to up
				i--;
			}
			else {
				j--;
			}
		}
		
		//output by reverse order
		for(int index = ans.size() - 1; index >= 0; index--) {
			System.out.printf("%s", ans.get(index));
		}
		
	}
	
}