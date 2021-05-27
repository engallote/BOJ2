import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int T = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int A = Integer.parseInt(st.nextToken());//id
    		int B = Integer.parseInt(st.nextToken());//time
    		int C = Integer.parseInt(st.nextToken());//rank
    		
    		pq.offer(new Pair(A, B, C));
    	}
    	
    	while(--T >= 0 && !pq.isEmpty()) {
    		Pair p = pq.poll();
    		bw.write(p.id+"\n");
    		
    		if(p.time - 1 > 0) pq.offer(new Pair(p.id, p.time - 1, p.rank - 1));
    	}
    	bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int id, time, rank;
	Pair(int id, int time, int rank){
		this.id = id;
		this.time = time;
		this.rank = rank;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.rank > this.rank) return 1;
		else if(o.rank == this.rank) {
			if(o.id > this.id) return -1;
			else return 1;
		}
		return -1;
	}
}