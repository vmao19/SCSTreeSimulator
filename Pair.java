
public class Pair {
	private int first;
	private int second;
	
	public Pair(int i, int j)
	{
		first = i;
		second = j;
	}
	
	public int getFirst()
	{
		return first;
	}
	
	public int getSecond()
	{
		return second;
	}
	
	public boolean isSame(Pair n)
	{
		if(first == n.getFirst() && second == n.getSecond())
			return true;
		if(second == n.getFirst() && first == n.getSecond())
			return true;
		
		return false;
	}
	
	
}
