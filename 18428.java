import java.util.*;

public class Main {
	static int N;
	static boolean flag = false;
	static char[][] arr;
	static ArrayList<Pair> aly = new ArrayList<>(), teacher = new ArrayList<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++){
        		arr[i][j] = sc.next().charAt(0);
        		if(arr[i][j] == 'X') aly.add(new Pair(i, j));
        		else if(arr[i][j] == 'T') teacher.add(new Pair(i, j));
        	}
        
        dfs(0, 0);
        
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
	private static void dfs(int idx, int cnt) {
		if(cnt > 3) return;
		if(idx == aly.size()){
			if(cnt < 3) return;
			find();
			return;
		}
		
		arr[aly.get(idx).x][aly.get(idx).y] = 'O';
		dfs(idx + 1, cnt + 1);
		arr[aly.get(idx).x][aly.get(idx).y] = 'X';
		dfs(idx + 1, cnt);
	}
	private static void find() {
		for(int i = 0; i < teacher.size(); i++){
			Pair p = teacher.get(i);
			
			for(int j = p.y + 1; j < N; j++){
				if(arr[p.x][j] == 'S') return;
				if(arr[p.x][j] == 'O') break;
			}
			for(int j = p.y - 1; j >= 0; j--){
				if(arr[p.x][j] == 'S') return;
				if(arr[p.x][j] == 'O') break;
			}
			for(int j = p.x + 1; j < N; j++){
				if(arr[j][p.y] == 'S') return;
				if(arr[j][p.y] == 'O') break;
			}
			for(int j = p.x - 1; j >= 0; j--){
				if(arr[j][p.y] == 'S') return;
				if(arr[j][p.y] == 'O') break;
			}
		}
		flag = true;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}