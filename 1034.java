import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		boolean[] chk = new boolean[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		int K = sc.nextInt();
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < M; j++)
				if(arr[i][j] == '0') ++cnt;
			
			if(cnt <= K && cnt % 2 == K % 2)
				chk[i] = true;
		}
		
		for(int i = 0; i < N; i++)
			if(chk[i]) {
				int cnt = 0;
				for(int j = 0; j < N; j++)
					if(new String(arr[i]).equals(new String(arr[j]))) ++cnt;
				
				max = Math.max(max, cnt);
			}
		
		System.out.println(max);
	}
}