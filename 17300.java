import java.util.*;

public class Main {
	static int N;
	static boolean end = false;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1, 2, 2, -2, -2, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1, 1, -1, 1, -1, 2, -2, 2, -2};
	static int[] arr;
	static boolean[][] chk;
	static int[][] map = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		int[] num = new int[10];
		boolean flag = true;
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			num[arr[i]] += 1;
			if(num[arr[i]] > 1) flag = false;
		}
		if(!flag) System.out.println("NO");
		else
		{
			end = false;
			int x = 0, y = 0;
			chk = new boolean[3][3];
			switch(arr[0]){
			case 2: y = 1; break;
			case 3: y = 2; break;
			case 4: x = 1; y = 0; break;
			case 5: x = 1; y = 1; break;
			case 6: x = 1; y = 2; break;
			case 7: x = 2; y = 0; break;
			case 8: x = 2; y = 1; break;
			case 9: x = 2; y = 2; break;
			}

			dfs(0, x, y, 0);
			if(end) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	private static void dfs(int idx, int x, int y, int d) {
		if(end) return;
		if(idx == N)
		{
			end = true;
			return;
		}
		if(map[x][y] != arr[idx])
		{
			if(!chk[x][y]) return;
			x += dx[d];
			y += dy[d];
			if(x < 0 || y < 0 || x >= 3 || y >= 3) return;
			dfs(idx, x, y, d);
			return;
		}
		chk[x][y] = true;
		for(int i = 0; i < 16; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
			dfs(idx + 1, nx, ny, i);
		}
		chk[x][y] = false;
	}
}