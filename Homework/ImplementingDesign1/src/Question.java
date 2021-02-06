/**
  * 
 * This class is used to demonstrate a Question which can be constructed and updated
 */
public class Question {
	
	private int questionId;
	private String questionData;
	
	public Question(int questionId, String questionData) {
		this.questionId = questionId;
		this.questionData = questionData;
	}
	public String getQuestionData() {
		return questionData;
	}
	
	public void updateQuestionData(String updatedQuestionData) {
		this.questionData = updatedQuestionData;
	}
}
