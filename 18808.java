import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static int[][] sti;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];
		boolean flag;
		
		while(--K >= 0){
			int R = sc.nextInt();
			int C = sc.nextInt();
			sti = new int[R][C];
			flag = false;
			
			for(int i = 0; i < R; i++)
				for(int j = 0; j < C; j++)
					sti[i][j] = sc.nextInt();
			
			for(int k = 0; k < 4; k++){
				for(int i = 0; i < N; i++){
					for(int j = 0; j < M; j++)
						if(isMatch(i, j, R, C, k)){
							flag = true;
							break;
						}
					if(flag) break;
				}
				if(flag) break;
			}
		}
		
		int res = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 1) ++res;
		
		System.out.println(res);
	}
	private static boolean isMatch(int x, int y, int r, int c, int d) {
		boolean flag = true;
		
		if(d == 0){//0
			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++){
					if(x + i >= N || y + j >= M || (arr[x + i][y + j] == 1 && sti[i][j] == 1)){
						flag = false;
						break;
					}
				}
				if(!flag) break;
			}
			
			if(flag){
				for(int i = 0; i < r; i++){
					for(int j = 0; j < c; j++)
						arr[x + i][y + j] = Math.max(sti[i][j], arr[x + i][y + j]);
				}
				return true;
			}
		}
		else if(d == 1){//90
			flag = true;
			
			int[][] tmp = new int[c][r];
			for(int i = 0; i < c; i++)
				for(int j = r - 1; j >= 0; j--)
					tmp[i][(r-1)-j] = sti[j][i];
			
			for(int i = 0; i < c; i++){
				for(int j = 0; j < r; j++)
					if(x + i >= N || y + j >= M || (arr[x + i][y + j] == 1 && tmp[i][j] == 1)){
						flag = false;
						break;
					}
				if(!flag) break;
			}
			
			if(flag){
				for(int i = 0; i < c; i++){
					for(int j = 0; j < r; j++)
						arr[x + i][y + j] = Math.max(tmp[i][j], arr[x + i][y + j]);
				}
				return true;
			}
		}
		else if(d == 2){//180
			flag = true;
			int[][] tmp = new int[r][c];
			for(int j = c - 1; j >= 0; j--)
				for(int i = 0; i < r; i++){
					tmp[(r-1)-i][(c-1)-j] = sti[i][j];
				}
			
			for(int i = 0; i < r; i++){
				for(int j = 0; j < c; j++){
					if(x + i >= N || y + j >= M || (arr[x + i][y + j] == 1 && tmp[i][j] == 1)){
						flag = false;
						break;
					}
				}
				if(!flag) break;
			}
			
			if(flag){
				for(int i = 0; i < r; i++){
					for(int j = 0; j < c; j++)
						arr[x + i][y + j] = Math.max(tmp[i][j], arr[x + i][y + j]);
				}
				return true;
			}
		}
		else{//270
			flag = true;
			int[][] tmp = new int[c][r];
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					tmp[j][i] = sti[i][(c-1)-j];
			
			for(int i = 0; i < c; i++){
				for(int j = 0; j < r; j++)
					if(x + i >= N || y + j >= M || (arr[x + i][y + j] == 1 && tmp[i][j] == 1)){
						flag = false;
						break;
					}
				if(!flag) break;
			}
			
			if(flag){
				for(int i = 0; i < c; i++){
					for(int j = 0; j < r; j++)
						arr[x + i][y + j] = Math.max(tmp[i][j], arr[x + i][y + j]);
				}
				return true;
			}
		}
		return false;
	}
}