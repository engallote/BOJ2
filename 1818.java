import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1], dp = new int[N + 1];
		int idx = 1;
		for(int i = 1; i <= N; i++) arr[i] = sc.nextInt();
		dp[1] = arr[1];
		
		for(int i = 2; i <= N; i++)
		{
			if(dp[idx] < arr[i]) dp[++idx] = arr[i];
			else{
				int l = 1, r = idx, mid = 0;
				while(l < r){
					mid = (l + r) / 2;
					if(dp[mid] >= arr[i]) r = mid;
					else l = mid + 1;
				}
				dp[r] = arr[i];
			}
		}
		
		System.out.println(N-idx);
	}
}