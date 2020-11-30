import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		if(N == 1) {
			System.out.println(arr[0]);
			return;
		}
		
		Arrays.sort(arr);
		
		if(N % 2 == 0) {
			int l = 0, r = N - 1;
			long res = 0;
			while(l < r) {
				res = Math.max(res, arr[l] + arr[r]);
				++l;
				--r;
			}
			System.out.println(res);
		}
		else {
			int l = 0, r = N - 2;
			long res = arr[N - 1];
			while(l < r) {
				res = Math.max(res, arr[l] + arr[r]);
				++l;
				--r;
			}
			System.out.println(res);
		}
	}
}