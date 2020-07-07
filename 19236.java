import java.util.*;

public class Main {
	static int res = 0;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[4][4];
		int[][] dir = new int[4][4];
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				int num = sc.nextInt();
				int d = sc.nextInt();
				map[i][j] = num;
				dir[i][j] = d - 1;
			}
		}
		int tmp = map[0][0];
		map[0][0] = 0;
		
		solve(map, dir, 0, 0, dir[0][0], tmp);
		
		System.out.println(res);
	}
	private static void solve(int[][] map, int[][] dir, int x, int y, int d, int sum) {
		res = Math.max(res, sum);
		//fish
		int[][][] ret = fish(map, dir, x, y);
		int[][] nmap = ret[0];
		int[][] ndir = ret[1];
		
		//shark
		for(int i = 1; i <= 3; i++){
			int nx = x + dx[d] * i, ny = y + dy[d] * i;
			if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || nmap[nx][ny] == 0) continue;
			int tmp = nmap[nx][ny];
			nmap[nx][ny] = 0;
			solve(nmap, ndir, nx, ny, ndir[nx][ny], sum + tmp);
			nmap[nx][ny] = tmp;
		}
	}
	private static int[][][] fish(int[][] map, int[][] dir, int x, int y) {
		int[][][] ret = new int[2][4][4];
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				ret[0][i][j] = map[i][j];
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				ret[1][i][j] = dir[i][j];
		
		boolean flag;
		for(int ii = 1; ii <= 16; ii++){
			flag = false;
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < 4; j++){
					if(ret[0][i][j] == ii){
						int d = ret[1][i][j];
						for(int k = 0; k < 8; k++){
							int nx = i + dx[(d + k) % 8], ny = j + dy[(d + k) % 8];
							if(!range(nx, ny, x, y)) continue;
							flag = true;
							if(ret[0][nx][ny] == 0){//empty space
								ret[0][nx][ny] = ret[0][i][j];
								ret[1][nx][ny] = (d + k) % 8;
								ret[0][i][j] = ret[1][i][j] = 0;
							}
							else{//another fish
								int tmp = ret[0][i][j];
								ret[0][i][j] = ret[0][nx][ny];
								ret[0][nx][ny] = tmp;
								
								tmp = (d + k) % 8;
								ret[1][i][j] = ret[1][nx][ny];
								ret[1][nx][ny] = tmp;
							}
							break;
						}//for k
					}//if
					if(flag) break;
				}//for j
				if(flag) break;
			}//for i
		}
		return ret;
	}
	private static boolean range(int x, int y, int sx, int sy) {
		if(x < 0 || y < 0 || x >= 4 || y >= 4 || (x == sx && y == sy)) return false;
		return true;
	}
}
class Pair{
	int x, y, d;
	Pair(int x, int d){
		this.x = x;
		this.d = d;
	}
	Pair(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}