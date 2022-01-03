import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	ArrayList<Integer> aly = new ArrayList<>();
    	boolean[] chk = new boolean[10001];
    	
    	for(int i = 2; i <= 10000; i++) {
    		if(chk[i]) continue;
    		aly.add(i);
    		
    		for(int j = i + i; j <= 10000; j+=i) chk[j] = true;
    	}
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for(int i = 0; i < aly.size() - 1; i++)
    		pq.offer(aly.get(i) * aly.get(i + 1));
    	
    	while(!pq.isEmpty()) {
    		int x = pq.poll();
    		
    		if(x > N) {
    			System.out.println(x);
    			return;
    		}
    	}
    }
}