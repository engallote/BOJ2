import java.util.*;

public class Main {
	static int N, max, idx;
	static boolean finish;
	static int[][] arr;
	static int[] num = new int[7];
	static boolean[][] chk;
	static ArrayList<Pair> aly = new ArrayList<>();
	static ArrayList<Pair>[] numChk = new ArrayList[7];
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			N = sc.nextInt();
			arr = new int[N][N];
			chk = new boolean[N][N];
			aly.clear();
			Arrays.fill(num, 0);
			finish = false;
			
			for(int i = 0; i < N; i++) {
				char[] ch = sc.next().toCharArray();
				for(int j = 0; j < N; j++)
					arr[i][j] = ch[j] - '0';
			}
			
			//첫 라운드 하기 전에 동일한 숫자가 있는지 검사
			bfs(0, 0);
			
			for(int i = 1; i <= 6; i++)
				numChk[i] = new ArrayList<>();
			
			int res = 0;
			//게임 시작
			while(true) {
				max = 0;
				idx = 0;
				dfs();
				
				if(finish) break;
				aly.addAll(numChk[idx]);
				num[idx] += 1;
				++res;
				
				for(int i = 1; i <= 6; i++)
					numChk[i].clear();
				
				for(int i = 0; i < N; i++)
					Arrays.fill(chk[i], false);
				
				for(Pair p : aly)
					arr[p.x][p.y] = idx;
				
//				for(int i = 0; i < N; i++) {
//					for(int j = 0; j < N; j++)
//						System.out.print(arr[i][j]);
//					System.out.println();
//				}
//				System.out.println("----------");
			}
			
			System.out.println(res);
			for(int i = 1; i <= 6; i++)
				System.out.print(num[i] + " ");
			System.out.println();
		}
	}
	private static void dfs() {
		finish = true;
		for(Pair p : aly) {
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == arr[p.x][p.y] || chk[nx][ny])
					continue;
				
				bfs(nx, ny, arr[nx][ny]);
				finish = false;
				
				if(numChk[arr[nx][ny]].size() > max) {
					max = numChk[arr[nx][ny]].size();
					idx = arr[nx][ny];
				}
				else if(numChk[arr[nx][ny]].size() == max) {
					idx = Math.min(idx, arr[nx][ny]);
				}
			}
		}
	}
	private static void bfs(int x, int y, int num) {
		Queue<Pair> q = new LinkedList<>();
		chk[x][y] = true;
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			numChk[num].add(new Pair(p.x, p.y));
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || arr[nx][ny] != num)
					continue;
				
				chk[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
	}
	private static void bfs(int x, int y) {
		chk[x][y] = true;
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			aly.add(p);
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || arr[nx][ny] != arr[x][y])
					continue;
				
				chk[nx][ny] = true;
				q.offer(new Pair(nx, ny));
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