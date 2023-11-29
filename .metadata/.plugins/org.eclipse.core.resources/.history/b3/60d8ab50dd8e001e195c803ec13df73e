package com.robert.devoop3;

public class BackEndDev extends Developer {
	public boolean isLogical;

	public BackEndDev() {
		super("Anonymous", 25, 100000.0);

		this.isLogical = true;
	}
	
	public void displayStatus() {
		super.displayStatus();
		System.out.println("isLogical: " + this.isLogical);
	}
	
	public void giveRaise(double amount) {
		double totalSalary = this.getSalary() + amount;
		this.setSalary(totalSalary);
	}
	


}
