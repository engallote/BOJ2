import java.util.*;

public class Main {
	static int N, M, V;
	static boolean[][] chk;
	static int[][] arr, fire;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	static Queue<Pair> fi = new LinkedList<Pair>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        //시작 위치
        int X = sc.nextInt()-1;
        int Y = sc.nextInt()-1;
        arr = new int[N][M];
        fire = new int[N][M];
        chk = new boolean[N][M];
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < M; j++)
        		arr[i][j] = sc.nextInt();
        
        for(int i = 0; i < V; i++){
        	int x = sc.nextInt()-1;
        	int y = sc.nextInt()-1;
        	int t = sc.nextInt();
        	chk[x][y] = true;//화산은 못 지나감
        	if(t == 0){//0초부터 터지는 화산
        		fire[x][y] = 1;
        		fi.offer(new Pair(x, y));
        	}
        	else pq.offer(new Pair(x, y, t));
        }
        
        bfs(X, Y);
    }
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int res = arr[x][y], rtime = 0;
		int size = 0, time = 0;
		
		while(!q.isEmpty()){
			size = fi.size();
			while(--size >= 0){//화산 먼저
				Pair p = fi.poll();
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || fire[nx][ny] != 0)
						continue;
					fire[nx][ny] = 1;//화산쇄설류가 덮치는 곳
					fi.offer(new Pair(nx, ny));
				}
			}
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(arr[p.x][p.y] > res){
					res = arr[p.x][p.y];
					rtime = time;
				}
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || fire[nx][ny] != 0)
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
			while(!pq.isEmpty() && pq.peek().time <= time){//분출시작
				Pair p = pq.poll();
				fire[p.x][p.y] = 1;
				fi.offer(new Pair(p.x, p.y));
			}
		}
		
		System.out.println(res + " " + rtime);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, time;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
	@Override
	public int compareTo(Pair o) {
		return o.time > this.time ? -1 : 1;
	}
}