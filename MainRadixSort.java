package p_03;

import java.util.Arrays;
import java.util.LinkedList;

public class MainRadixSort {

	public static void main(String[] args) {
		Radix_Sort radixAlg = new Radix_Sort();
		LinkedList<Integer> arr = new LinkedList<Integer>(Arrays.asList
				(1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713, 10, 0));
		
		int maxDigits = radixAlg.findMaxDigits(arr);
		System.out.println("initial array: " + arr + "\n");
		
		for (int i = 0; i < maxDigits; i++) {
			arr = radixAlg.sortNums(arr);
			System.out.println(i + 1 + " digit from last\npresorted array: " + arr);
			System.out.println("final array: " + radixAlg.getFinalArr());
			System.out.println();
		}
		
		radixAlg.getFinalArr().addAll(arr);
		System.out.println("result: " + radixAlg.getFinalArr());

	}

}
