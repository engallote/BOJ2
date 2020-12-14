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
		int K = Integer.parseInt(st.nextToken());
		Pair[] arr = new Pair[K];
		int[] res = new int[N];
		boolean flag = false;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= K; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > (N + 1) / 2) flag = true;
			arr[i-1] = new Pair(i, num);
		}
		
		if(flag) {
			bw.write("-1");
			bw.flush();
			return;
		}
		
		Arrays.sort(arr);
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < K; i++)
			for(int j = 0; j < arr[i].cnt; j++)
				q.offer(arr[i].num);
		
		for(int i = 0; i < (N + 1) / 2; i++)
			res[i*2] = q.poll();
		for(int i = 1; !q.isEmpty(); i+=2)
			res[i] = q.poll();
		
		for(int i = 0; i < N; i++)
			bw.write(res[i] + " ");
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	int num, cnt;
	Pair(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(o.cnt, this.cnt);
	}
}