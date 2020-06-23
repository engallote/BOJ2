import java.util.*;

public class Main {
	static String ans = "";
	static int len, len1, len2;
	static int[][][] dp;
	static char[] ch, ch1, ch2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ch1 = sc.next().toCharArray();
		ch2 = sc.next().toCharArray();
		ch = sc.next().toCharArray();
		len = ch.length;
		len1 = ch1.length;
		len2 = ch2.length;
		dp = new int[len][len1 + 1][len2 + 1];
		
		for(int i = 0; i < len; i++)
			for(int j = 0; j <= len1; j++)
				Arrays.fill(dp[i][j], -1);
		
		dfs(0, 0, 0, "");
		System.out.println(ans);
	}
	private static int dfs(int idx, int a, int b, String path) {
		if(idx == len){
			ans = path;
			return 1;
		}
		if(dp[idx][a][b] != -1) return dp[idx][a][b];
		dp[idx][a][b] = 1;
		
		if(a < len1 && ch[idx] == ch1[a])
			dfs(idx + 1, a + 1, b, path + "1");
		
		if(b < len2 && ch[idx] == ch2[b])
			dfs(idx + 1, a, b + 1, path + "2");
		
		return 1;
	}
}