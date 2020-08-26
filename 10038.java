import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr1, arr2, arr3;
	static int[][] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr1 = new ArrayList[N+1];
		arr2 = new ArrayList[N+1];
		arr3 = new ArrayList[N+1];
		dist = new int[3][N+1];
		
		for(int i = 1; i <= N; i++){
			arr1[i] = new ArrayList<>();
			arr2[i] = new ArrayList<>();
			arr3[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < 3; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		int M = sc.nextInt();
		while(--M >= 0){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr1[y].add(new Pair(x, a));
			arr2[y].add(new Pair(x, b));
		}
		
		find(0, N, arr1);
		find(1, N, arr2);
		
		for(int i = 1; i <= N; i++){
			for(int j = 0; j < arr1[i].size(); j++){
				Pair p1 = arr1[i].get(j);
				Pair p2 = arr2[i].get(j);
				int u = 0;
				
				if(dist[0][p1.v] - dist[0][i] != p1.cost) ++u;
				if(dist[1][p2.v] - dist[1][i] != p2.cost) ++u;
				
				arr3[p1.v].add(new Pair(i, u));
			}
		}
		
		find(2, 1, arr3);
		System.out.println(dist[2][N]);
	}
	private static void find(int idx, int start, ArrayList<Pair>[] arr) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(start, 0));
		dist[idx][start] = 0;
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(Pair next : arr[p.v])
					if(dist[idx][next.v] > p.cost + next.cost){
						dist[idx][next.v] = p.cost + next.cost;
						q.offer(new Pair(next.v, dist[idx][next.v]));
					}
			}
		}
	}
}
class Pair{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
}