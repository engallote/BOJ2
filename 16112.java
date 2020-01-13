import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		
		int cnt = 0;
		long sum = 0;
		for(int i = 0; i < N; i++){
			sum += arr[i] * cnt;
			if(cnt < K)	++cnt;
		}
		
		bw.write(sum+"");
		bw.flush();
	}
}