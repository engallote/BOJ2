import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0)
		{
			N = sc.nextInt();
			long[] arr = new long[N];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextLong();
			
			Arrays.sort(arr);
			
			long res = 0;
			for(int i = N - 3; i >= 0; i-=3)
				res += arr[i];
			
			System.out.println(res);
		}
	}
}