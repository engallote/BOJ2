import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr;
	static int[] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int M = sc.nextInt();
    	int X = sc.nextInt();
    	arr = new ArrayList[N + 1];
    	chk = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		arr[i] = new ArrayList<>();
    		chk[i] = Integer.MAX_VALUE;
    	}
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int c = sc.nextInt();
    		
    		arr[a].add(new Pair(b, c));
    		arr[b].add(new Pair(a, c));
    	}
    	
    	bfs(X);
    	
    	int res = 0;
    	for(int i = 1; i <= N; i++)
    		res = Math.max(res, chk[i]);
    	
    	System.out.println(res * 2);
	}
	private static void bfs(int x) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, 0));
		chk[x] = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(Pair next : arr[p.v])
					if(chk[next.v] > next.d + p.d) {
						chk[next.v] = next.d + p.d;
						q.offer(new Pair(next.v, chk[next.v]));
					}
			}
		}
	}
}
class Pair {
	int v, d;
	Pair(int v, int d) {
		this.v = v;
		this.d = d;
	}
}