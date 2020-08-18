import java.util.*;

public class Main {
	static int N,M;
	static char[][] map;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static Queue<Pair> q = new LinkedList<Pair>(), tmp = new LinkedList<Pair>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        arr = new int[N][M];
        
        for(int i = 0; i < N; i++){
        	map[i] = sc.next().toCharArray();
        	for(int j = 0; j < M; j++){
        		if(map[i][j] == '.') q.offer(new Pair(i, j));
        		if(j == 0 || j == M - 1 && map[i][j] == 'T'){
        			tmp.offer(new Pair(i, j));
        			arr[i][j] = 1;
        		}
        		if(i == 0 || i == N - 1 && map[i][j] == 'T'){
        			tmp.offer(new Pair(i, j));
        			arr[i][j] = 1;
        		}
        	}
        }
        
        int cnt = 1;
        while(!q.isEmpty() || !tmp.isEmpty()){
        	bfs(cnt);
        	++cnt;
        }
        
        String dot = ".";
        if(cnt >= 10) dot = "..";
        
        for(int i = 0; i < N; i++){
        	for(int j = 0; j < M; j++){
        		if(map[i][j] == '.') System.out.print(dot + ".");
        		else{
        			if(arr[i][j] >= 10) System.out.print("." + arr[i][j]);
        			else System.out.print(dot + "" + arr[i][j]);
        		}
        	}
        	System.out.println();
        }
	}
	private static void bfs(int num) {
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '.' || arr[nx][ny] != 0) 
					continue;
				
				arr[nx][ny] = num;
				tmp.offer(new Pair(nx, ny));
			}
		}
		
		q.addAll(tmp);
		tmp.clear();
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}