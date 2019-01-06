import java.util.*; 
  
public class points1Class 
{ 
    int x, y; 
    points1Class(int x, int y){ 
        this.x=x; 
        this.y=y; 
    } 
    
    public int getCoordY() {
    	return y;
    }
    
    public int getCoordX() {
    	return x;
    	
    }
    
    @Override
    	public String toString() {
    	return ("(" + this.getCoordX() +", " + getCoordY() + ")");
    }
} 