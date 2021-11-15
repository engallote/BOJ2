import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] arr, sum;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	arr = new int[N];
    	sum = new int[N];
    	int max = 0, idx = 0;
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		sum[i] += arr[i];
    		
    		if(i > 0) sum[i] += sum[i - 1];
    		if(max < arr[i]) {
    			max = arr[i];
    			idx = i;
    		}
    	}
    	
    	int res = 0;
    	for(int i = 0; i < N; i++) {
    		if(i == 0) {
    			for(int j = N - 2; j > i; j--) {
    				int tmp = sum[N - 1] - arr[N - 1] - arr[j] + sum[j - 1];
    				res = Math.max(res, tmp);
    			}
    		}
    		else if(i == N - 1) {
    			for(int j = 1; j < i; j++) {
    				int tmp = sum[i] * 2 - sum[j] - arr[0] - arr[j];
    				res = Math.max(res, tmp);
    			}
    		}
    		else {
    			int tmp = sum[i] - arr[0] + sum[N - 2] - sum[i - 1];
    			res = Math.max(res, tmp);
    		}
    	}
    	
    	System.out.println(res);
	}
}