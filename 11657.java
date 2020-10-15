import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long INF = Integer.MAX_VALUE;
		ArrayList<Pair>[] arr = new ArrayList[N + 1];
		long[] dist = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
			if(i > 1) dist[i] = INF;
		}
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			arr[a].add(new Pair(b, c));
		}
		
		for(int t = 1; t <= N; t++) {
			for(int i = 1; i <= N; i++)
				for(Pair next : arr[i])
					if(dist[i] != INF && dist[next.v] > dist[i] + next.cost) {
						dist[next.v] = dist[i] + next.cost;
						if(t == N) {
							System.out.println(-1);
							return;
						}
					}
		}
		
		for(int i = 2; i <= N; i++)
			System.out.println(dist[i] != INF ? dist[i] : -1);
	}
}
class Pair {
	int v;
	long cost;
	Pair(int v, long cost) {
		this.v = v;
		this.cost = cost;
	}
}