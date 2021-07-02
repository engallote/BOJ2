import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	Pair[] arr = new Pair[N];
    	long sum = 0;
    	
    	StringTokenizer st;
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		long b = Long.parseLong(st.nextToken());
    		arr[i] = new Pair(a, b);
    		sum += b;
    	}
    	Arrays.sort(arr);
    	double tmp = sum / 2.0;
    	int idx = 0;
    	long sum2 = 0;
    	for(int i = 0; i < N; i++) {
    		sum2 += arr[i].p;
    		idx = i;
    		if(sum2 >= tmp) break;
    	}
    	
    	bw.write(arr[idx].idx+"");
    	bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int idx;
	long p;
	Pair(int idx, long p){
		this.idx = idx;
		this.p = p;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.idx < this.idx) return 1;
		else if(o.idx == this.idx) return Long.compare(this.p, o.p);
		else return -1;
	}
}