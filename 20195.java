import java.util.*;

public class Main {
	static int N, M, ret = Integer.MAX_VALUE;
	static char c = '.';
	static char[][] map;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		chk = new boolean[N][M];
		
		int x = 0, y = 0;
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				if(map[i][j] == 'o') {
					x = i;
					y = j;
				}
		}
		
		goWest(x, y);
		goSouth(x, y);
		goNorth(x, y);
		goEast(x, y);
		
		if(ret != Integer.MAX_VALUE) {
			System.out.println(":)");
			System.out.println(c);
		}
		else System.out.println(":(");
	}
	private static void goWest(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		
		if(y - 1 >= 0 && map[x][y] != '.') {
			q.offer(new Pair(x, y - 1));
			int size, cnt = 0;
			
			loop:while(!q.isEmpty()) {
				size = q.size();
				while(--size >= 0) {
					Pair p = q.poll();
					
					if(map[p.x][p.y] == 'x') {
						if(ret > cnt) {
							ret = cnt;
							c = 'W';
							break loop;
						}
						else if(ret == cnt) {
							c = 'W';
							break loop;
						}
					}
					
					if(map[p.x][p.y] == '>' && !chk[p.x][p.y + 1]) {
						chk[p.x][p.y + 1] = true;
						q.offer(new Pair(p.x, p.y + 1));
					}
					else if(map[p.x][p.y] == '^' && !chk[p.x - 1][p.y]) {
						chk[p.x - 1][p.y] = true;
						q.offer(new Pair(p.x - 1, p.y));
					}
					else if(map[p.x][p.y] == '<' && !chk[p.x][p.y - 1]) {
						chk[p.x][p.y - 1] = true;
						q.offer(new Pair(p.x, p.y - 1));
					}
					else if(map[p.x][p.y] == 'v' && !chk[p.x + 1][p.y]) {
						chk[p.x + 1][p.y] = true;
						q.offer(new Pair(p.x + 1, p.y));
					}
				}
				++cnt;
			}
		}
	}
	private static void goSouth(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		
		if(x + 1 < N && map[x][y] != '.') {
			q.offer(new Pair(x + 1, y));
			int size, cnt = 0;
			
			loop:while(!q.isEmpty()) {
				size = q.size();
				while(--size >= 0) {
					Pair p = q.poll();
					
					if(map[p.x][p.y] == 'x') {
						if(ret > cnt) {
							ret = cnt;
							c = 'S';
							break loop;
						}
						else if(ret == cnt) {
							c = 'S';
							break loop;
						}
					}
					
					if(map[p.x][p.y] == '>' && !chk[p.x][p.y + 1]) {
						chk[p.x][p.y + 1] = true;
						q.offer(new Pair(p.x, p.y + 1));
					}
					else if(map[p.x][p.y] == '^' && !chk[p.x - 1][p.y]) {
						chk[p.x - 1][p.y] = true;
						q.offer(new Pair(p.x - 1, p.y));
					}
					else if(map[p.x][p.y] == '<' && !chk[p.x][p.y - 1]) {
						chk[p.x][p.y - 1] = true;
						q.offer(new Pair(p.x, p.y - 1));
					}
					else if(map[p.x][p.y] == 'v' && !chk[p.x + 1][p.y]) {
						chk[p.x + 1][p.y] = true;
						q.offer(new Pair(p.x + 1, p.y));
					}
				}
				++cnt;
			}
		}
	}
	private static void goNorth(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		
		if(x - 1 >= 0 && map[x][y] != '.') {
			q.offer(new Pair(x - 1, y));
			int size, cnt = 0;
			
			loop:while(!q.isEmpty()) {
				size = q.size();
				while(--size >= 0) {
					Pair p = q.poll();
					
					if(map[p.x][p.y] == 'x') {
						if(ret > cnt) {
							ret = cnt;
							c = 'N';
							break loop;
						}
						else if(ret == cnt) {
							c = 'N';
							break loop;
						}
					}
					
					if(map[p.x][p.y] == '>' && !chk[p.x][p.y + 1]) {
						chk[p.x][p.y + 1] = true;
						q.offer(new Pair(p.x, p.y + 1));
					}
					else if(map[p.x][p.y] == '^' && !chk[p.x - 1][p.y]) {
						chk[p.x - 1][p.y] = true;
						q.offer(new Pair(p.x - 1, p.y));
					}
					else if(map[p.x][p.y] == '<' && !chk[p.x][p.y - 1]) {
						chk[p.x][p.y - 1] = true;
						q.offer(new Pair(p.x, p.y - 1));
					}
					else if(map[p.x][p.y] == 'v' && !chk[p.x + 1][p.y]) {
						chk[p.x + 1][p.y] = true;
						q.offer(new Pair(p.x + 1, p.y));
					}
				}
				++cnt;
			}
		}
	}
	private static void goEast(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		
		if(y + 1 < M && map[x][y] != '.') {
			q.offer(new Pair(x, y + 1));
			int size, cnt = 0;
			
			loop:while(!q.isEmpty()) {
				size = q.size();
				while(--size >= 0) {
					Pair p = q.poll();
					
					if(map[p.x][p.y] == 'x') {
						if(ret > cnt) {
							ret = cnt;
							c = 'E';
							break loop;
						}
						else if(ret == cnt) {
							c = 'E';
							break loop;
						}
					}
					
					if(map[p.x][p.y] == '>' && !chk[p.x][p.y + 1]) {
						chk[p.x][p.y + 1] = true;
						q.offer(new Pair(p.x, p.y + 1));
					}
					else if(map[p.x][p.y] == '^' && !chk[p.x - 1][p.y]) {
						chk[p.x - 1][p.y] = true;
						q.offer(new Pair(p.x - 1, p.y));
					}
					else if(map[p.x][p.y] == '<' && !chk[p.x][p.y - 1]) {
						chk[p.x][p.y - 1] = true;
						q.offer(new Pair(p.x, p.y - 1));
					}
					else if(map[p.x][p.y] == 'v' && !chk[p.x + 1][p.y]) {
						chk[p.x + 1][p.y] = true;
						q.offer(new Pair(p.x + 1, p.y));
					}
				}
				++cnt;
			}
		}
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}