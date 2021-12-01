import java.util.*;

public class Main {
	static int N, X, Y;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int M = sc.nextInt();
    	X = sc.nextInt();
    	Y = sc.nextInt();
    	aly = new ArrayList[N + 1];
    	
    	for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
    	
    	while(--M >= 0) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		aly[a].add(b);
    		aly[b].add(a);
    	}
    	
    	solve();
    }
	private static void solve() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] chk = new boolean[N + 1];
		q.offer(X);
		int time = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				if(time == Y) {
					if(!pq.contains(x)) pq.offer(x);
					continue;
				}
				
				for(int next : aly[x])
					if(!chk[next])
						chk[next] = true;
			}
			
			for(int i = 1; i <= N; i++)
				if(chk[i]) {
					chk[i] = false;
					q.offer(i);
				}
			++time;
			if(time > Y) break;
		}
		
		if(time < Y) System.out.println(-1);
		else {
			while(!pq.isEmpty()) System.out.print(pq.poll() + " ");
		}
	}
}