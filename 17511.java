import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static boolean[] chk;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	chk = new boolean[N + 1];
    	aly = new ArrayList[N + 1];
    	int[] indgree = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		aly[a].add(b);
    		indgree[b] += 1;
    	}
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for(int i = 1; i <= N; i++) {
    		if(indgree[i] != 0) continue;
    		if(solve(i)) pq.offer(i);
    		Arrays.fill(chk, false);
    	}
    	
    	bw.write(pq.size() + "\n");
    	while(!pq.isEmpty()) bw.write(pq.poll() + " ");
    	bw.flush();
    }
	private static boolean solve(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		chk[s] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				++cnt;
				for(int next : aly[x])
					if(!chk[next]) {
						chk[next] = true;
						q.offer(next);
					}
			}
		}
		
		if(cnt == N) return true;
		return false;
	}
}