package com.robert.interfacedemo;

public class Cat extends Pet implements Keepable{

	public Cat() {}
	
	public Cat(String name) {
		super(name,"cat");
	}

	@Override
	public void showAffection() {
		System.out.println("Scratch, sleeps");
		
	}

	@Override
	public void askForFood() {
		System.out.println("Meow, Rubs on to show you hungry, purr , hiss");
		
	}

}
