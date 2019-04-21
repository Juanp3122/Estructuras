package StringsProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Height {

	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	       try {
	    	   String s= br.readLine();
	    	   int cases= Integer.parseInt(s);
	    	   for (int i = 0; i < cases; i++) {
				int lenght= Integer.parseInt(br.readLine());
				String []input= new String[lenght];
				input=br.readLine().split(" ");
				int[] intInput=new int[lenght];
				for (int j = 0; j < intInput.length; j++) {
					intInput[j]=Integer.parseInt(input[j]);
					
				}
				int []res= mergeSort(intInput);
				for (int j = 0; j < intInput.length; j++) {
					bw.write(res[j]+" ");
					bw.flush();
				}
				bw.write("\n");
				
				
			}
	    	   
	    	   
	    	   
			
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static int[] mergeSort(int[] array) {

		// Recursive control 'if' statement.
		if(array.length <= 1) {

			return array;

		}

		int midpoint = array.length / 2;

		// Declare and initialize left and right arrays.
		int[] left = new int[midpoint];
		int[] right;

		if(array.length % 2 == 0) { // if array.length is an even number.

			right = new int[midpoint];

		} else {

			right = new int[midpoint + 1];

		}

		// Populate the left and right arrays.
		for(int i=0; i < midpoint; i++) {

			left[i] = array[i];

		}

		for(int j=0; j < right.length; j++) {

			right[j] = array[midpoint+j];

		}

		int[] result = new int[array.length];

		// Recursive call for left and right arrays.
		left = mergeSort(left);
		right = mergeSort(right);

		// Get the merged left and right arrays.
		result = merge(left, right);

		// Return the sorted merged array.
		return result;

	}
	private static int[] merge(int[] left, int[] right) {

		// Merged result array.
		int[] result = new int[left.length + right.length];

		// Declare and initialize pointers for all arrays.
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;

		// While there are items in either array...
		while(leftPointer < left.length || rightPointer < right.length) {

			// If there are items in BOTH arrays...
			if(leftPointer < left.length && rightPointer < right.length) {

				// If left item is less than right item...
				if(left[leftPointer] < right[rightPointer]) {

					result[resultPointer++] = left[leftPointer++];

				} else {

					result[resultPointer++] = right[rightPointer++];

				}

			}

			// If there are only items in the left array...
			else if(leftPointer < left.length) {

				result[resultPointer++] = left[leftPointer++];

			}

			// If there are only items in the right array...
			else if(rightPointer < right.length) {

				result[resultPointer++] = right[rightPointer++];

			}

		}

		return result;

	}
}
