import java.util.*;

public class Main {
	static int N, M, K;
	static int[] chk1, chk2;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new ArrayList[N+1];
		chk1 = new int[N+1];
		chk2 = new int[N+1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			chk1[i] = Integer.MAX_VALUE;
			chk2[i] = Integer.MAX_VALUE;
		}
		
		chk1[1] = 0;
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i = 0; i < K; i++){
			int num = sc.nextInt();
			q.offer(new Pair(num, 0));
			chk2[num] = 0;
		}
		
		b_bfs();
		k_bfs(q);
		
		boolean flag = false;
		for(int i = 2; i <= N; i++){
			if(chk1[i] < chk2[i]){
				flag = true;
				System.out.print(i + " ");
			}
		}
		if(!flag) System.out.println(0);
	}
	private static void k_bfs(Queue<Pair> q) {
		int size;
		while(!q.isEmpty()){
			size = q.size();
			
			while(--size >= 0){
				Pair p = q.poll();
				
				for(Pair next : arr[p.v])
					if(chk2[next.v] > p.t + next.t){
						chk2[next.v] = p.t + next.t;
						q.offer(new Pair(next.v, chk2[next.v]));
					}
			}
		}
	}
	private static void b_bfs() {
		int size;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(1, 0));
		
		while(!q.isEmpty()){
			size = q.size();
			
			while(--size >= 0){
				Pair p = q.poll();
				
				for(Pair next : arr[p.v])
					if(chk1[next.v] > p.t + next.t){
						chk1[next.v] = p.t + next.t;
						q.offer(new Pair(next.v, chk1[next.v]));
					}
			}
		}
	}
}
class Pair{
	int v, t;
	Pair(int v, int t){
		this.v = v;
		this.t = t;
	}
}