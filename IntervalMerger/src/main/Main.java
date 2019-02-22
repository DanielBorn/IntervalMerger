package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import data.Interval;
import merger.Merger;

public class Main {
	
	public static List<Interval> generateExample(){
		List<Interval> listToMerge = new LinkedList<>();
		try {
			listToMerge.add(new Interval(25, 30));
			listToMerge.add(new Interval(2, 19));
			listToMerge.add(new Interval(14, 23));
			listToMerge.add(new Interval(4, 8));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listToMerge;
	}
	
	public static List<Interval> generateRandom(int listSize, int leftBoundLimit, int maxIntervalSize) {
		Random rand = new Random();
		List<Interval> listToMerge = new LinkedList<>();
		
		for(int i = 0; i < listSize; ++i) {
			//Obtain numbers between [0 - limit].
			int n1 = rand.nextInt(leftBoundLimit);
			int n2 = rand.nextInt(maxIntervalSize);
			
			try {
				listToMerge.add(new Interval(n1, n1 + n2));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listToMerge;
	}
	
	public static void printList(List<?> list) {
		list.stream().forEach((element) -> {
			System.out.print(element + " ");
		});
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		List<Interval> listToMerge = generateExample();
		//List<Interval> listToMerge = generateRandom(10, 100, 8);		//Some more testing data
		
		System.out.println("List to merge:");
		printList(listToMerge);
		
		Merger merger = new Merger();
		List<Interval> mergedList = merger.merge(listToMerge);
		
		System.out.println("Merged list:");
		printList(mergedList);
	}

}
