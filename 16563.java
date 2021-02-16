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
        boolean[] chk = new boolean[5000001];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 2; i <= 5000000; i++) {
        	if(chk[i]) continue;
        	arr.add(i);
        	for(int j = i + i; j <= 5000000; j+=i)
        		chk[j] = true;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	
        	if(!chk[num]) {
        		bw.write(num+"\n");
        		continue;
        	}
        	
        	loop:for(int n : arr) {
        		if(!chk[num]) {
        			bw.write(num+"");
        			break;
        		}
        		if(num % n == 0) {
        			while(num % n == 0) {
        				bw.write(n + " ");
        				num /= n;
        				if(num == 1) break loop;
        			}
        		}
        	}
        	bw.newLine();
        }
        bw.flush();
	}
}