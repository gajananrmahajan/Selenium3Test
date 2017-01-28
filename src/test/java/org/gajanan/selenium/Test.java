package org.gajanan.selenium;


public class Test {
	
	public static final String CONST = "John";
	
/*	public static void getNames(String...names){
		for (String name : names) {
			System.out.println("Name is :" + name);
		}
	}*/

	public static void getNames(CharSequence... names){
		for (CharSequence name : names) {
			System.out.println("New Name is :" + name);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Test.CONST);
		
		getNames("John", "Bob", "Mike");
		
		//Test.CONST = "Bob";

	}

}
