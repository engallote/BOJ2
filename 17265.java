import java.util.*;

public class Main {
	static int N, max, min;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		arr = new char[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.next().charAt(0);
		
		solve(0, 0, arr[0][0]-'0', '.');
		System.out.println(max + " " + min);
	}
	private static void solve(int x, int y, int sum, char op) {
		if(x == N - 1 && y == N - 1)
		{
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		if(x + 1 < N)
		{
			if(arr[x+1][y] >= '0' && arr[x+1][y] <= '5') 
			{
				if(op == '+') solve(x + 1, y, sum + (arr[x+1][y]-'0'), op);
				else if(op == '-') solve(x + 1, y, sum - (arr[x+1][y]-'0'), op);
				else solve(x + 1, y, sum * (arr[x+1][y]-'0'), op);
			}
			else solve(x + 1, y, sum, arr[x+1][y]);
		}
		if(y + 1 < N)
		{
			if(arr[x][y+1] >= '0' && arr[x][y+1] <= '5') 
			{
				if(op == '+') solve(x, y + 1, sum + (arr[x][y+1]-'0'), op);
				else if(op == '-') solve(x, y + 1, sum - (arr[x][y+1]-'0'), op);
				else solve(x, y + 1, sum * (arr[x][y+1]-'0'), op);
			}
			else solve(x, y + 1, sum, arr[x][y+1]);
		}
	}
}