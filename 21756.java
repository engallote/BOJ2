import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	Queue<Integer> q = new LinkedList<>(), wait = new LinkedList<>();
    	
    	for(int i = 1; i <= N; i++)
    		q.offer(i);
    	
    	int sw = 1;
    	while(q.size() > 1) {
    		sw = 1;
    		while(!q.isEmpty()) {
    			if(sw == 1) q.poll();
    			else wait.offer(q.poll());
    			sw *= -1;
    		}
    		
    		q.addAll(wait);
    		wait.clear();
    	}
    	
    	System.out.println(q.poll());
	}
}