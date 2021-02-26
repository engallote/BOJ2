import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer>[] dq = new LinkedList[N];
		HashMap<Integer, Integer> hm = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++)
			dq[i] = new LinkedList<>();
		
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(hm.containsKey(num)) dq[hm.get(num)].offer(i);
			else {
				hm.put(num, idx);
				dq[idx].offer(i);
				++idx;
			}
			pq.offer(num);
		}
		boolean rev = false;

		while(--M >= 0) {
			int num = pq.poll();
			
			if(rev) {
				int tmp = dq[hm.get(num)].pollLast();
				bw.write(tmp+"\n");
				
				if(num % 7 == 0) rev = !rev;
			}
			else {
				int tmp = dq[hm.get(num)].pollFirst();
				bw.write(tmp+"\n");
				
				if(num % 7 == 0) rev = !rev;
			}
		}
		
		bw.flush();
	}
}
class Pair{
	int idx, num;
	Pair(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
}