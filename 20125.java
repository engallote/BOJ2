import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		char[][] arr = new char[N][N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		int hx = -1, hy = 0, cnt = 0;
		loop:for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				cnt = 0;
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k], ny = j + dy[k];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == '_') continue;
					++cnt;
				}
				
				if(cnt == 4) {
					hx = i;
					hy = j;
					break loop;
				}
			}
		}
				
		System.out.println((hx + 1) + " " + (hy + 1));
		//left arm
		cnt = 0;
		for(int i = hy - 1; i >= 0; i--) {
			if(arr[hx][i] != '*') break;
			++cnt;
		}
		System.out.print(cnt + " ");
		//right arm
		cnt = 0;
		for(int i = hy + 1; i < N; i++) {
			if(arr[hx][i] != '*') break;
			++cnt;
		}
		System.out.print(cnt + " ");
		//stomach
		cnt = 0;
		int nx = 0;
		for(int i = hx + 1; i < N; i++) {
			if(arr[i][hy] != '*') break;
			++cnt;
			nx = i;
		}
		System.out.print(cnt + " ");
		//left leg
		cnt = 0;
		for(int i = nx + 1; i < N; i++) {
			if(arr[i][hy - 1] != '*') break;
			++cnt;
		}
		System.out.print(cnt + " ");
		//right leg
		cnt = 0;
		for(int i = nx + 1; i < N; i++) {
			if(arr[i][hy + 1] != '*') break;
			++cnt;
		}
		System.out.print(cnt + " ");
	}
}