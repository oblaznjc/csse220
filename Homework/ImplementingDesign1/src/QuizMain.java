import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is used to demonstrate a functional design involving Quizzes and
 * Questions which can be updated and displayed
 * 
 */
public class QuizMain {

	// TODO add instance variables here
	HashMap<Integer, Question> QuestionMap = new HashMap<Integer, Question>();
	HashMap<Integer, Quiz> quizMap = new HashMap<Integer, Quiz>();

	public QuizMain() {
		// TODO In order to demonstrate functionality, please follow the TODOs below
		// You will have to create questions and quizzes when a QuizMain is created

		// TODO 1 Create five questions (can be silly/basic questions) use id 1,2,3,4,5
		// ...

		
		QuestionMap.put(1, new Question(1, "What is 1?"));
		QuestionMap.put(2, new Question(2, "What is 2?"));
		QuestionMap.put(3, new Question(3, "What is 3?"));
		QuestionMap.put(4, new Question(4, "What is 4?"));



		// TODO 2 Create three or more quizzes use id 1,2,3...
		// (One quiz should share at least one question with another )

		quizMap.put(1, new Quiz(1));
		quizMap.get(1).UpdateQuiz(1);
		quizMap.get(1).UpdateQuiz(2);
		quizMap.get(1).UpdateQuiz(3);


		quizMap.put(2, new Quiz(2));
		quizMap.get(2).UpdateQuiz(1);

		quizMap.put(3, new Quiz(3));
		quizMap.get(3).UpdateQuiz(4);


	}

	public static void main(String[] args) {
		// We want to use instance variables of the QuizMain class so we need to
		// construct a QuizMain object
		QuizMain myQuizSimulator = new QuizMain();

		// TODO 3 Display three or more different quizzes
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more original quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);

		// TODO 4 Change two quiz questions
		// A. (One should be shared with two or more quizzes)
		// B. (One should be unique to one quiz)
		myQuizSimulator.handleUpdateQuizQuestion(1, "What is different 1?");
		myQuizSimulator.handleUpdateQuizQuestion(2, "What is different 2?");

		// TODO 5 Display the same three (or more) quizzes
		// A. One that has a unique question which changed
		// B. Two which share a question that has been changed
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more changed quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);

	}

	/**
	 * This method should display a quiz in a very similar fashion to the output
	 * provided in example_output.txt, which is located in your repository
	 * 
	 * 
	 * @param quizId
	 */
	public void handleDisplayQuiz(int quizId) {
		quizMap.get(quizId).DisplayQuiz(QuestionMap);
	}

	/**
	 * 
	 * This method should replace the data in the question with id=questionId with
	 * the new questionData
	 * 
	 * @param questionId
	 * @param questionData
	 */
	public void handleUpdateQuizQuestion(int questionId, String updatedQuestionData) {
		QuestionMap.get(questionId).updateQuestionData(updatedQuestionData);
	}
}
