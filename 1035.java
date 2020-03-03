import java.util.*;

public class Main {
	static int len = 0, res = Integer.MAX_VALUE;
	static char[][] arr = new char[5][5];
	static boolean[][] chk = new boolean[5][5], chk2 = new boolean[5][5];
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
        	arr[i] = sc.next().toCharArray();
        	for(int j = 0; j < 5; j++)
        		if(arr[i][j] == '*'){
        			arr[i][j] = '.';
        			++len;
        			aly.add(new Pair(i, j));
        		}
        }
        
        if(len == 1){
        	System.out.println(0);
        	return;
        }
        
        dfs(0, 0);
        
        System.out.println(res);
    }
	private static void con(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || arr[nx][ny] == '.' || chk[nx][ny])
					continue;
				chk[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
	}
	private static void dfs(int idx, int sum) {
		if(res < sum) return;
		if(idx == len){
			int cnt = 0;
			for(int i = 0; i < 5; i++)
				Arrays.fill(chk[i], false);
			
			for(int i = 0; i < 5; i++)
				for(int j = 0; j < 5; j++)
					if(arr[i][j] == '*' && !chk[i][j]){
						con(i, j);
						++cnt;
					}
					
			if(cnt == 1) res = Math.min(res, sum);
			return;
		}
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				if(arr[i][j] == '.'){
					arr[i][j] = '*';
					dfs(idx + 1, sum + Math.abs(aly.get(idx).x - i) + Math.abs(aly.get(idx).y - j));
					arr[i][j] = '.';
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