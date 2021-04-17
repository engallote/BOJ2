import java.util.*;

public class Main {
	static int N, M;
	static int[] go;
	static int[] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	go = new int[101];
    	chk = new int[101];
    	
    	Arrays.fill(chk, Integer.MAX_VALUE);
    	
    	for(int i = 0; i < N; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		go[a] = b;
    	}
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		go[a] = b;
    	}
    	
    	solve();
	}
	private static void solve() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		chk[1] = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				if(x == 100) {
					System.out.println(chk[x]);
					return;
				}
				
				for(int i = 1; i <= 6; i++) {
					int next = x + i;
					if(next <= 100) {
						if(go[next] == 0 && chk[next] > chk[x] + 1) {
							chk[next] = chk[x] + 1;
							q.offer(next);
						}
						else if(go[next] != 0 && chk[go[next]] > chk[x] + 1) {
							chk[go[next]] = chk[x] + 1;
							q.offer(go[next]);
						}
					}
				}
			}
		}
		
	}
}