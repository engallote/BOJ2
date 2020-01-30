import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int N;
	static long M;
	static Pair[] arr;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new Pair[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(Long.parseLong(st.nextToken()), 0);
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i].y = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		long max = M;
		long res = M;
		for(int i = 0; i < N; i++){
			if(res >= arr[i].x && arr[i].y > arr[i].x){
				res -= arr[i].x;
				res += arr[i].y;
			}
			else if(res < arr[i].x) break;
			max = Math.max(res, max);
		}
		
		bw.write(max+"");
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	long x, y;
	Pair(long x, long y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return -1;
		else if(o.x == this.x){
			if(o.y > this.y) return 1;
			else if(o.y == this.y) return 0;
			else return -1;
		}
		else return 1;
	}
}