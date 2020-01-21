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
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int[] res = new int[N];
		Arrays.fill(res, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(st.nextToken());
			while(!pq.isEmpty()){
				Pair p = pq.peek();
				
				if(p.num < num){
					res[p.idx] = num;
					pq.poll();
				}
				else break;
			}
			pq.offer(new Pair(i, num));
		}
		
		for(int i = 0; i < N; i++)
			bw.write(res[i] + " ");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return o.num > this.num ? -1 : 1;
	}
}