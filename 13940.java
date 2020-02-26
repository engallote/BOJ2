import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dx = {1, 0}, dy = {0, 1};
        char[][] arr = new char[N][M];
        boolean[][] chk = new boolean[N][M];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.next().toCharArray();
        
        Queue<Pair> q = new LinkedList<Pair>(), tmp = new LinkedList<Pair>();
        StringBuilder sb = new StringBuilder();
        q.offer(new Pair(0, 0));
        sb.append(arr[0][0]);
        
        while(true){
        	while(!q.isEmpty()) tmp.offer(q.poll());
        	char c = 'z';
        	
        	while(!tmp.isEmpty()){
        		Pair p = tmp.poll();
        		
        		for(int i = 0; i < 2; i++){
        			int nx = p.x + dx[i], ny = p.y + dy[i];
        			if(nx >= N || ny >= M || chk[nx][ny]) continue;
        			chk[nx][ny] = true;
        			
        			if(c == arr[nx][ny]) q.offer(new Pair(nx, ny));
        			else if(c > arr[nx][ny]){
        				c = arr[nx][ny];
        				q.clear();
        				q.offer(new Pair(nx, ny));
        			}
        		}
        	}
        	
        	if(sb.toString().length() < N + M - 1) sb.append(c);
        	else break;
        	tmp.clear();
        }
        
        System.out.println(sb.toString());
    }
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}