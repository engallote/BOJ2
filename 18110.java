import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import javax.naming.LimitExceededException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		double n = Math.round(N * 0.3 / 2.0);
		double sum = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
			pq.offer(Integer.parseInt(br.readLine()));
			
		for(int i = 0; i < n; i++)
			pq.poll();
		
		while(pq.size() > n) sum += pq.poll();
		
		sum /= N - (n * 2);
		bw.write((Math.round(sum))+"\n");
		bw.flush();
	}
}