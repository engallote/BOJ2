import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>(), res = new PriorityQueue<>();
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		pq.offer(new Pair(s, e, c));
    	}
    	
    	int s = pq.peek().s, e = pq.peek().e, c = pq.poll().c;
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		
    		if(p.s <= e) {
    			s = Math.min(p.s, s);
    			e = Math.max(e, p.e);
    			c = Math.min(c, p.c);
    		}
    		else {
    			res.offer(new Pair(s, e, c));
    			s = p.s;
    			e = p.e;
    			c = p.c;
    		}
    	}
    	res.offer(new Pair(s, e, c));
    	
    	bw.write(res.size()+"\n");
    	while(!res.isEmpty())
    		bw.write(res.peek().s + " " + res.peek().e + " " + res.poll().c + "\n");
    	bw.flush();
    }
}
class Pair implements Comparable<Pair> {
	int s, e, c;
	Pair(int s, int e, int c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s < this.s) return 1;
		else if(o.s == this.s) {
			if(o.e > this.e) return -1;
			else if(o.e == this.e) return Integer.compare(this.c, o.c);
			else return 1;
		}
		else return -1;
	}
}