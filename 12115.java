import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[] cnt = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
			
		
		int Q = Integer.parseInt(br.readLine());
		while(--Q >= 0) {
			Arrays.fill(cnt, 0);
			st = new StringTokenizer(br.readLine());
			for(int t = 0; t < M; t++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) {
					for(int j = 0; j < N; j++)
						cnt[j] += 1;
				}
				else {
					for(int i = 0; i < N; i++)
						if(arr[i][t] == num) cnt[i] += 1;
				}
			}
			
			int res = 0;
			for(int i = 0; i < N; i++)
				if(cnt[i] == M) ++res;
			
			bw.write(res+"\n");
		}
		bw.flush();
	}
}