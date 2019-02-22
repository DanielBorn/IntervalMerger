package merger;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import data.Interval;

public class Merger {
	
	/**
	 * This function merges the intervals in the given list and returns the merged list
	 * 
	 * The list is firstly sorted ascending by the left bound.
	 * For each interval in the given list it is then checked 
	 * if it is overlapping with one of the intervals in the working (current) list.
	 * If so, both intervals are merged in place.
	 * The working list is then returned.
	 */
	public List<Interval> merge(List<Interval> mergeList) {
		if(mergeList == null)
			return new LinkedList<Interval>();
		
		LinkedList<Interval> currentList = new LinkedList<>();
		
		mergeList.sort(Comparator.comparing(Interval::getLeftBound));
		
		mergeList.forEach((interval) -> {
			if(currentList.isEmpty()) {
				currentList.add(interval);
				return;
			}
			
			for (Interval currentListInterval : currentList) {
				if(interval.isOverlapping(currentListInterval)) {
					//System.out.println("overlap: " + interval + " " + currentListInterval);
					
					int leftBound = Math.min(interval.getLeftBound(), currentListInterval.getLeftBound());
					int rightBound = Math.max(interval.getRightBound(), currentListInterval.getRightBound());
					
					try {
						currentListInterval.setLeftAndRightBound(leftBound, rightBound);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return;
				}
				//shortcut to not iterate whole list, it works because of the sorted input
				else if(interval.isSmallerThan(currentListInterval))	
					break;
			}
			
			//here: not overlapping -> add
			currentList.add(interval);
		});
		
		return currentList;
	}
	
}
