import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static int[] par;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		par = new int[N + 1];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		ArrayList<Integer>[] res = new ArrayList[N + 1];
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			par[i] = i;
			res[i] = new ArrayList<>();
			
			if(i == N) break;
			
			st = new StringTokenizer(br.readLine());
			for(int j = i + 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.offer(new Pair(i, j, num));
			}
		}
		
		int cnt = 0;
		while(!pq.isEmpty() && cnt < N - 1) {
			Pair p = pq.poll();
			int ap = find(p.a), bp = find(p.b);
			
			if(ap == bp) continue;
			++cnt;
			par[bp] = ap;
			res[p.a].add(p.b);
			res[p.b].add(p.a);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(res[i]);
			bw.write(res[i].size() + " ");
			for(int next : res[i])
				bw.write(next + " ");
			bw.newLine();
		}
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int a, b, cost;
	Pair(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}
}