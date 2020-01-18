import java.util.*;

public class Main {
	static int N, K;
	static boolean flag;
	static char[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new char[N][10];
		chk = new boolean[N][10];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		while(true){
			flag = false;
			for(int i = 0; i < N; i++)
				Arrays.fill(chk[i], false);
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < 10; j++)
					if(arr[i][j] != '0' && !chk[i][j])
						remove(i, j);
			if(!flag) break;
			down();
		}
		
		for(int i = 0; i < N; i++)
			System.out.println(new String(arr[i]));
	}
	private static void down() {
		for(int i = N - 1; i > 0; i--)
			for(int j = 0; j < 10; j++)
				if(arr[i][j] == '0'){
					int nx = i - 1;
					while(nx >= 0){
						if(arr[nx][j] != '0'){
							arr[i][j] = arr[nx][j];
							arr[nx][j] = '0';
							break;
						}
						--nx;
					}
				}
	}
	private static void remove(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>(), tmp = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int size = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				tmp.offer(p);
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= 10 || chk[nx][ny] || arr[nx][ny] != arr[x][y])
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		if(tmp.size() >= K){
			flag = true;
			while(!tmp.isEmpty()){
				Pair p = tmp.poll();
				arr[p.x][p.y] = '0';
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