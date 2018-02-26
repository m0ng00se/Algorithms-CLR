import java.util.ArrayList;
import java.util.List;

/*!
 * Solution for Problem 1.2.1.
 */
public class SelectionSort extends Sort {
    
    //! No implementation.
    public <T extends Comparable<T>> void sort(List<T> m) {
	throw new UnsupportedOperationException();
    }

    //! Copy input array and sort the copy in-place.
    public <T extends Comparable<T>> List<T> _sort(List<T> m) {
	List<T> result = new ArrayList<T>(m);
	for (int i=0; i<result.size(); ++i) {
	    //! Find the current element
	    T elem = result.get(i);

	    //! Find the smallest remaining element
	    int k=i;
	    for (int j=i; j<result.size(); ++j) {
		System.out.println("Comparing: " + elem + "," + result.get(j));
		if (elem.compareTo(result.get(j)) > 0) {
		    System.out.println("FOUND!");
		    elem = result.get(j); k=j;
		}
	    }

	    //! Swap the smallest element with current element
	    if (i != k) {
		T tmp = result.get(i);
		result.set(i,elem);
		result.set(k,tmp);
		System.out.println("swap!");
	    }
	    System.out.println("loop done");;
	}
	return result;
    }

    //! Unit tests
    public static void main(String[] args) {
	SelectionSort s = new SelectionSort();

	System.out.println("");
	List<Integer> ints = randomInts(10, 1, 50);
	System.out.println("Input:\t " + ints);
	//List<Integer> sorted = s._sort(ints);
	//System.out.println("Output:\t " + sorted);
	System.out.println("");

	List<Integer> sortedUpInts = sortedIncreasingInts(10, 1);
	System.out.println("Input:\t " + sortedUpInts);
	//List<Integer> sortedUpInts_sort = s._sort(sortedUpInts);
	//System.out.println("Output:\t " + sortedUpInts_sort);
	System.out.println("");

	List<Integer> sortedDownInts = sortedDecreasingInts(10, 10);
	System.out.println("Input:\t " + sortedDownInts);
	List<Integer> sortedDownInts_sort = s._sort(sortedDownInts);
	System.out.println("Output:\t " + sortedDownInts_sort);
	System.out.println("");
    }
}
