package MapProblems;

import java.util.ArrayList;
import java.util.HashMap;

public class MapProblems {
	
	/**
	 * findCities
	 * 
	 * ensures: that an ArrayList of city names are returned where each city in the ArrayList has a 
	 *          population >= minPopulation, and cityNameToPopulationMap is not to be modified
	 * 
	 * @param cityNameToPopulationMap - a map that contains mappings from a city name to the city's population (see example below)
	 * @param minPopulation - the minimum population for a city to have in order to be added to the ArrayList
	 * @return - an ArrayList of city names
	 * 
	 * Example:
	 * 
	 * incoming values:
	 *    HashMap<String, Integer> myMap = {
	 *    	Beijing=20463, 
	 *    	Nairobi=4735, 
	 *    	Chicago=8865, 
	 *    	Los Angeles=12447,
	 *    	Buenos Aires=15057, 
	 *    	Mumbai=20411, 
	 *    	Riyadh=7231}
	 *    int myPop = 15000
	 *
	 *   ArrayList<String> result = findCities(myMap, myPop);   // Example call
	 *   
	 * outgoing values:
	 *    myMap is unchanged
	 *    myPop is unchanged
	 *    result = [Beijing, Buenos Aires, Mumbai]
	 */
	public static ArrayList<String> findCities(HashMap<String, Integer> cityNameToPopulationMap, int minPopulation) {
		// TODO: finish me
		ArrayList<String> result = new ArrayList<String>();
		for(String city : cityNameToPopulationMap.keySet()) {
			if(cityNameToPopulationMap.get(city) >= minPopulation) {
				result.add(city);
			}
		}
		return result;
	} // findCities
	

	// *********************************************************************************************
	
	
	/**
	 * updateGPA
	 * 
	 * ensures: for each key k found in studentIds the mapping found in studentIdToGPAMap that corresponds 
	 *          to k will have its value increased by 0.5 and studentIds is not to be modified
	 * 
	 * @param studentIdToGPAMap - a map that contains mappings from a student's ID to the student's GPA (see example below)
	 * @param studentIds - an ArrayList of student IDs
	 * 
	 * requires: all keys in studentIds can be found in studentIdToGPAMap
	 * 
	 * 
	 * Example:
	 * 
	 * incoming values:
	 *    HashMap<Integer, Double> myMap = {6658=4.0, 1287=1.0, 6584=2.1, 5242=2.3, 2476=1.1, 8046=3.8, 1230=0.75}
	 *    ArrayList<Integer> myKeys = [6658, 1230]
	 *    
	 *    updateGPA(myMap, myKeys);   // Example call
	 *    
	 * outgoing values:
	 *    myMap = {6658=4.5, 1287=1.0, 6584=2.1, 5242=2.3, 2476=1.1, 8046=3.8, 1230=1.25}
	 *    myKeys = is unchanged
	 *    
	 * Note: some GPAs might end up being > 4.0, this is not a problem
	 *    
	 */
	public static void updateGPA(HashMap<Integer, Double> studentIdToGPAMap, ArrayList<Integer> studentIds) {		
		// TODO: finish me	
		
		//System.out.println("Before: " + studentIdToGPAMap);
		for(int student: studentIds) {
		studentIdToGPAMap.replace(student, studentIdToGPAMap.get(student) + .5);
		}
		//System.out.println("After: " + studentIdToGPAMap);


	} // updateGPA

}
