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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) + 2;
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] chk = new boolean[N + 1];
		int[] sum = new int[N + 1];
		
		HashSet<Integer> hs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++)
			hs.add(Integer.parseInt(st.nextToken()));
		
		Queue<Integer> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; i++) {
			int num = Integer.parseInt(st.nextToken());
			q.clear();
			q.offer(num);
			
			while(!q.isEmpty()) {
				int x = q.poll();
				
				if(hs.contains(x)) continue;
				chk[x] = true;
				
				for(int j = 2; ; j++) {
					if(x * j > N) break;
					q.offer(x * j);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(chk[i]) sum[i] = sum[i - 1];
			else sum[i] = sum[i - 1] + 1;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			bw.write((sum[e] - sum[s - 1]) + "\n");
		}
		bw.flush();
	}
}