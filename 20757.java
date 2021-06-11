import java.util.*;

public class Main {
	static int[] par;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	while(--T >= 0) {
    		int N = sc.nextInt();
    		int[][] arr = new int[N][N];
    		Queue<Pair> q = new LinkedList<>();
    		par = new int[N];
    		
    		for(int i = 0; i < N; i++) {
    			par[i] = i;
    			for(int j = 0; j < N; j++) {
    				arr[i][j] = sc.nextInt();
    				if(arr[i][j] == 1) q.offer(new Pair(i, j));
    			}
    		}
    		
    		if(N == 1) {
    			System.out.println(0);
    			continue;
    		}
    		
    		int res = 0;
    		while(!q.isEmpty()) {
    			Pair p = q.poll();
    			
    			int ap = find(p.a), bp = find(p.b);
    			
    			if(ap == bp) continue;
    			par[bp] = ap;
    			++res;
    		}
    		
    		System.out.println(res); 
    	}
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair {
	int a, b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}