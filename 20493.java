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
		int T = Integer.parseInt(st.nextToken());
		
		int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
		int x = 0, y = 0, d = 0, t = 0;
		
		if(N == 0) {
			bw.write(T + " 0");
			bw.flush();
			return;
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String nd = st.nextToken();
			
			x += dx[d] * (num - t);
			y += dy[d] * (num - t);
			t = num;
			
			if(nd.equals("right")) d = (d + 1) % 4;
			else {
				d -= 1;
				if(d < 0) d = 3;
			}
		}
		
		x += dx[d] * (T - t);
		y += dy[d] * (T - t);
		bw.write(x + " " + y);
		bw.flush();
	}
}