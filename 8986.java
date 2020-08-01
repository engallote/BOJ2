import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		long l = 0, r = 1000000000, res = Long.MAX_VALUE;
		while(l + 3 <= r){
			long m1 = (l * 2 + r) / 3;
			long m2 = (l + r * 2) / 3;
			
			long sum1 = sum(m1, arr, N), sum2 = sum(m2, arr, N);
			
			if(sum1 < sum2) r = m2;
			else l = m1;
		}
		
		for(long i = l; i <= r; i++)
			res = Math.min(res, sum(i, arr, N));
		
		System.out.println(res);
	}

	private static long sum(long m1, long[] arr, int N) {
		long ret = 0;
		for(int i = 1; i < N; i++)
			ret += Math.abs(m1 * i - arr[i]);
		return ret;
	}
}