import java.util.*;

public class Main {
	static int N, M, cnt;
	static char[][] arr;
	static char[] path;
	static Pair[] pt;
	static int[] dx= {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
        	N = sc.nextInt();
            M = sc.nextInt();
            
            if(N == 0 && M == 0) break;
            
            arr = new char[N][M];
            
            int sx = 0, sy = 0;
            cnt = 0;
            
            for(int i = 0; i < N; i++){
            	arr[i] = sc.next().toCharArray();
            	for(int j = 0; j < M; j++){
            		if(arr[i][j] == 'A'){
            			sx = i;
            			sy = j;
            		}
            		else if(arr[i][j] >= '0' && arr[i][j] <= '9') ++cnt;
            	}
            }
            
            path = new char[cnt];
            pt = new Pair[cnt];
            
            for(int i = 0; i < cnt; i++){
            	int num = sc.nextInt();
            	path[i] = sc.next().charAt(0);
            	pt[i] = new Pair(sc.nextInt(), sc.nextInt());
            }
            	
            bfs(sx, sy);
        }
    }
	private static void bfs(int sx, int sy) {
		Queue<Pair> q = new LinkedList<Pair>();
		int[][][] chk = new int[N][M][3];
		int res = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
		
		int size = 0;
		chk[sx][sy][0] = chk[sx][sy][1] = chk[sx][sy][2] = 0;
		q.offer(new Pair(sx, sy, 0));
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(arr[p.x][p.y] == 'B'){
					res = Math.min(res, p.time);
					continue;
				}
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '.')
						continue;
					
					if(arr[nx][ny] >= '0' && arr[nx][ny] <= '9'){//교차로
						if((i == 0 || i == 2)){//남북
							int sum = find(p.time, arr[nx][ny]-'0', '|');
							
							if(chk[nx][ny][1] <= p.time + sum) continue;
							
							chk[nx][ny][1] = p.time + sum;
							q.offer(new Pair(nx, ny, p.time + sum));
						}
						else if((i == 1 || i == 3)){//동서
							int sum = find(p.time, arr[nx][ny]-'0', '-');
							
							if(chk[nx][ny][2] <= p.time + sum) continue;
							
							chk[nx][ny][2] = p.time + sum;
							q.offer(new Pair(nx, ny, p.time + sum));
						}
					}
					else{//일반 도로
						if(chk[nx][ny][0] <= p.time + 1) continue;
						chk[nx][ny][0] = p.time + 1;
						q.offer(new Pair(nx, ny, p.time + 1));
					}
				}
			}
		}
		
		if(res == Integer.MAX_VALUE) System.out.println("impossible");
		else System.out.println(res);
	}
	private static int find(int time, int idx, char next) {
		char cur = path[idx];//현재 교차로 상태
		int[] ta = {0, 0};
		
		for(int i = 0; i < time; i++){
			if(cur == '-'){
				++ta[0];
				if(ta[0] >= pt[idx].x) {
					ta[0] = 0;
					cur = '|';
				}
			}
			else if(cur == '|'){
				++ta[1];
				if(ta[1] >= pt[idx].y) {
					ta[1] = 0;
					cur = '-';
				}
			}
		}
		
		if(cur == next) return 1;
		int sum = 0;
		
		if(cur == '-') 
			sum = pt[idx].x - ta[0] + 1;
		else 
			sum = pt[idx].y - ta[1] + 1;
		
		return sum;
	}
}
class Pair{
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
}