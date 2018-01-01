import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*!
 * Solutions for Problems 1.1.1 and 1.1.2
 */
public class InsertionSort extends Sort {
    //! Sort a list in increasing order.
    public <T extends Comparable<T>> void sort(List<T> m) {
	if (m.size() <= 1)
	    return;
	for (int i=1; i<m.size(); ++i) {
	    T elem = m.get(i);
	    int j = i-1;
	    while (j >= 0 && m.get(j).compareTo(elem) > 0) {
		m.set(j+1, m.get(j)); j--;
	    }
	    m.set(j+1, elem);
	}
    }

    //! No implementation
    public <T extends Comparable<T>> List<T> sortWithCopy(List<T> m) {
	return null;
    }

    //! Sort a list in reverse order.
    public <T extends Comparable<T>> void reverse(List<T> m) {
	if (m.size() <= 1)
	    return;
	for (int i=1; i<m.size(); ++i) {
	    T elem = m.get(i);
	    int j = i-1;
	    while (j >= 0 && m.get(j).compareTo(elem) < 0) {
		m.set(j+1, m.get(j)); j--;
	    }
	    m.set(j+1, elem);
	}
    }

    //! Unit tests
    public static void main(String[] args) {
	InsertionSort s = new InsertionSort();

	System.out.println("");
	List<Integer> ints = randomInts(10, 1, 50);
	System.out.println("Input:\t " + ints);
	s.sort(ints);
	System.out.println("Sort:\t " + ints);
	s.reverse(ints);
	System.out.println("Reverse: " + ints);
	
	System.out.println("");
	
	List<String> strings = randomStrings();
	System.out.println("Input:\t " + strings);
	s.sort(strings);
	System.out.println("Sort:\t " + strings);
	s.reverse(strings);
	System.out.println("Reverse: " + strings);
	System.out.println("");
    }
}
