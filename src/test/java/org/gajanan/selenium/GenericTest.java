package org.gajanan.selenium;

public class GenericTest {

	/*@SuppressWarnings("unchecked")
	public static <T> T getProperty(Class<T> type) {
		Integer i = 10;
		Double f = 10.245; 
		
		if(type.equals(String.class)){
			return (T)"Hello";
		}else if(type.equals(Integer.class)){
			return (T)i;
		}
		else if(type.equals(Double.class)){
			return (T)f;
		}
		return null;
	}
	
	public static void main(String[] args) {

		System.out.println("String is " + getProperty(String.class) );
		System.out.println("Integer is " + getProperty(Integer.class) );
		System.out.println("Double is " + getProperty(Double.class) );
	
	}*/

	
	public static <E> void printArray(E[] array){
		for (E element: array) {
			System.out.println("ELement is " + element);
		}
	}

	public static void main(String[] args) {
		Integer[] intArray = {1,2,3,4,5};
		Double[] doubleArray = {1.23, 23.5, 343.5, 253.35};
		String[] stringArray = {"John", "Bob", "Mike"};
		
		System.out.println("Printing int array: ");
		printArray(intArray);
		
		System.out.println("Printing double array: ");
		printArray(doubleArray);
		
		System.out.println("Printing String array: ");
		printArray(stringArray);
		
 	}
}
