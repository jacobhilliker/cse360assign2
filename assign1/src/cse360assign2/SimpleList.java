/*
 * Author: Jacob Hilliker
 * Class ID: 364
 * Assignment #2
 * Description: A class containing simple list operations such as adding, removing, and searching for elements.
 */

package cse360assign2;

/**
 * Allows for manipulation of ten-integer arrays through adding/removing elements, searching for elements,
 * returning the number of elements in the array, and converting the array's contents to a String.
 */
public class SimpleList {

	private int[] list;
	private int count;
	
	/**
	 * Class constructor which takes no parameters. Initializes a ten-integer array and sets count of array elements to 0.
	 */
	public SimpleList() {
		
		list = new int[10];
		count = 0;
		
	}
	
	/**
	 * Adds the parameter into the first index of the array, shifting back any other elements if necessary. Elements shifted
	 * past out of the array's bounds will be lost. The array's <code>count</code> variable is updated accordingly.
	 * @param newInteger the integer to be added
	 */
	public void add(int newInteger) {
		
		int index;
		
		// Avoids ArrayIndexOutOfBoundsException
		if (count >= list.length) {
			
			index = list.length - 1;
			
		} else {
			
			index = count;
			
		}
		
		while (index > 0) {
			
			list[index] = list[index - 1];
			index--;
			
		}
		
		list[0] = newInteger;
		
		if (count < list.length) {
			
			count++;
			
		}
		
	}
	
	/**
	 * Removes the first occurrence of the parameter from the array if it is present, 
	 * shifting elements and adjusting <code>count</code> as necessary.
	 * @param target the value to be removed if possible
	 */
	public void remove(int target) {
		
		int index = 0;
		
		while (index < count && list[index] != target) {
			index++;
		}
		
		if (list[index] == target) {
			
			while (index < count - 1) {
				
				list[index] = list[index + 1];
				index++;
				
			}
			
			count--;
			
		}
		
		list[count] = 0;
		
	}
	
	/**
	 * Returns the <code>count</code> variable, indicating the number of elements stored in the array, not counting initial zeros.
	 * @return the count of elements in the array
	 */
	public int count() {
		
		return count;
		
	}
	
	/**
	 * Returns the elements of the array (not including trailing zeros) as a String.
	 * @return the list as a String
	 */
	public String toString() {
		
		String listString = "";
		
		for (int index = 0; index < count; index++) {
			
			if (index == 0) {
				
				listString += list[index];
				
			} else {
				
				listString += " " + list[index];
				
			}
			
		}
		
		return listString;
	}
	
	/**
	 * Searches the list for the parameter and returns the index of its first occurrence.
	 * @param target the value desired from the array
	 * @return       the index of the parameter in the array (-1 if the element is absent)
	 */
	public int search(int target) {
		
		int returnIndex = -1;
		
		for (int searchIndex = count - 1; searchIndex >= 0; searchIndex--) {
			
			if (list[searchIndex] == target) {
				
				returnIndex = searchIndex;
				
			}
			
		}
		
		return returnIndex;
		
	}
	
	/**
	 * Returns the <code>list</code> array for use by JUnit tests, since <code>list</code> is private.
	 * @return the current list
	 */
	public int[] list() {
		
		return list;
		
	}
	
}
