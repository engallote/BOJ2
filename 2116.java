import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] dice;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	dice = new int[N][6];
    	
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 6; j++)
    			dice[i][j] = Integer.parseInt(st.nextToken());
    	}
    	
    	int res = 0;
    	for(int i = 0; i < 6; i++) {
			int max = rotate(0, i);
			res = Math.max(res, solve(dice[0][i]) + max);
		}
    	System.out.println(res);
    }
	private static int solve(int p) {
		int up = p, sum = 0;
		for(int k = 1; k < N; k++) {
			int under = 0, max = 0;
			for(int j = 0; j < 6; j++)
				if(dice[k][j] == up) {
					//¹Ø¸é Ã£À½
					under = j;
					break;
				}
			
			if(under == 0) {
				up = dice[k][5];
				for(int i = 1; i < 5; i++) max = Math.max(max, dice[k][i]);
			}
			else if(under == 1) {
				up = dice[k][under + 2];
				for(int i = 0; i < 6; i++)
					if(i != under && i != under + 2) max = Math.max(max, dice[k][i]);
			}
			else if(under == 2) {
				up = dice[k][under + 2];
				for(int i = 0; i < 6; i++)
					if(i != under && i != under + 2) max = Math.max(max, dice[k][i]);
			}
			else if(under == 3) {
				up = dice[k][under - 2];
				for(int i = 0; i < 6; i++)
					if(i != under && i != under - 2) max = Math.max(max, dice[k][i]);
			}
			else if(under == 4) {
				up = dice[k][under - 2];
				for(int i = 0; i < 6; i++)
					if(i != under && i != under - 2) max = Math.max(max, dice[k][i]);
			}
			else {
				up = dice[k][0];
				for(int i = 1; i < 5; i++) max = Math.max(max, dice[k][i]);
			}
			
			sum += max;
		}
		
		return sum;
	}
	private static int rotate(int idx, int r) {
		//rÀ» À­¸éÀ¸·Î
		int max = 0;
		if(r == 0) {
			for(int i = 1; i < 5; i++) max = Math.max(max, dice[idx][i]);
		}
		else if(r == 1) {
			for(int i = 0; i < 6; i++)
				if(i != r && i != r + 2) max = Math.max(max, dice[idx][i]);
		}
		else if(r == 2) {
			for(int i = 0; i < 6; i++)
				if(i != r && i != r + 2) max = Math.max(max, dice[idx][i]);
		}
		else if(r == 3) {
			for(int i = 0; i < 6; i++)
				if(i != r && i != r - 2) max = Math.max(max, dice[idx][i]);
		}
		else if(r == 4) {
			for(int i = 0; i < 6; i++)
				if(i != r && i != r - 2) max = Math.max(max, dice[idx][i]);
		}
		else {
			for(int i = 1; i < 5; i++) max = Math.max(max, dice[idx][i]);
		}
		return max;
	}
}