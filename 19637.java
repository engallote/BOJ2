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
		Pair[] arr = new Pair[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(str, num);
		}
		
		Arrays.sort(arr);
		
		int l = 0, r = N - 1, mid;
		while(--M >= 0) {
			int num = Integer.parseInt(br.readLine());
			
			l = 0;
			r = N - 1;
			String str = "";
			while(l <= r) {
				mid = (l + r) / 2;
				
				if(arr[mid].num < num) l = mid + 1;
				else {
					str = arr[mid].str;
					r = mid - 1;
				}
			}
			
			bw.write(str+"\n");
		}
		
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	String str;
	int num;
	Pair(String str, int num){
		this.str = str;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return o.num > this.num ? -1 : 1;
	}
}