import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[] par, candy;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		par = new int[N + 1];
		candy = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			par[i] = -1;
			candy[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int ap = find(a), bp = find(b);
			if(ap == bp) continue;
			
			if(ap > bp) {
				int tmp = ap;
				ap = bp;
				bp = tmp;
			}
			
			par[ap] += par[bp];
			candy[ap] += candy[bp];
			par[bp] = ap;
		}
		
		ArrayList<Pair> arr = new ArrayList<>();
		int[] dp = new int[3001];
		
		for(int i = 1; i <= N; i++)
			if(par[i] < 0)
				arr.add(new Pair(candy[i], -par[i]));
			
		for(int i = 0; i < arr.size(); i++)
			for(int j = K - 1; j >= arr.get(i).w; j--)
				dp[j] = Math.max(dp[j], dp[j - arr.get(i).w] + arr.get(i).v);
		
		int res = 0;
		for(int i = 1; i < K; i++)
			res = Math.max(res, dp[i]);
		
		bw.write(res+"");
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] < 0) return x;
		return par[x] = find(par[x]);
	}
}
class Pair{
	int v, w;
	Pair(int v, int w){
		this.v = v;
		this.w = w;
	}
}