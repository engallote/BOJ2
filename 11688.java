import java.util.*;

public class Main {
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long L = sc.nextLong();
		
		long lcm = LCM(a, b);
		if(L % lcm != 0) System.out.println(-1);
		else{
			long c = L / lcm, tmp = c;
			Queue<Long> q = new LinkedList<Long>();
			
			for(long i = 2; i * i <= tmp; i++){
				if(tmp % i != 0) continue;
				q.offer(i);
				while(tmp % i == 0) tmp /= i;
			}
			
			if(tmp != 1) q.offer(tmp);
			
			while(!q.isEmpty())
				c *= max(a, b, q.poll());
			
			System.out.println(c);
		}
	}
	private static long max(long a, long b, long p) {
		long ret1 = 1, ret2 = 1;
		
		while(a % p == 0){
			ret1 *= p;
			a /= p;
		}
		
		while(b % p == 0){
			ret2 *= p;
			b /= p;
		}
		
		return Math.max(ret2, ret1);
	}
	private static long LCM(long a, long b) {
		long res = (a * b) / gcd(a, b);
		return res;
	}
	private static long gcd(long a, long b) {
		if(b == 0) return a;
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		return gcd(b, a % b);
	}
}