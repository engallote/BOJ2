import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(--T >= 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int seed = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			par = new int[N];
			
			for(int i = 0; i < N; i++)
				par[i] = i;
			
			int e = seed % (N * N);
			int x = e / N;
			int y = e % N;
			int cnt = 0;
			int res = 0;
			int ap = find(x), bp = find(y);
			if(ap != bp) {
				par[bp] = ap;
				cnt = 1;
			}
			
			if(N == 2) {
				if(cnt == 1) bw.write("1\n");
				else bw.write("0\n");
				continue;
			}
			
			for(int i = 1; i <= N * N; i++) {
				e = (int)(((long)e * (long)A + (long)B) % ((long)N * (long)N));
				x = e / N;
				y = e % N;
				
				ap = find(x);
				bp = find(y);
				
				if(ap == bp) continue;
				++cnt;
				par[bp] = ap;
				
				if(cnt == N - 1) {
					res = i + 1;
					break;
				}
			}
			
			bw.write(res+"\n");
		}
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}