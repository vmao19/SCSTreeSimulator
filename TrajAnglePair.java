
public class TrajAnglePair {
	private Trajectory trajectory;
	private int angle;
	
	public TrajAnglePair(Trajectory t, int ang) {
		trajectory = t;
		angle = ang;
	}
	
	public Trajectory getTraj() {
		return trajectory;
	}
	
	public int getAngle(){
		return angle;
	}
}
