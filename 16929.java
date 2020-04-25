import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[][] chk;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        chk = new int[N][M];
        
        for(int i = 0; i < N; i++){
        	arr[i] = sc.next().toCharArray();
        	Arrays.fill(chk[i], -1);
        }
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		if(chk[i][j] == -1)
        			if(findCycle(i, j)){
        				System.out.println("Yes");
        				return;
        			}
        
        System.out.println("No");
    }
	private static boolean findCycle(int x, int y) {
		char c = arr[x][y];
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = 0;
		int size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != c)
						continue;
					if(chk[nx][ny] == chk[p.x][p.y] + 1) return true;
					if(chk[nx][ny] != -1) continue;
					chk[nx][ny] = chk[p.x][p.y] + 1;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		return false;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}