import java.util.*;

public class Main {
	static int N, M;
	static boolean flag;
	static String res;
	static char[][] arr;
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0){
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new char[N][M];
			aly.clear();
			res = "................................";
			flag = false;
			
			for(int i = 0; i < N; i++){
				arr[i] = sc.next().toCharArray();
				for(int j = 0; j < M; j++)
					if(arr[i][j] == '.') aly.add(new Pair(i, j));
			}
			
			solve(0, "");
			if(!flag) System.out.println("XHAE");
			else System.out.println(res);
		}
	}
	private static void solve(int idx, String path) {
		if(find(path)) return;
		if(idx == 10) return;
		if(idx == 0){
			solve(idx + 1, path + "U");
			solve(idx + 1, path + "L");
			solve(idx + 1, path + "R");
			solve(idx + 1, path + "D");
		}
		else{
			if(path.charAt(idx-1) != 'U') solve(idx + 1, path + "U");
			if(path.charAt(idx-1) != 'L') solve(idx + 1, path + "L");
			if(path.charAt(idx-1) != 'R') solve(idx + 1, path + "R");
			if(path.charAt(idx-1) != 'D') solve(idx + 1, path + "D");
		}
	}
	private static boolean find(String path) {
		for(Pair p : aly){
			int x = p.x, y = p.y;
			for(char c : path.toCharArray()){
				if(arr[x][y] == 'O') break;
				if(c == 'R'){
					while(range(x, y + 1)){
						y += 1;
						if(arr[x][y] == 'O') break;
					}
				}
				else if(c == 'U'){
					while(range(x - 1, y)){
						x -= 1;
						if(arr[x][y] == 'O') break;
					}
				}
				else if(c == 'L'){
					while(range(x, y - 1)){
						y -= 1;
						if(arr[x][y] == 'O') break;
					}
				}
				else if(c == 'D'){
					while(range(x + 1, y)){
						x += 1;
						if(arr[x][y] == 'O') break;
					}
				}
			}
			if(arr[x][y] != 'O') return false;
		}
		if(res.length() > path.length())
			res = path;
		flag = true;
		return true;
	}
	private static boolean range(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M || arr[x][y] == '#') return false;
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