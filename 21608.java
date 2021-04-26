import java.util.*;

public class Main {
	static int N, e, f;
	static int[][] map, student;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new int[N][N];
    	int len = N * N;
    	int[] list = new int[len];
    	student = new int[len + 1][5];
    	
    	for(int i = 0; i < len; i++) {
    		int idx = sc.nextInt();
    		list[i] = idx;
    		for(int j = 1; j <= 4; j++)
    			student[idx][j] = sc.nextInt();
    	}
    	
    	for(int s = 0; s < len; s++) {
    		int idx = list[s];
    		
    		int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE, empty = 0, fav = 0;
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < N; j++)
    				if(map[i][j] == 0) {
    					e = 0;
    					f = 0;
    					find(i, j, idx);
    					
    					if(f > fav) {
    						fav = f;
    						empty = e;
    						x = i;
    						y = j;
    					}
    					else if(f == fav && e > empty) {
    						fav = f;
    						empty = e;
    						x = i;
    						y = j;
    					}
    					else if(f == fav && empty == e && x > i) {
    						fav = f;
    						empty = e;
    						x = i;
    						y = j;
    					}
    					else if(f == fav && empty == e && x == i && y > j) {
    						fav = f;
    						empty = e;
    						x = i;
    						y = j;
    					}
    				}
    		
    		map[x][y] = idx;
    	}
    	
    	int res = 0;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++) {
    			int idx = map[i][j], cnt = 0;
    			
    			for(int d = 0; d < 4; d++) {
    				int nx = i + dx[d], ny = j + dy[d];
    				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
    				if(map[nx][ny] == student[idx][1] || map[nx][ny] == student[idx][2] || map[nx][ny] == student[idx][3] || map[nx][ny] == student[idx][4])
    					++cnt;
    			}
    			
    			if(cnt == 1) res += 1;
    			else if(cnt == 2) res += 10;
    			else if(cnt == 3) res += 100;
    			else if(cnt == 4) res += 1000;
    		}
    	
    	System.out.println(res);
	}
	private static void find(int x, int y, int idx) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(map[nx][ny] == 0) ++e;
			else {
				int num = map[nx][ny];
				if(num == student[idx][1] || num == student[idx][2] || num == student[idx][3] || num == student[idx][4])
					++f;
			}
		}
		
	}
}