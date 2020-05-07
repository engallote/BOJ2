import java.util.*;

public class Main {
	static int N, M;
	static char[] a, b;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0){
			N = sc.nextInt();
			a = sc.next().toCharArray();
			M = sc.nextInt();
			b = sc.next().toCharArray();
			dp = new int[101][101];
			
			for(int i = 0; i <= 100; i++)
				Arrays.fill(dp[i], -1);
			
			int res = solve(0, 0);
			System.out.println(res);
		}
	}
	private static int solve(int idx1, int idx2) {
		if(idx1 == N || idx2 == M){
			int cost = 0;
			if(idx1 < N){
				for(int i = idx1; i < N; i++){
					if(a[i] == 'A') cost -= 3;
					else if(a[i] == 'C') cost -= 4;
					else if(a[i] == 'G') cost -= 2;
					else cost -= 1;
				}
			}
			else{
				for(int i = idx2; i < M; i++){
					if(b[i] == 'A') cost -= 3;
					else if(b[i] == 'C') cost -= 4;
					else if(b[i] == 'G') cost -= 2;
					else cost -= 1;
				}
			}
			return cost;
		}
		if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
		int ret = -100000000;
		if(a[idx1] == b[idx2])// 둘이 같은 유전자 
			ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) + 5);
		if(idx2 + 1 < M){//a 공백
			if(b[idx2] == 'A') ret = Math.max(ret, solve(idx1, idx2 + 1) - 3);
			else if(b[idx2] == 'C') ret = Math.max(ret, solve(idx1, idx2 + 1) - 4);
			else if(b[idx2] == 'G') ret = Math.max(ret, solve(idx1, idx2 + 1) - 2);
			else ret = Math.max(ret, solve(idx1, idx2 + 1) - 1);
		}
		if(idx1 + 1 < N){//b 공백
			if(a[idx1] == 'A') ret = Math.max(ret, solve(idx1 + 1, idx2) - 3);
			else if(a[idx1] == 'C') ret = Math.max(ret, solve(idx1 + 1, idx2) - 4);
			else if(a[idx1] == 'G') ret = Math.max(ret, solve(idx1 + 1, idx2) - 2);
			else ret = Math.max(ret, solve(idx1 + 1, idx2) - 1);
		}
		if(a[idx1] != b[idx2]){//서로 다른 유전자
			if(a[idx1] == 'A'){
				if(b[idx2] == 'C') ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 1);
				else if(b[idx2] == 'G') ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 2);
				else ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 1);
			}
			else if(a[idx1] == 'C'){
				if(b[idx2] == 'A') ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 1);
				else if(b[idx2] == 'G') ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 3);
				else ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 2);
			}
			else if(a[idx1] == 'G'){
				if(b[idx2] == 'A') ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 2);
				else if(b[idx2] == 'C') ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 3);
				else ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 2);
			}
			else if(a[idx1] == 'T'){
				if(b[idx2] == 'A') ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 1);
				else if(b[idx2] == 'C') ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 2);
				else ret = Math.max(ret, solve(idx1 + 1, idx2 + 1) - 2);
			}
		}
		
		return dp[idx1][idx2] = ret;
	}
}