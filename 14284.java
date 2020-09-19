import java.util.*;

public class Main {
	static int N, M;
	static int[] dist;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dist = new int[N+1];
        arr = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++){
        	arr[i] = new ArrayList<>();
        	dist[i] = 1000000000;
        }
        
        for(int i = 0; i < M; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	
        	arr[a].add(new Pair(b, c));
        	arr[b].add(new Pair(a, c));
        }
        
        int s = sc.nextInt();
        int e = sc.nextInt();
        dist[s] = 0;
        
        System.out.println(bfs(s, e));;
    }
	private static int bfs(int s, int e) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(s, 0));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.v == e) return p.cost;
			
			for(Pair next : arr[p.v])
				if(dist[next.v] > p.cost + next.cost){
					dist[next.v] = p.cost + next.cost;
					pq.offer(new Pair(next.v, dist[next.v]));
				}
		}
		
		return 0;
	}
}
class Pair implements Comparable<Pair>{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}