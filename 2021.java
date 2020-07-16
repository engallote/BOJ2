import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr, sub;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		sub = new ArrayList[M];
		
		for(int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++){
			sub[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while(true){
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				sub[i].add(num);
				arr[num].add(i);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(start, end));
	}
	private static int bfs(int start, int end) {
		int[] dist = new int[N+1];
		boolean[] chk = new boolean[N+1], chk2 = new boolean[M];
		Queue<Integer> q = new LinkedList<>();
		for(int idx : arr[start]){
			chk2[idx] = true;
			for(int station : sub[idx]){
				q.offer(station);
				chk[station] = true;
			}
		}
		
		while(!q.isEmpty()){
			int x = q.poll();
			
			if(x == end) return dist[x];
			
			for(int idx : arr[x]){
				if(chk2[idx]) continue;
				chk2[idx] = true;
				for(int next : sub[idx])
					if(!chk[next] && next != x){
						chk[next] = true;
						dist[next] = dist[x] + 1;
						
						if(next == end) return dist[next];
						q.offer(next);
					}
			}
		}
		return -1;
	}
}