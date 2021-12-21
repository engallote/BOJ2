import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	long[] arr = new long[N];
    	PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
    	long res = 0;
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.nextLong();
    		if(i > 0) pq.offer(arr[i] - arr[i - 1] - 1);
    	}
    	
    	res = arr[N - 1] + 1 - arr[0];
    	
    	while(--K > 0) res -= pq.poll();
    	
    	System.out.println(res);    	
    }
}