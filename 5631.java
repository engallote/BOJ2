import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int tc = 1;
    	while(true) {
    		int N = Integer.parseInt(br.readLine());
    		
    		if(N == 0) break;
    		
    		bw.write("Case " + tc + ":\n");
    		++tc;
    		
    		Pair[] arr = new Pair[N];
    		StringTokenizer st;
    		for(int i = 0; i < N; i++) {
    			st = new StringTokenizer(br.readLine());
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			arr[i] = new Pair(x, y);
    		}
    		
    		st = new StringTokenizer(br.readLine());
    		int ax = Integer.parseInt(st.nextToken());
    		int ay = Integer.parseInt(st.nextToken());
    		int bx = Integer.parseInt(st.nextToken());
    		int by = Integer.parseInt(st.nextToken());
    		int q = Integer.parseInt(st.nextToken());
    		
    		double[] a = new double[N], b = new double[N];
    		
    		for(int i = 0; i < N; i++) {
    			a[i] = Math.sqrt(Math.pow(arr[i].x - ax, 2) + Math.pow(arr[i].y - ay, 2));
    			b[i] = Math.sqrt(Math.pow(arr[i].x - bx, 2) + Math.pow(arr[i].y - by, 2));
    		}
    		
    		Arrays.sort(a);
    		Arrays.sort(b);
    		
    		while(--q >= 0) {
    			st = new StringTokenizer(br.readLine());
    			int r1 = Integer.parseInt(st.nextToken());
    			int r2 = Integer.parseInt(st.nextToken());
    			
    			int res = solve(a, r1) + solve(b, r2);
    			if(res > N) res = N;
    			
    			bw.write((N - res) + "\n");
    		}
    	}
    	bw.flush();
    }

	private static int solve(double[] arr, int r1) {
		int l = 0, r = arr.length - 1, mid;
		while(l <= r) {
			mid = (l + r) / 2;
			
			if(arr[mid] <= r1) {
				l = mid + 1;
			}
			else r = mid - 1;
		}
		return l;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}