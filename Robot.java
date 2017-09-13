import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Robot {

	private int direction;
	private boolean hasSensed, hasFlipped;
	private Trajectory t;
	private int angle;
	private int sizeR;
	private int startingX;
	private int startingY;
	private boolean labelToggle;
	private boolean starving;
	private boolean isoToggle;
	private int wifiRange;
	private final int checkingAngle  = 5;
	private int ID;
	
	
	public Robot( Trajectory traj, int ang, int dir)
	{
		ID = traj.getID();
		direction = dir;
		labelToggle = true;
		hasFlipped = false;
		hasSensed = false;
		t = traj;
		angle = ang;
		sizeR = t.getSize()/5;
	//	startingX = x;
		//startingY = y;
		starving = false;
		isoToggle = false;
		double hdis = (t.getSize()/2) + (t.getSize()/6) - (t.getSize()/2)*Math.cos((Math.PI/180)*checkingAngle);
		double vdis = (t.getSize()/2)*Math.sin((Math.PI/180)*checkingAngle);
		wifiRange = (int)Math.round(Math.sqrt(hdis*hdis + vdis*vdis));
	}
	
	public boolean inRange(Robot b){
		double centerX = t.getVertex().getX() + t.getSize()/2*Math.cos((Math.PI/180)*angle);
		
		double centerY = t.getVertex().getY() + t.getSize()/2*Math.sin((Math.PI/180)*angle);
		
		double leg1 = Math.abs(centerX - b.getTraj().getVertex().getX() + t.getSize()/2*Math.cos((Math.PI/180)*angle));
		
		double leg2 = Math.abs(centerY - b.getTraj().getVertex().getY() + t.getSize()/2*Math.sin((Math.PI/180)*angle));
		
		double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
		
		if(Math.ceil(hypotenuse) < wifiRange + sizeR/2){
			System.out.println("#" + t.getID() +" detected #" + b.getTraj().getID());
		}
		
		return Math.ceil(hypotenuse) < wifiRange + sizeR/2;
	}
	
	public int getCheckingAngle(){
		return checkingAngle;
	}
	
	public void setDirection(int dir){
		direction = dir;
	}
	
	public int getDirection(){
		return direction;
	}
	
	public void setIsolationToggle(boolean b){
		isoToggle = b;
	}
	
	public void setFlipped(boolean h){
		hasFlipped = h;
	}
	
	public boolean getFlipped(){
		return hasFlipped;
	}
	
	public Trajectory getTraj()
	{
		return t;
	}
	public void setTrajectory(Trajectory tr){
		t=tr;
	}
	
	public void setAngle(int a){
		angle = a;
	}
	
	public int getAngle()
	{
		return angle;
	}
	
	public void setHasSensed(boolean state){
		hasSensed = state;
	}
	
	public boolean hasSensed(){
		return hasSensed;
	}
	
	public boolean isStarving(){
		return starving;
	}
	
	public void setStarving(boolean s){
		starving = s;
	}

	
	public boolean contains(Coordinate c){
		double centerX = t.getVertex().getX() + t.getSize()/2*Math.cos(angle);
		double centerY = t.getVertex().getY() - t.getSize()/2*Math.sin(angle);
		double leg1 = Math.abs(centerX - c.getY());
		double leg2 = Math.abs(centerY - c.getY());
		double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
		return hypotenuse < sizeR / 2;
	}
	
	public void setLabelToggle(boolean b){
		labelToggle = b;
	}
	
	public void draw(Graphics2D g2)
	{
		
		
		
		
		if(starving && isoToggle){
			g2.setColor(Color.yellow);
		}else{
			g2.setColor(Color.black);
		}
		//g2.setColor(Color.black);
	
		g2.fill(new Ellipse2D.Double(t.getVertex().getX() + t.getSize()/2*Math.cos((Math.PI/180)*angle) - sizeR/2, t.getVertex().getY() - t.getSize()/2*Math.sin((Math.PI/180)*angle) - sizeR/2, sizeR, sizeR));//t.getSize()*Math.cos(angle)
	
		//dras range circle
		//g2.draw(new Ellipse2D.Double(t.getVertex().getX() + t.getSize()/2*Math.cos((Math.PI/180)*angle) - (2*wifiRange + sizeR)/2, t.getVertex().getY() - t.getSize()/2*Math.sin((Math.PI/180)*angle) - (2*wifiRange + sizeR)/2, (2*wifiRange + sizeR), (2*wifiRange + sizeR)));
		if(starving && isoToggle){
			g2.setColor(Color.black);
		}else{
			g2.setColor(Color.white);
		}
		
		Font font = new Font("Callibri", Font.PLAIN, sizeR/3);//font.getStringBounds("Waller's Triangle Game", g2.getFontRenderContext()).getWidth())/2)
		
		g2.setFont(font);
		//g2.setStroke(new BasicStroke(sizeR/4));
		if(labelToggle){
		g2.drawString(ID + " ", (int)(t.getVertex().getX() + t.getSize()/2*Math.cos((Math.PI/180)*angle)-sizeR/6), (int)(t.getVertex().getY() - t.getSize()/2*Math.sin((Math.PI/180)*angle)+sizeR/6));
		}
	
	}
	
	public Coordinate getPosition(){
		return new Coordinate(t.getVertex().getX() + t.getSize()/2*Math.cos((Math.PI/180)*angle) - sizeR/2,t.getVertex().getY() + t.getSize()/2*Math.sin((Math.PI/180)*angle) - sizeR/2);
	}
	
}
