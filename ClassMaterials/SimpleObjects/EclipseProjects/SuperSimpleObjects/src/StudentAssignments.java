import java.util.HashMap;

/**
 * This class is used to track student grades
 * 
 * @author oblaznjc
 *
 */
public class StudentAssignments {

	private String name;
	private HashMap<String, Double> assignmentToGradeMap = new HashMap<String, Double>();
	private double average;

	public StudentAssignments(String name) {
		this.name = name;
	}
	
	public StudentAssignments() {
		this.name = "Jacob O";
	}

	public void addAssignment(String assignmentName, double score) {
		this.assignmentToGradeMap.put(assignmentName, score);
	}
	
	public double computeAverage() {
		double sum = 0;
		double count = 0;
		for( double score: assignmentToGradeMap.values()) {
			++count;
			sum = sum + score;
		}		
		this.average = sum / count;
		return this.average;
	}

	public void printGradeReport() {
		System.out.println(this.name + " ");
		System.out.printf("Average: %.2f", this.computeAverage());
		System.out.println(); // Next Line
		for (String key : this.assignmentToGradeMap.keySet()) {
			System.out.println(key + " - " + this.assignmentToGradeMap.get(key));
		}
	}

}
