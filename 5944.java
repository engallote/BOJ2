import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int C, P, PB;
	static ArrayList<Pair>[] arr;
	static int[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		PB = Integer.parseInt(st.nextToken());
		int PA1 = Integer.parseInt(st.nextToken());
		int PA2 = Integer.parseInt(st.nextToken());
		arr = new ArrayList[P+1];
		chk = new int[P+1];
		
		for(int i = 1; i <= P; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < C; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		int res1 = 0, res2 = 0;
		find(PB);
		res1 = chk[PA1];
		res2 = chk[PA2];
		find(PA1);
		int res = Math.min(res1, res2) + chk[PA2];
		
		bw.write(res+"");
		bw.flush();
	}
	private static void find(int start) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		Arrays.fill(chk, 1000000000);
		chk[start] = 0;
		q.offer(new Pair(start, 0));
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(chk[p.v] < p.cost) continue;
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > next.cost + p.cost){
					chk[next.v] = next.cost + p.cost;
					q.offer(new Pair(next.v, chk[next.v]));
				}
		}
	}
}
class Pair implements Comparable<Pair>{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}
}