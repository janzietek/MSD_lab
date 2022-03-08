import java.util.ArrayList;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

	public void clicked() {
		currentState=(++currentState)%numStates;	
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState() {
		if (this.getState() == 0) {
			if (this.calculateActiveNeighbors() == 3)
				this.nextState = 1;
			else
				this.nextState = 0;
		}
		else {
			if (this.calculateActiveNeighbors() == 3 || this.calculateActiveNeighbors() == 2)
				this.nextState = 1;
			else
				this.nextState = 0;
		}
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	//TODO: write method counting all active neighbors of THIS point
	private int calculateActiveNeighbors () {
		int count = 0;
		for (Point p: this.neighbors) {
			if (p.getState() > 0) count = count + 1;
		}
		return count;
	}
}
