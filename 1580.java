import java.util.*;

public class Main {
	static int N, M, ax = 0, ay = 0, bx = 0, by = 0;
	static char[][] arr;
	static boolean[][][][] chk;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new char[N][M];
		chk = new boolean[N][M][N][M];
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++){
				if(arr[i][j] == 'A'){
					arr[i][j] = '.';
					ax = i;
					ay = j;
				}
				else if(arr[i][j] == 'B'){
					arr[i][j] = '.';
					bx = i;
					by = j;
				}
			}
		}
		Queue<ArrayList<Pair>> q = new LinkedList<ArrayList<Pair>>();
		ArrayList<Pair> aly = new ArrayList<>();
		chk[ax][ay][bx][by] = true;
		aly.add(new Pair(ax, ay));
		aly.add(new Pair(bx, by));
		q.offer(aly);
		bfs(q);
	}
	private static void bfs(Queue<ArrayList<Pair>> q) {
		int size = 0, time = 0;
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				ArrayList<Pair> p = q.poll();
				Pair A = p.get(0), B = p.get(1);
				
				if(A.x == bx && A.y == by && B.x == ax && B.y == ay){
					System.out.println(time);
					return;
				}
				
				for(int i = 0; i < 8; i++){
					int nax = A.x + dx[i], nay = A.y + dy[i];
					if(!range(nax, nay)) continue;
					for(int j = 0; j < 8; j++){
						if(side(i, j, A, B)) continue;
						int nbx = B.x + dx[j], nby = B.y + dy[j];
						if(!range(nbx, nby) || chk[nax][nay][nbx][nby] || (nax == nbx && nay == nby))
							continue;
						
						chk[nax][nay][nbx][nby] = true;
						ArrayList<Pair> next = new ArrayList<>();
						next.add(new Pair(nax, nay));
						next.add(new Pair(nbx, nby));
						q.offer(next);
						if(!chk[A.x][A.y][nbx][nby] && (A.x != nbx || A.y != nby)){
							chk[A.x][A.y][nbx][nby] = true;
							ArrayList<Pair> next2 = new ArrayList<>();
							next2.add(A);
							next2.add(new Pair(nbx, nby));
							q.offer(next2);
						}
					}
					if(!chk[nax][nay][B.x][B.y] && (nax != B.x || nay != B.y)){
						chk[nax][nay][B.x][B.y] = true;
						ArrayList<Pair> next = new ArrayList<>();
						next.add(new Pair(nax, nay));
						next.add(B);
						q.offer(next);
					}
				}
			}
			++time;
		}
		System.out.println(-1);
	}
	private static boolean side(int ad, int bd, Pair a, Pair b) {
		if(ad == 0 && bd == 2){//a는 아래로, b는 위로
			if(a.x == b.x - 1 && a.y == b.y) return true;
			else return false;
		}
		if(ad == 2 && bd == 0){//a는 위로, b는 아래로
			if(a.x - 1== b.x && a.y == b.y) return true;
			else return false;
		}
		if(ad == 1 && bd == 3){//a는 오른쪽, b는 왼쪽
			if(a.x == b.x && a.y + 1 == b.y) return true;
			else return false;
		}
		if(ad == 3 && bd == 1){//a는 왼쪽, b는 오른쪽
			if(a.x == b.x && a.y == b.y + 1) return true;
			else return false;
		}
		if(ad == 4 && bd == 7){//a는 대각선 아래 오른쪽, b는 대각선 위 왼쪽
			if(a.x == b.x - 1 && a.y == b.y - 1) return true;
			else return false;
		}
		if(ad == 7 && bd == 4){//a는 대각선 위 왼쪽, b는 대각선 아래 오른쪽 
			if(a.x - 1 == b.x && a.y - 1 == b.y) return true;
			else return false;
		}
		if(ad == 5 && bd == 6){//a는 대각선 아래 왼쪽, b는 대각선 위 오른쪽
			if(a.x == b.x - 1 && a.y == b.y + 1) return true;
			else return false;
		}
		if(ad == 6 && bd == 5){//a는 대각선 위 오른쪽, b는 대각선 아래 왼쪽
			if(a.x - 1 == b.x && a.y + 1 == b.y) return true;
			else return false;
		}
		return false;
	}
	private static boolean range(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M || arr[x][y] == 'X') return false;
		return true;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}