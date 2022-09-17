package org.cm.main;

import java.util.HashMap;

public class CoffeeMachine {

	private static int TotalCapacity = 10; // Coffee Machine Total Capacity = 10 L
	private static int CurrentCapacity = 0; // Coffee Machine Current Capacity = 0 L
	private static int EachDrinkCapacity = 1;// Each Drink-1Litre
	private static int DrinkCategoryMaxCapacity = 5; // Coffee/Milk/Water Individual Capacity=5 Liter->=1 and less=5
	private static int DrinkCategoryMinCapacity = 1; // Coffee/Milk/Water Individual Capacity=5 Liter->=1 and less=5

	private static boolean MachineStoped = false;

	private static HashMap<DrinkCategory, Integer> DrinksAvailable = new HashMap<DrinkCategory, Integer>();

	public static void ResetMachine() {
		MachineStoped = true;
		CurrentCapacity = 0;
		DrinksAvailable = new HashMap<DrinkCategory, Integer>();
		System.out.println("Coffee Machine - Reset Success.");
	}

	public static void StartMachine() {
		MachineStoped = false;
		System.out.println("Coffee Machine - Started.");
	}

	public static void StopMachine() {
		MachineStoped = true;
		System.out.println("Coffee Machine - Stopped.");
	}

	public static void refillMachine(DrinkCategory nameOfDrink, Integer capacity) {

		if (!MachineStoped) {
			System.out.println("You can only refill when machine is stopped. Cannot Refill.");
			return;
		}

		if (CurrentCapacity + capacity > TotalCapacity) {
			System.out.println("Current Capacity of Machine will be more than Total Capacity 10 L. Cannot Refill.");
			return;
		}

		if (capacity < DrinkCategoryMinCapacity) {
			System.out.println("Minimum Capacity requirement (1 L) does not meet. Cannot Refill.");
			return;
		}

		Integer currentDrinkCapacity = DrinksAvailable.get(nameOfDrink);
		if (currentDrinkCapacity == null) {
			currentDrinkCapacity = 0;
		}

		if (currentDrinkCapacity >= 1) {
			System.out.println(
					"Current Capacity of " + nameOfDrink.toString() + " is more than or equal to 1 L. Cannot Refill.");
			return;
		}

		currentDrinkCapacity += capacity;

		if (currentDrinkCapacity > DrinkCategoryMaxCapacity) {
			System.out
					.println("Maximum Capacity requirement (5 L) does not meet for the drink category. Cannot Refill.");
			return;
		} else {

			System.out.println(nameOfDrink.toString() + " Refill  #########   Started.");

			DrinksAvailable.remove(nameOfDrink);
			DrinksAvailable.put(nameOfDrink, currentDrinkCapacity);
			CurrentCapacity += capacity;

			System.out.println(nameOfDrink.toString() + " Refill  #########   Completed Success.");
			System.out.println("");
			System.out.println("=======================COFFEE MACHINE STATUS=====================");
			System.out.println(nameOfDrink.toString() + " Capacity : " + currentDrinkCapacity);
			System.out.println("Coffee Machine Current Capacity : " + CurrentCapacity);
			System.out.println("==================================================================");
			System.out.println("");
		}

	}

	public static void getDrink(DrinkCategory nameOfDrink) {

		Integer currentDrinkCapacity = DrinksAvailable.get(nameOfDrink);

		if (MachineStoped) {
			System.out.println("Please ask Admin to start machine. Cannot get requested Drink.");
			return;
		}

		if (currentDrinkCapacity == null || currentDrinkCapacity < EachDrinkCapacity) {
			System.out.println("Please ask Admin to refill machine. Cannot get requested Drink.");
			return;
		}

		currentDrinkCapacity -= EachDrinkCapacity;

		DrinksAvailable.remove(nameOfDrink);
		DrinksAvailable.put(nameOfDrink, currentDrinkCapacity);
		CurrentCapacity -= EachDrinkCapacity;

		System.out.println("Have the drink " + nameOfDrink.toString() + " " + EachDrinkCapacity + " L - Enjoy!!");
		System.out.println("");
		System.out.println("=======================COFFEE MACHINE STATUS=====================");
		System.out.println(nameOfDrink.toString() + " Remaining Capacity : " + currentDrinkCapacity);
		System.out.println("Coffee Machine Current Capacity : " + CurrentCapacity);
		System.out.println("==================================================================");
		System.out.println("");

	}

}