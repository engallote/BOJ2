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
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Pair> ene = new PriorityQueue<>(), heal = new PriorityQueue<>();
		for(int i = 1; i <= X; i++) {
			int num = Integer.parseInt(br.readLine());
			ene.offer(new Pair(i, num));
		}
		
		for(int i = 1; i <= Y; i++) {
			int num = Integer.parseInt(br.readLine());
			heal.offer(new Pair(i, num));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!ene.isEmpty()) {
			Pair p1 = ene.poll();
			
			if(M - p1.num > 0) {
				sb.append(-p1.idx + "\n");
				M -= p1.num;
			}
			else {
				if(heal.isEmpty()) {
					bw.write("0");
					bw.flush();
					return;
				}
				while(!heal.isEmpty()) {
					Pair p2 = heal.peek();
					
					M += p2.num;
					heal.poll();
					sb.append(p2.idx+"\n");
					if(M > p1.num) break;
				}
				M -= p1.num;
				sb.append(-p1.idx+"\n");
			}
		}
		
		while(!heal.isEmpty())
			sb.append(heal.poll().idx + "\n");
		
		bw.write(sb.toString());
		bw.flush();
	}
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return o.num > this.num ? -1 : (o.num == this.num ? 0 : 1);
	}
}