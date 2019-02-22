package data;

public class Interval {

	private int leftBound;
	private int rightBound;
	
	/**
	 * Constructs an interval with given integer interval bounds (inclusive)
	 * @throws Exception if bounds are in wrong order
	 */
	public Interval(int leftBound, int rightBound) throws Exception {
		setLeftAndRightBound(leftBound, rightBound);
	}
	
	/**
	 * Sets an interval with given integer interval bounds (inclusive)
	 * @throws Exception if bounds are in wrong order
	 */
	public void setLeftAndRightBound(int leftBound, int rightBound) throws Exception {
		if(leftBound > rightBound)
			throw new Exception("Left bound can't be greater than right bound!");
		
		this.leftBound = leftBound;
		this.rightBound = rightBound;
	}

	public int getLeftBound() {
		return leftBound;
	}

	public int getRightBound() {
		return rightBound;
	}
	
	public boolean isOverlapping(Interval other) {
		if(other == null)
			return false;	//or exception
		
		//Case: interval inside an other
		if((this.leftBound >= other.leftBound) &&
				(this.rightBound <= other.rightBound))
			return true;
		
		//Case: reverse order
		if((other.leftBound >= this.leftBound) &&
				(other.rightBound <= this.rightBound))
			return true;
		
		//Case:  -----
		//          -----
		if((this.leftBound <= other.leftBound) &&
				(this.rightBound >= other.leftBound))
			return true;
		
		//Case:  -----
		//     -----
		if((this.leftBound <= other.rightBound) &&
				(this.rightBound >= other.rightBound))
			return true;
		
		return false;
	}
	
	public boolean isSmallerThan(Interval other) {
		if(other == null)
			return false;	//or exception
		
		if(this.rightBound < other.leftBound)
			return true;
		
		return false;
	}
	
	public String toString() {
		return "[" + leftBound + ", " + rightBound + "]";
	}
	
}
