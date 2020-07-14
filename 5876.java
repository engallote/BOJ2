import java.util.*;

public class Main {
	static int N, res = 0;
	static char[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		chk = new boolean[N][N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		if(arr[0][0] == ')'){
			System.out.println(0);
			return;
		}
		
		chk[0][0] = true;
		solve(0, 0, 1, 0, arr[0][0]+"");
		
		System.out.println(res);
	}
	private static void solve(int x, int y, int left, int right, String path) {
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny]) continue;
			chk[nx][ny] = true;
			if(arr[nx][ny] == '(' && right == 0) 
				solve(nx, ny, left + 1, right, path + arr[nx][ny] + "");
			else if(arr[nx][ny] == ')')
				solve(nx, ny, left, right + 1, path + arr[nx][ny] + "");
			chk[nx][ny] = false;
		}
	
		if(left == right) res = Math.max(res, left + right);
	}
}