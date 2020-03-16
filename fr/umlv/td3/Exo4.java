package fr.umlv.td3;

import java.util.Arrays;

public class Exo4 {
	public static void main(String args[]) {
		int a[] = {0, 2, 99, 32, 22, -1, 4};
		System.out.println(Arrays.toString(a));	
		Exo4.swap(a, 0, 4);
		System.out.println(Arrays.toString(a));	
		int minIndex = Exo4.indexOfMin(a);
		System.out.println(minIndex);
		minSort(a);
		System.out.println(Arrays.toString(a));	
	}

	public static void swap(int a[], int index1, int index2) {
		if (index1 >= a.length || index2 >= a.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	public static int indexOfMin(int a[]) {
		return indexOfMin(a, 0, a.length);
	}
	
	public static int indexOfMin(int a[], int index1, int index2) {
		if (a.length == 0) return -1;
		if (index1 >= a.length || index2 > a.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int minIndex=index1;
		int minValue=a[index1];
		for(int i=index1+1; i<index2; ++i) {
			if(a[i] < minValue) {
				minIndex = i;
				minValue = a[i];
			}
		}
		return minIndex;

	}

	public static void minSort(int a[]) {
		for(int i=0; i<a.length; ++i)
		{
			int minIndex = indexOfMin(a, i, a.length);
			if( minIndex != i) swap(a, i, minIndex);	
		}
	}
};
