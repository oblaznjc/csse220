import java.util.ArrayList;


public class Student {
	private String name;
	private int absences;
	private int countAssignments;
	private ArrayList<Double> grades;
	//TODO: You'll probably need to have some more fields here
	
	/**
	 * makes a new student object
	 * 
	 * @param newName the name of the student
	 */
	public Student(String newName) {
		//TODO: initialize fields here
		this.name = newName;
		this.absences = 0;
		this.countAssignments = 0;
		this.grades = new ArrayList<Double>();
	}

	/**
	 * gets the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		return this.name;
	}
	
	public void addAbsence() {
		++absences;
	}
	
	public String getAbsences() {
		return absences+"" ;
	}
	
	public void addGrade(double score) {
		++countAssignments;
		grades.add(score);
	}
	
	public String getAverage() {
		double sum = 0;
		for(double score: grades) {
			sum = sum + score;
		}
		return (Math.round(sum / this.countAssignments)) + "";
	}
}
