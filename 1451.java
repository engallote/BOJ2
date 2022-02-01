import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new char[N][M];
    	for(int i = 0; i < N; i++) arr[i] = sc.next().toCharArray();
    	
    	long res = 0;
    	//세로로 자르기
    	for(int i = 0; i < M - 2; i++)
    		for(int j = i + 1; j < M - 1; j++)
    			res = Math.max(res, sum(0, 0, N - 1, i) * sum(0, i + 1, N - 1, j) * sum(0, j + 1, N - 1, M - 1));
    	
    	//가로로 자르기
    	for(int i = 0; i < N - 2; i++)
    		for(int j = i + 1; j < N - 1; j++)
    			res = Math.max(res, sum(0, 0, i, M - 1) * sum(i + 1, 0, j, M - 1) * sum(j + 1, 0, N - 1, M - 1));
    	
    	//왼쪽에 2개, 오른쪽에 1개
    	for(int i = 0; i < N - 1; i++)
    		for(int j = 0; j < M - 1; j++)
    			res = Math.max(res, sum(0, 0, i, j) * sum(i + 1, 0, N - 1, j) * sum(0, j + 1, N - 1, M - 1));
    	
    	//왼쪽에 1개, 오른쪽에 2개
    	for(int i = 0; i < N - 1; i++)
    		for(int j = 1; j < M; j++)
    			res = Math.max(res, sum(0, 0, N - 1, j - 1) * sum(0, j, i, M - 1) * sum(i + 1, j, N - 1, M - 1));
    	
    	//위쪽에 2개, 아래쪽에 1개
    	for(int i = 0; i < M - 1; i++)
    		for(int j = 0; j < N - 1; j++)
    			res = Math.max(res, sum(0, 0, j, i) * sum(0, i + 1, j, M - 1) * sum(j + 1, 0, N - 1, M - 1));
    	
    	//위쪽에 1개, 아래쪽에 2개
    	for(int i = 0; i < M - 1; i++)
    		for(int j = 1; j < N; j++)
    			res = Math.max(res, sum(0, 0, j - 1, M - 1) * sum(j, 0, N - 1, i) * sum(j, i + 1, N - 1, M - 1));
    	
    	System.out.println(res);
    }
	private static long sum(int sx, int sy, int ex, int ey) {
		long ret = 0;
		for(int i = sx; i <= ex; i++)
			for(int j = sy; j <= ey; j++)
				ret += arr[i][j] - '0';
		return ret;
	}
}