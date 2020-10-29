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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 2], sum = new int[N + 2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		while(-- Q >= 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			sum[a] += c;
			sum[b + 1] -= c;
		}
		
		int res = 0;
		for(int i = 1; i <= N; i++) {
			res += sum[i];
			arr[i] += res;
			bw.write(arr[i] + " ");
		}
		bw.flush();
	}
}