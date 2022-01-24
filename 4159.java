import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		int N = sc.nextInt();
    		
    		if(N == 0) break;
    		
    		int[] arr = new int[N + 1];
    		arr[N] = 1422;
    		
    		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    		Arrays.sort(arr);
    		PriorityQueue<Integer> pq = new PriorityQueue<>();
    		
    		for(int i = 1; i <= N; i++) {
    			if(i == N) pq.offer((arr[i] - arr[i - 1]) * 2);
    			else pq.offer(arr[i] - arr[i - 1]);
    		}
    		boolean flag = true;
    		while(!pq.isEmpty())
    			if(pq.poll() > 200) {
    				flag = false;
    				break;
    			}
    		
    		System.out.println(flag ? "POSSIBLE" : "IMPOSSIBLE");
    	}
    }
}