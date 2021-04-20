import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static int[] plus, cost;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new ArrayList[N + 1];
    	plus = new int[N + 1];
    	cost = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		arr[i] = new ArrayList<>();
    		int num = sc.nextInt();
    		if(num == -1) continue;
    		arr[num].add(i);
    	}
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int w = sc.nextInt();
    		plus[a] += w;
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	boolean[] chk = new boolean[N + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		if(plus[i] == 0) continue;
    		Arrays.fill(chk, false);
    		q.clear();
    		q.offer(i);
    		chk[i] = true;
    		int sum = plus[i];
    		cost[i] += sum;
    		
    		while(!q.isEmpty()) {
    			int size = q.size();
    			while(--size >= 0) {
    				int x = q.poll();
    				
    				for(int next : arr[x])
    					if(!chk[next]) {
    						chk[next] = true;
    						cost[next] += sum;
    						q.offer(next);
    					}
    			}
    		}
    	}
    	
    	for(int i = 1; i <= N; i++)
    		System.out.print(cost[i] + " ");
	}
}