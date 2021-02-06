import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * A sample class for practicing implementing UML
 * 
 * @author yoder1
 *
 */
public class Main {

	//TODO add instance variables for class Main
	private ArrayList<A> myAsList = new ArrayList<A>();

	
	public Main() {
		
		//TODO create 5 As for Main object
		// names should be "A" "B" "C" "D" "E"
		A a1 = new A("A");
		
		this.myAsList.add(a1);
		this.myAsList.add(new A("B"));
		this.myAsList.add(new A("C"));
		this.myAsList.add(new A("D"));
		this.myAsList.add(new A("E"));

			

	}
	

	/**
	 *  Used to create
	 * 
	 * @param args Command line arguments (ignored)
	 */
	public static void main(String[] args) {
		
		Main myExample = new Main();
		myExample.setAllBValuesTo3();

	}
	
	public void setAllBValuesTo3() {
		//TODO update the values for all the Bs associated with As to be 3
		for(A a: this.myAsList) {
			System.out.println(a);
		}
		
		for(A a: this.myAsList) {
			a.setBvalue(3);
		}
	}
	
	
	
	
}
