import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		int res = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		int l = 1, r = N - 2, cnt = 0;
		while(l <= r)
		{
			cnt = 0;
			for(int i = 0; i < l; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] != 'W') ++cnt;
			
			for(int i = l; i <= r; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] != 'B') ++cnt;
			
			for(int i = r + 1; i < N; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] != 'R') ++cnt;
			
			res = Math.min(res, cnt);
			++l;
			if(l > r)
			{
				l = 1;
				--r;
			}
		}
		
		System.out.println(res);
	}
}