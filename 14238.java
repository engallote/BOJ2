import java.util.*;

public class Main {
	static int len;
	static char[] res;
	static int[][][][][] dp;
	static String ans = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		len = ch.length;
		res = new char[len];
		int A = 0, B = 0, C = 0;
		
		for(char c : ch){
			if(c == 'A') ++A;
			else if(c == 'B') ++B;
			else ++C;
		}
		
		dp = new int[A+1][B+1][C+1][4][4];
		
		for(int i = 0; i <= A; i++)
			for(int j = 0; j <= B; j++)
				for(int k = 0; k <= C; k++)
					for(int l = 0; l <= 3; l++)
						Arrays.fill(dp[i][j][k][l], -1);
		
		solve(0, A, B, C, 3, 3);
		
		if(ans.length() == 0) System.out.println(-1);
		else System.out.println(ans);
	}
	private static void solve(int idx, int a, int b, int c, int p1, int p2) {
		if(ans.length() != 0) return;
		if(idx == len){
			if(a == 0 && b == 0 && c == 0) ans = new String(res);
			return;
		}
		if(dp[a][b][c][p1][p2] != -1) return;
		
		if(a > 0){
			res[idx] = 'A';
			solve(idx + 1, a - 1, b, c, p2, 0);
			res[idx] = '.';
		}
		if(b > 0 && p2 != 1){
			res[idx] = 'B';
			solve(idx + 1, a, b - 1, c, p2, 1);
			res[idx] = '.';
		}
		if(c > 0 && p1 != 2 && p2 != 2){
			res[idx] = 'C';
			solve(idx + 1, a, b, c - 1, p2, 2);
			res[idx] = '.';
		}
		dp[a][b][c][p1][p2] = 0;
	}
}