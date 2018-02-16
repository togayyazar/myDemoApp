package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	App obj=new App();
	public void testMethodShouldNotRunWithNullArrays() {
		  try
		  {
			  obj.bothContain(null, null, 8,false);
		  }
		  catch(RuntimeException e )
		  {
		    String msg = "Arrays must not be null.";
		    assertEquals(msg, e.getMessage());
		  }
	}

	public void testLengthOfBothArraysIsZeroandDoNotAddTheValueToTheArrays() {
		Integer[] arr1=new Integer[0];
		ArrayList<Integer> arr2=new ArrayList<>();
		assertFalse(obj.bothContain(arr1, arr2, 5, false));
	}

	public void testLengthOfBothArrayIsZeroAndAddValueToTheArrays() {
		Integer[] arr1=new Integer[0];
		ArrayList<Integer> arr2=new ArrayList<>();
		assertFalse(obj.bothContain(arr1, arr2, 5, true));
	}

	public void testIntegerArrayDoesNotContainValueandTheValueIsNotGoingToBeAdded() {
		Integer[] arr1= {1,5,7,null};
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(1);
		arr2.add(13);
		arr2.add(9);
		assertFalse(obj.bothContain(arr1, arr2, 13, false));
	}

	public void testIntegerArrayDoesNotContainValueandTheValueIsGoingToBeAddedToIntegerArray() {
		Integer[] arr1= new Integer[2];
		arr1[0]=5;
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(1);
		arr2.add(13);
		arr2.add(9);
		assertFalse(obj.bothContain(arr1, arr2, 13, true));
	}

	public void testIntegerArrayDoesNotContainValueandHasNoEmptyIndexAlsoAddingOperationIsAllowedandTheValueIsNotGoingToBeAddedtoIntegerArray() {
		Integer[] arr1= new Integer[2];
		arr1[0]=1;
		arr1[1]=2;
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(1);
		arr2.add(13);
		arr2.add(9);
		assertFalse(obj.bothContain(arr1, arr2, 13, true));
	}

	public void testArrayListDoesNotContainValueandAddingOperationIsNotAllowedsoTheValueIsNotGoingToBeAddedToArrayList() {
		Integer[] arr1= new Integer[2];
		arr1[0]=1;
		arr1[1]=2;
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(1);

		assertFalse(obj.bothContain(arr1, arr2, 2, false));
	}
	

	public void testArrayListDoesNotContainValueandAddingOperationIsAllowedsoTheValueIsGoingToBeAddedToArrayList() {
		Integer[] arr1= new Integer[2];
		arr1[0]=1;
		arr1[1]=2;
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(1);

		assertFalse(obj.bothContain(arr1, arr2, 2, true));
	}

	public void testBothTwoArraysDoNotContainTheValueAddOperationIsNotAllowed() {
		Integer[] arr1= new Integer[2];
		arr1[0]=1;
		arr1[1]=2;
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(1);

		assertFalse(obj.bothContain(arr1, arr2, 3, false));
	}

	public void testBothTwoArraysDoNotContainTheValueAddOperationIsAllowed() {
		Integer[] arr1= new Integer[2];
		arr1[0]=1;
		arr1[1]=2;
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(1);

		assertFalse(obj.bothContain(arr1, arr2, 3, true));
	}

	public void testBothTwoArraysContainTheValueReturnsTrue() {
		Integer[] arr1= new Integer[2];
		arr1[0]=1;
		arr1[1]=2;
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(1);
		assertTrue(obj.bothContain(arr1, arr2, 1, false));
	}
}
