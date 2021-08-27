import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	double x1 = sc.nextDouble();
    	double y1 = sc.nextDouble();
    	double r1 = sc.nextDouble();
    	double x2 = sc.nextDouble();
    	double y2 = sc.nextDouble();
    	double r2 = sc.nextDouble();
    	
    	double d = Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    	
    	if(d < r1 + r2 || (d < r1 + r2 && Math.max(r1, r2) - Math.min(r2, r1) < d))
    		System.out.println("YES");
    	else if(d < Math.max(r2, r1) - Math.min(r2, r1))
    		System.out.println("YES");
    	else System.out.println("NO");
	}
}