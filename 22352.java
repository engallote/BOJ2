import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    	int[][] arr = new int[N][M], arr2 = new int[N][M];
    	boolean[][] chk = new boolean[N][M];
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			arr[i][j] = sc.nextInt();
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			arr2[i][j] = sc.nextInt();
    	
    	int x = 0, y = 0, num = 0, num2 = 0;
    	loop:for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(arr[i][j] != arr2[i][j]) {
    				x = i;
    				y = j;
    				num = arr[i][j];
    				num2 = arr2[i][j];
    				break loop;
    			}
    	
    	if(num == 0) {
    		System.out.println("YES");
    		return;
    	}
    	
    	Queue<Pair> q = new LinkedList<>();
    	q.offer(new Pair(x, y));
    	
    	while(!q.isEmpty()) {
    		Pair p = q.poll();
    		arr[p.x][p.y] = num2;
    		chk[p.x][p.y] = true;
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = p.x + dx[i], ny = p.y + dy[i];
    			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != num || chk[nx][ny]) 
    				continue;
    			
    			chk[nx][ny] = true;
    			q.offer(new Pair(nx, ny));
    		}
    	}
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(arr[i][j] != arr2[i][j]) {
    				System.out.println("NO");
    				return;
    			}
    	
    	System.out.println("YES");
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}