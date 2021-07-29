import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int X = sc.nextInt();
    	int[] arr = new int[N];
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = sc.nextInt();
    	
    	int l = 1, r = N, mid, res = r;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
    		pq.clear();
    		int max = 0;
    		
    		for(int i = 0; i < N; i++) {
    			if(pq.size() + 1 <= mid) {
    				pq.offer(arr[i]);
    				max = Math.max(max, arr[i]);
    				continue;
    			}
    			int num = pq.poll();
    			max = Math.max(max, arr[i] + num);
    			pq.offer(num + arr[i]);
    		}
    		
    		if(max > X) l = mid + 1;
    		else {
    			r = mid - 1;
    			res = Math.min(res, mid);
    		}
    	}
    	
    	System.out.println(res);
	}
}