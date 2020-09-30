import java.util.*;

public class Main {
	static int M, N, P, hp;
	static HashMap<Character, Integer> hm = new HashMap<>();
	static int[] attack, move;
	static char[][] mp;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		P = sc.nextInt();
		mp = new char[N][M];
		move = new int[P];
		attack = new int[P];
		chk = new boolean[N][M];
		int idx = 0;
		Queue<Pair> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			mp[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) {
				if(mp[i][j] >= 'a' && mp[i][j] <= 'z') {
					q.offer(new Pair(i, j));
					hm.put(mp[i][j], idx);
					++idx;
				}
			}
		}
		
		for(int i = 0; i < P; i++) {
			char ch = sc.next().charAt(0);
			int num = sc.nextInt();
			
			attack[hm.get(ch)] = num;
		}
		
		hp = sc.nextInt();
		
		for(int i = 0; i < P; i++) 
			move[i] = bfs(q.peek().x, q.poll().y);
		
		solve();
	}
	private static int bfs(int x, int y) {
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int size, time = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || mp[nx][ny] == 'X' || chk[nx][ny])
						continue;
					if(mp[nx][ny] == 'B') return time;
					
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
		}
		return -1;
	}
	private static void solve() {
		HashSet<Integer> hs = new HashSet<>();
		while(hp > 0) {
			//attack
			for(int i = 0; i < P; i++)
				if(move[i] == 0) {
					hp -= attack[i];
					hs.add(i);
				}
			
			if(hp <= 0) break;
			
			//move
			for(int i = 0; i < P; i++)
				if(move[i] > 0)
					move[i] -= 1;
		}
		
		System.out.println(hs.size());
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}