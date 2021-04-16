import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static ArrayList<Pair> wolf;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new char[N][M];
    	wolf = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		map[i] = sc.next().toCharArray();
    		for(int j = 0; j < M; j++)
    			if(map[i][j] == 'W') wolf.add(new Pair(i, j));
    	}
    	
    	if(wolf.isEmpty()) {
    		loop:for(int i = 0; i < N; i++)
    			for(int j = 0; j < M; j++)
    				if(map[i][j] == '.') {
    					map[i][j] = 'D';
    					break loop;
    				}
    	}
    	else {
    		for(Pair p : wolf) {
        		for(int i = 0; i < 4; i++) {
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			
        			if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'W') continue;
        			if(map[nx][ny] == 'S') {
        				System.out.println(0);
        				return;
        			}
        			map[nx][ny] = 'D';
        		}
        	}
    	}
    	
        System.out.println(1);
    	for(int i = 0; i < N; i++)
    		System.out.println(new String(map[i]));
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}