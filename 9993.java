import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		int res = 0;
		for(int i = 0; i < N; i++){
			if(i == 0 || i == N - 1){
				for(int j = 0; j < M; j++)
					res = Math.max(res, findMax(i, j));
			}
			else{
				res = Math.max(res, findMax(i, 0));
				res = Math.max(res, findMax(i, M - 1));
			}
		}
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	private static int findMax(int x, int y) {
		int ret = 0, d = 0;
		if(x == 0)//down
			ret = Math.max(ret, go(x, y, d));
		else if(x == N - 1){//up
			d = 2;
			ret = Math.max(ret, go(x, y, d));
		}
		//side
		if(y == M - 1) ret = Math.max(ret, go(x, y, 1));
		else if(y == 0) ret = Math.max(ret, go(x, y, 3));
		
		return ret;
	}
	private static int go(int x, int y, int d) {
		int cnt = 1;
		
		while(true){
			if(arr[x][y] == '\\'){
				if(d == 0) d = 3;
				else if(d == 1) d = 2;
				else if(d == 2) d = 1;
				else d = 0;
			}
			else{
				if(d == 0) d = 1;
				else if(d == 1) d = 0;
				else if(d == 2) d = 3;
				else d = 2;
			}
			
			x += dx[d];
			y += dy[d];
			
			if(!isRange(x, y)) break;
			++cnt;
		}
		return cnt;
	}
	private static boolean isRange(int x, int y) {
		if(x >= 0 && y >= 0 && x < N && y < M) return true;
		return false;
	}
}