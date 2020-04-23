import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static boolean end;
	static boolean[][] chk;
	static ArrayList<Pair> aly = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        chk = new boolean[N][M];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.next().toCharArray();
        
        int K = sc.nextInt();
        boolean left = true;
        while(--K >= 0){
        	int num = sc.nextInt();
        	
        	solve(num, left);
        	
        	left = !left;
        }
        
        for(int i = 0; i < N; i++)
        	System.out.println(new String(arr[i]));
    }
	private static void dfs(int x, int y) {
		aly.add(new Pair(x, y));
		chk[x][y] = true;
		if(x == N - 1) end = true;
		
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] == '.')
				continue;
			dfs(nx, ny);
		}
	}
	private static void solve(int num, boolean left) {
		int r = N - num, y = -1;
		if(!left){//right -> left
			for(int i = M - 1; i >= 0; i--)
				if(arr[r][i] == 'x'){
					arr[r][i] = '.';
					y = i;
					break;
				}
		}
		else{
			for(int i = 0; i < M; i++)
				if(arr[r][i] == 'x'){
					arr[r][i] = '.';
					y = i;
					break;
				}
		}
		
		if(y != -1){
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < N; j++)//초기화
					Arrays.fill(chk[j], false);
				int nx = r + dx[i], ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '.')
					continue;
				end = false;
				aly.clear();
				dfs(nx, ny);
				if(end) continue;
				down();
			}
		}
		
	}
	private static void down() {
		Collections.sort(aly);
		boolean flag = true;
		while(true){
			for(Pair p : aly)
				arr[p.x][p.y] = '.';//초기화
			
			for(Pair p : aly)
				if(p.x + 1 >= N || arr[p.x + 1][p.y] == 'x'){
					flag = false;
					break;
				}
			
			for(int i = 0; i < aly.size(); i++){
				if(flag) aly.get(i).x = aly.get(i).x + 1;
				arr[aly.get(i).x][aly.get(i).y] = 'x';
			}
			if(!flag) break;
		}//while
	}
}
class Pair implements Comparable<Pair>{
	int x, y, idx;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		return o.x > this.x ? 1 : (o.x == this.x ? 0 : -1);
	}
}