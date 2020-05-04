
package fr.umlv.td10.main;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
	public static void main(String args[]) {
		var list = List.of("hello", "world", "hello", "lambda");
		System.out.println(count(list, "hello"));
		System.out.println(count2(list, "hello"));

		System.out.println(upperCase(list));
		System.out.println(upperCase2(list));
		System.out.println(upperCase3(list));
		System.out.println(count3(list, "hello"));
		
		var list2 = new Random(0)
			.ints(1_000_000, 0, 100)
			.mapToObj(Integer::toString)
			.collect(Collectors.toList());

		printAndTime(() -> count(list2, "33"));
		printAndTime(() -> count2(list2, "33"));
		printAndTime(() -> count3(list2, "33"));

	}

	private static <T> long count(List<T> list, T value) {
		long i = 0;
		for(var e: list) {
			if(e.equals(value)) { ++i; } 
		}
		return i;
	}

	private static <T> long count2(List<T> list, T value) {	
		return list
			.stream()
			.filter(e -> e.equals(value))
			.count();
	}

	private static <T> long count3(List<T> list, T value) {
		return list
			.stream()
			.filter(e -> e.equals(value))
			.mapToLong(e -> 1)
			.reduce(0, (acc, i) -> acc + i);
	}

	private static List<String> upperCase(List<String> list) {
		var upper = new ArrayList<String>();
		for(var str: list) {
			upper.add(str.toUpperCase());
		}
		return upper;
	}

	private static List<String> upperCase2(List<String> list) {
		return list
			.stream()
			.map(e -> e.toUpperCase())
			.collect(Collectors.toList());
	}
	private static List<String> upperCase3(List<String> list) {
		return list
			.stream()
			.map(String::toUpperCase)
			.collect(Collectors.toList());
	}

	private static <T> void printAndTime(Supplier<T> func) {
		var start = System.nanoTime();
		var result = func.get();
		var end = System.nanoTime();
		System.out.println("result " + result);
		System.out.println(" elapsed time " + (end - start));
	}

}


