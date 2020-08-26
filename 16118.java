import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Pair>[] arr, arr2;
	static int[] fdist;
	static int[][] wdist;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		arr2 = new ArrayList[N+1];
		fdist = new int[N+1];
		wdist = new int[N+1][2];
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			arr2[i] = new ArrayList<>();
		}
		
		while(--M >= 0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Pair(b, c * 2));
			arr[b].add(new Pair(a, c * 2));
			
			arr2[a].add(new Pair(b, c, 0));
			arr2[a].add(new Pair(b, c * 4, 1));
			arr2[b].add(new Pair(a, c, 0));
			arr2[b].add(new Pair(a, c * 4, 1));
		}
		
		clear();
		fox();
		wolf();
		
		int res = 0;
		for(int i = 2; i <= N; i++){//달이 비추는 그루터기 번호
			if(fdist[i] < Math.min(wdist[i][0], wdist[i][1])) ++res;
//			System.out.println(i + " >> " + fdist[i] + " : " + wdist[i][0] + ", " + wdist[i][1]);
		}
		
		bw.write(res+"\n");
		bw.flush();
	}
	private static void wolf() {
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.offer(new Pair(1, 0, 1));
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(wdist[p.v][p.speed] <= p.cost) continue;
			wdist[p.v][p.speed] = p.cost;
			
			for(Pair next : arr2[p.v]){
				if(wdist[next.v][next.speed] <= p.cost || p.speed == next.speed) continue;
				q.offer(new Pair(next.v, p.cost + next.cost, next.speed));
			}
		}
	}
	private static void fox() {
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.offer(new Pair(1, 0));
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(fdist[p.v] <= p.cost) continue;
			fdist[p.v] = p.cost;
			
			for(Pair next : arr[p.v])
				if(fdist[next.v] > p.cost + next.cost)
					q.offer(new Pair(next.v, p.cost + next.cost));
		}
	}
	private static void clear() {
		for(int i = 1; i <= N; i++) Arrays.fill(wdist[i], Integer.MAX_VALUE);
		Arrays.fill(fdist, Integer.MAX_VALUE);
	}
}
class Pair implements Comparable<Pair>{
	int v, speed, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, int cost, int speed){
		this.v = v;
		this.cost = cost;
		this.speed = speed;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}