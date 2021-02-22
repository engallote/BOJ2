import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(--T >= 0) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			par = new int[1000000];
			
			for(int i = 0; i < 1000000; i++)
				par[i] = i;
			
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			for(int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < C - 1; j++) {
					int num = Integer.parseInt(st.nextToken());
					pq.offer(new Pair(i * 500 + j, i * 500 + j + 1, num));
				}
			}
			
			for(int i = 0; i < R - 1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < C; j++) {
					int num = Integer.parseInt(st.nextToken());
					pq.offer(new Pair(i * 500 + j, (i + 1) * 500 + j, num));
				}
			}
			
			int res = 0;
			while(!pq.isEmpty()) {
				Pair p = pq.poll();
				
				int ap = find(p.a), bp = find(p.b);
				
				if(ap == bp) continue;
				par[bp] = ap;
				res += p.c;
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
class Pair implements Comparable<Pair>{
	int a, b, c;
	Pair(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.c, o.c);
	}
}