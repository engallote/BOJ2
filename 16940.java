import java.util.*;

public class Main {
	static int N;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	ArrayList<Integer>[] arr = new ArrayList[N + 1];
    	boolean[] chk = new boolean[N + 1];
    	int[] ans = new int[N];
    	
    	for(int i = 1; i <= N; i++)
    		arr[i] = new ArrayList<>();
    	
    	for(int i = 0; i < N - 1; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		arr[b].add(a);
    		arr[a].add(b);
    	}
    	
    	for(int i = 0; i < N; i++)
    		ans[i] = sc.nextInt();
    	
    	if(ans[0] != 1) {
    		System.out.println(0);
    		return;
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(1);
    	int idx = 1;
    	HashSet<Integer> hs = new HashSet<>();
    	hs.add(1);
    	chk[1] = true;
    	
    	while(!q.isEmpty()) {
    		int x = q.poll();
    		int size = 0;
    		
    		for(int next : arr[x])
    			if(!chk[next]) {
    				hs.add(next);
    				chk[next] = true;
    				++size;
    			}
    		
    		for(int i = idx; i < idx + size; i++) {
    			if(!hs.contains(ans[i])) {
    				System.out.println(0);
    				return;
    			}
    			else q.offer(ans[i]);
    		}
    		idx += size;
    	}
    	
    	System.out.println(1);
	}
}