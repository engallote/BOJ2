import java.util.*;

public class Main {
	static int N, cycle;
	static int[] chk;
	static boolean[] finish;
	static ArrayList<Integer>[] aly;
	static Queue<Integer> q;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	chk = new int[N + 1];
    	finish = new boolean[N + 1];
    	aly = new ArrayList[N + 1];
    	q = new LinkedList<>();
    	
    	for(int i = 1; i <= N; i++) {
    		aly[i] = new ArrayList<>();
    		chk[i] = Integer.MAX_VALUE;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		aly[a].add(b);
    		aly[b].add(a);
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		Arrays.fill(finish, false);
    		cycle = 0;
    		findCycle(i, i, 0);
    		
    		if(cycle == 1) {
    			chk[i] = 0;
    			q.offer(i);
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(--size >= 0) {
    			int x = q.poll();
    			
    			for(int next : aly[x])
    				if(chk[next] > chk[x] + 1) {
    					chk[next] = chk[x] + 1;
    					q.offer(next);
    				}
    		}
    	}
    	
    	for(int i = 1; i <= N; i++)
    		System.out.print(chk[i] + " ");
	}
	private static void findCycle(int idx, int p, int cnt) {
		if(cycle == 1) return;
		if(idx == p && cnt >= 2) {
			cycle = 1;
			return;
		}
		finish[idx] = true;
		for(int i = 0; i < aly[idx].size(); i++) {
			int next = aly[idx].get(i);
			
			if(!finish[next])
				findCycle(next, p, cnt + 1);
			else {
				if(next == p && cnt >= 2) findCycle(next, p, cnt);
			}
		}
	}
}