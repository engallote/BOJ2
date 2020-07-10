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
		int[] res = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) pq.offer(new Pair(i, Integer.parseInt(st.nextToken())));
		
		int cnt = -1, pre = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(pre != p.num) ++cnt;
			res[p.idx] = cnt;
			pre = p.num;
		}
		
		for(int i = 0; i < N; i++)
			bw.write(res[i] + " ");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int num, idx;
	Pair(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return -1;
		else if(o.num == this.num) return o.idx > this.idx ? -1 : 1;
		else return 1;
	}
}