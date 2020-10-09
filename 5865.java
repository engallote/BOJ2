import java.util.*;

public class Main {
	static int N, M, X;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();
        arr = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int l = sc.nextInt();
        	int c = sc.nextInt();
        	arr[a].add(new Pair(b, l, c));
        	arr[b].add(new Pair(a, l, c));
        }
        
        dijk();
    }
	private static void dijk() {
		double[] chk = new double[N + 1];
		Arrays.fill(chk, Double.MAX_VALUE);
		chk[1] = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(1, 0, 1000000));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(p.v == N) continue;
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > next.l + p.l + (X / Math.min(p.c, next.c))) {
					chk[next.v] = next.l + p.l + (X / Math.min(p.c, next.c));
					q.offer(new Pair(next.v, next.l + p.l, Math.min(p.c, next.c)));
				}
		}
		
		System.out.println((int)chk[N]);
	}
}
class Pair{
	int v, l, c;
	Pair(int v, int l, int c){
		this.v = v;
		this.l = l;
		this.c = c;
	}
}