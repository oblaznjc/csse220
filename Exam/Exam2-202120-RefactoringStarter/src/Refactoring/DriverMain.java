package Refactoring;

import java.util.ArrayList;
import java.util.List;

/**
 * This program features laptops
 * 
 * Your job is to use inheritance with a class or inheritance with an abstract
 * class to remove as much code duplication as you can from the 3 laptop classes
 * (ChromeBook, MacBook, SurfaceBook) and the main program (below)
 * 
 * @author oblaznjc
 *
 */
public class DriverMain {

	public static void main(String[] args) {
		List<Laptop> laptops = new ArrayList<>();

		// ------------------------------------------------------------------------

		// ----------------
		// Add Laptops
		// ----------------
		laptops.add(new ChromeBook("Prof Yoder", 2.1));
		laptops.add(new MacBook("Prof Boutell", 9.8));
		laptops.add(new MacBook("Prof Wilkin", 10.0));
		laptops.add(new SurfaceBook("Prof Mohan", 5.5));

		// ------------------------------------------------------------------------

		// ----------------
		// Generate Reports
		// ----------------
		for (Laptop laptop : laptops) {
			laptop.generateOwnerReport();
		} // end for

		// ------------------------------------------------------------------------

		// ----------------
		// Generate List of All Owner Names
		// ----------------
		for (Laptop laptop : laptops) {
			System.out.println(laptop.getOwnerName());
		} // end for

	} // main

} // DriverMain