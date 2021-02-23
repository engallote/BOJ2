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
		Deque<Integer> dq = new LinkedList<>(), sq = new LinkedList<>();
		Deque<Integer> dg = new LinkedList<>(), sg = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			dq.offer(d);
			sq.offer(s);
		}
		
		//순서 : 아래 ---- 위
		int who = 1, num;
		while(--M >= 0) {
			if(who == 1) {//do
				if(dq.isEmpty()) {
					bw.write("su");
					bw.flush();
					return ;
				}
				num = dq.pollLast();
				if(dq.isEmpty()) {
					bw.write("su");
					bw.flush();
					return ;
				}
				dg.offer(num);
			}
			else {//su
				if(sq.isEmpty()) {
					bw.write("do");
					bw.flush();
					return ;
				}
				num = sq.pollLast();
				if(sq.isEmpty()) {
					bw.write("do");
					bw.flush();
					return ;
				}
				sg.offer(num);
			}
			
			if((!sg.isEmpty() && sg.peekLast() == 5) || (!dg.isEmpty() && dg.peekLast() == 5)) {
				while(!sg.isEmpty())
					dq.offerFirst(sg.pollFirst());
				while(!dg.isEmpty())
					dq.offerFirst(dg.pollFirst());
			}
			else if(!dg.isEmpty() && !sg.isEmpty() && dg.peekLast() + sg.peekLast() == 5) {
				while(!dg.isEmpty())
					sq.offerFirst(dg.pollFirst());
				while(!sg.isEmpty())
					sq.offerFirst(sg.pollFirst());
			}
			who *= -1;
		}
		
		if(dq.size() > sq.size()) bw.write("do");
		else if(dq.size() == sq.size()) bw.write("dosu");
		else bw.write("su");
		bw.flush();
	}
}