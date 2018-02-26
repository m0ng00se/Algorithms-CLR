import java.util.ArrayList;
import java.util.List;

/*!
 * TODO:
 */
public class MergeSort extends Sort {

    public <T extends Comparable<T>> void sort(List<T> m) {
	mergeSort(m, 0, m.size()-1);
    }

    private <T extends Comparable<T>> void mergeSort(List<T> m, int p, int r) {
	if (p < r) {
	    int q = (p+r)/2;
	    mergeSort(m, p, q);
	    mergeSort(m, q+1, r);
	    merge(m, p, q, r);
	}
    }

    private <T extends Comparable<T>> void merge(List<T> m, int p, int q, int r) {
	// Copy subarrays into set-aside memory
	List<T> left = new ArrayList<T>(m.subList(p,q+1));
	List<T> right = new ArrayList<T>(m.subList(q+1,r+1));

	System.out.println("Left:  " + left);
	System.out.println("Right: " + right);

	// Merge the elements of two sorted sub-arrays
	T elem1 = left.remove(0);
	T elem2 = right.remove(0);
	System.out.println("elem1: " + elem1);
	System.out.println("elem2: " + elem2);
	System.out.println("new left: " + left);
	System.out.println("new righT: " + right);
	int i=p, i1=p, i2=q+1;
	while ((i1 < q+1) && (i2 < r+1)) {
	    if (elem1.compareTo(elem2) < 0) {
		System.out.println("one");
		i++; i1++;
		if (left.size() > 0) {
		    elem1 = left.remove(0);
		}
	    }
	    else {
		System.out.println("two");
		i++; i2++;
		if (right.size() > 0) {
		    elem2 = right.remove(0);
		}
	    }
	}

	// Finish filling out left and rights sides    
        while (i1 < q+1) {
	    i1++;
	}
	while (i2 < r+1) {
	    i2++;
      	}
		
	/*
	while ((i1 < q+1) && (i2 < r+1)) {
	    T elem1 = m.get(i1);
	    T elem2 = m.get(i2);
	    System.out.println("elem1: " + elem1);
	    System.out.println("elem2: " + elem2);
	    System.out.println("i: " + i);
	    System.out.println("i1: " + i1);
	    System.out.println("i2: " + i2);
	    if (elem1.compareTo(elem2) < 0) {
		m.set(i, elem1);
		System.out.println("one");
		i++; i1++;
	    }
	    else {
		System.out.println("two");
		m.set(i, elem2);
		i++; i2++;
	    }
	    System.out.println(m);
	}
	System.out.println("Done with main loop");

	// Finish filling out left and rights sides
	while (i1 < q+1) {
	    System.out.println("finish one: " + m.get(i1));
	    m.set(i, m.get(i1));
	    i++; i1++;
	    System.out.println(m);
	    System.out.println("i : " + i);
	    System.out.println("i1: " + i1);
	}
	while (i2 < r+1) {
	    System.out.println("finish two: " + m.get(i2));
	    m.set(i, m.get(i2));
	    i++; i2++;
	    System.out.println(m);
	    System.out.println("i : " + i);
	    System.out.println("i2: " + i2);
	}
	
	System.out.println("");
	*/
    }

    //! Unit tests
    public static void main(String[] args) {
	MergeSort s = new MergeSort();

	// Test even-sized array
	System.out.println("");
	List<Integer> ints1 = randomInts(10, 1, 50);
	System.out.println("Input:\t " + ints1);
	s.sort(ints1);
	System.out.println("Sort:\t " + ints1);
	System.out.println("");
	/*
	// Test odd-sized array
	List<Integer> ints2 = randomInts(11, 1, 50);
	System.out.println("Input:\t" + ints2);
	s.sort(ints2);
	System.out.println("Sort:\t" + ints2);
	System.out.println("");*/
    }
}
