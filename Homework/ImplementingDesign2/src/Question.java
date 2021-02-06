/**
 * Class: Question
 * 
 * @author oblaznjc
 * 
 *         Purpose: Used to hold question information (id, prompt, answer) <br>
 *         Restrictions: Can only be used for true/false questions <br>
 *         For Example: <br>
 *         Question question1 = new Question( 1 , true, "author is oblaznjc?");
 */
public class Question {

	private int id;
	private boolean answer;
	private String prompt;

	/**
	 * ensures: initializes question with id to id, prompt to prompt, and answer to
	 * answer
	 * 
	 * @param id     used to initialize question's Id <br>
	 *               requires: id;
	 * @param answer used to initialize the question's answer<br>
	 *               requires: answer &eq; boolean
	 * @param prompt used to initialize the question's prompt<br>
	 *               requires: prompt;
	 */

	public Question(int id, boolean answer, String prompt) {
		this.id = id;
		this.answer = answer;
		this.prompt = prompt;
	} // Question

	/**
	 * ensures: that the current answer is returned
	 * 
	 * @return the answer to the question prompt
	 */
	public boolean isAnswer() {
		return answer;
	} // isAnswer

	/**
	 * ensures: sets the answer to newAnswer
	 * 
	 * @param answer the new answer <br>
	 *               requires: newAnswer &eq; boolean
	 */
	public void setAnswer(boolean newAnswer) {
		this.answer = newAnswer;
	} // setAnswer

	/**
	 * ensures: that the current prompt is returned
	 * 
	 * @return the prompt
	 */
	public String getPrompt() {
		return prompt;
	} // getPrompt

	/**
	 * ensures: sets the prompt to newPrompt
	 * 
	 * @param newPrompt the question's new prompt<br>
	 *                  requires: newPrompt;
	 */
	public void setPrompt(String newPrompt) {
		this.prompt = newPrompt;
	} // setPrompt
} // end Question