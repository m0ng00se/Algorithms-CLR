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
		if (elem.compareTo(result.get(j)) > 0) {
		    elem = result.get(j); k=j;
		}
	    }

	    //! Swap the smallest element with current element
	    T tmp = result.get(i);
	    result.set(i,elem);
	    result.set(k,tmp);
	}
	return result;
    }

    //! Unit tests
    public static void main(String[] args) {
	SelectionSort s = new SelectionSort();

	System.out.println("");
	List<Integer> ints = randomInts(10, 1, 50);
	System.out.println("Input:\t " + ints);
	List<Integer> sorted = s._sort(ints);
	System.out.println("Sort:\t " + sorted);
	System.out.println("");
    }
}
