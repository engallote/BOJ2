import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] aly;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int Q = sc.nextInt();
    	aly = new ArrayList[N + 1];
    	
    	for(int i = 1; i <= N; i++)
    		aly[i] = new ArrayList<>();
    	
    	for(int i = 0; i < N - 1; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int k = sc.nextInt();
    		aly[a].add(new Pair(b, k));
    		aly[b].add(new Pair(a, k));
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	boolean[] chk = new boolean[N + 1];
    	int res = 0;
    	while(--Q >= 0) {
    		int k = sc.nextInt();
    		int v = sc.nextInt();
    		q.clear();
    		Arrays.fill(chk, false);
    		res = 0;
    		
    		q.offer(v);
    		chk[v] = true;
    		
    		while(!q.isEmpty()) {
    			int x = q.poll();
    			
    			for(Pair next : aly[x])
    				if(next.k >= k && !chk[next.v]) {
    					chk[next.v] = true;
    					++res;
    					q.offer(next.v);
    				}
    		}
    		
    		System.out.println(res);
    	}
	}
}
class Pair {
	int v, k;
	Pair(int v, int k) {
		this.v = v;
		this.k = k;
	}
}