package com.mycompany.app;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	public static boolean bothContain(Integer[] arry1,ArrayList<Integer> arry2,int value,boolean addToArray) {
		/*This method checks whether given arrays contain the value.If both of them contains the value,method returns true.
		 *addToArray parameter decides that whether method adds the value to arrays which does not contain the value.
		 *If addToArray is true,value will be added to arrays that do not contain the value.
		 *If addToArray is false,method does not perform add operation,it only checks whether the value exists in arry1 and arry2.
		 *If they both contain the value,then method returns true,otherwise returns false.
		 */
		boolean arry1ContainsValue=false;
		boolean arry2ContainsValue=false;
		if(arry1==null||arry2==null) {
			throw new RuntimeException("Arrays must not be null.");
		}
		if(arry1.length==0&&arry2.size()==0) {
			if(addToArray)
				addToIntegerArray(arry1,value);
				arry2.add(value);
			return false;
		}
		
		for(int i=0;i<arry1.length;i++) {
			if(arry1[i]!=null) {
				if(i==value) {
					arry1ContainsValue=true;
					break;
				}
			}

		}
		
		for(int i:arry2) {
			if(i==value) {
				arry2ContainsValue=true;
				break;
			}
		}
		
		if(addToArray==true) {//adding operation is allowed.
			
			if(!arry1ContainsValue)
				addToIntegerArray(arry1,value);
			if(!arry2ContainsValue)
				arry2.add(value);
		}
		
		return arry1ContainsValue&&arry2ContainsValue; 
		
	}
	// if there is any empty(null) index in Integer[] array ,indexOfEmpty() returns index of the empty field,otherwise returns -1;
	private static int indexOfEmpty(Integer[] arry1) { 
		int index=-1;
		for(int i=0;i<arry1.length;i++) {
			if(arry1[i]==null) {
				index=i;
				break;
			}
		}
		return index;
	}
	private static void addToIntegerArray(Integer[] arry1,int value) {
		int index=indexOfEmpty(arry1);
			if(index!=-1) 
				arry1[index]=value;
			else
				System.out.println("Since Integer[] is full,no space to add value, adding operation could not be performed on Integer[] array.");
	}
}
