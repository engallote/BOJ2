import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		long[] bit = new long[N + 1], sum = new long[N + 1];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.offer(new Pair(x, y));
		}
		
		int idx = 2;
		bit[1] = (long)pq.poll().y;
		while(!pq.isEmpty()){
			bit[idx] = bit[idx-1] ^ (long)pq.poll().y;
			++idx;
		}
		
		idx = 1;
		while(idx <= N){
			if(idx - M >= 0) sum[idx] = sum[idx - M] + (bit[idx] ^ bit[idx-M]);
			++idx;
		}
		
		int Q = Integer.parseInt(br.readLine());
		int a, b;
		while(--Q >= 0){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			bw.write((sum[a * M + b] - sum[b]) + "\n");
		}
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		return o.x > this.x ? 1 : -1;
	}
}