import java.math.BigInteger;
import java.util.*;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	static int[] arr = new int[10];
	static int[][] dp;
	static BigInteger ans = new BigInteger("-1");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
			min = Math.min(min, arr[i]);
		}
		int M = sc.nextInt();
		dp = new int[11][M+1];
		for(int i = 0; i <= 10; i++)
			Arrays.fill(dp[i], -1);
		ArrayList<Integer> path = new ArrayList<>();
		solve(10, M, path);
		System.out.println(ans.toString());
	}
	private static void solve(int idx, int num, ArrayList<Integer> path) {
		if(num < min){
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			for(int i : path) pq.offer(i);
			
			while(!pq.isEmpty()) sb.append(pq.poll());
			if(ans.compareTo(new BigInteger(sb.toString())) < 0) 
				ans = new BigInteger(sb.toString());
			return;
		}
		if(dp[idx][num] != -1) return;
		
		for(int i = N - 1; i >= 0; i--)
			if(num >= arr[i]){
				for(int k = 1; arr[i] * k <= num; k++){
					for(int j = 0; j < k; j++)
						path.add(i);
					solve(i, num - (arr[i] * k), path);
					for(int j = 0; j < k; j++)
						path.remove(path.size()-1);
				}
			}
		dp[idx][num] = 0;
	}
}