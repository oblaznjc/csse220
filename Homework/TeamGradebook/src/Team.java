import java.util.ArrayList;


public class Team {
	private String name;
	private ArrayList<Student> currentTeam;
	private int countAssignments;
	private ArrayList<Double> grades;
	

	public Team(String teamName, ArrayList<Student> currentTeam) {
		// TODO Auto-generated constructor stub
		this.name = teamName;
		this.currentTeam = currentTeam;
		this.countAssignments = 0;
		this.grades = new ArrayList<Double>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int size() {
		return this.currentTeam.size();
	}
	
	public Student get(int i) {
		return this.currentTeam.get(i);
	}
	
	public void addGrade(double score) {
		++countAssignments;
		grades.add(score);
	}
	
	public double getAverage() {
		double sum = 0;
		for(double score: grades) {
			sum = sum + score;
		}
		return sum / this.countAssignments;
	}
	
	
	// You'll need to add methods, constructors and fields here
	
}
