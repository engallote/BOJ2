import java.util.*;

public class Main {
	static int r, g, b;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) {
    		r = sc.nextInt();
    		g = sc.nextInt();
    		b = sc.nextInt();
    		
    		if(r == -1 && g == -1 && b == -1) break;
    		double min = Double.MAX_VALUE;
    		String res = "";
    		
    		if(calc(255, 255, 255) < min) {
    			min = calc(255, 255, 255);
    			res = "White";
    		}
    		if(calc(192, 192, 192) < min) {
    			min = calc(192, 192, 192);
    			res = "Silver";
    		}
    		if(calc(128, 128, 128) < min) {
    			min = calc(128, 128, 128);
    			res = "Gray";
    		}
    		if(calc(0, 0, 0) < min) {
    			min = calc(0, 0, 0);
    			res = "Black";
    		}
    		if(calc(255, 0, 0) < min) {
    			min = calc(255, 0, 0);
    			res = "Red";
    		}
    		if(calc(128, 0, 0) < min) {
    			min = calc(128, 0, 0);
    			res = "Maroon";
    		}
    		if(calc(255, 255, 0) < min) {
    			min = calc(255, 255, 0);
    			res = "Yellow";
    		}
    		if(calc(128, 128, 0) < min) {
    			min = calc(128, 128, 0);
    			res = "Olive";
    		}
    		if(calc(0, 255, 0) < min) {
    			min = calc(0, 255, 0);
    			res = "Lime";
    		}
    		if(calc(0, 128, 0) < min) {
    			min = calc(0, 128, 0);
    			res = "Green";
    		}
    		if(calc(0, 255, 255) < min) {
    			min = calc(0, 255, 255);
    			res = "Aqua";
    		}
    		if(calc(0, 128, 128) < min) {
    			min = calc(0, 128, 128);
    			res = "Teal";
    		}
    		if(calc(0, 0, 255) < min) {
    			min = calc(0, 0, 255);
    			res = "Blue";
    		}
    		if(calc(0, 0, 128) < min) {
    			min = calc(0, 0, 128);
    			res = "Navy";
    		}
    		if(calc(255, 0, 255) < min) {
    			min = calc(255, 0, 255);
    			res = "Fuchsia";
    		}
    		if(calc(128, 0, 128) < min) {
    			min = calc(128, 0, 128);
    			res = "Purple";
    		}
    		System.out.println(res);
    	}
	}
    public static double calc(int R, int G, int B) {
    	double z = (R - r) * (R - r);
    	double x = (G - g) * (G - g);
    	double c = (B - b) * (B - b);
    	
    	return Math.sqrt(z + x + c);
    }
}