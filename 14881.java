import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(--T >= 0) {
        	int A = sc.nextInt();
        	int B = sc.nextInt();
        	int C = sc.nextInt();
        	
        	if(C == A || C == B) {
        		System.out.println("YES");
        		continue;
        	}
        	
        	int g = gcd(A, B);
        	
        	if(C <= Math.max(A, B) && C % g == 0) System.out.println("YES");
        	else System.out.println("NO");
        }
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		if(b > a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}