import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		Pair[] arr = new Pair[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(a, b);
		}
		
		Arrays.sort(arr);
		dp[N] = Integer.MAX_VALUE;
		
		for(int i = N - 1; i>= 0; i--)
			dp[i] = Math.min(dp[i + 1], (long)arr[i].a);
		
		int maxIdx = 0;
		long sum = 0;
		for(int i = 0; i < N; i++) {
			if(arr[maxIdx].b - arr[maxIdx].a < arr[i].b - arr[i].a) maxIdx = i;
			sum += arr[i].b;
			long min = Math.min(sum - arr[maxIdx].b + arr[maxIdx].a, sum - arr[i].b + dp[i]);
			bw.write(min+"\n");
		}
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int a, b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		return this.b - o.b;
	}
}