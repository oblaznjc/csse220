package refactoring;

import java.util.ArrayList;

public abstract class Pizza {
	protected String pizzaName;
	protected ArrayList<String> toppingsList = new ArrayList<String>();

	// -----------------------------------------------------------

	public void bake() {
		System.out.println("Baking pizza: Pepperoni");
	} // bake

	public void cut() {
		System.out.println("Cutting pizza: Pepperoni");
	} // cut

	public void box() {
		System.out.println("Boxing pizza: Pepperoni");
	} // box

	public abstract void prepare(); // prepare

	public void order() {
		this.prepare();
		this.bake();
		this.cut();
		this.box();
	} // order

	public String getPizzaName() {
		return pizzaName;
	} // getPizzaName

} // end class
