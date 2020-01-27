import java.util.*;

public class Main {
	static int N, M, len;
	static HashMap<Integer, Integer> ha = new HashMap<>(), hb = new HashMap<>();
	static ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			N = sc.nextInt();
			if(N == 0) break;
			a.clear();
			b.clear();
			ha.clear();
			hb.clear();
			
			for(int i = 0; i < N; i++){
				int num = sc.nextInt();
				a.add(num);
				ha.put(num, i);
			}
			M = sc.nextInt();
			for(int i = 0; i < M; i++){
				int num = sc.nextInt();
				b.add(num);
				hb.put(num, i);
			}
			
			len = Math.max(N, M);
			dp = new int[len+1][3];
			
			for(int i = 0; i <= len; i++)
				Arrays.fill(dp[i], -1);
			
			int res = solve(0, 0);
			System.out.println(res);
		}
	}
	private static int solve(int idx, int p) {
		if((p == 1 && idx >= N) || (p == 2 && idx >= M)) return 0;
		if(dp[idx][p] != -1) return dp[idx][p];
		int ret = Integer.MIN_VALUE;
		
		if(p == 0){//start
			ret = Math.max(solve(1, 1) + a.get(0), solve(1, 2) + b.get(0));
			if(hb.containsKey(a.get(0))) //a -> b
				ret = Math.max(ret, solve(hb.get(a.get(0)) + 1, 2) + a.get(0));
			if(ha.containsKey(b.get(0))) //b -> a
				ret = Math.max(ret, solve(ha.get(b.get(0)) + 1, 1) + b.get(0));
		}
		else if(p == 1){//a
			ret = Math.max(ret, solve(idx + 1, 1) + a.get(idx)); //계속 a로
			if(hb.containsKey(a.get(idx))) //a -> b
				ret = Math.max(ret, solve(hb.get(a.get(idx)) + 1, 2) + a.get(idx));
		}
		else{//b
			ret = Math.max(ret, solve(idx + 1, 2) + b.get(idx)); //계속 b로
			if(ha.containsKey(b.get(idx))) //b -> a
				ret = Math.max(ret, solve(ha.get(b.get(idx)) + 1, 1) + b.get(idx));
		}
		return dp[idx][p] = ret;
	}
}