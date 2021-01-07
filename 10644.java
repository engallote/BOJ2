import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N + 1][M];
		int[][] arr = new int[N + 1][2];
		
		int min = 1000000;
		arr[0][0] = 1000000;
		arr[0][1] = -1;
		Arrays.fill(map[0], '.');
		for(int i = 1; i <= N; i++) {
			arr[i][0] = 1000000;
			arr[i][1] = -1;
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				if(map[i][j] == 'J') {
					min = Math.min(min, i);
					arr[i][0] = Math.min(arr[i][0], j);
					arr[i][1] = Math.max(arr[i][1], j);
				}
		}
		
		int y = 0, d = 1, r = N, res = 0;
		
		while(r >= min) {
			int ny = 0;
			if(d == 1) {//¿À¸¥ÂÊ
				ny = Math.max(arr[r][1], Math.max(y, arr[r-1][1]));
				
				if(ny != -1) {
					res += ny - y;
					y = ny;
				}
				
			}
			else {//¿ÞÂÊ
				ny = Math.min(arr[r][0], Math.min(y, arr[r-1][0]));
				
				if(ny != 1000000) {
					res += y - ny;
					y = ny;
				}
			}
			if(r > min) ++res;
			--r;
			d *= -1;
		}
		
		System.out.println(res);
	}
}