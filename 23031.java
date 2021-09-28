import java.util.*;

public class Main {
	static int N;
	static char[] order;
	static char[][] map;
	static boolean[][] light;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	static ArrayList<Pair> zom = new ArrayList<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new char[N][N];
    	light = new boolean[N][N];
    	order = sc.next().toCharArray();
    	
    	for(int i = 0; i < N; i++) {
    		map[i] = sc.next().toCharArray();
    		
    		for(int j = 0; j < N; j++)
    			if(map[i][j] == 'Z') {
    				zom.add(new Pair(i, j, 1));
    				map[i][j] = 'O';
    			}
    	}
    	
    	solve();
	}
	private static void solve() {
		int x = 0, y = 0, d = 0;
		for(int i = 0; i < order.length; i++) {
			char c = order[i];
			
			if(c == 'L')
				d = (d + 1) % 4;
			else if(c == 'R') {
				d -= 1;
				if(d < 0) d = 3;
			}
			else {
				if(x + dx[d] >= 0 && x + dx[d] < N && y + dy[d] >= 0 && y + dy[d] < N) {
					x += dx[d];
					y += dy[d];
				}
			}
			
			if(map[x][y] == 'S') {//switch
				light[x][y] = true;
				for(int j = 0; j < 8; j++) {
					int nx = x + dx[j], ny = y + dy[j];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					light[nx][ny] = true;
				}
			}
			
			for(int j = 0; j < zom.size(); j++) {
				Pair p = zom.get(j);
				
				if(p.x == x && p.y == y) {//아리와 좀비 학생이 만남
					if(!light[x][y]) {
						System.out.println("Aaaaaah!");
						return;
					}
				}
				
				if(p.x + p.d >= 0 && p.x + p.d < N) {
					zom.get(j).x = p.x + p.d;
				}
				else {
					zom.get(j).d *= -1;
				}
				
				if(zom.get(j).x == x && p.y == y) {//아리와 좀비 학생이 만남
					if(light[x][y]) continue;
					else {
						System.out.println("Aaaaaah!");
						return;
					}
				}
			}
		}
		System.out.println("Phew...");
	}
}
class Pair {
	int x, y, d;
	Pair(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}