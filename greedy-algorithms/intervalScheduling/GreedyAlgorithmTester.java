package intervalScheduling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GreedyAlgorithmTester {
	public static void main(String arg[ ]){
		Scanner  sc = new  Scanner(System.in);
		
		System.out.printf("#Jobs: ") ;
		int n = 0;
		try {
			n =  sc.nextInt( ) ; 
		}catch(InputMismatchException e) {
			System.out.printf("error : not number\n");
			System.out.printf("system has terminated.");
			System.exit(0) ;
		}
		
		//preparing of jobs
		Job[ ] array = new Job[n]; 
		try {
			for (int i = 0 ; i < n ; i++) 
				array[i] =  new Job( ) ;
			for (int i = 0 ; i < n ; i++)  
				array[i].inputJobData( ) ; 
			}
		catch(IllegalArgumentException e) {
			System.out.printf("error : inappropriate value\n");
			System.out.printf("system has terminated.");
			System.exit(0) ;
		}
		
		// quick sorting
		JobFinishComparator c = new JobFinishComparator();
		quickSort(array,0,n,c);

		// result of sorting
		System.out.printf("\nEarliest end time policy\n");
		for (int i = 0 ; i < n ; i++)
			System.out.printf("%s ",array[i].getName());
		System.out.printf("\n");
		
		////////////////////////////////////////////////////////////////////////////////////
		//GreedyAlgorithm
		ArrayList<Job> ans = greedyMethod(array,n);
		
		System.out.printf("Answer:\n");
		System.out.printf("name   : ");
		for (int i = 0 ; i < ans.size() ; i++)
			System.out.printf("%s ",ans.get(i).getName());
		System.out.printf("\n");
		
		System.out.printf("start  : ");
		for (int i = 0 ; i < ans.size() ; i++)
			System.out.printf("%d ",ans.get(i).getStart());
		System.out.printf("\n");
		
		System.out.printf("finish : ");
		for (int i = 0 ; i < ans.size() ; i++)
			System.out.printf("%d ",ans.get(i).getFinish());
		System.out.printf("\n");
		////////////////////////////////////////////////////////////////////////////////////
		
		sc.close() ;
	} // main
	
	public static ArrayList<Job> greedyMethod(Job[] array, int size) {
		Job previous = array[0];
		ArrayList<Job> ret = new ArrayList<Job>();
		
		ret.add(previous);
		
		for(int i = 1; i < size; i++) {
			if(previous.getFinish() <= array[i].getStart()) {
				previous = array[i];
				ret.add(previous);
			}
		}
		
		return ret;
	}
	
	
	public static <T> void quickSort(T[] array, int from, int to, Comparator<T> comparator)
    {
        int size = to - from;        //  size of a sorting area

        T pivot = array[from + size / 2];        //  pivot value（center position of a sorting target）

        int left = from;         
        int right = to - 1;         

        do {
            while (comparator.compare(array[left], pivot) < 0) {
                left++;
            }
            while (comparator.compare(pivot, array[right]) < 0) {
                right--;
            }
            if (left <= right) {
                T work = array[left];
                array[left] = array[right];
                array[right] = work;
                left++;
                right--;
            }
        } while (left <= right);

        if (from < right + 1) {
            quickSort(array, from, right + 1, comparator);
        }

        if (left < to - 1) {
            quickSort(array, left, to, comparator);
        }
    }
}