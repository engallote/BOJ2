import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] xx, yy, dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] chk;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new char[N][M];
    	chk = new int[N][M];
    	xx = new int[N * M];
    	yy = new int[N * M];
    	
    	for(int i = 0; i < N; i++) {
    		map[i] = br.readLine().trim().toCharArray();
    		Arrays.fill(chk[i], -1);
    	}
    	
    	int G = Integer.parseInt(br.readLine());
    	while(--G >= 0) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken()) - 1;
    		int y = Integer.parseInt(st.nextToken()) - 1;
    		
    		if(map[x][y] == 'x'){
    			bw.write("0\n");
    			continue;
    		}
    		
    		int res = Integer.MAX_VALUE;
    		xx[0] = x;
    		yy[0] = y;
    		chk[x][y] = G;
    		
    		int l = 0, h = 1;
    		while(l < h) {
    			int cx = xx[l], cy = yy[l++];
    			
    			if(dist(cx, cy, x, y) >= res) continue;
    			
    			for(int i = 0; i < 4; i++) {
    				int nx = cx + dx[i], ny = cy + dy[i];
    				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] == G) continue;
    				
    				chk[nx][ny] = G;
    				int tmp = dist(nx, ny, x, y);
    				
    				if(tmp >= res) continue;
    				
    				if(map[nx][ny] == 'x') res = tmp;
    				xx[h] = nx;
    				yy[h++] = ny;
    			}
    		}
    		
			map[x][y] = 'x';
    		bw.write(res+"\n");
    	}
    	bw.flush();
    }
    private static int dist(int x, int y, int x2, int y2) {
		return (x - x2) * (x - x2) + (y - y2) * (y - y2);
	}
}