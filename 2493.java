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
//		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(br.readLine());
		Stack<Pair> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int num = Integer.parseInt(st.nextToken());
			if(i > 0){
				while(!stack.isEmpty() && stack.peek().num < num) stack.pop();
				if(stack.isEmpty()) bw.write("0 ");
				else bw.write(stack.peek().idx + " ");
			}
			else bw.write("0 ");
			stack.push(new Pair(i + 1, num));
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