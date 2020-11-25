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
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int[] arr = new int[366];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.offer(new Pair(s, e));
		}
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			for(int i = p.s; i <= p.e; i++)
				++arr[i];
		}
		
		long s = 0, e = 0, row = 0, res = 0;
		for(int i = 1; i <= 365; i++) {
			if(arr[i] == 0) {
				if(s == 0) continue;
				res += (e - s + 1) * row;
				row = 0;
				s = e = 0;
			}
			else {
				if(s == 0) s = i;
				e = i;
				row = Math.max(row, arr[i]);
			}
		}
		
		if(s != 0) res += (e - s + 1) * row;
		
		bw.write(res+"");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int s, e;
	Pair(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.s > this.s) return -1;
		else if(o.s == this.s) {
			if(o.e > this.e) return 1;
			else if(o.e == this.e) return 0;
			else return -1;
		}
		else return 1;
	}
}