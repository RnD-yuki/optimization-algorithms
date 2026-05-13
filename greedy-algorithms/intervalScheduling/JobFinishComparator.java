package intervalScheduling;

import java.util.Comparator;

public class JobFinishComparator implements Comparator<Job> {
	public int compare(Job data, Job anotherData) {
		return Integer.compare(data.getFinish() , anotherData.getFinish()) ;
	} // the end of this comparing method
}