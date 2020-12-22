import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, A, B, K;
	static ArrayList<Pair>[] arr;
	static long[][] cost;
	static long[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new ArrayList[200101];
		cost = new long[101][M];
		
		int[][] path = new int[M][2];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			path[i][0] = a;
			path[i][1] = b;
			cost[0][i] = c;
		}
		
		K = Integer.parseInt(br.readLine());
		
		chk = new long[200101];
		Arrays.fill(chk, Long.MAX_VALUE);
		
		for(int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				cost[i][j] = Long.parseLong(st.nextToken());
		}
		
		for(int i = 1; i <= 200100; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++)
			for(int j = 0; j <= K; j++) {
				arr[path[i][0] * 200 + j].add(new Pair(path[i][1] * 200 + j, cost[j][i]));
				arr[path[i][1] * 200 + j].add(new Pair(path[i][0] * 200 + j, cost[j][i]));
			}
		
		
		bw.write(bfs()+"");
		bw.flush();
	}
	private static long bfs() {
		long ret = Long.MAX_VALUE;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(A * 200, 0));
		chk[A * 200] = 0;
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(chk[p.v] < p.cost) continue;
			
			int k = p.v % 200;
			
			if(k + 1 <= K && chk[p.v + 1] > p.cost) {
				chk[p.v + 1] = p.cost;
				pq.offer(new Pair(p.v + 1, p.cost));
			}
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > p.cost + next.cost) {
					chk[next.v] = p.cost + next.cost;
					pq.offer(new Pair(next.v, p.cost + next.cost));
				}
		}
		
		for(int i = 0; i <= K; i++)
			ret = Math.min(ret, chk[B * 200 + i]);
		
		return ret;
	}
}
class Pair implements Comparable<Pair>{
	int v;
	long cost;
	Pair(int v, long cost) {
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cost > this.cost) return -1;
		else if(o.cost == this.cost) return 0;
		else return 1;
	}
}