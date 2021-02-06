import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * @author oblaznjc <br>
 *         Purpose: Used to hold QuizTest information (id, searchString) <br>
 *         Restrictions: None <br>
 *         For Example: <br>
 *         QuizTest quizTest1 = new QuizTest( 1, "oblaznjc" );
 * 
 */
public class QuizTest {

	private int id;
	private String searchString;

	/**
	 * ensures: initializes this quiz test's id to id and searchString to the
	 * searchString
	 * 
	 * @param id           used to initialize the quiz test's id<br>
	 *                     requires: id;
	 * @param searchString used to initialize the quiz test's search String
	 *                     requires: searchString;
	 */

	public QuizTest(int id, String searchString) {
		this.id = id;
		this.searchString = searchString;
	} // QuizTest

	/**
	 * ensures: it tests the provided quiz with this quiz test by answering each
	 * question in a quiz and returning the grade
	 * 
	 * @param quiz the quiz to be tested<br>
	 *             requires quiz;
	 * @return the grade the quiz test earned
	 */
	public double testQuiz(Quiz quiz) {
		// System.out.println("Testing quiz: " + quiz + "\n" +
		// quiz.display() + "\nwith QuizTester: " + id
		// + " SearchString: " + searchString);
		double score = 0;
		for (Question question : quiz.getQuestionList()) {
			boolean guess = question.getPrompt().contains(searchString);
			if (question.isAnswer() == guess) {
				++score;
			}
		}
		// System.out.println("Completed testing quiz: " + quiz + "\nFinal Score: " +
		// score + " / " + quiz.getQuestionList().size() + " AKA: " + (score /
		// quiz.getQuestionList().size()) );
		return score / quiz.getQuestionList().size();
	} // testQuiz

	/**
	 * ensures: it tests each quiz in the quizMap using this quiz test by answering
	 * each question in each quiz and returning the overall average grade
	 * 
	 * @param quizMap the hash map containing each quiz created in the
	 *                QuizSimulatorMain class <br>
	 *                requires: quizMap;
	 * @return the average of each grade received for testing each quiz
	 */
	public double testAllQuizzes(HashMap<Integer, Quiz> quizMap) {
		double overallScore = 0;
		for (Quiz quiz : quizMap.values()) {
			overallScore += this.testQuiz(quiz);
		}
		return overallScore / quizMap.size();
	} // testAllQuizzes
}// end QuizTest
