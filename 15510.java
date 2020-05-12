import java.util.*;

public class Main {
	static int N;
	static boolean[][] chk;
	static int[] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        chk = new boolean[N+1][N+1];
        dp = new int[1<<17];
        
        Arrays.fill(dp, -1);
        
        for(int i = 0; i < M; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	chk[a][b] = chk[b][a] = true;
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        int res = solve(0, 0, path);
        if(res == 1) System.out.println("POSSIBLE");
        else System.out.println("IMPOSSIBLE");
    }
	private static int solve(int idx, int visit, ArrayList<Integer> path) {
		if(isMatch(visit))
			return 1;
		if(idx > N) return 0;
		if(dp[visit] != -1) return dp[visit];
		int ret = 0;
		boolean flag = false;
		
		for(int i = idx + 1; i <= N; i++)
			if((visit&(1<<i)) == 0){
				flag = true;
				for(int j : path)
					if(chk[i][j]){
						flag = false;
						break;
					}
				if(flag){
					path.add(i);
					ret = Math.max(ret, solve(i, visit|(1<<i), path));
					path.remove(path.size()-1);
				}
			}
		return dp[visit] = ret;
	}
	private static boolean isMatch(int visit) {
		ArrayList<Integer> path = new ArrayList<>();
		for(int i = 1; i <= N; i++)
			if((visit&(1<<i)) == 0){
				for(int j : path)
					if(chk[i][j]) return false;
				path.add(i);
			}
		return true;
	}
}