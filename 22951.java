import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	Queue<Pair> q = new LinkedList<>();
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < K; j++)
    			q.offer(new Pair(i + 1, sc.nextInt()));
    	
    	Pair cur = q.poll();
    	int cnt = cur.num - 1;
    	
    	if(q.isEmpty()) {
    		System.out.println(cur.idx + " " + cur.num);
    		return;
    	}
    	
    	while(q.size() > 1) {
    		Pair p = q.poll();
    		
    		if(cnt <= 0) {
    			cur = p;
    			cnt = p.num;
    		}
    		else q.offer(p);
    		cnt -= 1;
    	}
    	
    	System.out.println(q.peek().idx + " " + q.peek().num);
	}
}
class Pair {
	int idx, num;
	Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}