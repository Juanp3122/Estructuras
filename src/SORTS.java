import java.util.Arrays;

public class SORTS {
	public static void main(String[] args) {

		int []a= new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i]=(int) (Math.random() * 30) + 1;

		}
		System.out.println(Arrays.toString(a));
		quickSort(a);
		//		for (int w = 0; w <= 30; w++) {
		//			long startTime=System.nanoTime();
		//			mergeSort(a);
		//			long endTime=System.nanoTime();
		//			long duration=endTime-startTime;
		//			 
		//			
		//			System.out.println(duration);
		//		}
	}
	public  static int[] bubbleSort(int []a) {
		int temp;
		boolean swapped=false;
		do {
			swapped=false;
			for (int i = 0; i < a.length-1; i++) {
				if(a[i]>a[i+1]) {
					temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
					swapped=true;
				}
			}
		} while (swapped);
		return a;	
	}
	public static int[] insertionSort(int []a) {
		int temp,index;
		for (int i = 1; i < a.length; i++) {
			index=i; temp =a[i];
			while(index > 0 && temp < a[index -1]) {
				a[index]=a[index-1];
				index-=1;
			}
			a[index]=temp;
		}
		return a;
	}
	private static void printArray(int[] array) {

		for(int i: array) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	// Breaks down the array to single or null elements in array.
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

	// Merges the left and right array in ascending order.
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
	public  static  int[] quickSort(int []a){

		if(a.length<2) {

			return a;
		}
		int[]array_1=new int[a.length-1];
		int[] array_2=new int [a.length-1];
		int index_1=0;
		int index_2=0;

		for (int i = 1; i < a.length; i++) {
			if(a[0]>a[i]) {
				index_1++;
				array_1[index_1-1]=a[i];

			}
			if(a[0]<a[i]) {
				index_2++;
				array_2[index_2-1]=a[i];

			}

		}
		array_1[index_1]=a[0];
		int[]res1=new int[index_1+1];
		int[]res2=new int[index_2];
		for (int i = 0; i < res1.length; i++) {
			res1[i]=array_1[i];
		}
		for (int i = 0; i < res2.length; i++) {
			res2[i]=array_2[i];
		}

		System.out.println(Arrays.toString(quickSort(res1))
				+Arrays.toString(quickSort(res2)));
		


		return a;





	}
}