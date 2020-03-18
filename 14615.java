import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] arr, arr2;
	static boolean[] chk, chk2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		arr2 = new ArrayList[N+1];
		chk = new boolean[N+1];
		chk2 = new boolean[N+1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			arr2[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr2[b].add(a);
		}
		
		bfs();
		
		int C = Integer.parseInt(br.readLine());
		while(--C >= 0){
			int num = Integer.parseInt(br.readLine());
			if(chk2[num] && chk[num]) bw.write("Defend the CTP\n");
			else bw.write("Destroyed the CTP\n");
		}
		bw.flush();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		
		while(!q.isEmpty()){
			int x = q.poll();
			
			for(int next : arr[x])
				if(!chk[next]){
					chk[next] = true;
					q.offer(next);
				}
		}
		q.clear();
		q.offer(N);
		
		while(!q.isEmpty()){
			int x = q.poll();
			
			for(int next : arr2[x])
				if(!chk2[next]){
					chk2[next] = true;
					q.offer(next);
				}
		}
	}
}