import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	HashMap<Integer, Integer> hm = new HashMap<>();
    	String[] arr = new String[M];
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < M; i++) {
    		hm.clear();
    		st = new StringTokenizer(br.readLine());
    		sb = new StringBuilder();
    		for(int j = 0; j < N; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			int val = j;
    			if(hm.containsKey(num)) val = hm.get(num);
    			else hm.put(num, j);
    			pq.offer(new Pair(val, num));
    		}
    		
    		while(!pq.isEmpty())
    			sb.append(pq.poll().idx+",");
    		
    		arr[i] = sb.toString();
    	}
    	
    	int res = 0;    	
    	for(int i = 0; i < M - 1; i++)
    		for(int j = i + 1; j < M; j++)
    			if(arr[i].equals(arr[j])) ++res;
    	System.out.println(res);
    }
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(this.num < o.num) return -1;
		else if(this.num == o.num) return Integer.compare(this.idx, o.idx);
		else return 1;
	}
}