import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		pq.offer(new Pair(Math.min(x, y), Math.max(x, y)));
    	}
    	
    	int ps = 0, pe = Integer.MIN_VALUE + 1;
    	long res = 0;
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		
    		if(pe < p.a) res += (long)Math.abs(p.b - p.a);
    		else if(p.a <= pe && pe < p.b) res += (long)Math.abs(p.b - pe);
			
    		ps = p.a;
			pe = Math.max(pe, p.b);
    	}
    	
    	System.out.println(res);
    }
}
class Pair implements Comparable<Pair> {
	int a, b;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.a < o.a) return -1;
		else if(this.a == o.a) return Integer.compare(o.b, this.b);
		else return 1;
	}
}