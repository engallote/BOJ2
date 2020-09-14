import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, Q;
	static long[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			long num = Long.parseLong(st.nextToken());
			arr[i] = num;
		}
		
		while(--Q >= 0){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			long res = 0;
			
			int l = y, r = N, mid, idx = y;
			while(l <= r){
				mid = (l + r) / 2;
				if(arr[mid] >= x){
					idx = Math.max(idx, mid);
					l = mid + 1;
				}
				else r = mid - 1;
			}
			
			if(arr[idx] >= x) res += idx - y + 1;
			if(arr[y] > x) res += arr[y] - x;
			
			bw.write(res+"\n");
		}
		bw.flush();
	}
}