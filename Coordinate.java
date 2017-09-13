
public class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate(double i, double j){
		this.x = (int)i;
		this.y = (int)j;
	}
	
	public Coordinate(int i, int j)
	{
		this.x = i;
		this.y = j;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
