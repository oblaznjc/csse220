package refactoring;

public class ClamPizza extends Pizza {
	// -----------------------------------------------------------

	public ClamPizza() {
		this.pizzaName = "Clam";
	} // ClamPizza

	public void prepare() {
		System.out.println("Preparing pizza: " + this.pizzaName);
		this.toppingsList.add("traditional crust");
		this.toppingsList.add("red sauce");
		this.toppingsList.add("cheese");
		this.toppingsList.add("clams");
	} // prepare
} // end class
