import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	HashSet<Integer> hs = new HashSet<>();
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++) {
    		int num = sc.nextInt();
    		hs.add(num);
    		pq.offer(num);
    	}
    	
    	if(hs.size() == N) {
    		System.out.println(N);
    		return;
    	}
    	
    	boolean flag = true;
    	while(flag) {
    		flag = false;
    		hs.clear();
    		while(!pq.isEmpty()) {
    			int num = pq.poll();
    			
    			while(hs.contains(num)) {
    				int sum = num * 2;
    				hs.remove(num);
    				
    				num = sum;
    				flag = true;
    			}
    			
    			hs.add(num);
    		}
    		
    		Iterator<Integer> it = hs.iterator();
    		while(it.hasNext()) {
    			int key = it.next();
    			
    			pq.offer(key);
    		}
    	}
    	
    	System.out.println(hs.size());
	}
}