/*
 * Author: Jacob Hilliker
 * Class ID: 364
 * Assignment #2
 * Description: A class containing simple list operations such as adding, removing, and searching for elements.
 */

package cse360assign2;
import java.util.Arrays;

/**
 * Allows for manipulation of ten-integer arrays through adding/removing elements, searching for elements,
 * returning the number of elements in the array, and converting the array's contents to a String.
 */
public class SimpleList {

	private int[] list;
	private int count;
	private int size;
	
	/**
	 * Class constructor which takes no parameters. Initializes a ten-integer array and sets count of array elements to 0.
	 */
	public SimpleList() {
		
		list = new int[10];
		count = 0;
		size = list.length;
		
	}
	
	/**
	 * Adds the parameter into the first index of the array, shifting back any other elements if necessary. The array will grow
	 * by 50% if it is full to accommodate new integers. The array's <code>count</code> variable is updated accordingly.
	 * @param newInteger the integer to be added
	 */
	public void add(int newInteger) {
		
		int index;
		
		// Avoids ArrayIndexOutOfBoundsException
		if (count >= size) {
			
			list = Arrays.copyOf(list, size * 3 / 2); // Increases size by 50%
			size = list.length;
			
		}
			
		index = count;
		
		while (index > 0) {
			
			list[index] = list[index - 1];
			index--;
			
		}
		
		list[0] = newInteger;
		count++;		
		
	}
	
	/**
	 * Removes the first occurrence of the parameter from the array if it is present, 
	 * shifting elements and adjusting <code>count</code> as necessary. If the array is left
	 * more than 25% empty as a result, the array will shrink to fit <code>count</code>.
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
		
		// Cuts off empty spaces if array is more than 25% empty
		if (count < size * 3 / 4 && count > 0) {
			
			list = Arrays.copyOf(list, count);
			size = list.length;
			
		}
		
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
	
	/**
	 * Adds the desired integer to the end of the list, increasing the size of the array by 50% if
	 * the array is already full.
	 * @param newInteger the integer to be added
	 */
	public void append(int newInteger) {
		
		if (count == size) {
			
			list = Arrays.copyOf(list, size * 3 / 2);
			size = list.length;
			
		}
		
		list[count] = newInteger;
		count++;
		
	}
	
	/**
	 * Returns the first element of the list. If the list is empty, return -1
	 * @return the first element of the list if it is present, otherwise -1
	 */
	public int first() {
		
		int first;
		
		if (count > 0)
			first = list[0];
		else
			first = -1;
		
		return first;
		
	}
	
	/**
	 * Returns the last element of the list. If the list is empty, return -1
	 * @return the last element of the list if it is present, otherwise -1
	 */
	public int last() {
		
		int last;
		
		if (count > 0)
			last = list[count - 1];
		else
			last = -1;
		
		return last;
		
	}
	
	/**
	 * Returns the size of the array, including empty indices
	 * @return the size of the array
	 */
	public int size() {
		
		return size;
		
	}
	
}
