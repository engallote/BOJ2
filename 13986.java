import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		int nx = 0;
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		for(int j = 0; j < M; j++)
			for(int i = N - 1; i >= 0; i--)
			{
				if(arr[i][j] != '.') continue;
				nx = i - 1;
				while(nx >= 0)
				{
					if(arr[nx][j] == 'o')
					{
						arr[i][j] = 'o';
						arr[nx][j] = '.';
						break;
					}
					else if(arr[nx][j] == '#') break;
					--nx;
				}
			}
	
		for(int i = 0; i < N; i++)
			System.out.println(new String(arr[i]));
	}
}