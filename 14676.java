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
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		int[] cnt = new int[N+1], ok = new int[N+1], indgree = new int[N+1];
		boolean flag = true;
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			++indgree[b];
		}
		
		for(int i = 0; i < K; i++){
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(!flag) continue;
			
			if(op == 1){//건설
				if(ok[num] == indgree[num]){
					cnt[num] += 1;
					if(cnt[num] == 1){
						for(int j : arr[num])
							ok[j] += 1;
					}
				}
				else flag = false;
			}
			else{//철거
				if(cnt[num] == 0) flag = false;
				else{
					cnt[num] -= 1;
					if(cnt[num] == 0){
						for(int j : arr[num])
							ok[j] -= 1;
					}
				}
			}
		}
		
		if(flag) bw.write("King-God-Emperor\n");
		else bw.write("Lier!\n");
		bw.flush();
	}
}