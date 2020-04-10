import java.util.*;

public class Main {
	static int N, M, res;
	static boolean end;
	static int[] cur;
	static int[][] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cur = new int[N];
		chk = new boolean[N];
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++)
			cur[i] = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		M = sc.nextInt();
		end = false;
		res = 0;
		solve(0, N);
		
		System.out.println(res);
	}
	private static void solve(int time, int survive) {
		if(end) return;
		res = Math.max(res, time);
		if(survive == 1){
			if(!chk[M]) end = true;//best choice
			return;
		}
		if(chk[M]) return;
		
		if(survive % 2 == 0){//night
			for(int i = 0; i < N; i++)
				if(i != M && !chk[i]){
					chk[i] = true;
					changeCur(i, 1);
					solve(time + 1, survive - 1);
					changeCur(i, -1);
					chk[i] = false;
				}
		}
		else{//day
			int m = findM();
			if(m != -1){
				chk[m] = true;
				solve(time, survive - 1);
				chk[m] = false;
			}
		}
	}
	private static int findM() {
		int max = Integer.MIN_VALUE, midx = -1;
		for(int i = 0; i < N; i++)
			if(!chk[i] && max < cur[i]){
				max = cur[i];
				midx = i;
			}
		return midx;
	}
	private static void changeCur(int idx, int d) {
		for(int i = 0; i < N; i++)
			if(i != idx && !chk[i]) cur[i] += arr[idx][i] * d;
	}
}