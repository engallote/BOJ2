import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] dic = new int[N][58];
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			char[] ch = br.readLine().trim().toCharArray();
			arr[i] = new String(ch);
			
			for(char c : ch) dic[i][c - 'A'] += 1;
		}

		int M = Integer.parseInt(br.readLine());
		int[] cur = new int[58];
		
		for(int t = 0; t < M; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int res = 1;
			while(st.hasMoreTokens()) {
				char[] ch = st.nextToken().toCharArray();
				Arrays.fill(cur, 0);
				int cnt = 0;
				for(char c : ch) cur[c - 'A'] += 1;
				
				for(int i = 0; i < N; i++) {
					boolean flag = true;
					
					for(int j = 0; j < 58; j++)
						if(dic[i][j] != cur[j]) {
							flag = false;
							break;
						}
					
					if(!flag) continue;
					
					if(arr[i].charAt(0) == ch[0] && arr[i].charAt(arr[i].length() - 1) == ch[ch.length - 1])
						++cnt;
				}
				res *= cnt;
			}
			
			bw.write(res+"\n");
		}
		bw.flush();
	}
}