import java.io.*;
import java.util.*;

class sorter{

    private ArrayList <Integer> answer;


  

     
    public ArrayList<Integer> merge (ArrayList<Integer> A, ArrayList<Integer> B) {

	ArrayList<Integer> result = new ArrayList <Integer>();
	int sizer = A.size() + B.size();
	int a=0,b=0;
	for (int i=0; i<sizer; i++) {
	    if (a == A.size()) { //If you max out A
		result.add (B.get(b));
		b++;
	    }
	    else if (b == B.size()) { // If you max out B
		result.add(A.get(a));
		a++;
	    }
	    else if (A.get(a).compareTo( B.get(b)) == -1) {
		result.add (A.get(a));
		a++;
	    }
	    else {
		result.add(B.get(b));
		b++;
	    }
	}
	return result;
    }

    public ArrayList <Integer> sort ( ArrayList<Integer> doo) {

	answer = new ArrayList <Integer> ();

	if ( doo.length <= 1) {
	    return doo;
	}

	else {

	    int half = doo.length / 2;


	    ArrayList <Integer> a = new ArrayList <Integer> ();
	    ArrayList <Integer> b = new ArrayList <Integer> ();
	     

	    /*     else {

		   int [] a = new int [half];
		   int [] b = new int [doo.length - half];
		   }*/



	    for (int i = 0; i < half; i++) {
		a [i] = doo [i];
	    }
	     
	    for (int n = half; n < doo.length; n++) {
		b[n - half] = doo [n];
	    }


	    answer =  merge (sort (a), sort (b));
	   

	}

	return answer;
    }


    public String toString () {

	return (Arrays.toString (answer));

    }
}


public class MergeSort {

    public static void main (String [] args) {

	sorter s = new sorter ();


	ArrayList <Integer> bob = new ArrayList <Integer> ();
	Collections.addAll (bob, 3, 2,5,12,34,1);


	s.sort (bob);
	System.out.println (s);

    }

}





