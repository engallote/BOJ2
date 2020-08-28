import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, s, e;
	static ArrayList<Pair>[] arr;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		dist = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		bfs();
		int res = Integer.MAX_VALUE, sum = 0, idx = 0;
		Pair[] aly = new Pair[N+1];
		for(int i = 0; i <= N; i++){
			if(res > dist[e][i]) res = dist[e][i];
			if(dist[e][i] != Integer.MAX_VALUE) aly[idx++] = new Pair(i, dist[e][i]);
		}
		
		bw.write(res+"\n");
		
		while(--K >= 0){
			sum += Integer.parseInt(br.readLine());
			
			res = Integer.MAX_VALUE;
			for(int i = 0; i < idx; i++)
				res = Math.min(res, aly[i].v * sum + aly[i].cost);
			
			bw.write(res+"\n");
		}
		bw.flush();
	}
	private static int bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean flag = true;
		pq.offer(new Pair(s, 0, 0));
		dist[s][0] = 0;
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(dist[p.v][p.cnt] < p.cost || p.cnt + 1 >= N || p.v == e) continue;
			
			flag = false;
			for(int i = 0; i < p.cnt; i++)
				if(dist[p.v][i] < p.cost){
					flag = true;
					break;
				}
			
			if(flag) continue;
			
			for(Pair next : arr[p.v])
				if(dist[next.v][p.cnt + 1] > p.cost + next.cost){
					dist[next.v][p.cnt + 1] = p.cost + next.cost;
					pq.offer(new Pair(next.v, p.cnt + 1, p.cost + next.cost));
				}
				
		}
		
		return Integer.MAX_VALUE;
	}
}
class Pair implements Comparable<Pair>{
	int v, cost, cnt;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, int cnt, int cost){
		this.v = v;
		this.cnt = cnt;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}