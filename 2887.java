import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static int[] par;
	static Pair[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new Pair[N];
		par = new int[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			par[i] = i;
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(i, x, y, z);
		}
		
		int res = 0;
		Arrays.sort(arr, new Xsort());	
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 1; i < N; i++){
			int cost = Math.min(Math.abs(arr[i-1].x - arr[i].x), Math.min(Math.abs(arr[i-1].y - arr[i].y), Math.abs(arr[i-1].z - arr[i].z)));
			pq.offer(new Pair(arr[i-1].idx, arr[i].idx, cost));
		}
		
		Arrays.sort(arr, new Ysort());
		for(int i = 1; i < N; i++){
			int cost = Math.min(Math.abs(arr[i-1].x - arr[i].x), Math.min(Math.abs(arr[i-1].y - arr[i].y), Math.abs(arr[i-1].z - arr[i].z)));
			pq.offer(new Pair(arr[i-1].idx, arr[i].idx, cost));
		}
		
		Arrays.sort(arr, new Zsort());
		for(int i = 1; i < N; i++){
			int cost = Math.min(Math.abs(arr[i-1].x - arr[i].x), Math.min(Math.abs(arr[i-1].y - arr[i].y), Math.abs(arr[i-1].z - arr[i].z)));
			pq.offer(new Pair(arr[i-1].idx, arr[i].idx, cost));
		}
		
		int cnt = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			int ap = find(p.x), bp = find(p.y);
			if(ap == bp) continue;
			
			par[bp] = ap;
			res += p.cost;
			++cnt;
			if(cnt == N - 1) break;
		}
		
		bw.write(res+"");
		bw.flush();
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int idx, x, y, z, cost;
	Pair(int idx, int x, int y, int z){
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	Pair(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}
class Xsort implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.x > o2.x) return 1;
		else if(o1.x == o2.x){
			if(o1.y > o2.y) return 1;
			else if(o1.y == o2.y){
				if(o1.z > o2.z) return 1;
				else return -1;
			}
			else return -1;
		}
		return -1;
	}
}
class Ysort implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.y > o2.y) return 1;
		else if(o1.y == o2.y){
			if(o1.x > o2.x) return 1;
			else if(o1.x == o2.x){
				if(o1.z > o2.z) return 1;
				else return -1;
			}
			else return -1;
		}
		return -1;
	}
}
class Zsort implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.z > o2.z) return 1;
		else if(o1.z == o2.z){
			if(o1.x > o2.x) return 1;
			else if(o1.x == o2.x){
				if(o1.y > o2.y) return 1;
				else return -1;
			}
			else return -1;
		}
		return -1;
	}
}