package org.cm.main;

public class ExecuteCoffeeMachine {
	public static void main(String[] args) {

		System.out.println("Coffee Machine Project- Begin");
		System.out.println("=============================");

		Admin admin1 = new Admin();
		Customer customer1 = new Customer();

		// System.out.println("=========ADMIN1 -START=========");
		System.out.println("");
		admin1.resetMachine();
		admin1.stopMachine();
		admin1.refillMachine(DrinkCategory.COFFEE, 5);
		admin1.refillMachine(DrinkCategory.MILK, 3);
		admin1.refillMachine(DrinkCategory.WATER, 2);
		admin1.startMachine();

		System.out.println("=========ADMIN1 -END=========");
		System.out.println("");

		System.out.println("=========CUSTOMER1 -START=========");
		System.out.println("");

		customer1.getDrink(DrinkCategory.COFFEE);
		customer1.getDrink(DrinkCategory.MILK);
		customer1.getDrink(DrinkCategory.WATER);

		System.out.println("=========CUSTOMER1 -END=========");
		System.out.println("");

		System.out.println("=============================");
		System.out.println("Coffee Machine Project- End");

	}
}
