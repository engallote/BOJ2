import java.util.*;

public class Main {
	static int N, avg;
	static int[][] arr, chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        chk = new int[N][N];
        avg = N * N / 2;
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		arr[i][j] = sc.nextInt();
        
        int l = 0, r = 100000000, mid, res = 100000000;
        while(l <= r){
        	mid = (l + r) / 2;
        	
        	for(int i = 0; i < N; i++)
        		Arrays.fill(chk[i], -1);
        	
        	int sum = 0;
        	loop:for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			if(chk[i][j] == -1){
        				sum = dfs(i, j, mid);
        				if(sum >= avg) break loop;
        			}
        	
        	if(sum >= avg){
        		res = Math.min(res, mid);
        		r = mid - 1;
        	}
        	else l = mid + 1;
        }
        System.out.println(res);
	}
	private static int dfs(int x, int y, int mid) {
		chk[x][y] = 1;
		
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] != -1 || Math.abs(arr[nx][ny] - arr[x][y]) > mid)
				continue;
			chk[x][y] += dfs(nx, ny, mid);
		}
		
		return chk[x][y];
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}