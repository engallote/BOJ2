import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	PriorityQueue<Integer> pre = new PriorityQueue<>(Collections.reverseOrder());
    	for(int i = 0; i < N; i++)
    		pre.offer(sc.nextInt());
    	
    	boolean flag = true;
    	for(int i = 0; i < M; i++) {
    		int num = sc.nextInt();
    		
    		if(!flag) continue;
    		
    		if(!pre.isEmpty()) {
    			int p = pre.poll();
    			
    			if(p >= num) p -= num;
    			else {
    				flag = false;
    				continue;
    			}
    			
    			if(p > 0) pre.offer(p);
    		}
    		else {
    			flag = false;
				continue;
    		}
    	}
    	
    	System.out.println(flag ? 1 : 0);
    }
}