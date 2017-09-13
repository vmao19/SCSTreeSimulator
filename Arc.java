import java.awt.Color;

public class Arc {
	private Trajectory traj;
	private int quadrant;
	private boolean assigned;
	private Color color;
	private Ring ring;
	
	
	
	//possible flag
	public static boolean compare(Arc a, Arc b){
		if(a.getTraj().equals(b.getTraj()) && a.getQuadrant() == b.getQuadrant()){
			return true;
		}else{
			return false;
		}
	}
	
	public Arc(Trajectory t, int q){
		traj = t;
		quadrant = q;
		assigned = false;
		color = Color.black;
	}
	
	public void setAssigned(boolean a){
		assigned = a;
	}
	
	public boolean isAssigned(){
		return assigned;
	}
	
	public int getQuadrant(){
		return quadrant;
	}
	
	public Trajectory getTraj(){
		return traj;
	}
	
	public Color getColor(){
		return color; 
	}
	
	public void setColor(Color c){
		color = c;
	}
	
	public void setRing(Ring r){
		ring = r;
	}
	
	public Ring getRing(){
		return ring;
	}
}
