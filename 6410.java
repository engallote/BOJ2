import java.util.*;

public class Main {
	static int res;
	static int[][] map, chk;
	static Pair[] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	map = new int[8][8];
    	chk = new int[8][8];
    	arr = new Pair[64];
    	int T = sc.nextInt();
    	
    	while(--T >= 0) {
    		int idx = 0;
    		for(int i = 0; i < 8; i++)
    			for(int j = 0; j < 8; j++) {
    				map[i][j] = sc.nextInt();
    				arr[idx] = new Pair(i, j, map[i][j]);
    				idx += 1;
    			}
    		
    		res = 0;
    		dfs(0, 0, 0);
    		int len = Integer.toString(res).length();
    		
    		for(int i = 0; i < 5 - len; i++) System.out.print(" ");
    		System.out.println(res);
    	}
	}
	private static void dfs(int idx, int cnt, int sum) {
		if(cnt == 8) {
			res = Math.max(res, sum);
			return;
		}
		
		for(int i = idx; i < 64; i++)
			if(chk[arr[i].x][arr[i].y] == 0) {
				check(arr[i].x, arr[i].y, 1);
				dfs(i + 1, cnt + 1, sum + arr[i].num);
				check(arr[i].x, arr[i].y, -1);
			}
	}
	private static void check(int x, int y, int v) {
		for(int i = 0; i < 8; i++) {
			chk[x][i] += v;
			chk[i][y] += v;
		}
		
		for(int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--,j--) chk[i][j] += v;
		for(int i = x - 1, j = y + 1; i >= 0 && j < 8; i--,j++) chk[i][j] += v;
		for(int i = x + 1, j = y - 1; i < 8 && j >= 0; i++,j--) chk[i][j] += v;
		for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++,j++) chk[i][j] += v;
	}
}
class Pair {
	int x, y, num;
	Pair(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}