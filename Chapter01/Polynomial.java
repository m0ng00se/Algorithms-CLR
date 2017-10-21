import java.util.ArrayList;
import java.util.List;

//! Solution for problem 2.4
public class Polynomial {

    private List<Integer> coefficients;

    //! Constructor. Coefficients are sorted in ascending order.
    public Polynomial(List<Integer> coefficients) {
	this.coefficients = coefficients;
    }

    //! Simple O(n^2) evaluation of polynomial at point 'x'.
    public Double evaluate(Double x) {
	Double result = 0.0;
	int n = this.coefficients.size();
	for (int i=0; i<n; ++i) {
	    result += this.coefficients.get(i) * exp(x, n-i-1);
	}
	return result;
    }

    //! Horner O(n) evaluation of polynomial at point 'x'.
    public Double horner(Double x) {
	Double result = 0.0;
	if (this.coefficients.size() != 0) {
	    result = new Double(this.coefficients.get(0));
	    int n = this.coefficients.size();
	    for (int i=1; i<n; ++i) {
		result = (result * x + this.coefficients.get(i));
	    }
	}
	return result;
    }

    //! Exponential function. O(n) performance.
    private static Double exp(Double base, Integer power) {
	Double result = 1.0;
	for (int i=0; i<power; ++i) {
	    result *= base;
	}
	return result;
    }

    //! Unit tests for the exponential function.
    private static void testExp(Double base, Integer power) {
	Double result = exp(base, power);
	System.out.println(base + "^" + power + " = " + result);
    }

    //! Unit test for simple evaluation.
    private static void testEvaluate(Polynomial polynomial, Double x) {
	Double result = polynomial.evaluate(x);
	System.out.println("Eval: p(" + x + ") = " + result);
    }

    //! Unit test for simple evaluation with point array.
    private static void testEvaluateWithPoints(Polynomial polynomial, List<Double> points) {
	for (int i=0; i<points.size(); ++i) {
	    testEvaluate(polynomial, points.get(i));
	}
    }

    //! Unit test for Horner evaluation.
    private static void testHorner(Polynomial polynomial, Double x) {
	Double result = polynomial.horner(x);
	System.out.println("Horner: p(" + x + ") = " + result);
    }

    //! Unit test for Horner evaluation with point array.
    private static void testHornerWithPoints(Polynomial polynomial, List<Double> points) {
	for (int i=0; i<points.size(); ++i) {
	    testHorner(polynomial, points.get(i));
	}
    }
    
    public static void main(String[] args) {
	System.out.println("");
	System.out.println("Exp function");
	System.out.println("------------");
	testExp(0.0, 0);
	testExp(0.0, 1);
	testExp(0.0, 2);
	testExp(1.0, 0);
	testExp(1.0, 1);
	testExp(1.0, 2);
       	testExp(2.0, 3);
	testExp(2.1, 3);
	testExp(3.0, 4);
	testExp(3.2, 4);
	System.out.println("");

	// x^2 - 2x + 1, roots = 1, 1
	System.out.println("x^2 - 2x + 1");
	System.out.println("------------");
	List<Integer> C1 = new ArrayList<Integer>();
	C1.add(1);
	C1.add(-2);
	C1.add(1);
	Polynomial P1 = new Polynomial(C1);
	List<Double> Points1 = new ArrayList<Double>();
	Points1.add(0.0);
	Points1.add(1.0);
	Points1.add(2.0);
	testEvaluateWithPoints(P1, Points1);
	System.out.println("");
	testHornerWithPoints(P1, Points1);
	System.out.println("");
	
	// x^2 - 5x + 6; roots = 2, 3
	System.out.println("x^2 - 5x + 6");
	System.out.println("------------");
	List<Integer> C2 = new ArrayList<Integer>();
	C2.add(1);
	C2.add(-5);
	C2.add(6);
	Polynomial P2 = new Polynomial(C2);
	List<Double> Points2 = new ArrayList<Double>();
	Points2.add(0.0);
	Points2.add(1.0);
	Points2.add(2.0);
	Points2.add(2.5);
	Points2.add(3.0);
	Points2.add(4.0);
	Points2.add(5.0);
	testEvaluateWithPoints(P2, Points2);
	System.out.println("");
	testHornerWithPoints(P2, Points2);
	System.out.println("");

	// x + 3, root = -3
	System.out.println("x + 3");
	System.out.println("-----");
	List<Integer> C3 = new ArrayList<Integer>();
	C3.add(1);
	C3.add(3);
	Polynomial P3 = new Polynomial(C3);
	List<Double> Points3 = new ArrayList<Double>();
	Points3.add(-4.0);
	Points3.add(-3.0);
	Points3.add(-2.0);
	testEvaluateWithPoints(P3, Points3);
	System.out.println("");
	testHornerWithPoints(P3, Points3);
	System.out.println("");

	// 2
	System.out.println("2");
	System.out.println("-");
	List<Integer> C4 = new ArrayList<Integer>();
	C4.add(2);
	Polynomial P4 = new Polynomial(C4);
	List<Double> Points4 = new ArrayList<Double>();
	Points4.add(1.0);
	Points4.add(2.0);
	Points4.add(3.0);
	testEvaluateWithPoints(P4, Points4);
	System.out.println("");
	testHornerWithPoints(P4, Points4);
	System.out.println("");

	// Empty
	System.out.println("Empty");
	System.out.println("-----");
	List<Integer> C5 = new ArrayList<Integer>();
	Polynomial P5 = new Polynomial(C5);
	List<Double> Points5 = new ArrayList<Double>();
	Points5.add(1.0);
	Points5.add(2.0);
	Points5.add(3.0);
	testEvaluateWithPoints(P5, Points5);
	System.out.println("");
	testHornerWithPoints(P5, Points5);
	System.out.println("");
    }
}
