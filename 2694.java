import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int N, idx;
		int[] arr = new int[10000];
		while(--T >= 0){
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer("");
			int len = N / 10 + (N % 10 > 0 ? 1 : 0);
			idx = 0;
			
			for(int i = 0; i < len; i++){
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()){
					arr[idx] = Integer.parseInt(st.nextToken());
					++idx;
				}
			}
			
			long res = 0, sum;
			for(int i = 0; i < N; i++){
				res += arr[i];
				sum = 0;
				idx = i + 1;
				while(idx < N){
					if(sum + arr[idx] <= res){
						sum += arr[idx];
						++idx;
					}
					else{
						if(sum == res && arr[idx] <= res){
							sum = arr[idx];
							++idx;
						}
						else{
							idx = -1;
							break;
						}
					}
				}
				
				if(idx >= N && sum == res) break;
			}
			
			bw.write(res+"\n");
		}
		bw.flush();
	}
}