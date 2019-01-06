import java.lang.reflect.Array;
import java.util.Vector;
import java.util.Random;

class ConvexHullClass {

	public static int theOrientation1(points1Class p, points1Class q, points1Class r) {
		int val1 = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val1 == 0)
			return 0;
		return (val1 > 0) ? 1 : 2;
	}

	public static int theOrientation2(points2Class p, points2Class q, points2Class r) {
		double val2 = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val2 == 0)
			return 0;
		return (val2 > 0) ? 1 : 2;
	}

	// Returns convex hull of a set of n points.
	public static void convexHull1(points1Class points[], int n) {
		// Minimum 3 points
		if (n < 3)
			return;

		Vector<points1Class> hull = new Vector<points1Class>();

		// Find leftmost point
		int l = 0;
		for (int i = 1; i < n; i++)
			if (points[i].x < points[l].x)
				l = i;

		int p = l;
		int q;
		do {
			// Add current point to result
			hull.add(points[p]);

			q = (p + 1) % n;

			for (int i = 0; i < n; i++) {
				// If i is more counterclockwise than
				// current q, then update q
				if (theOrientation1(points[p], points[i], points[q]) == 2)
					q = i;
			}

			// q is the most counterclockwise w.r.t p
			p = q;

		} while (p != l);

		for (points1Class temp : hull)
			System.out.println("(" + temp.x + ", " + temp.y + ")");

		System.out.println("size of hull is: " + hull.size() + "\n");
	}

	public static void convexHull2(points2Class points[], int n) {
		// Minimum 3 points
		if (n < 3)
			return;

		// Initialize Result
		Vector<points2Class> hull = new Vector<points2Class>();

		// Find leftmost point
		int l = 0;
		for (int i = 1; i < n; i++)
			if (points[i].x < points[l].x)
				l = i;

		// Begin at leftmost point

		int p = l;
		int q;
		do {

			hull.add(points[p]);

			q = (p + 1) % n;

			for (int i = 0; i < n; i++) {

				if (theOrientation2(points[p], points[i], points[q]) == 2)
					q = i;
			}

			p = q;

		} while (p != l);

		// Print Result
		for (points2Class temp : hull)
			System.out.println("(" + temp.x + ", " + temp.y + ")");

		System.out.println("size of hull is: " + hull.size());
	}

	public static points1Class[] createPointsPart1(int numElements) {

		points1Class makePoints[] = new points1Class[numElements];
		int lowerBound = -30;
		int upperBound = 30;

		for (int a = 0; a < numElements; a++) {
			int coordX = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;
			int coordY = (int) (Math.random() * (upperBound - lowerBound)) + lowerBound;

			points1Class coord1 = new points1Class(coordX, coordY);
			makePoints[a] = coord1;
		}
		return makePoints;
	}

	public static points2Class[] createPointsPart2(int numElements) {

		points2Class makePoints[] = new points2Class[numElements];

		Random var = new Random();
		for (int b = 0; b < numElements; b++) {
			double coordX = var.nextGaussian();
			double coordY = var.nextGaussian();
			points2Class coord1 = new points2Class(coordX, coordY);
			makePoints[b] = coord1;

		}
		return makePoints;

	}

	
	/////////////////////PART 3
	//METHOD TO FIND THE CENTER OF THE CIRCLE FOR PART 3
	/*public static points1Class findCenterPoint(points1Class set[]) {
		points1Class newPoint = new points1Class(0, 0);

		int x = 0;
		int y = 0;

		int pointlength = set.length;
		for (int i = 0; i < pointlength; i++) {
			x += set[i].getCoordX();
			y += set[i].getCoordY();
		}
		int xPoint = x / pointlength;
		int yPoint = y / pointlength;
		newPoint.x = xPoint;
		newPoint.y = yPoint;
		return newPoint;
	}*/

	//METHOD TO FIND THE RADIUS BY TAKING THE MEAN POINT, THEN FINDING MAX DISTANCE FROM THAT POINT, GIVEN A SET OF POINTS
	/*public static double findMaxDist(points1Class center, points1Class points[]) {
		int length = points.length;

		for (int d = 0; d < length; d++) {
			double firstDistance = Math.sqrt((points[d].getCoordX() - center.getCoordX())
					* ((points[d].getCoordX() - center.getCoordX()) + (points[d].getCoordY() - center.getCoordY())
							* ((points[d].getCoordY() - center.getCoordY()))));
			double secondDistance = Math.sqrt(
					(points[d + 1].getCoordX() - center.getCoordX()) * ((points[d + 1].getCoordX() - center.getCoordX())
							+ (points[d + 1].getCoordY() - center.getCoordY())
									* ((points[d + 1].getCoordY() - center.getCoordY()))));
			if (firstDistance > secondDistance){
				
			}
		}
		return firstDistance;
	}*/

	/*public static points1Class findRadius(points1Class set [], points1Class center) {
		points1Class newPoint = new points1Class(0,0);	
        	
    		for(int i=0; i<10; i++) {
    		int x = 0; 
        	int y = 0;
			return newPoint;
    		}
    }
*/
    		
	//////////////////////////////////////////////// MAIN
	public static void main(String[] args) {

		int setNumPart1 = 1;

		for (int elements = 5; elements <= 105; elements += 10) {
			points1Class thePoints[] = createPointsPart1(elements);

			System.out.println("Set #: " + setNumPart1);
			for (points1Class points : thePoints) {
				System.out.println(points);
			}
			System.out.println(" \nThe Convex Hull is: ");
			convexHull1(thePoints, elements);
			setNumPart1++;
		}

		int setNumPart2 = 1;
		for (int elements = 5; elements <= 105; elements += 10) {
			points2Class thePoints[] = createPointsPart2(elements);

			System.out.println("Set #: " + setNumPart2);
			for (points2Class points : thePoints) {
				System.out.println(points);
			}
			System.out.println(" \nThe Convex Hull is: ");
			convexHull2(thePoints, elements);
			setNumPart2++;
		}

	}
}