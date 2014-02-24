public class Recursinator {

    /*******************************************************
* int fact(int n)
* @param n number whose factorial is to be computed
* precond: n >= 0
* eg: fact(5) -> 120
*******************************************************/
    public static int fact( int n ) {
		if(n>0){
	    return(n*fact(n-1));
	    }
     
		return 1;
	
    }


    /*******************************************************
* int fibRec(int n) returns nth term of Fibonacci sequence
* Uses recursion.
* @param n specifies position of term in sequence.
* precond: 0th, 1st, 2nd terms are 0,1,1
* eg: fibRec(3) -> 2
*******************************************************/
    public static int fibRec(int n) {
	if(n==0)
	    return 0;
	if(n==1)
	    return 1;
	return(fibRec(n-1)+fibRec(n-2));
    }


    /*******************************************************
* int fibIt(int n) returns nth term of Fibonacci sequence
* Uses iteratiion.
* @param n specifies position of term in sequence.
* precond: 0th, 1st, 2nd terms are 0,1,1
* eg: fibIt(3) -> 2
*******************************************************/
    public static int fibIt(int n) {
	if(n==0)
	    return 0;
	if(n==1)
	    return 1;
	int x=1;
	int[] old={0,1};
	for(int y=0;y<n;y++){
	    int temp=x;
	    x=old[0]+old[1];
	    old[0]=old[1];
	    old[1]=temp;
	}
	return x;
    }
    

    /*******************************************************
* String fenceIt(int n) builds a fence with n fenceposts
* @param n number of |'s in return String
* precond: n >= 1
* eg: fenceIt(1) -> "|"
* eg: fenceIt(2) -> "|---|"
* eg: fenceIt(3) -> "|---|---|"
*******************************************************/
    public static String fenceIt( int n ) {
	String s="|";
	for(int x=1;x<n;x++){
	    s+="---|";
	}
	return s;
    }


    /*******************************************************
* String fenceRec(int n) builds a fence with n fenceposts
* @param n number of |'s in return String
* precond: n >= 1
* eg: fenceRec(1) -> "|"
* eg: fenceRec(2) -> "|---|"
* eg: fenceRec(3) -> "|---|---|"
*******************************************************/
    public static String fenceRec( int n ) {
	if(n==1)
	    return "|";
	return(fenceRec(n-1)+"---|");
    }


    /*******************************************************
* String commafyIt(int n) returns a String representation of
* n with commas inserted where appropriate
* @param n number in need of commas
* precond: n >= 0
* eg: commafyIt(100) -> 100
* eg: commafyIt(1000) -> 1,000
* eg: commafyIt(10,000,000) -> 10,000,000
*******************************************************/
    public static String commafyIt( int n ) {
	String s="";



	while (n >= 1000) {
	    s=("," + Integer.toString(n%1000) + s);
	    n = n / 1000;
	}

       	if (n < 1000) {
	    s = Integer.toString (n) + s;
	}

	return s;
    }


    /*******************************************************
* String commafyRec(int n) returns a String representation of
* n with commas inserted where appropriate
* @param n number in need of commas
* precond: n >= 0
* eg: commafyRec(100) -> 100
* eg: commafyRec(1000) -> 1,000
* eg: commafyRec(10,000,000) -> 10,000,000
*******************************************************/
    public static String commafyRec( int n ) {
	if(n<1000){
	    return Integer.toString(n);
	}
	return(commafyRec(n / 1000) + "," + Integer.toString (n%1000));
    
    }




    public static void main( String [] args ) {

/*============================================
Main method for testing. Suggested use:
Set up a list of test cases for each function
BEFORE you begin writing each method.
Move top comment bar (----) down one line at a time
when you're ready to test each line.
============================================*/

System.out.println( "fact(0) -> " + fact(0) );
System.out.println( "fact(1) -> " + fact(1) ); 
System.out.println( "fact(2) -> " + fact(2) ); 
System.out.println( "fact(3) -> " + fact(3) ); 
System.out.println( "fact(4) -> " + fact(4) );
System.out.println( "fact(5) -> " + fact(5) ); 

System.out.println( "fibIt(0) -> " + fibIt(0) ); 
System.out.println( "fibIt(1) -> " + fibIt(1) ); 
System.out.println( "fibIt(2) -> " + fibIt(2) ); 
System.out.println( "fibIt(3) -> " + fibIt(3) ); 
System.out.println( "fibIt(4) -> " + fibIt(4) ); 
System.out.println( "fibIt(5) -> " + fibIt(5) ); 

System.out.println( "fibRec(0) -> " + fibRec(0) ); 
System.out.println( "fibRec(1) -> " + fibRec(1) ); 
System.out.println( "fibRec(2) -> " + fibRec(2) );
System.out.println( "fibRec(3) -> " + fibRec(3) );
System.out.println( "fibRec(4) -> " + fibRec(4) );
System.out.println( "fibRec(5) -> " + fibRec(5) ); 

System.out.println( "fenceRec(1) -> " + fenceRec(1) ); 
System.out.println( "fenceRec(2) -> " + fenceRec(2) ); 
System.out.println( "fenceRec(3) -> " + fenceRec(3) ); 
System.out.println( "fenceRec(4) -> " + fenceRec(4) ); 
System.out.println( "fenceRec(5) -> " + fenceRec(5) );

System.out.println( "fenceIt(1) -> " + fenceIt(1) ); 
System.out.println( "fenceIt(2) -> " + fenceIt(2) );
System.out.println( "fenceIt(3) -> " + fenceIt(3) ); 
System.out.println( "fenceIt(4) -> " + fenceIt(4) ); 
System.out.println( "fenceIt(5) -> " + fenceIt(5) ); 

System.out.println( "commafyIt(1) -> " + commafyIt(1) ); 
System.out.println( "commafyIt(10421) -> " + commafyIt(10421) ); 
System.out.println( "commafyIt(33211231) -> " + commafyIt(33211231) );
System.out.println( "commafyIt(413123123) -> " + commafyIt(413123123) ); 
System.out.println( "commafyIt(913211245) -> " + commafyIt(913211245) );

System.out.println( "commafyRec(1) -> " + commafyRec(1) );
System.out.println( "commafyRec(10421) -> " + commafyRec(10421) ); 
System.out.println( "commafyRec(33211231) -> " + commafyRec(33211231) );
System.out.println( "commafyRec(413123123) -> " + commafyRec(413123123) );
System.out.println( "commafyRec(913211245) -> " + commafyRec(913211245) );


    }//end main

}//end class 
