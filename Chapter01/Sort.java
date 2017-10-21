import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//! Solution for Problems 1.1 and 1.2
public class Sort {
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

    //! Return a list of arbitrary ints.
    public static List<Integer> randomInts() {
	Random rand = new Random();
	List<Integer> ints = new ArrayList<Integer>();
	for (int i=0; i<10; ++i) {
	    int n = rand.nextInt(50) + 1; // 1 is min, 50 is max
	    ints.add(n);
	}
	return ints;
    }

    //! Return a list of arbitrary strings.
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

    //! Unit tests
    public static void main(String[] args) {
	Sort s = new Sort();

	System.out.println("");
	List<Integer> ints = randomInts();
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
