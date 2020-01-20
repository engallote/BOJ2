import java.util.*;

public class Main {
	static boolean end;
	static int[] res = new int[5];
	static int[][] arr = new int[9][9];
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(--N >= 0){
			aly.clear();
			end = false;
			for(int i = 0; i < 9; i++){
				char[] ch = sc.next().toCharArray();
				for(int j = 0; j < 9; j++){
					arr[i][j] = ch[j] - '0';
					if(arr[i][j] == 0) aly.add(new Pair(i, j));
				}
			}
			
			solve(0);
			if(!end) System.out.println("Could not complete this grid.");
			System.out.println();
		}
	}
	private static void solve(int idx) {
		if(end) return;
		if(idx >= aly.size()){
			for(int i = 0; i < 9; i++)
				for(int j = 0; j < 9; j++)
					if(!find(i, j)) return;
			end = true;
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++)
					System.out.print(arr[i][j]);
				System.out.println();
			}
			return;
		}
		for(int i = 1; i <= 9; i++){
			arr[aly.get(idx).x][aly.get(idx).y] = i;
			solve(idx + 1);
			arr[aly.get(idx).x][aly.get(idx).y] = 0;
		}
	}
	private static boolean find(int x, int y) {
		int num = arr[x][y];
		for(int i = 0; i < 9; i++){//hor, ver
			if(i != y && arr[x][i] == num) return false;
			if(i != x && arr[i][y] == num) return false;
		}
		
		int nx = (x / 3) * 3, ny = (y / 3) * 3;
		for(int i = nx; i < nx + 3; i++)
			for(int j = ny; j < ny + 3; j++){
				if(i == x && j == y) continue;
				if(arr[i][j] == num) return false;
			}
		
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