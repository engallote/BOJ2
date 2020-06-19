import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long g = sc.nextLong();
		long lcm = sc.nextLong();
		
		long tmp = g * lcm;
		long a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
		for(long i = g; i <= lcm; i++)
			if(tmp % i == 0){
				long gcd = GCD(i, tmp / i);
				
				if(gcd == g && a + b > i + (tmp / i)){
					a = i;
					b = tmp / i;
				}
			}
		
		System.out.println(a + " " + b);
	}

	private static long GCD(long a, long b) {
		if(b == 0) return a;
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		return GCD(b, a % b);
	}
}