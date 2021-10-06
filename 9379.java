import java.util.*;

public class Main {
	static int N, M, res;
	static char[][] map, tmp;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		N = sc.nextInt();
    		M = sc.nextInt();
    		res = 0;
    		
    		if(N == 0 && M == 0) break;
    		
    		map = new char[N][M];
    		tmp = new char[N][M];
    		
    		for(int i = 0; i < N; i++)
    			map[i] = sc.next().toCharArray();
    		
    		solve(N - 1);
    		System.out.println(res);
    	}
	}
	private static void solve(int idx) {
		if(idx < 1) return;
		
		for(int i = 0; i < M;) {
			int num = map[idx][i] - '0';
			if(num == 0) {
				i += 1;
				continue;
			}
			
			int ret = down(idx, i, i + num) + num;
			res = Math.max(res, ret);
			
			i += num;
		}
		
		solve(idx - 1);
	}
	private static int down(int idx, int s, int e) {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				tmp[i][j] = map[i][j];
			
			if(i == idx)
				for(int j = s; j < e; j++) tmp[i][j] = '0';
		}
		
		for(int i = idx - 1; i >= 0; i--) {
			for(int j = 0; j < M;) {
				int num = tmp[i][j] - '0';
				if(num == 0) {
					j += 1;
					continue;
				}
				boolean flag = true;
				int cnt = 0;
				
				for(int k = j; k < Math.min(j + num, M); k++) {
					if(tmp[i][k] - '0' != num) {
						flag = false;
						break;
					}
					++cnt;
				}
				
				if(!flag || cnt != num) {
					j += 1;
					continue;
				}
				
				for(int k = j; k < Math.min(j + num, M); k++)
					if(tmp[i + 1][k] != '0') {
						flag = false;
						break;
					}
				
				if(flag) {
					sum += num;
					for(int k = j; k < Math.min(j + num, M); k++)
						tmp[i][k] = '0';
				}
				j += num;
			}
		}
		return sum;
	}
}