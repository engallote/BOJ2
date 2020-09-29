import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static long[] dp = new long[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		Arrays.fill(dp, 1);
		for(int i = 2; i <= 1000000; i++) {
			for(int j = 1;; j++) {
				if(i * j > 1000000) break;
				dp[i * j] += i;
			}
			dp[i] += dp[i-1];
		}
		
		while(--T >= 0) {
			N = Integer.parseInt(br.readLine());
			
			bw.write(dp[N]+"\n");
		}
		bw.flush();
	}
}