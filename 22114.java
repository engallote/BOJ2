import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	arr = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i < N; i++)
    		arr[i] = Integer.parseInt(st.nextToken());
    	
    	int res = 1;
    	
    	for(int i = 0; i < N - 1; i++) {
    		int sum = 1, cnt = 1;
    		for(int j = i + 1; j < N; j++) {
    			if(arr[j] <= K) ++sum;
    			else if(arr[j] > K && cnt == 1) {
    				cnt = 0;
    				++sum;
    			}
    			else break;
    		}
    		res = Math.max(res, sum);
    	}
    	
    	bw.write(res+"");
    	bw.flush();
	}
}