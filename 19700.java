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
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] tmp = new int[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	pq.offer(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        while(!pq.isEmpty()) {
        	Pair p = pq.poll();
        	
        	int l = 0, r = N - 1, mid, idx = 0;
        	while(l <= r){
        		mid = (l + r) / 2;
        		if(tmp[mid] >= p.k){
        			r = mid - 1;
        		}
        		else {
        			idx = mid;
        			l = mid + 1;
        		}
        	}
        	
        	tmp[idx] += 1;
        }
        
        int res = 0;
        for(int i = 0; i < N; i++)
        	if(tmp[i] != 0) ++res;
        
        bw.write(res+"");
        bw.flush();
    }
}
class Pair implements Comparable<Pair>{
	int num, k;
	Pair(int num, int k){
		this.num = num;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		return o.num > this.num ? 1 : -1;
	}
}