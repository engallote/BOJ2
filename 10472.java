import java.util.*;

public class Main {
	static int res = 0;
	static char[][] arr = new char[3][3], arr2 = new char[3][3];
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0)
		{
			res = Integer.MAX_VALUE;
			for(int i = 0; i < 3; i++) Arrays.fill(arr[i], '.');
			for(int i = 0; i < 3; i++) arr2[i] = sc.next().toCharArray();
			
			solve(0, 0, 0);
			System.out.println(res);
		}
	}
	private static void solve(int x, int y, int cnt) {
		boolean flag = true;
		for(int i = 0; i < 3 && flag; i++)
			for(int j = 0; j < 3; j++)
				if(arr[i][j] != arr2[i][j])
				{
					flag = false;
					break;
				}
		if(flag)
		{
			res = Math.min(res, cnt);
			return;
		}
		if(x >= 3) return;
		if(y >= 3)
		{
			solve(x + 1, 0, cnt);
			return;
		}
		solve(x, y + 1, cnt);
		arr[x][y] = (arr[x][y] == '.') ? '*' : '.';
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
			arr[nx][ny] = (arr[nx][ny] == '.') ? '*' : '.';
		}
		solve(x, y + 1, cnt + 1);
		arr[x][y] = (arr[x][y] == '.') ? '*' : '.';
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
			arr[nx][ny] = (arr[nx][ny] == '.') ? '*' : '.';
		}
	}
}