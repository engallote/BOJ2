import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++)
    		pq.offer(new Pair(sc.nextInt(), sc.nextInt()));
    	
    	int s = pq.peek().s, e = pq.poll().e, res = 0;
    	
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		
    		if(e < p.s) {//선분이 중간에 끊어짐
    			res += e - s;
    			s = p.s;
    			e = p.e;
    		}
    		else if(p.e <= e) {//이미 그어진 선분 위
    			continue;
    		}
    		else {
    			s = Math.min(s, p.s);
    			e = p.e;
    		}
    	}
    	
    	res += e - s;
    	
    	System.out.println(res);
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
		else if(o.s == this.s) return Integer.compare(o.e, this.e);
		return 1;
	}
}