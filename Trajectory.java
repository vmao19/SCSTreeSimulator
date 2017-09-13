import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Trajectory {

	private Coordinate vertex;
	
	private int sizeT;
	private ArrayList<Robot> bots;
	private Arc arc1;
	private Arc arc2;
	private Arc arc3;
	private Arc arc4;
	private int trajID;
	private int dir;
	private boolean ghostReady;
	private ArrayList<TrajAnglePair> neighbors;
	
	public Trajectory(Coordinate v, int s, int id, int d)
	{
		neighbors = new ArrayList<TrajAnglePair>();
		ghostReady = false;
		arc1 = new Arc(this,1);
		arc2 = new Arc(this,2);
		arc3 = new Arc(this,3);
		arc4 = new Arc(this,4);
		bots = new ArrayList<Robot>();
		vertex = v;
		sizeT = s;
		trajID = id;
		dir = d;
	}
	
	public int getID(){
		return trajID;
	}
	
	public int getDir(){
		return dir;
	}
	
	public void setColor(Color c){
		arc1.setColor(c);
		arc2.setColor(c);
		arc3.setColor(c);
		arc4.setColor(c);
	}	
	
	public void setArc1(Arc a){
		arc1 = a;
	}
	
	public void setArc2(Arc a){
		arc2 = a;
	}
	
	public void setArc3(Arc a){
		arc3 = a;
	}
	
	public void setArc4(Arc a){
		arc4 = a;
	}
	
	public void setReady(boolean b){
		ghostReady = b;
	}
	
	public boolean isReady(){
		return ghostReady;
	}
	
	public Arc getArc1(){
		return arc1;
	}
	public Arc getArc2(){
		return arc2;
	}
	
	public Arc getArc3(){
		return arc3;
	}
	
	public Arc getArc4(){
		return arc4;
	}
	
	public void addBot(Robot b){
		bots.add(b);
	}
	
	public void removeBot(Robot b){
		bots.remove(b);
	}
	
	public Coordinate getVertex()
	{
		return vertex;
	}
	
	
	public int getSize()
	{
		return sizeT;
	}
	
	public ArrayList<Robot> getRobotList(){
		return bots;
	}
	
	public boolean overlaps(Trajectory t){
		double centerX = vertex.getX();
		
		double centerY = vertex.getY();
		
		double leg1 = Math.abs(centerX - t.getVertex().getX());
		
		double leg2 = Math.abs(centerY - t.getVertex().getY());
		
		double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
		
		return Math.ceil(hypotenuse) < (sizeT + sizeT/6);
	}
	
	public boolean tangent(Trajectory t) {
		double centerX = vertex.getX();
		
		double centerY = vertex.getY();
		
		double leg1 = Math.abs(centerX - t.getVertex().getX());
		
		double leg2 = Math.abs(centerY - t.getVertex().getY());
		
		double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
		
		return Math.ceil(hypotenuse) >= (sizeT + sizeT/6) -1 && Math.ceil(hypotenuse) <= (sizeT + sizeT/6) +1;
	}
	
	public boolean contains(Coordinate c){
		double centerX = vertex.getX();
		double centerY = vertex.getY();
		int adjustRadius = sizeT/2 + sizeT/6;
		double leg1 = Math.abs(centerX - c.getX());
		double leg2 = Math.abs(centerY - c.getY());
		double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
		
		return hypotenuse < 2*adjustRadius;
	}
	
	public int angleFrom(Trajectory t) {
		double centerX = vertex.getX();
		
		double centerY = vertex.getY();
		
		double leg1, leg2;
		
		
		if(centerX > t.getVertex().getX())
		{
			leg1 = (centerX - t.getVertex().getX());
		}
		else
			leg1 = (centerX - t.getVertex().getX());
		
		if(centerY > t.getVertex().getY())
		{
			leg2 = -(centerY - t.getVertex().getY());
		}
		else
			leg2 = -(centerY - t.getVertex().getY());
		
		int ang = Math.abs((int)((180/Math.PI)*Math.atan(leg2/leg1)));
		int tempAng = Math.abs((int)((180/Math.PI)*Math.atan(leg2/leg1)));
		if(leg1 > 0 && leg2 >= 0)
		{
			tempAng = ang;
		}
		if(leg1 < 0 && leg2 >= 0)
		{
			tempAng = 180 - ang;
		}
		if(leg1 <= 0 && leg2 < 0)
		{
			tempAng = 180 + ang;
		}
		if(leg2 < 0 && leg1 >= 0)
		{
			tempAng = 360 - ang;
		}
		
		tempAng = (int)AngleUtilities.coterminal(tempAng);
		/*
		leg1 = (centerX - t.getVertex().getX());
		if(leg1 != 0){
			leg1*=-1;
		}
		
		leg2 = -(centerY - t.getVertex().getY()); 
		
		
		int tempAng = (int)((180/Math.PI)*Math.atan(leg2/leg1));
		
		tempAng = (int)AngleUtilities.coterminal(tempAng);
		
		if(leg2 == -0.0)
			{
			int diff = 90 - tempAng;
			tempAng += 2*diff;
			}
		if(leg1 < 0){
			int dif = 90 - tempAng;
			tempAng += 2*dif;
		}
		*/
		
		
		return tempAng;
		
	}
	
	public void removeNeighbor(TrajAnglePair tap)
	{
		neighbors.remove(tap);
	}
	
	public void addNeighbor(TrajAnglePair tap) {
		neighbors.add(tap);
	}
	
	public ArrayList<TrajAnglePair> getNeighbors(){
		return neighbors;
	}
	
	public void draw(Graphics2D g2)
	{
		g2.setColor(arc1.getColor());
		g2.drawArc(vertex.getX()- sizeT / 2, vertex.getY()- sizeT / 2, sizeT, sizeT, 0, 90);
		
		g2.setColor(arc2.getColor());
		g2.drawArc(vertex.getX()- sizeT / 2, vertex.getY()- sizeT / 2, sizeT, sizeT, 90, 90);
		
		g2.setColor(arc3.getColor());
		g2.drawArc(vertex.getX()- sizeT / 2, vertex.getY()- sizeT / 2, sizeT, sizeT, 180, 90);
		
		g2.setColor(arc4.getColor());
		g2.drawArc(vertex.getX()- sizeT / 2, vertex.getY()- sizeT / 2, sizeT, sizeT, 270, 90);
		
		g2.drawString("" + trajID, vertex.getX(), vertex.getY());;
		//if(direction == 1){
		//	g2.setColor(Color.blue);
		//}else{
		//	g2.setColor(Color.red);
		//}
		
		//original
		//g2.setColor(Color.black);
		//g2.draw(new Ellipse2D.Double(vertex.geti() - sizeT / 2, vertex.getj() - sizeT / 2, sizeT, sizeT));
	}
}
