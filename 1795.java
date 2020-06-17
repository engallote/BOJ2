import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static int[][][] num;
	static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2}, dy = {2, -2, 2, -2, 1, -1, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		num = new int[100][N][M];
		ArrayList<Integer> aly = new ArrayList<>();
		int idx = 0, res = Integer.MAX_VALUE, sum;
		
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < N; j++)
				Arrays.fill(num[i][j], Integer.MAX_VALUE);
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				if(arr[i][j] != '.'){
					aly.add(idx);
					num[idx][i][j] = 0;
					bfs(idx, arr[i][j] - '0', i, j);
					++idx;
				}
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				sum = 0;
				for(int k : aly){
					if(num[k][i][j] == Integer.MAX_VALUE){
						sum = Integer.MAX_VALUE;
						break;
					}
					sum += num[k][i][j];
				}
				res = Math.min(res, sum);
			}
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	private static void bfs(int idx, int count, int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		int size, time = 1, cnt = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 8; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || num[idx][nx][ny] <= time)
						continue;
					num[idx][nx][ny] = time;
					q.offer(new Pair(nx, ny));
				}
			}
			
			++cnt;
			if(cnt == count){
				++time;
				cnt = 0;
			}
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}