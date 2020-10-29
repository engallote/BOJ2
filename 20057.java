import java.util.*;

public class Main {
	static int N, res;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		res = 0;
		
		for(int i = 0; i < N; ++i)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		int x = N / 2, y = N / 2, cnt = 1, sw = 0, d = 0;
		boolean flag = true;
		for(int t = 1; flag; t++) {
			for(int i = 0; i < cnt; i++) {
				x += dx[d];
				y += dy[d];
				if(x < 0 || y < 0 || x >= N || y >= N) {
					flag = false;
					break;
				}
				if(d == 0) toLeft(x, y);
				else if(d == 1) toDown(x, y);
				else if(d == 2) toRight(x, y);
				else toUp(x, y);
			}
			
			d = (d + 1) % 4;
			if(t % 2 == 0) ++cnt;
		}
		
		System.out.println(res);
	}
	private static void toLeft(int x, int y) {
		int ten = (int) (arr[x][y] * 0.10), sev = (int) (arr[x][y] * 0.07), fiv = (int) (arr[x][y] * 0.05), two = (int) (arr[x][y] * 0.02), one = (int) (arr[x][y] * 0.01);
		arr[x][y] -= 2 * one + 2 * two + 2 * sev + 2 * ten + fiv;
		
		//1%
		if(y + 1 < N) {
			if(x - 1 >= 0) arr[x - 1][y + 1] += one;
			else res += one;
			if(x + 1 < N) arr[x + 1][y + 1] += one;
			else res += one;
		}
		else res += one * 2;
		
		//2%
		if(x - 2 >= 0) arr[x - 2][y] += two;
		else res += two;
		if(x + 2 < N) arr[x + 2][y] += two;
		else res += two;
		
		//7%
		if(x - 1 >= 0) arr[x - 1][y] += sev;
		else res += sev;
		if(x + 1 < N) arr[x + 1][y] += sev;
		else res += sev;
		
		//10%
		if(y - 1 >= 0) {
			if(x - 1 >= 0) arr[x - 1][y - 1] += ten;
			else res += ten;
			if(x + 1 < N) arr[x + 1][y - 1] += ten;
			else res += ten;
		}
		else res += ten * 2;
		
		//5%
		if(y - 2 >= 0) arr[x][y - 2] += fiv;
		else res += fiv;
		
		//a
		if(y - 1 >= 0) arr[x][y - 1] += arr[x][y];
		else res += arr[x][y];
		arr[x][y] = 0;
	}
	private static void toDown(int x, int y) {
		int ten = (int) (arr[x][y] * 0.10), sev = (int) (arr[x][y] * 0.07), fiv = (int) (arr[x][y] * 0.05), two = (int) (arr[x][y] * 0.02), one = (int) (arr[x][y] * 0.01);
		arr[x][y] -= 2 * one + 2 * two + 2 * sev + 2 * ten + fiv;
		
		//1%
		if(x - 1 >= 0) {
			if(y + 1 < N) arr[x - 1][y + 1] += one;
			else res += one;
			if(y - 1 >= 0) arr[x - 1][y - 1] += one;
			else res += one;
		}
		else res += 2 * one;
		
		//2%
		if(y - 2 >= 0) arr[x][y - 2] += two;
		else res += two;
		if(y + 2 < N) arr[x][y + 2] += two;
		else res += two;
		
		//7%
		if(y - 1 >= 0) arr[x][y - 1] += sev;
		else res += sev;
		if(y + 1 < N) arr[x][y + 1] += sev;
		else res += sev;
		
		//10%
		if(x + 1 < N) {
			if(y - 1 >= 0) arr[x + 1][y - 1] += ten;
			else res += ten;
			if(y + 1 < N) arr[x + 1][y + 1] += ten;
			else res += ten;
		}
		else res += 2 * ten;
		
		//5%
		if(x + 2 < N) arr[x + 2][y] += fiv;
		else res += fiv;
		
		//a
		if(x + 1 < N) arr[x + 1][y] += arr[x][y];
		else res += arr[x][y];
		arr[x][y] = 0;
	}
	private static void toRight(int x, int y) {
		int ten = (int) (arr[x][y] * 0.10), sev = (int) (arr[x][y] * 0.07), fiv = (int) (arr[x][y] * 0.05), two = (int) (arr[x][y] * 0.02), one = (int) (arr[x][y] * 0.01);
		arr[x][y] -= 2 * one + 2 * two + 2 * sev + 2 * ten + fiv;
		
		//1%
		if(y - 1 >= 0) {
			if(x + 1 < N) arr[x + 1][y - 1] += one;
			else res += one;
			if(x - 1 >= 0) arr[x - 1][y - 1] += one;
			else res += one;
		}
		else res += 2 * one;
		
		//2%
		if(x - 2 >= 0) arr[x - 2][y] += two;
		else res += two;
		if(x + 2 < N) arr[x + 2][y] += two;
		else res += two;
		
		//7%
		if(x - 1 >= 0) arr[x - 1][y] += sev;
		else res += sev;
		if(x + 1 < N) arr[x + 1][y] += sev;
		else res += sev;
		
		//10%
		if(y + 1 < N) {
			if(x - 1 >= 0) arr[x - 1][y + 1] += ten;
			else res += ten;
			if(x + 1 < N) arr[x + 1][y + 1] += ten;
			else res += ten;
		}
		else res += 2 * ten;
		
		//5%
		if(y + 2 < N) arr[x][y + 2] += fiv;
		else res += fiv;
		
		//a
		if(y + 1 < N) arr[x][y + 1] += arr[x][y];
		else res += arr[x][y];
		arr[x][y] = 0;
	}
	private static void toUp(int x, int y) {
		int ten = (int) (arr[x][y] * 0.10), sev = (int) (arr[x][y] * 0.07), fiv = (int) (arr[x][y] * 0.05), two = (int) (arr[x][y] * 0.02), one = (int) (arr[x][y] * 0.01);
		arr[x][y] -= 2 * one + 2 * two + 2 * sev + 2 * ten + fiv;
		
		//1%
		if(x + 1 < N) {
			if(y + 1 < N) arr[x + 1][y + 1] += one;
			else res += one;
			if(y - 1 >= 0) arr[x + 1][y - 1] += one;
			else res += one;
		}
		else res += 2 * one;
		
		//2%
		if(y - 2 >= 0) arr[x][y - 2] += two;
		else res += two;
		if(y + 2 < N) arr[x][y + 2] += two;
		else res += two;
		
		//7%
		if(y - 1 >= 0) arr[x][y - 1] += sev;
		else res += sev;
		if(y + 1 < N) arr[x][y + 1] += sev;
		else res += sev;
		
		//10%
		if(x - 1 >= 0) {
			if(y - 1 >= 0) arr[x - 1][y - 1] += ten;
			else res += ten;
			if(y + 1 < N) arr[x - 1][y + 1] += ten;
			else res += ten;
		}
		else res += 2 * ten;
		
		//5%
		if(x - 2 >= 0) arr[x - 2][y] += fiv;
		else res += fiv;
		
		//a
		if(x - 1 >= 0) arr[x - 1][y] += arr[x][y];
		else res += arr[x][y];
		arr[x][y] = 0;
	}
}