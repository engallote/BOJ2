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
        int D = Integer.parseInt(st.nextToken());
        
        int res = 0, cnt = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	if(i == 0 || i == N - 1) {
        		if(num == 0) {
        			res += 1;
        			cnt = 0;
        		}
        	}
        	else if(num == 1) cnt = 0;
        	else {
        		++cnt;
        		if(cnt == D) {
        			cnt = 0;
        			++res;
        		}
        	}
        }
        
        bw.write(res+"");
        bw.flush();
	}
}