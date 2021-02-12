import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, R, C, K;
	static int[][] map, tmp;
	static ArrayList<Pair>[] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        while(true) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	R = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	
        	if(N == 0 && R == 0 && C == 0 && K == 0) break;
        	
        	map = new int[R][C];
        	tmp = new int[R][C];
        	arr = new ArrayList[N];
        	
        	for(int i = 0; i < N; i++)
        		arr[i] = new ArrayList<>();
        	
        	for(int i = 0; i < R; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < C; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			tmp[i][j] = map[i][j];
        			arr[map[i][j]].add(new Pair(i, j));
        		}
        	}
        	
        	while(--K >= 0) {
        		for(int i = 0; i < N; i++)
        			for(Pair p : arr[i])
        				find(i, p);
        		
        		for(int i = 0; i < N; i++)
        			arr[i].clear();
        		
        		for(int i = 0; i < R; i++)
            		for(int j = 0; j < C; j++) {
            			map[i][j] = tmp[i][j];
            			arr[map[i][j]].add(new Pair(i, j));
            		}
        	}
        	
        	for(int i = 0; i < R; i++) {
        		for(int j = 0; j < C; j++)
        			bw.write(map[i][j] + " ");
        		bw.newLine();
        	}
        }
        bw.flush();
	}

	private static void find(int idx, Pair p) {
		int ene = (idx + 1) % N;
		
		for(int i = 0; i < 4; i++) {
			int nx = p.x + dx[i], ny = p.y + dy[i];
			if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != ene) continue;
			tmp[nx][ny] = idx;
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}