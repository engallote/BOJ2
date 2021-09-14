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
    	int N = Integer.parseInt(br.readLine());
    	Pair[] arr = new Pair[N];
    	
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int r = Integer.parseInt(st.nextToken());
    		
    		arr[i] = new Pair(x - r, x + r);
    	}
    	
    	Arrays.sort(arr);
    	
    	boolean flag = true;
    	for(int i = 1; i < N; i++) {
    		if(arr[i].l <= arr[i - 1].r && arr[i - 1].r <= arr[i].r) {
    			flag = false;
    			break;
    		}
    	}
    	
    	if(flag) bw.write("YES");
    	else bw.write("NO");
    	
    	bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int l, r;
	Pair(int l, int r){
		this.l = l;
		this.r = r;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.l < o.l) return -1;
		else if(o.l == this.l) return Double.compare(this.r, o.r);
		else return 1;
	}
}