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
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<Integer>();
		
		while(--N >= 0){
			String order = br.readLine().trim();
			if(order.contains(" ")){
				String[] str = order.split(" ");
				int num = Integer.parseInt(str[1]);
				dq.offer(num);
			}
			else if(order.equals("pop")){
				if(dq.isEmpty()) bw.write("-1\n");
				else bw.write(dq.pollFirst()+"\n");
			}
			else if(order.equals("size")) bw.write(dq.size()+"\n");
			else if(order.equals("empty")) bw.write(dq.isEmpty() ? "1\n" : "0\n");
			else if(order.equals("front")) bw.write(dq.isEmpty() ? "-1\n" : dq.peekFirst()+"\n");
			else if(order.equals("back")) bw.write(dq.isEmpty() ? "-1\n" : dq.peekLast()+"\n");
		}
		bw.flush();
	}
}