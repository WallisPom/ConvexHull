import java.util.*; 
  
public class points2Class 
{ 
    double x, y; 
    points2Class(double x, double y){ 
        this.x=x; 
        this.y=y; 
    } 
    
    public double getCoordY() {
    	return y;
    }
    
    public double getCoordX() {
    	return x;
    	
    }
    
    @Override
    	public String toString() {
    	return ("(" + this.getCoordX() + "," + getCoordY() + ")");
    }
} 