import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*!
 * Abstract base class for sorting procedures.
 */
public abstract class Sort {
    
    //! Override to provide in-place sort
    public abstract <T extends Comparable<T>> void sort(List<T> m);

    //! Return a list of n random integers (for unit testing)
    public static List<Integer> randomInts(int size, int low, int high) {
	Random rand = new Random();
        List<Integer> ints = new ArrayList<Integer>();
        for (int i=0; i<size; ++i) {
            int n = rand.nextInt(high-low+1) + low;
            ints.add(n);
        }
        return ints;
    }

    //! Return a list of sorted, increasing integers, starting at low.
    public static List<Integer> sortedIncreasingInts(int size, int low) {
	List<Integer> ints = new ArrayList<Integer>();
	for (int i=0; i<size; ++i) {
	    ints.add(low+i);
	}
	return ints;
    }

    //! Return a list of reverse-sorted, decreasing integers, starting at high.
    public static List<Integer> sortedDecreasingInts(int size, int high) {
	List<Integer> ints = new ArrayList<Integer>();
	for (int i=0; i<size; ++i) {
	    ints.add(high-i);
	}
	return ints;
    }

    //! Return a list of arbitary (unsorted) strings (for unit testing)
    public static List<String> randomStrings() {
	List<String> strings = new ArrayList<String>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");
        strings.add("six");
        strings.add("seven");
        strings.add("eight");
        strings.add("nine");
        strings.add("ten");
        return strings;
    }
}
