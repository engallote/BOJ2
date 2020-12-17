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
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> sm = new PriorityQueue<>(Collections.reverseOrder()), bg = new PriorityQueue<>();
		
		int num = Integer.parseInt(br.readLine());
		sm.offer(num);
		bw.write(num+"\n");
		
		for(int i = 1; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			
			if(sm.peek() < num) bg.offer(num);
			else sm.offer(num);
			
			if(Math.abs(sm.size() - bg.size()) > 1) {
				if(sm.size() > bg.size()) bg.offer(sm.poll());
				else sm.offer(bg.poll());
			}
			
			if(sm.size() == bg.size()) bw.write(sm.peek()+"\n");
			else if(sm.size() > bg.size()) bw.write(sm.peek()+"\n");
			else bw.write(bg.peek()+"\n");
		}
		bw.flush();
	}
}