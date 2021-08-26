import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	PriorityQueue<Long> pq = new PriorityQueue<>();
    	
    	long cur = sc.nextLong();
    	for(int i = 1; i < N; i++) pq.offer(sc.nextLong());
    	
    	while(!pq.isEmpty()) {
    		if(cur > pq.peek()) cur += pq.poll();
    		else break;
    	}
    	
    	if(pq.isEmpty()) System.out.println("Yes");
    	else System.out.println("No");
	}
}