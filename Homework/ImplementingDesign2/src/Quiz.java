import java.util.ArrayList;

/**
 * 
 * @author oblaznjc <br>
 *         Purpose: Used to hold quiz information (id, questionList) <br>
 *         Restrictions: None <br>
 *         For Example: <br>
 *         Quiz quiz1 = new Quiz(1);
 */

public class Quiz {

	private int quizId;
	private ArrayList<Question> questionList = new ArrayList<Question>();

	/**
	 * ensures: initializes quiz with id to id
	 * 
	 * @param id used to initial the quiz's id <br>
	 *           requires: id;
	 */
	public Quiz(int id) {
		this.quizId = id;
	} // Quiz

	/**
	 * ensures: it adds the question to the questionList
	 * 
	 * @param question the question to be added to the quiz's questionList<br>
	 *                 requires: question;
	 */
	public void addQuestion(Question question) {
		this.questionList.add(question);
	} // addQuestion

	/**
	 * ensures: it displays each Question #: label followed the corresponding
	 * question prompt using a recursive method
	 * 
	 * For Example: <br>
	 * Question 1: "oblaznjc is the author's name" <br>
	 * Question 2: "Jacob is the author's name" <br>
	 * 
	 * @param numQuestion the number of questions in this quiz's questionList minus
	 *                    one <br>
	 *                    requires: numQuestion &gt; 0
	 * 
	 * @return the following label "Question #:" starting a 1 and incrementing up
	 *         followed by the question prompt in same order that questions were
	 *         added to the quiz's questionList
	 */
	public String display() {
		return displayHelper(this.questionList.size() - 1);

	} // display

	public String displayHelper(int numQuestion) {
		if (numQuestion < 1) {
			return " Question " + (numQuestion + 1) + ": " + questionList.get(numQuestion).getPrompt();
		}
		return this.displayHelper(numQuestion - 1) + "\n Question " + (numQuestion + 1) + ": "
				+ questionList.get(numQuestion).getPrompt();
	}

	/**
	 * ensures: that the current questionList is returned
	 * 
	 * @return the list of questions in this quiz
	 */
	public ArrayList<Question> getQuestionList() {
		return questionList;
	} // getQuestionList
} // end Quiz
