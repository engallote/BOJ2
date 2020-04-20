import java.util.*;

public class Main {
	static int N, all = 0;
	static char[][] arr;
	static boolean[][][] dp;
	static int[] dx = {1, 1, -1, -1}, dy = {1, -1, 1, -1};
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		dp = new boolean[N][N][901];
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < N; j++){
				if(arr[i][j] == 'K') aly.add(new Pair(i, j));
				else if(arr[i][j] == 'o') ++all;
				Arrays.fill(dp[i][j], false);
			}
		}
		ArrayList<Pair> path = new ArrayList<>();
		
		for(Pair p : aly){
			path.clear();
			if(dfs(p.x, p.y, all, path)) break;
		}
	}
	private static boolean dfs(int x, int y, int all, ArrayList<Pair> path) {
		if(all == 0){
			for(Pair p : path)
				System.out.println((p.x + 1) + " " + (p.y + 1));
			System.out.println((x + 1) + " " + (y + 1));
			return true;
		}
		if(dp[x][y][all]) return true;
		boolean ret = false;
		
		path.add(new Pair(x, y));
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 'o') continue;
			
			if(nx + dx[i] < 0 || ny + dy[i] < 0 || nx + dx[i] >= N || ny + dy[i] >= N || arr[nx + dx[i]][ny + dy[i]] != '+') continue;
			
			arr[nx][ny] = '-';
			ret |= dfs(nx + dx[i], ny + dy[i], all - 1, path);
			arr[nx][ny] = 'o';
		}
		path.remove(path.size()-1);
		
		return dp[x][y][all] = ret;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}