
import java.util.ArrayList;


public class Ring {
	
	//private static boolean[] colorArrayUsed = {false, false, false, false,false,false,false,false};
	private ArrayList<Arc> arcList;
	private ArrayList<Robot> robotList;
	
	
	public Ring(){
		arcList = new ArrayList<Arc>();
		robotList = new ArrayList<Robot>();
		
	}
	
	public void addArc(Arc a){
		arcList.add(a);
	}
	
	public void addRobot(Robot r){
		robotList.add(r);
	}
	
	public ArrayList<Arc> getArcList(){
		return arcList;
	}
	
	public ArrayList<Robot> getRobotList(){
		return robotList;
	}
	
	public void resetRobotList(){
		robotList = new ArrayList<Robot>();
	}
	
	public String toString(){
		return "num of arcs " + arcList.size();
	}
}
