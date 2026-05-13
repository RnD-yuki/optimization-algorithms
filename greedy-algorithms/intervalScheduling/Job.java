package intervalScheduling;

import java.util.Scanner;

public class Job{
	private int start,finish;
	private String name;
	
	private static final Scanner sc = new Scanner(System.in);
	
	
	public Job() {}
	
	public Job(int start, int finish, String name) throws IllegalArgumentException{
        setStart(start);
        setFinish(finish);
        setName(name);
        }
	
	public void inputJobData( ) throws IllegalArgumentException{ // input values
        System.out.printf("the name of the job : ") ;
        setName( sc.nextLine( ) );
        System.out.printf("start : ") ;
        setStart( Integer.parseInt( sc.nextLine( ) ));
        System.out.printf("finish : ") ;
        setFinish( Integer.parseInt( sc.nextLine( ) ));
    }
	
	
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		if (start < 0)
    		throw new IllegalArgumentException() ;
		this.start = start;
	}
	
	public int getFinish() {
		return finish;
	}
	
	public void setFinish(int finish) {
		if (finish < start)
    		throw new IllegalArgumentException() ;
		this.finish = finish;
	}
	
	public String getName( ) { 
        return name ;
    }
	
	public void setName(String name) { 
    	if (name == null)
    		throw new IllegalArgumentException() ;
        this.name = name ;
    }
	

	
	
}