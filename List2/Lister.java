import java.io.*;
import java.util.*;

//BEN ROTHMAN
//HE'S IN APC2 PERIOD 8
//ITS A HOMEWORK NUMBER 17 OR 18 - I THINK 18 THIS TIME
//DON'T FORGET THE DATE - THE 2ND OF SPRING

/*
  “Why was all laid to burnination, and what does this reveal about the current state of society?”


  One must remember our forefathers fight for independence against the mighty Yorak's in 205 E.F. Those brave men and women gave their lives for our freedom, and now it comes time for us to do  the same. We must march on men. For Meroh, we must march on. 
*/


class LLNode {

    private int size;
    private Object value;
    private LLNode linkage;

    public LLNode() {

	size = 1;
	value = null;
	linkage = null;
    }

    public LLNode (Object s, LLNode node) {
	size = 2;
	value = s;
	linkage = node; 

    }

    public LLNode (Object s) {
	size = 1;
	value = s;
	linkage = null;
    }

    public void setLinkage (LLNode node) {
	linkage = node;
    }

    public LLNode getLinkage() {
	return linkage;
    }

    public void setValue (Object s) {
	value = s;
    }

    public String getValue() {
	return value;
    }

    public void setSize(int i) {
	size = i;
    }

    public int getSize () {
	return size;
    }

}

class LList implements List {
    private LLNode linker;

    public boolean add( Object x ) {
	LLNode tmpNode = new LLNode (x, linker);
	linker = tmpNode;
	linker.setSize (linker.getSize () + 1);
	return true;
    } 

    public void add (int i, Object s) {
	int count = i;
	LLNode tmpNode = linker;

	if (count < 0 || count >= linker.getSize()) {
	    throw new IndexOutOfBoundsException();
	}

	if (count == 0) {
	    add(s);
	}

	else {


	while (count > 1) {
	    
	    tmpNode=tmpNode.getLinkage();
	    count = count - 1;
	}
	 
	LLNode tmpNode2 = new LLNode(s, tmpNode.getLinkage());
	LLNode tmpNode3 = tmpNode.getLinkage();
	  tmpNode3 = tmpNode2; 

	//tmpNode.getLinkage() = tmpNode2; this doesn't work, but preceding code does. Why?????????????????????

       	linker.setSize (linker.getSize () + 1); //works because of java pointers
	}
    }

    public Object remove (int i) {
        int count = i;
	LLNode tmpNode = linker;

	if (count < 0 || count >= linker.getSize()) {
	    throw new IndexOutOfBoundsException();
	}

	if (count == 0) {
	    Object tmpObject = linker.getValue();
	    linker = linker.getLinkage();
	    return tmpObject;
	}


	while (count > 1) {
	    tmpNode = tmpNode.getLinkage();
	    count = count - 1;
	}

	String retObject = tmpNode.getLinkage().getValue();
	tmpNode.setLinkage(tmpNode.getLinkage().getLinkage());

	linker.setSize (linker.getSize() - 1);
	return retObject;
    }


    public Object get( int i ) { 
	int count = i;
	LLNode tmpNode = linker;

	while (count > 0) {
	    if (tmpNode.getLinkage() == null) {
		return null; //in case not in linked list
	    }

	    tmpNode = tmpNode.getLinkage();
	    count = count -1;
	}

	return tmpNode.getValue();
    } 

    public Object set(int i, Object x ) { 

	int count = i;
	LLNode tmpNode = linker;

	while (count > 0) {
	    if (tmpNode.getLinkage() ==null) {
		return null;
	    }

	    tmpNode = tmpNode.getLinkage();
	    count = count - 1;
	}
	
	Object temp = tmpNode.getValue();
	tmpNode.setValue (x);
	return temp;

    } 

    public int size() { 
	/*	int count = 1;
		LLNode tmpNode = linker;
		while (tmpNode.getLinkage()!= null) {
		count = count + 1;
		tmpNode = tmpNode.getLinkage();
		}

		return count;*/
	return linker.getSize();
	    
    } 

}






public class Lister {

    public static void main (String[] args) {

	//Hi These are test cases - Use your imaginationnnnnnn. 
    }
}
