import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static int[] dist, chk;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		chk = new int[N+1];
		arr = new ArrayList[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			dist[i] = Integer.parseInt(st.nextToken());
			if(dist[i] == 0) q.offer(i);
		}
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		boolean flag;
		while(!q.isEmpty()){
			int x = q.poll();
			
			flag = true;
			for(int next : arr[x])
				if(dist[next] == 0 || dist[next] == 2){
					flag = false;
					break;
				}
			
			if(!flag) continue;
			
			Arrays.fill(chk, 10);
			
			if(bfs(x)){
				bw.write(x+"\n");
				break;
			}
		}
		bw.flush();
	}
	private static boolean bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		chk[x] = 0;
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				int v = q.poll();
				
				for(int next : arr[v]){
					if(chk[next] == 10){
						chk[next] = (chk[v] + 1) % 3;
						if(dist[next] != chk[next]) return false;
						q.offer(next);
					}
				}
			}
		}
		
		return true;
	}
}