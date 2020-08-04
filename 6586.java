import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int N = sc.nextInt();
			
			if(N == 0) break;
			
			int[][] arr = new int[N][N];
			int[] row = new int[N], col = new int[N];
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++){
					arr[i][j] = sc.nextInt();
					row[i] += arr[i][j];
					col[j] += arr[i][j];
				}
			
			boolean ok = true;
			int r = 0, c = 0, cnt = 0;
			for(int i = 0; i < N; i++){
				if(row[i] % 2 == 0 && col[i] % 2 == 0) continue;
				else if(row[i] % 2 != 0){
					--row[i];
					r = i + 1;
					++cnt;
					for(int j = 0; j < N; j++)
						if(col[j] % 2 != 0){
							if(arr[i][j] == 1){
								arr[i][j] = 0;
								c = j + 1;
								--col[j];
							}
							else{
								arr[i][j] = 1;
								c = j + 1;
								++col[j];
							}
							break;
						}
				}
				else if(col[i] % 2 != 0){
					++cnt;
					--col[i];
					c = i + 1;
					for(int j = 0; j < N; j++)
						if(row[j] % 2 != 0){
							if(arr[j][i] == 1){
								arr[j][i] = 0;
								r = j + 1;
								--row[j];
							}
							else{
								arr[j][i] = 1;
								r = j + 1;
								++row[j];
							}
							break;
						}
				}
			}
			
			if(ok && cnt == 0) System.out.println("OK");
			else if(ok && cnt == 1) System.out.println("Change bit (" + r + "," + c + ")");
			else if(cnt > 1) System.out.println("Corrupt");
		}
	}
}