package refactoring;

import java.util.ArrayList;
import java.util.List;

public class PizzaStoreDriver {

	public static void handleOrder(int numCheesePizzas, int numClamPizzas, int numPepperoniPizzas) {

		List<Pizza> Pizzas = new ArrayList<Pizza>();

		System.out.println("======================================================");
		System.out.println("==================== Making Pizzas ===================");
		System.out.println("======================================================");

		// Make Cheese pizzas
		for (int k = 0; k < numCheesePizzas; k++) {
			Pizza pizza = new CheesePizza();
			Pizzas.add(pizza);
		} // end for

		// Make Clam pizzas
		for (int k = 0; k < numClamPizzas; k++) {
			Pizza pizza = new ClamPizza();
			Pizzas.add(pizza);
		} // end for

		// Make Pepperoni pizzas
		for (int k = 0; k < numPepperoniPizzas; k++) {
			Pizza pizza = new PepperoniPizza();
			Pizzas.add(pizza);
		} // end for

		// Order pizzas
		for (Pizza pizza : Pizzas) {
			pizza.order();
		}

		System.out.println("======================================================");
		System.out.println("==================== Pizzas Made =====================");
		System.out.println("======================================================");

	}

	public static void main(String[] args) {
		int numCheeses = 2;
		int numClams = 1;
		int numPepperonis = 2;
		handleOrder(numCheeses, numClams, numPepperonis);
	}

}
