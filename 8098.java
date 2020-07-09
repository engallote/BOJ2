import java.util.*;

public class Main {
	static int N;
	static Pair[] arr;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new Pair[N];
		dp = new int[30001];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		Arrays.sort(arr);
		
		int idx = 0;
		for(int i = 1; i <= 30000; i++){
			dp[i] = Math.max(dp[i], dp[i-1]);
			if(idx >= N) continue;
			
			int start = arr[idx].s, end = arr[idx].e;
			
			if(end > i) continue;
			
			dp[i] = Math.max(dp[i], dp[start] + (end - start));
			++idx;
		}
		
		System.out.println(dp[30000]);
	}
}
class Pair implements Comparable<Pair>{
	int s, e;
	Pair(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.e > this.e) return -1;
		else if(o.e == this.e){
			if(o.s > this.s) return -1;
			else if(o.s == this.s) return 0;
			else return 1;
		}
		else return 1;
	}
}