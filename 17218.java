import java.util.*;

public class Main {
	static int len1, len2;
	static char[] ch1, ch2;
	static String[][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ch1 = sc.next().toCharArray();
        ch2 = sc.next().toCharArray();
        
        len1 = ch1.length;
        len2 = ch2.length;
        
        dp = new String[len1][len2];
        
        for(int i = 0; i < len1; i++)
        	Arrays.fill(dp[i], "");
        
        String res = solve(0, 0);
        
        StringBuilder ans = new StringBuilder();
        ans.append(res);
        ans.reverse();
        
        System.out.println(ans.toString());
    }
	private static String solve(int idx1, int idx2) {
		if(idx1 >= len1 || idx2 >= len2) return "";
		if(dp[idx1][idx2].length() > 0) return dp[idx1][idx2];
		
		String ret = "", ret1 = "", ret2 = "";
		
		if(ch1[idx1] == ch2[idx2]) 
			ret = solve(idx1 + 1, idx2 + 1) + ch1[idx1] + "";
		ret1 = solve(idx1 + 1, idx2);
		ret2 = solve(idx1, idx2 + 1);
		
		String ret3 = "";
		if(ret.length() > ret3.length()) ret3 = ret;
		if(ret1.length() > ret3.length()) ret3 = ret1;
		if(ret2.length() > ret3.length()) ret3 = ret2;
		
		return dp[idx1][idx2] = ret3;
	}
}