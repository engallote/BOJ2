import java.util.*;

public class Main {
	static int N, M;
	static int[] par;
	static long[] chk;
	static String path = "";
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		chk = new long[N+1];
		par = new int[N+1];
		arr = new ArrayList[N+1];
		
		Arrays.fill(chk, Long.MAX_VALUE);
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		chk[1] = 0;
		findPath();
		int idx = N;
		long res = Long.MIN_VALUE;
		
		while(true){
			Arrays.fill(chk, Long.MAX_VALUE);
			chk[1] = 0;
			bfs(par[idx], idx);
			res = Math.max(res, chk[N]);
			idx = par[idx];
			if(idx <= 1) break;
		}
		
		System.out.println(res);
	}
	private static void bfs(int nx, int ny) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(1, 0));
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(p.v == N) return;
			
			for(Pair next : arr[p.v]){
				if((p.v == nx && next.v == ny) || (p.v == ny && next.v == nx)) //양방향 도로 파괴
					continue;
				if(chk[next.v] > p.cost + next.cost){
					chk[next.v] = p.cost + next.cost;
					q.offer(new Pair(next.v, chk[next.v]));
				}
			}
		}
	}
	private static void findPath() {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(1, 0));
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(p.v == N) return;
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > p.cost + next.cost){
					chk[next.v] = p.cost + next.cost;
					par[next.v] = p.v;
					q.offer(new Pair(next.v, chk[next.v]));
				}
		}
	}
}
class Pair implements Comparable<Pair>{
	int v;
	long cost;
	Pair(int v, long cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}