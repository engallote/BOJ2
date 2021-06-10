import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int w = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		pq.offer(new Pair(w, c));
    	}
    	
    	boolean flag = false;
    	int weight = 0, same = 0, pre = -1, res = Integer.MAX_VALUE;
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		
    		weight += p.w;
    		if(pre == p.cost) same += p.cost;
    		else same = p.cost;
    		
    		if(weight >= M) {
    			flag = true;
    			res = Math.min(res, same);
    		}
    		pre = p.cost;
    	}
    	
    	if(!flag) res = -1;
    	bw.write(res+"");
    	bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int w, cost;
	Pair(int w, int cost) {
		this.w = w;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cost > this.cost) return -1;
		else if(o.cost == this.cost) {
			return Integer.compare(o.w, this.w);
		}
		return 1;
	}
}