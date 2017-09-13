
public class AngleUtilities {
	
	
	
	/*public static int getAngle(Coordinate c, Coordinate a){
		double hDis = a.getX() - c.getX();
		double vDis = c.getY() - a.getY();
		
		
		
		//4 special cases
		if(hDis == 0 && vDis < 0){
			return 270;
		}
		
		if(hDis == 0 && vDis > 0){
			return 90;
		}
		
		if(hDis > 0 && vDis == 0){
			return 0;
		}
		
		if(hDis < 0 && vDis == 0){
			return 180;
		}
		
		if(hDis > 0){
			double tempAng = (int)((180/Math.PI)*Math.atan(vDis/hDis));
			tempAng = coterminal((int)tempAng);
			return (int)tempAng;
		}else{
			double tempAng = Math.atan(vDis/hDis);
			tempAng = tempAng + Math.PI;
			tempAng = tempAng*(180/Math.PI);
			tempAng = coterminal((int)tempAng);
			return (int)tempAng;
		}
	}*/
	
	public static int coterminal(int a){
		if(a >= 360){
			return a - 360;
		}
		
		if(a < 0){
			return a + 360;
		}
		
		return a;
	}
	
	public static int angleDif(int a, int b){
		int tempDif = Math.abs(a-b);
		
		if(tempDif > 180){
			tempDif = 360 - tempDif;
		}
		
		return tempDif;
	}
	
	public static boolean inRange(int a, int b, int ang){
		int small, big;
		
		if(a == b){
			//System.out.println("a");
			if(ang == a){
				return true;
			}
			return false;
		}
		
		if(a > b){
			
			small = b;
			big = a;
		}else{
			small = a;
			big = b;
		}
		
		if(big - small <= 180){
			//System.out.println("b");
			//System.out.println("big: " + big);
			//System.out.println("small: " + small);
			if(ang <= big && ang >= small){
				return true;
			}else{
				return false;
			}
		}else{
			//System.out.println("c");
			if(ang >= big || ang <= small){
				return true;
			}else{
				return false;
			}
		}
	}
}
