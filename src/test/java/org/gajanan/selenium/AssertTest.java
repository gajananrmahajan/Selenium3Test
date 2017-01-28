package org.gajanan.selenium;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.testng.*;

//import org.testng.Assert;


public class AssertTest {

	String firstName;
	String lastName;
	
	
	public AssertTest(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/*public boolean equals(Object obj){
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof AssertTest) {
			
		}
	}*/
	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AssertTest firstObj = new AssertTest("Bob", "Sesek");

		AssertTest secondObj = new AssertTest("Ru", "Wang");
		
		System.out.println(secondObj.firstName);
		//Assert.assertEquals(firstObj, secondObj);
		Assert.assertTrue(firstObj.equals(firstObj));
		//Assert.assertTrue(firstObj.equals(secondObj));
		
		/*Assert.assertTrue(firstObj == firstObj);
		Assert.assertTrue(firstObj == secondObj);*/
	}

}
