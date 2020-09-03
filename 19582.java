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
		int cnt = 1, sum = 0, max = 0;
		boolean flag = true;
		
		StringTokenizer st;
		while(--N >= 0){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(!flag) continue;
			if(sum <= x){
				sum += p;
				max = Math.max(max, p);
			}
			else if(sum - max > x || max < p) --cnt;
			else{
				--cnt;
				sum -= max;
				sum += p;
			}
			
			if(cnt < 0) flag = false;
		}
		
		if(flag) bw.write("Kkeo-eok");
		else bw.write("Zzz");
		bw.flush();
	}
}