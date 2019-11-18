import java.util.*;

public class Main {
	static int N;
	static boolean end;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		end = false;
		int all = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 2) ++all;
			}
		
		if(all == 1)
		{
			System.out.println("Possible");
			return;
		}
		for(int i = 1; i < N - 1 && !end; i++)
			for(int j = 1; j < N - 1; j++)
				if(arr[i][j] == 2)
				{
					game(i, j, all);
					if(end) break;
				}
		
		if(end) System.out.println("Possible");
		else System.out.println("Impossible");
	}
	private static void game(int x, int y, int cnt) {
		if(end) return;
		if(cnt == 1)
		{
			end = true;
			return;
		}
		
		for(int i = 1; i < N - 1; i++)
			for(int j = 1; j < N - 1; j++)
				if(arr[i][j] == 2)
				{
					if(i + 2 < N - 1 && arr[i+1][j] == 2 && arr[i+2][j] == 0)
					{
						arr[i][j] = arr[i+1][j] = 0;
						arr[i+2][j] = 2;
						game(i+2, j, cnt - 1);
						arr[i+2][j] = 0;
						arr[i][j] = arr[i+1][j] = 2;
					}
					if(i - 2 > 0 && arr[i-1][j] == 2 && arr[i-2][j] == 0)
					{
						arr[i][j] = arr[i-1][j] = 0;
						arr[i-2][j] = 2;
						game(i-2, j, cnt - 1);
						arr[i-2][j] = 0;
						arr[i][j] = arr[i-1][j] = 2;
					}
					if(j + 2 < N - 1 && arr[i][j+1] == 2 && arr[i][j+2] == 0)
					{
						arr[i][j] = arr[i][j+1] = 0;
						arr[i][j+2] = 2;
						game(i, j+2, cnt - 1);
						arr[i][j+2] = 0;
						arr[i][j] = arr[i][j+1] = 2;
					}
					if(j - 2 > 0 && arr[i][j-1] == 2 && arr[i][j-2] == 0)
					{
						arr[i][j] = arr[i][j-1] = 0;
						arr[i][j-2] = 2;
						game(i, j-2, cnt - 1);
						arr[i][j-2] = 0;
						arr[i][j] = arr[i][j-1] = 2;
					}
					if(i + 2 < N - 1 && j + 2 < N - 1 && arr[i+1][j+1] == 2 && arr[i+2][j+2] == 0)
					{
						arr[i][j] = arr[i+1][j+1] = 0;
						arr[i+2][j+2] = 2;
						game(i+2, j+2, cnt - 1);
						arr[i+2][j+2] = 0;
						arr[i][j] = arr[i+1][j+1] = 2;
					}
					if(i + 2 < N - 1 && j - 2 > 0 && arr[i+1][j-1] == 2 && arr[i+2][j-2] == 0)
					{
						arr[i][j] = arr[i+1][j-1] = 0;
						arr[i+2][j-2] = 2;
						game(i+2, j-2, cnt - 1);
						arr[i+2][j-2] = 0;
						arr[i][j] = arr[i+1][j-1] = 2;
					}
					if(i - 2 > 0 && j + 2 < N - 1 && arr[i-1][j+1] == 2 && arr[i-2][j+2] == 0)
					{
						arr[i][j] = arr[i-1][j+1] = 0;
						arr[i-2][j+2] = 2;
						game(i-2, j+2, cnt - 1);
						arr[i-2][j+2] = 0;
						arr[i][j] = arr[i-1][j+1] = 2;
					}
					if(i - 2 > 0 && j + 2 > 0 && arr[i-1][j-1] == 2 && arr[i-2][j-2] == 0)
					{
						arr[i][j] = arr[i-1][j-1] = 0;
						arr[i-2][j-2] = 2;
						game(i-2, j-2, cnt - 1);
						arr[i-2][j-2] = 0;
						arr[i][j] = arr[i-1][j-1] = 2;
					}
				}
	}
}