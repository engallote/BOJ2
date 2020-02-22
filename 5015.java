import java.util.*;

public class Main {
	static int N, len1, len2;
	static char[] order;
	static char[] ch;
	static int[][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        order = sc.next().toCharArray();
        N = sc.nextInt();
        len1 = order.length;
        
        for(int i = 0; i < N; i++){
        	ch = sc.next().toCharArray();
        	len2 = ch.length;
        	dp = new int[len1][len2];
        	
        	for(int ii = 0; ii < len1; ii++)
        		Arrays.fill(dp[ii], -1);
        	
        	int res = isMatch(0, 0);
        	
        	if(res > 0) 
        		System.out.println(new String(ch));
        }
    }
	private static int isMatch(int idx1, int idx2) {
		if(idx1 >= len1 && idx2 >= len2) return 1;
		if(idx1 >= len1) return 0;
		if(idx2 >= len2) {
			if(idx1 == len1 - 1 && order[idx1] == '*') return 1;
			else return 0;
		}
		if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
		int ret = 0;
		
		if(order[idx1] == ch[idx2]) ret = Math.max(ret, isMatch(idx1 + 1, idx2 + 1));
		if(order[idx1] == '*') {
			if(idx1 + 1 < len1){
				for(int i = idx2; i < len2; i++)
					if(ch[i] == order[idx1+1])
						ret = Math.max(ret, isMatch(idx1 + 2, i + 1));
			}
			else return dp[idx1][idx2] = 1;
		}
		
		return dp[idx1][idx2] = ret;
	}
}