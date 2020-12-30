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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] rank = new int[N + 1];
		ArrayList<Integer>[] arr = new ArrayList[M + 1];
		
		for(int i = 0; i <= M; i++)
			arr[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			rank[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
				int k = Integer.parseInt(st.nextToken());
				arr[k].add(i);
			}
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int Q = Integer.parseInt(br.readLine());
		while(--Q >= 0) {
			pq.clear();
			int num = Integer.parseInt(br.readLine());
			
			for(int i : arr[num])
				pq.offer(new Pair(i, rank[i]));
			
			if(pq.isEmpty()) bw.write("-1");
			while(!pq.isEmpty())
				bw.write(pq.poll().idx + " ");
			bw.newLine();
		}
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int idx, rank;
	Pair(int idx, int rank) {
		this.idx = idx;
		this.rank = rank;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.rank, o.rank);
	}
}