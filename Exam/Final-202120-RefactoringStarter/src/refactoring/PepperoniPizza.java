package refactoring;

public class PepperoniPizza extends Pizza {

	// -----------------------------------------------------------

	public PepperoniPizza() {
		this.pizzaName = "Pepperoni";
	} // PepperoniPizza

	public void prepare() {
		System.out.println("Preparing pizza: " + this.pizzaName);
		this.toppingsList.add("traditional crust");
		this.toppingsList.add("red sauce");
		this.toppingsList.add("cheese");
		this.toppingsList.add("pepperoni");
	} // prepare
} // end class
