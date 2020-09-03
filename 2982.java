import java.util.*;

public class Main {
	static int N, K;
	static int[] path, dist;
	static int[][] in, out;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int s = sc.nextInt();//출발
		int e = sc.nextInt();//도착
		K =sc.nextInt();//시간차
		int G = sc.nextInt();//방문하는 교차로 수
		
		arr = new ArrayList[N+1];
		path = new int[G];
		dist = new int[N+1];//상근이가 가는 거리
		in = new int[N+1][N+1];
		out = new int[N+1][N+1];
		
		for(int i = 0; i < G; i++)
			path[i] = sc.nextInt();
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		while(--M >= 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		//고둘라 움직임
		int d = 0;
		for(int i = 0; i < G - 1; i++){
			for(Pair p : arr[path[i]])
				if(p.v == path[i+1]){
					in[path[i]][path[i+1]] = d;
					in[path[i+1]][path[i]] = d;
					d += p.d;
					out[path[i+1]][path[i]] = d;
					out[path[i]][path[i+1]] = d;
					break;
				}
		}
		
		//상근이 움직임
		bfs(s, e);
	}
	private static void bfs(int s, int e) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(s, K));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.v == e){
				System.out.println(p.d - K);
				return;
			}
			if(dist[p.v] <= p.d) continue;
			dist[p.v] = p.d;
			
			for(Pair next : arr[p.v]){
				int d = p.d;
				
				if(in[p.v][next.v] <= d && d < out[p.v][next.v]) d = out[p.v][next.v] + next.d;
				else d += next.d;
				
				if(dist[next.v] > d) pq.offer(new Pair(next.v, d));
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int v, d;
	Pair(int v, int d){
		this.v = v;
		this.d = d;
	}
	@Override
	public int compareTo(Pair o) {
		return o.d > this.d ? -1 : (o.d == this.d ? 0 : 1);
	}
}