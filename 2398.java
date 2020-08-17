import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M, a, b, c;
	static ArrayList<Pair>[] arr;
	static int[][] dist, par;
	static Queue<String> path;
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        dist = new int[N+1][3];
        par = new int[N+1][3];
        path = new LinkedList<String>();
        
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++){
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	arr[a].add(new Pair(b, c));
        	arr[b].add(new Pair(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        bfs();
        
        int min = Integer.MAX_VALUE, idx = 0;
        
        for(int i = 1; i <= N; i++)
        	if(min > dist[i][0] + dist[i][1] + dist[i][2]){
        		min = dist[i][0] + dist[i][1] + dist[i][2];
        		idx = i;
        	}
        
        find(idx);
        
        bw.write(min + " " + path.size() + "\n");
        while(!path.isEmpty()) bw.write(path.poll()+"\n");
        bw.flush();
	}
	private static void find(int idx) {
		int id = idx;
		while(par[id][0] != 0){
			path.offer(id + " " + par[id][0]);
			id = par[id][0];
		}
		
		id = idx;
		while(par[id][1] != 0){
			path.offer(id + " " + par[id][1]);
			id = par[id][1];
		}
		
		id = idx;
		while(par[id][2] != 0){
			path.offer(id + " " + par[id][2]);
			id = par[id][2];
		}
	}
	private static void bfs() {
		for(int i = 1; i <= N; i++)
			Arrays.fill(dist[i], 1000000000);
		dist[a][0] = dist[b][1] = dist[c][2] = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(a, 0, 0));
		q.offer(new Pair(b, 1, 0));
		q.offer(new Pair(c, 2, 0));
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.cost > dist[p.v][p.u]) continue;
				
				for(Pair next : arr[p.v]){
					if(dist[next.v][p.u] > dist[p.v][p.u] + next.cost){
						dist[next.v][p.u] = dist[p.v][p.u] + next.cost;
						par[next.v][p.u] = p.v;
						q.offer(new Pair(next.v, p.u, dist[next.v][p.u]));
					}
				}
			}
		}
	}
}
class Pair{
	int v, u, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, int u, int cost){
		this.v = v;
		this.u = u;
		this.cost = cost;
	}
}