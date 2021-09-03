import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] chk;
	static boolean[][] road;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	road = new boolean[N + 1][N + 1];
    	chk = new int[N + 1];
    	aly = new ArrayList[N + 1];
    	
    	for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		road[a][b] = road[b][a] = true;
    		aly[a].add(b);
    		aly[b].add(a);
    	}
    	
    	int K = Integer.parseInt(br.readLine());
    	
    	while(--K >= 0) {
    		Arrays.fill(chk, Integer.MAX_VALUE);
    		st = new StringTokenizer(br.readLine());
    		int p = Integer.parseInt(st.nextToken());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		if(p == 1) {
    			aly[a].add(b);
    			aly[b].add(a);
    			road[a][b] = road[b][a] = true;
    		}
    		else {
    			road[a][b] = road[b][a] = false;
    		}
    		chk[1] = 0;
    		bfs();
    		
    		for(int i = 1; i <= N; i++)
    			bw.write(((chk[i] == Integer.MAX_VALUE ? -1 : chk[i]) + " "));
    		bw.newLine();
    	}
    	bw.flush();
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				for(int next : aly[x])
					if(road[x][next] && chk[next] > chk[x] + 1) {
						chk[next] = chk[x] + 1;
						q.offer(next);
					}
			}
		}
	}
}