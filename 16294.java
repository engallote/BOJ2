import java.util.*;

public class Main {
	static int H, N, M;
	static char[][] map;
	static boolean[][] chk;
	static int[] dx = {0, 0, 1, 1, -1, -1}, dy = {2, -2, -1, 1, -1, 1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt() * 2;
        map = new char[N][M];
        chk = new boolean[N][M];
        
        sc.nextLine();
        for(int i = 0; i < N; i++) {
        	Arrays.fill(map[i], ' ');
        	char[] ch = sc.nextLine().toCharArray();
        	
        	if(i % 2 == 0) {
        		for(int j = 0; j < M - 1; j++)
            		map[i][j] = ch[j];	
        	}
        	else {
        		for(int j = 0; j < M; j++)
            		map[i][j] = ch[j];	
        	}
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++) 
        		if(map[i][j] == '.' && !chk[i][j]) 
        			pq.offer(bfs(i, j));
        
        int res = 0;
        while(!pq.isEmpty() && H > 0) {
        	int num = pq.poll();
        	
        	H -= num;
        	++res;
        }
        
        System.out.println(res);
    }
	private static int bfs(int x, int y) {
		chk[x][y] = true;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		int size, cnt = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				++cnt;
				for(int i = 0; i < 6; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '#' || chk[nx][ny]) 
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		return cnt;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}