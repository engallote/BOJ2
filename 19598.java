import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	int[] arr = new int[100000];
    	
    	for(int i = 0; i < N; i++) {
    		int s = sc.nextInt();
    		int e = sc.nextInt();
    		pq.offer(new Pair(s, e));
    	}
    	
    	int idx = 0;
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		boolean flag = false;
    		
    		for(int i = 0; i <= idx; i++) {
    			if(arr[i] <= p.s) {
    				flag = true;
    				arr[i] = p.e;
    				break;
    			}
    		}
    		
    		if(!flag) {
    			idx += 1;
    			arr[idx] = p.e;
    		}
    	}
    	
    	System.out.println(idx + 1);
	}
}
class Pair implements Comparable<Pair> {
	int s, e;
	Pair(int s, int e) {
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return -1;
		else if(o.s == this.s) return Integer.compare(this.e, o.e);
		else return 1;
	}
}