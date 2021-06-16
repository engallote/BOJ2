import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static int[][] chk;
	static ArrayList<Pair> aly;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	aly = new ArrayList<>();
    	
    	while(true) {
    		N = Integer.parseInt(br.readLine());
    		
    		if(N == 0) break;
    		
    		map = new char[N][N];
    		chk = new int[N][N];
    		aly.clear();
    		
    		for(int i = 0; i < N; i++) {
    			map[i] = br.readLine().trim().toCharArray();
    			for(int j = 0; j < N; j++)
    				if(map[i][j] == '.') aly.add(new Pair(i, j));
    		}
    		
    		int res = dfs(0, 0);
    		bw.write(res+"\n");
    	}
    	bw.flush();
	}
	private static int dfs(int idx, int cnt) {
		if(idx == aly.size()) return cnt;
		int ret = cnt;
		
		for(int i = idx; i < aly.size(); i++) {
			Pair p = aly.get(i);
			if(chk[p.x][p.y] == 0) {
				check(p.x, p.y, 1);
				ret = Math.max(ret, dfs(i + 1, cnt + 1));
				check(p.x, p.y, -1);
			}
		}
		
		return ret;
	}
	private static void check(int x, int y, int val) {
		chk[x][y] += val;
		
		for(int i = x - 1; i >= 0; i--) {
			if(map[i][y] == 'X') break;
			chk[i][y] += val;
		}
		
		for(int i = x + 1; i < N; i++) {
			if(map[i][y] == 'X') break;
			chk[i][y] += val;
		}
		
		for(int i = y - 1; i >= 0; i--) {
			if(map[x][i] == 'X') break;
			chk[x][i] += val;
		}
		
		for(int i = y + 1; i < N; i++) {
			if(map[x][i] == 'X') break;
			chk[x][i] += val;
		}
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}