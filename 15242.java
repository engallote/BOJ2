import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] start = sc.next().toCharArray();
        char[] end = sc.next().toCharArray();
        int[][] arr = new int[8][8];
        int x = start[1]-'0'-1, y = start[0]-'a', ex = end[1]-'0'-1, ey = end[0]-'a';
        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2}, dy = {2, -2, 1, -1, 2, -2, 1, -1};
        arr[x][y] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));
        int size = 0, time = 0;
        
        while(!q.isEmpty()){
        	size = q.size();
        	while(--size >= 0){
        		Pair p = q.poll();
        		
        		if(p.x == ex && p.y == ey){
        			System.out.println(time);
        			return;
        		}
        		
        		for(int i = 0; i < 8; i++){
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8 || arr[nx][ny] == 1) continue;
        			arr[nx][ny] = 1;
        			q.offer(new Pair(nx, ny));
        		}
        	}
        	++time;
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