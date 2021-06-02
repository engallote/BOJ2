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
    	int M = Integer.parseInt(st.nextToken());
    	int[] arr = new int[N];
    	
    	int max = 0;
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    		max = Math.max(max, arr[i]);
    	}
    	
    	int l = 1, r = max, mid, res = -1;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
    		int sum = 0;
    		for(int i = 0; i < N; i++) {
    			if(arr[i] <= K) continue;
    			if(arr[i] >= 2 * K) sum += (arr[i] - 2 * K) / mid;
    			else if(arr[i] < 2 * K && arr[i] > K) sum += (arr[i] - K) / mid;
    		}
    		
    		if(sum >= M) {
    			res = mid;
    			l = mid + 1;
    		}
    		else r = mid - 1;
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
}