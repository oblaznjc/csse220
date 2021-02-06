import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * This class is used to demonstrate a Quiz which can be constructed, updated, and displayed
 *
 * 
 */
public class Quiz {
	
	private ArrayList<Integer> questionList = new ArrayList<Integer>();
	private int quizId;

	public Quiz(int quizId) {
		this.quizId = quizId;
	}
	
	public void UpdateQuiz(int questionId) {
		this.questionList.add(questionId);
	}
	
	public void DisplayQuiz(HashMap<Integer, Question> everyQuestionList) {
		System.out.println("Quiz: " + this.quizId);
		for(int questionId : questionList) {
			System.out.printf("    Question[%d]: %s", questionId, everyQuestionList.get(questionId).getQuestionData());
			System.out.println();
		}
		
	}
	
}