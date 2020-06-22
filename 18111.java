import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE, max = 0;
		arr = new int[266];
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++){
				int num = Integer.parseInt(st.nextToken());
				
				arr[num] += 1;
				min = Math.min(min, num);
				max = Math.max(max, num);
			}
		}
		
		long res = Long.MAX_VALUE, sum = 0;
		int h = 0;
		
		for(int i = min; i <= max; i++){
			sum = find(i, B, min, max);
			if(sum < res){
				res = sum;
				h = i;
			}
			else if(sum == res) h = i;
		}
		
		bw.write(res + " " + h);
		bw.flush();
	}
	private static long find(int i, int block, int min, int max) {
		long sum = 0;
		int b = block;
		for(int j = min; j < i; j++){
			sum += (i - j) * arr[j];
			b -= (i - j) * arr[j];
		}
		for(int j = i + 1; j <= max; j++){
			sum += (j - i) * arr[j] * 2;
			b += (j - i) * arr[j];
		}
		
		if(b < 0) return Long.MAX_VALUE;
		return sum;
	}
}