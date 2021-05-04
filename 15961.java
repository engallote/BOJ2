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
    	int N = Integer.parseInt(st.nextToken());//접시 수
    	int d = Integer.parseInt(st.nextToken());//초밥 가짓수
    	int k = Integer.parseInt(st.nextToken());//연속해서 먹는 접시 수
    	int c = Integer.parseInt(st.nextToken());//쿠폰 번호
    	int[] arr = new int[N], num = new int[d + 1];
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = Integer.parseInt(br.readLine());
    	
    	int res = 0, max = 0;
    	for(int i = 0; i < k; i++) {
    		if(num[arr[i]] == 0) ++max;
    		++num[arr[i]];
    	}
    	
    	res = max;
    	
    	for(int i = 0; i < N; i++) {
    		--num[arr[i]];//지나간 것은 빼기
    		if(num[arr[i]] == 0) --max;
    		
    		int idx = (i + k) % N;
    		if(num[arr[idx]] > 0) ++num[arr[idx]];
    		else {
    			++num[arr[idx]];
    			++max;
    		}
    		
    		if(num[c] == 0) res = Math.max(res, max + 1);
    		else res = Math.max(res, max);
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
}