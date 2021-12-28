import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int T = Integer.parseInt(br.readLine());
    	StringTokenizer st;
    	StringBuilder sb;
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for(int test_case = 1; test_case <= T; test_case++) {
    		int N = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine());
    		int[] arr = new int[N + 1];
    		sb = new StringBuilder();
    		sb.append("Case #" + test_case + ": ");
    		pq.clear();
    		
    		int res = 0;
    		for(int i = 1; i <= N; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    			
    			pq.offer(arr[i]);
    			while(!pq.isEmpty() && pq.peek() <= res) pq.poll();
    			if(pq.size() > res) res += 1;
    			
    			sb.append(res + " ");
    		}
    		bw.write(sb.toString() + "\n");
    	}
    	bw.flush();
    }
}