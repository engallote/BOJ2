import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		int idx = M - 1, res = 0;
		boolean flag = true;
		while(idx >= 0){
			int r = -1, c = idx;
			flag = false;
			
			for(int i = N - 1; i >= 0; i--)
				if(arr[i][idx] == 1){//발견
					r = i;
					flag = true;
					break;
				}
			
			boolean flag2 = true;
			while(r >= 0 && c >= 0){
				if(arr[r][c] == 1)//청소
					arr[r][c] = 0;
				
				flag2 = false;
				
				for(int i = r - 1; i >= 0; i--){//열 탐색
					if(arr[i][c] == 1){//발견
						r = i;
						flag2 = true;
						break;
					}
				}
				
				if(!flag2) --c;//해당 열에 아무것도 없으면 열을 왼쪽으로 옮김
			}
			if(flag) ++res;//청소기 증가
			if(!flag) --idx;//아무것도 발견 못했으면 열을 왼쪽으로 옮김
		}
		
		System.out.println(res);
	}
}