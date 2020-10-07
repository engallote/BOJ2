import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Pair>[] arr;
	static int[] chk, par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new ArrayList[N + 1];
		chk = new int[N + 1];
		par = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		int ori = bfs();
		int e = N, res = 0;
		while(par[e] != 0) {
			int s = par[e];
			
			for(int i = 0; i < arr[s].size(); i++)
				if(arr[s].get(i).v == e) {
					int tmp = arr[s].get(i).cost;
					arr[s].get(i).cost *= 2;
					
					res = Math.max(res, bfs());
					
					arr[s].get(i).cost = tmp;
					break;
				}
			
			e = s;
		}
		System.out.println(res - ori);
	}
	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		Arrays.fill(chk, 1000000000);
		chk[1] = 0;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(Pair next : arr[x])
				if(chk[next.v] > chk[x] + next.cost) {
					chk[next.v] = chk[x] + next.cost;
					q.offer(next.v);
					par[next.v] = x;
				}
		}
		
		return chk[N];
	}
}
class Pair{
	int v, cost;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}