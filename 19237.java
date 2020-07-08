import java.util.*;

public class Main {
	static int N, M, k;
	static int[] dir;
	static boolean[][] cur;
	static int[][] smell, map;
	static int[][][] nd;
	static Pair[] arr;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		k = sc.nextInt();
		arr = new Pair[M + 1];//상어 위치
		map = new int[N][N];
		smell = new int[N][N];
		cur = new boolean[N][N];
		dir = new int[M + 1];
		nd = new int[M + 1][4][4];//상하좌우 우선순위
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j] != 0){
					arr[map[i][j]] = new Pair(i, j);
					smell[i][j] = k;
				}
			}
		
		for(int i = 1; i <= M; i++)
			dir[i] = sc.nextInt() - 1;
		
		for(int i = 1; i <= M; i++)
			for(int j = 0; j < 4; j++)
				for(int k = 0; k < 4; k++)
					nd[i][j][k] = sc.nextInt() - 1;
		
		int res = 0;
		boolean flag = true;
		while(flag){
			for(int i = 0; i < N; i++)
				Arrays.fill(cur[i], false);
			
			move();
			remove();
			smellRemove();
			flag = false;
			for(int i = 2; i <= M; i++)
				if(arr[i].x != -1){
					flag = true;
					break;
				}
			++res;
			if(res > 1000){
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(res);
	}
	private static void remove() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(map[i][j] > 0 && cur[i][j]){
					smell[i][j] = k;
					q.offer(map[i][j]);
				}
		
		for(int i = 1; i <= M; i++)
			if(!q.contains(i)) arr[i].x = -1;
				
	}
	private static void smellRemove() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(map[i][j] != 0 && !cur[i][j]){
					smell[i][j] -= 1;
					if(smell[i][j] == 0) map[i][j] = 0;
				}
	}
	private static void move() {
		for(int i = 1; i <= M; i++){
			if(arr[i].x == -1) continue;
			Pair p = arr[i];
			
			//주변 빈 칸 확인
			int cnt = 0, idx = 0;
			for(int d = 0; d < 4; d++){
				int nx = p.x + dx[d], ny = p.y + dy[d];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || smell[nx][ny] != 0) continue;
				idx = d;
				++cnt;
			}
			
			if(cnt == 0){//빈 칸이 없으면 자기 냄새 있는 곳으로
				cnt = 0;
				idx = 0;
				for(int d = 0; d < 4; d++){
					int nx = p.x + dx[d], ny = p.y + dy[d];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != i) continue;
					idx = d;
					++cnt;
				}
				if(cnt == 0) System.out.println("이동 x");
				else if(cnt == 1){//자기 냄새가 나는 칸이 하나
					int nx = p.x + dx[idx], ny = p.y + dy[idx]; 
					cur[nx][ny] = true;
					map[nx][ny] = i;
					arr[i].x = nx;
					arr[i].y = ny;
					dir[i] = idx;
				}
				else{//자기 냄새가 나는 칸이 여러 개
					for(int d = 0; d < 4; d++){
						int nx = p.x + dx[nd[i][dir[i]][d]], ny = p.y + dy[nd[i][dir[i]][d]];
						if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != i) continue;
						dir[i] = nd[i][dir[i]][d];
						cur[nx][ny] = true;
						map[nx][ny] = i;
						arr[i].x = nx;
						arr[i].y = ny;
						break;
					}
				}
			}
			else if(cnt == 1){//빈 칸이 하나라면 그곳으로 이동
				int nx = p.x + dx[idx], ny = p.y + dy[idx]; 
				if(map[nx][ny] == 0){//빈 칸
					map[nx][ny] = i;
					arr[i].x = nx;
					arr[i].y = ny;
					dir[i] = idx;
				}
				else if(map[nx][ny] < i){//더 강한 상어가 있다
					arr[i].x = -1;
				}
				else{//내가 더 강한 상어다
					map[nx][ny] = i;
					arr[i].x = nx;
					arr[i].y = ny;
					dir[i] = idx;
				}
				cur[nx][ny] = true;
			}
			else{//빈 칸 여러 개면 우선순위에 따라 이동
				for(int d = 0; d < 4; d++){
					int nx = p.x + dx[nd[i][dir[i]][d]], ny = p.y + dy[nd[i][dir[i]][d]];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || smell[nx][ny] != 0) continue;
					dir[i] = nd[i][dir[i]][d];
					cur[nx][ny] = true;
					if(map[nx][ny] == 0){//아무도 없다
						map[nx][ny] = i;
						arr[i].x = nx;
						arr[i].y = ny;
					}
					else if(map[nx][ny] < i){//더 강한 상어가 있다
						arr[i].x = -1;
					}
					else{//내가 더 강한 상어다
						map[nx][ny] = i;
						arr[i].x = nx;
						arr[i].y = ny;
						dir[i] = idx;
					}
					break;
				}
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