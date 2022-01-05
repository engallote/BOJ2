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
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	Deque<Pair> dq = new LinkedList<>();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(dq.isEmpty() || dq.peekLast().num < num) dq.offer(new Pair(i, num));
    		while(!dq.isEmpty() && dq.peekLast().num >= num) dq.pollLast();
    		if(!dq.isEmpty() && dq.peekFirst().num == num) dq.pollFirst();
    		dq.offer(new Pair(i, num));
    		
    		while(!dq.isEmpty() && dq.peekFirst().idx <= i - L) dq.pollFirst();
    		bw.write(dq.peekFirst().num + " ");
    	}
    	bw.flush();
    }
}
class Pair {
	int idx, num;
	Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}