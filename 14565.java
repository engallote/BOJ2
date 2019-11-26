import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long A = sc.nextLong();
		
		System.out.print((N-A) + " ");//덧셈 역원
		if(gcd(N, A) == 1)
		{
			long g = getExtendedGcd(N, A);
			while(g < 0) g += N;
			System.out.println(g);
		}
		else System.out.println(-1);
	}
	private static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	private static long getExtendedGcd(long n, long m) {
		long x = 0, y = 1, quotient = 0, tmpx, tmpy, tmpNum, res1 = 1, res2 = 0;
		
		while(m != 0)
		{
			quotient = (long) Math.floor((double) n / m);
			tmpNum = m;
			m = n % m;
			n = tmpNum;
			
			tmpx = res1 - quotient * x;
			res1 = x;
			x = tmpx;
			
			tmpy = res2 - quotient * y;
			res2 = y;
			y = tmpy;
		}
		
		return res2;
	}
}