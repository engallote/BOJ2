import java.util.*;

public class Main {
	static int N, M, t;
	static ArrayList<Pair>[] arr;
	static int[] chk, chk2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new ArrayList[N+1];
		chk = new int[N+1];
		chk2 = new int[N+1];
		
		Arrays.fill(chk, Integer.MAX_VALUE);
		Arrays.fill(chk2, Integer.MAX_VALUE);
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			arr[a].add(new Pair(b, c, d, e));
		}
		
		bfs();
	}
	private static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0, 1));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.v == N){
				System.out.println(p.cost + " " + p.cnt);
				return;
			}
			
			for(Pair next : arr[p.v]){
				int cost = next.c;
				if(next.e - 10 > 0) cost += (next.e - 10) * next.d;
				cost += p.cost;
				
				if(chk[next.v] > cost || (chk[next.v] == cost && chk2[next.v] > p.cnt + 1)){
					chk[next.v] = cost;
					chk2[next.v] = p.cnt + 1;
					pq.offer(new Pair(next.v, chk[next.v], p.cnt + 1));
				}
			}
		}
		
		System.out.println("It is not a great way.");
	}
}
class Pair implements Comparable<Pair>{
	int v, cost, c, d, e, cnt;
	Pair(int v, int cost, int cnt){
		this.v = v;
		this.cost = cost;
		this.cnt = cnt;
	}
	Pair(int v, int c, int d, int e){
		this.v = v;
		this.c = c;
		this.d = d;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cost > this.cost) return -1;
		else if(o.cost == this.cost){
			if(o.cnt > this.cnt) return -1;
			else if(o.cnt == this.cnt) return 0;
			else return 1;
		}
		else return 1;
	}
}