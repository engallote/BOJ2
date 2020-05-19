import java.util.*;

public class Main {
	static int N, M, H, mod = 10007;
	static ArrayList<Integer>[] arr;
	static int[][][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        arr = new ArrayList[N+1];
        dp = new int[N+1][M+1][H+1];
        
        for(int i = 1; i <= N; i++){
        	arr[i] = new ArrayList<>();
        	for(int j = 0; j <= M; j++)
        		Arrays.fill(dp[i][j], -1);
        }
        
        sc.nextLine();
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
        	st = new StringTokenizer(sc.nextLine());
        	while(st.hasMoreTokens()) arr[i].add(Integer.parseInt(st.nextToken()));
        }
        
        int res = solve(1, 0, 0);
        System.out.println(res);
    }
	private static int solve(int idx, int m, int h) {
		if(h == H) return 1;
		if(idx > N) return 0;
		if(dp[idx][m][h] != -1) return dp[idx][m][h];
		int ret = 0;
		
		ret += solve(idx + 1, M, h) % mod;
		ret %= mod;
		
		for(int i = 0; i < arr[idx].size(); i++)
			if(h + arr[idx].get(i) <= H){
				ret += solve(idx + 1, i, h + arr[idx].get(i));
				ret %= mod;
			}
		return dp[idx][m][h] = ret;
	}
}