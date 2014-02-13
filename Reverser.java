//This runs in N time - linear. It goes through the each of the String's characters once using the for loop. It vaires linearly with the length of the String. 

public class Reverser {
    public static void main (String [] args){
	String s=args [0];
	String answer=reverse (s);
	System.out.println (answer);
    }

    public static String reverse (String s){
	String temp = "";
	for (int i=s.length()-1; i>=0; i--){
	    temp=temp+s.substring(i,i+1);
	}
	return temp;
    }
}

