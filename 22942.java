import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	Pair[] arr = new Pair[N];
    	
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    	}
    	
    	Arrays.sort(arr);
    	
    	for(int i = 0; i < N; i++)
    		for(int j = i + 1; j < N; j++) {
    			if(arr[i].x + arr[i].r < arr[j].x - arr[j].r) break;
    			double d = Math.sqrt((arr[i].x - arr[j].x) * (arr[i].x - arr[j].x));
    			if(arr[i].r + arr[j].r < d || d < Math.abs(arr[i].r - arr[j].r) || d == 0)
    				continue;
    			System.out.println("NO");
    			return;
    		}
    	System.out.println("YES");
	}
}
class Pair implements Comparable<Pair>{
	int x, r;
	Pair(int x, int r){
		this.x = x;
		this.r = r;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.x < o.x) return -1;
		else if(o.x == this.x) return Integer.compare(this.r, o.r);
		else return 1;
	}
}