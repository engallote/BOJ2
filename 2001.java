import java.util.*;

public class Main {
	static int N, M, K, res;
	static int[] juw;
	static ArrayList<Pair>[] arr;
	static boolean[][] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	K = sc.nextInt();
    	juw = new int[N + 1];
    	arr = new ArrayList[N + 1];
    	chk = new boolean[N + 1][1 << (K + 1)];
    	res = 0;
    	
    	for(int i = 1; i <= N; i++)
    		arr[i] = new ArrayList<>();
    	
    	Arrays.fill(juw, -1);
    	for(int i = 0; i < K; i++)
    		juw[sc.nextInt()] = i;
    		
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int c = sc.nextInt();
    		
    		arr[a].add(new Pair(b, c));
    		arr[b].add(new Pair(a, c));
    	}
    	arr[1].add(new Pair(1, K));
    	
    	solve(1, 0, 0);
    	System.out.println(res);
	}
	private static void solve(int idx, int sum, int visit) {
		if(chk[idx][visit]) return;
		chk[idx][visit] = true;
		if(idx == 1) res = Math.max(res, sum);
		
		for(Pair next : arr[idx]) {
			if(!chk[next.v][visit] && next.w >= sum) 
				solve(next.v, sum, visit);
			
			if(juw[next.v] >= 0 && (visit&(1<<juw[next.v])) == 0 && next.w >= sum + 1) 
				solve(next.v, sum + 1, visit | (1<<juw[next.v]));
		}
	}
}
class Pair {
	int v, w;
	Pair(int v, int w) {
		this.v = v;
		this.w = w;
	}
}