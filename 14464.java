import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] chick = new int[N];
		boolean[] chk = new boolean[N];
		Pair[] arr = new Pair[M];
		for(int i = 0; i < N; i++)
			chick[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(chick);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(a, b);
		}
		
		Arrays.sort(arr);
		int res = 0;
		
		for(int c = 0; c < M; c++){
			Pair p = arr[c];
			
			for(int i = 0; i < N; i++)
				if(!chk[i] && p.s <= chick[i] && chick[i] <= p.e) {
					chk[i] = true;
					++res;			
					break;
				}
		}
		
		bw.write(res+"");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int s, e;
	Pair(int s, int e){
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.e > this.e) return -1;
		else if(o.e == this.e) return o.s > this.s ? -1 : (o.s == this.s ? 0 : 1);
		return 1;
	}
}