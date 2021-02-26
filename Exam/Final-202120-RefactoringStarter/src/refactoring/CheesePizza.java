package refactoring;

public class CheesePizza extends Pizza {

	// -----------------------------------------------------------

	public CheesePizza() {
		this.pizzaName = "Cheese";
	} // CheesePizza

	public void prepare() {
		System.out.println("Preparing pizza: " + this.pizzaName);
		this.toppingsList.add("thin crust");
		this.toppingsList.add("red sauce");
		this.toppingsList.add("3 types of cheeses");
	}
} // end class
