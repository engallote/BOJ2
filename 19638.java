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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//거인의 수
		int H = Integer.parseInt(st.nextToken());//센티의 키
		int T = Integer.parseInt(st.nextToken());//횟수 제한
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(num);
		}
		
		int cnt = 0;
		while(--T >= 0) {
			int num = pq.poll();
			
			if(num < H || num == 1) {
				pq.offer(num);
				break;
			}
			
			++cnt;
			pq.offer(num / 2);
		}
		
		if(pq.peek() < H) {
			bw.write("YES\n");
			bw.write(cnt+"");
		}
		else {
			bw.write("NO\n");
			bw.write(pq.peek()+"");
		}
		bw.flush();
	}
}