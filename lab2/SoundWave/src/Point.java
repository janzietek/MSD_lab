import java.util.Random;

public class Point {
	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;

	public static Integer[] types = {0, 1, 2};
	int type;

	int sinInput;
	Random rand = new Random();

	public Point() {
		type = 0;
		clear();
		sinInput = rand.nextInt(360);
	}

	public void clicked() {
		pressure = 1;
	}

	public void createNeighborhood (Point s, Point w, Point n, Point e) {
		nNeighbor = n;
		wNeighbor = w;
		eNeighbor = e;
		sNeighbor = s;
	}

	public void clear() {
		// TODO: clear velocity and pressure
		nVel = 0;
		wVel = 0;
		eVel = 0;
		sVel = 0;
		pressure = 0;
	}

	public void updateVelocity() {
		// TODO: velocity update
		if (type == 0) {
			nVel = nVel - (nNeighbor.getPressure() - this.getPressure());
			wVel = wVel - (wNeighbor.getPressure() - this.getPressure());
			eVel = eVel - (eNeighbor.getPressure() - this.getPressure());
			sVel = sVel - (sNeighbor.getPressure() - this.getPressure());
		}
	}

	public void updatePresure() {
		// TODO: pressure update
		if (type == 0)
			pressure = pressure - 0.5f * (nVel + wVel + eVel + sVel);
		else if (type == 2) {
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
	}

	public void updateSinInput () {
		sinInput = (sinInput + 30) % 360;
	}

	public float getPressure() {
		return pressure;
	}
}