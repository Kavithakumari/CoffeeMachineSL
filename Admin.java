package org.cm.main;

public class Admin extends Customer {

	public void resetMachine() {
		CoffeeMachine.ResetMachine();
	}

	public void startMachine() {
		CoffeeMachine.StartMachine();
	}

	public void stopMachine() {
		CoffeeMachine.StopMachine();
	}

	public void refillMachine(DrinkCategory nameOfDrink, Integer capacity) {
		CoffeeMachine.refillMachine(nameOfDrink, capacity);
	}

}
