import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr;
	static int[] path;
	static long[] chk, chk2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		path = new int[10];
		chk = new long[N + 1];
		chk2 = new long[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
			chk2[i] = Long.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Long> hm = new HashMap<>();
		path[0] = Integer.parseInt(st.nextToken());
		int prev = path[0];
		hm.put(prev, 0l);
		for(int i = 1; i < 10; i++) {
			path[i] = Integer.parseInt(st.nextToken());
			
			if(i > 0) {
				long tmp = ya(prev, path[i]);
				if(tmp == Long.MAX_VALUE) continue;
				if(hm.containsKey(path[i])) hm.replace(path[i], hm.get(prev) + tmp);
				else hm.put(path[i], hm.get(prev) + tmp);
			}
			
			prev = path[i];
		}
		
		int start = Integer.parseInt(br.readLine());
		
		chk2[start] = 0;
		go(start);
		
		int res = -1;
		Iterator<Integer> it = hm.keySet().iterator();
		while(it.hasNext()) {
			int num = it.next();
			
			if(hm.get(num) >= chk2[num]) {
				if(res == -1) res = num;
				else res = Math.min(res, num);
			}
		}
		bw.write(res+"");
		bw.flush();
	}
	private static void go(int start) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(start, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(chk2[p.v] != p.cost) continue;
			
			for(Pair next : arr[p.v])
				if(chk2[next.v] > p.cost + next.cost) {
					chk2[next.v] = p.cost + next.cost;
					q.offer(new Pair(next.v, chk2[next.v]));
				}
		}
	}
	
	private static long ya(int start, int end) {
		Arrays.fill(chk, Long.MAX_VALUE);
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(start, 0));
		chk[start] = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(chk[p.v] != p.cost) continue;
			if(p.v == end) return chk[p.v];
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > chk[p.v] + next.cost) {
					chk[next.v] = chk[p.v] + next.cost;
					q.offer(new Pair(next.v, chk[next.v]));
				}
		}
		
		return Long.MAX_VALUE;
	}
}
class Pair implements Comparable<Pair>{
	int v;
	long cost;
	Pair(int v, long cost) {
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cost > this.cost) return -1;
		else if(o.cost == this.cost) return 0;
		else return 1;
	}
}