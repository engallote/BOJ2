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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int res = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while(true){
			cnt = 0;
			for(int i = 0; i < N; i++){
				if(arr[i] % 2 != 0){
					arr[i] -= 1;
					++res;
				}
				if(arr[i] == 0) ++cnt;
			}
			if(cnt == N) break;
			
			for(int i = 0; i < N; i++)
				arr[i] /= 2;
			++res;
		}
		
		bw.write(res+"");
		bw.flush();
	}
}