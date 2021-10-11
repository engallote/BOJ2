import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	
    	int g = gcd(A, B);
    	System.out.println(g);
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		
		if(a < b) {
			int t = a;
			a = b;
			b = t;
		}
		
		return gcd(b, a%b);
	}
}