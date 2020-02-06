import java.util.*;

public class Main {
	static int len1, len2;
	static int[][] dp;
	static char[] ch1, ch2;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ch1 = sc.next().toCharArray();
        ch2 = sc.next().toCharArray();
        
        if(ch1.length < ch2.length){
        	char[] tmp = ch1;
        	ch1 = ch2;
        	ch2 = tmp;
        }
        
        len1 = ch1.length;
        len2 = ch2.length;
        
        dp = new int[len1][len2];
        
        for(int i = 0; i < len1; i++)
        	Arrays.fill(dp[i], -1);
        
        int res = solve(0, 0);
        System.out.println(res);
    }
	private static int solve(int idx1, int idx2) {
		if(idx1 >= len1 && idx2 >= len2) return 0;
		if(idx1 >= len1) return len1-idx2;
		if(idx2 >= len2) return len1-idx1;
		if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
		int ret = 1000000000;
		
		if(ch1[idx1] == ch2[idx2]) //문자가 같음
			ret = Math.min(ret, solve(idx1 + 1, idx2 + 1));
		else{//문자가 다름
			ret = Math.min(ret, solve(idx1, idx2 + 1) + 1);//추가
			ret = Math.min(ret, solve(idx1 + 1, idx2) + 1);//삭제
			ret = Math.min(ret, solve(idx1 + 1, idx2 + 1) + 1);//치환
		}
		
		return dp[idx1][idx2] = ret;
	}
}