import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N][N];
    	chk = new boolean[N][N];
    	StringTokenizer st;
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++)
    			arr[i][j] = Integer.parseInt(st.nextToken());
    	}
    	
    	int l = 0, r = 1000000000, mid, res = Integer.MAX_VALUE;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
    		if(bfs(mid)) {
    			res = Math.min(res, mid);
    			r = mid - 1;
    		}
    		else l = mid + 1;
    		
    		for(int i = 0; i < N; i++)
    			Arrays.fill(chk[i], false);
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
	private static boolean bfs(int m) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, 0));
		chk[0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == N - 1) return true;
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny]) continue;
					int dif = Math.abs(arr[p.x][p.y] - arr[nx][ny]);
					
					if(dif > m) continue;
					
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		return false;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}