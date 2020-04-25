import java.util.*;

public class Main {
	static int N;
	static boolean end = false;
	static String[][] arr = new String[8][8];
	static boolean[][][][][] chk = new boolean[8][8][8][8][64];
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        for(int i = 7; i >= 0; i--)
        	for(int j = 0; j < 8; j++)
        		arr[i][j] = (char)(j + 'a') + "" + (8 - i);
        
        ArrayList<String> path = new ArrayList<>();
        path.add("a1");
        solve(7, 0, 7, 0, 0, path);
    }
	private static void solve(int x, int y, int px, int py, int cnt, ArrayList<String> path) {
		if(end) return;
		if(cnt == N){
			if(x == 0 && y == 7){
				end = true;
				for(String str : path)
					System.out.print(str + " ");
			}
			return;
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 1; j < 8; j++){
				int nx = x + (dx[i] * j), ny = y + (dy[i] * j);
				if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8) break;
				if(path.contains(arr[nx][ny]) || chk[nx][ny][x][y][cnt]) continue;
				path.add(arr[nx][ny]);
				chk[nx][ny][x][y][cnt] = true;
				solve(nx, ny, x, y, cnt + 1, path);
				path.remove(path.size()-1);
				chk[nx][ny][x][y][cnt] = false;
			}
		}
	}
}