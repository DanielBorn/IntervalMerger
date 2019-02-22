# IntervalMerger

This is a small program, which merges a list of intervals in such way, that every overlapping intervals are merged into one interval respectively with the new bounds:

``` 
newLowerBound = min(lowerBound1, lowerBound2);
newUpperBound = max(upperBound1, upperBound2);
```

## Example
Input: [25, 30] [2, 19] [14, 23] [4, 8]  
Output: [2, 23] [25, 30]


## Merge function
The interval list is firstly sorted ascending by the left bound.
For each interval in the given list, it is then checked, if it is overlapping with one of the intervals in the working (current) list.
If so, both intervals are merged in place.
The working list is then returned.

## Time complexity
The sorting function has a time complexity of O(n * log(n)).
Since the merge function is comparing each input interval with the intervals in the working list, the time complexity is O(n^2).
So the overall complexity is O(n^2).

## Memory usage
The number of interval objects allocated are the number of input interval objects and the number of output objects.
Changes of the intervals are made in place, by changeing the parameters in the object.
So in the worst case, there are 2 times the number of input intervals.

## Robustness
The interval class only accepts integer numbers and checks that the bounds are in the correct order. If not, an exception is thrown.
Concerning the memory usage: The input size is bounded by the usable memory for the intervals divided by 2 (see Memory usage).
